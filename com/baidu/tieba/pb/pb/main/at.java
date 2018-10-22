package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class at {
    private PostWriteCallBackData fPr;
    private EditText fWA;
    private com.baidu.tieba.write.b fWx = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fWy;
    private EditText fWz;

    public at() {
        this.fWx.wf(e.d.cp_cont_i);
        this.fWx.wg(e.d.cp_cont_h_alpha85);
        this.fWy = new com.baidu.tieba.write.b();
        this.fWy.wf(e.d.cp_cont_i);
        this.fWy.wg(e.d.cp_cont_h_alpha85);
    }

    public void lj(boolean z) {
        if (this.fWz != null && this.fWz.getText() != null) {
            int selectionEnd = this.fWz.getSelectionEnd();
            SpannableStringBuilder b = this.fWx.b(this.fWz.getText());
            if (b != null) {
                this.fWx.ob(true);
                this.fWz.setText(b);
                if (z && this.fWx.bLr() >= 0) {
                    this.fWz.requestFocus();
                    this.fWz.setSelection(this.fWx.bLr());
                } else {
                    this.fWz.setSelection(selectionEnd);
                }
                this.fWx.oa(this.fWx.bLr() >= 0);
            }
        }
    }

    public void lk(boolean z) {
        if (this.fWA != null && this.fWA.getText() != null) {
            int selectionEnd = this.fWA.getSelectionEnd();
            SpannableStringBuilder b = this.fWy.b(this.fWA.getText());
            if (b != null) {
                this.fWy.ob(true);
                this.fWA.setText(b);
                if (z && this.fWy.bLr() >= 0) {
                    this.fWA.requestFocus();
                    this.fWA.setSelection(this.fWy.bLr());
                } else {
                    this.fWA.setSelection(selectionEnd);
                }
                this.fWy.oa(this.fWy.bLr() >= 0);
            }
        }
    }

    public void bkv() {
        this.fWy.wJ(null);
        this.fWy.aA(null);
        this.fWy.oa(false);
    }

    public void bkw() {
        this.fWx.wJ(null);
        this.fWx.aA(null);
        this.fWx.oa(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWx.aA(postWriteCallBackData.getSensitiveWords());
            this.fWx.wJ(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.J(this.fWx.bLq())) {
                lj(true);
                this.fPr = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWy.aA(postWriteCallBackData.getSensitiveWords());
            this.fWy.wJ(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.J(this.fWy.bLq())) {
                lk(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fWz = editText;
    }

    public void h(EditText editText) {
        this.fWA = editText;
    }

    public void onDestroy() {
        this.fWz = null;
        this.fWA = null;
    }

    public void onChangeSkinType() {
        this.fWx.onChangeSkinType();
        this.fWy.onChangeSkinType();
        if (this.fWx.bLs()) {
            lj(false);
        }
        if (this.fWy.bLs()) {
            lk(false);
        }
    }

    public com.baidu.tieba.write.b bkx() {
        return this.fWx;
    }

    public com.baidu.tieba.write.b bky() {
        return this.fWy;
    }

    public EditText bkz() {
        return this.fWA;
    }

    public PostWriteCallBackData bkA() {
        return this.fPr;
    }
}
