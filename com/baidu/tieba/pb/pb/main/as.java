package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText fOX;
    private PostWriteCallBackData hrm;
    private com.baidu.tieba.write.b hys = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hyt;
    private EditText hyu;

    public as() {
        this.hys.AS(d.C0277d.cp_btn_a);
        this.hys.AT(d.C0277d.cp_cont_h_alpha85);
        this.hyt = new com.baidu.tieba.write.b();
        this.hyt.AS(d.C0277d.cp_btn_a);
        this.hyt.AT(d.C0277d.cp_cont_h_alpha85);
    }

    public void nZ(boolean z) {
        if (this.hyu != null && this.hyu.getText() != null) {
            int selectionEnd = this.hyu.getSelectionEnd();
            SpannableStringBuilder b = this.hys.b(this.hyu.getText());
            if (b != null) {
                this.hys.qV(true);
                this.hyu.setText(b);
                if (z && this.hys.cnX() >= 0) {
                    this.hyu.requestFocus();
                    this.hyu.setSelection(this.hys.cnX());
                } else {
                    this.hyu.setSelection(selectionEnd);
                }
                this.hys.qU(this.hys.cnX() >= 0);
            }
        }
    }

    public void oa(boolean z) {
        if (this.fOX != null && this.fOX.getText() != null) {
            int selectionEnd = this.fOX.getSelectionEnd();
            SpannableStringBuilder b = this.hyt.b(this.fOX.getText());
            if (b != null) {
                this.hyt.qV(true);
                this.fOX.setText(b);
                if (z && this.hyt.cnX() >= 0) {
                    this.fOX.requestFocus();
                    this.fOX.setSelection(this.hyt.cnX());
                } else {
                    this.fOX.setSelection(selectionEnd);
                }
                this.hyt.qU(this.hyt.cnX() >= 0);
            }
        }
    }

    public void bNu() {
        this.hyt.Ei(null);
        this.hyt.aE(null);
        this.hyt.qU(false);
    }

    public void bNv() {
        this.hys.Ei(null);
        this.hys.aE(null);
        this.hys.qU(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hys.aE(postWriteCallBackData.getSensitiveWords());
            this.hys.Ei(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hys.cnW())) {
                nZ(true);
                this.hrm = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyt.aE(postWriteCallBackData.getSensitiveWords());
            this.hyt.Ei(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyt.cnW())) {
                oa(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hyu = editText;
    }

    public void l(EditText editText) {
        this.fOX = editText;
    }

    public void onDestroy() {
        this.hyu = null;
        this.fOX = null;
    }

    public void onChangeSkinType() {
        this.hys.onChangeSkinType();
        this.hyt.onChangeSkinType();
        if (this.hys.cnY()) {
            nZ(false);
        }
        if (this.hyt.cnY()) {
            oa(false);
        }
    }

    public com.baidu.tieba.write.b bNw() {
        return this.hys;
    }

    public com.baidu.tieba.write.b bNx() {
        return this.hyt;
    }

    public EditText bNy() {
        return this.fOX;
    }

    public PostWriteCallBackData bNz() {
        return this.hrm;
    }
}
