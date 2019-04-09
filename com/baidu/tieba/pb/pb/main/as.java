package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText fOX;
    private PostWriteCallBackData hrn;
    private com.baidu.tieba.write.b hyt = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hyu;
    private EditText hyv;

    public as() {
        this.hyt.AS(d.C0277d.cp_btn_a);
        this.hyt.AT(d.C0277d.cp_cont_h_alpha85);
        this.hyu = new com.baidu.tieba.write.b();
        this.hyu.AS(d.C0277d.cp_btn_a);
        this.hyu.AT(d.C0277d.cp_cont_h_alpha85);
    }

    public void nZ(boolean z) {
        if (this.hyv != null && this.hyv.getText() != null) {
            int selectionEnd = this.hyv.getSelectionEnd();
            SpannableStringBuilder b = this.hyt.b(this.hyv.getText());
            if (b != null) {
                this.hyt.qV(true);
                this.hyv.setText(b);
                if (z && this.hyt.cnX() >= 0) {
                    this.hyv.requestFocus();
                    this.hyv.setSelection(this.hyt.cnX());
                } else {
                    this.hyv.setSelection(selectionEnd);
                }
                this.hyt.qU(this.hyt.cnX() >= 0);
            }
        }
    }

    public void oa(boolean z) {
        if (this.fOX != null && this.fOX.getText() != null) {
            int selectionEnd = this.fOX.getSelectionEnd();
            SpannableStringBuilder b = this.hyu.b(this.fOX.getText());
            if (b != null) {
                this.hyu.qV(true);
                this.fOX.setText(b);
                if (z && this.hyu.cnX() >= 0) {
                    this.fOX.requestFocus();
                    this.fOX.setSelection(this.hyu.cnX());
                } else {
                    this.fOX.setSelection(selectionEnd);
                }
                this.hyu.qU(this.hyu.cnX() >= 0);
            }
        }
    }

    public void bNu() {
        this.hyu.Ei(null);
        this.hyu.aE(null);
        this.hyu.qU(false);
    }

    public void bNv() {
        this.hyt.Ei(null);
        this.hyt.aE(null);
        this.hyt.qU(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyt.aE(postWriteCallBackData.getSensitiveWords());
            this.hyt.Ei(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyt.cnW())) {
                nZ(true);
                this.hrn = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyu.aE(postWriteCallBackData.getSensitiveWords());
            this.hyu.Ei(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyu.cnW())) {
                oa(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hyv = editText;
    }

    public void l(EditText editText) {
        this.fOX = editText;
    }

    public void onDestroy() {
        this.hyv = null;
        this.fOX = null;
    }

    public void onChangeSkinType() {
        this.hyt.onChangeSkinType();
        this.hyu.onChangeSkinType();
        if (this.hyt.cnY()) {
            nZ(false);
        }
        if (this.hyu.cnY()) {
            oa(false);
        }
    }

    public com.baidu.tieba.write.b bNw() {
        return this.hyt;
    }

    public com.baidu.tieba.write.b bNx() {
        return this.hyu;
    }

    public EditText bNy() {
        return this.fOX;
    }

    public PostWriteCallBackData bNz() {
        return this.hrn;
    }
}
