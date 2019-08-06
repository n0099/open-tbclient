package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText gnm;
    private PostWriteCallBackData hQd;
    private com.baidu.tieba.write.b hXq = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hXr;
    private EditText hXs;

    public as() {
        this.hXq.CK(R.color.cp_btn_a);
        this.hXq.CL(R.color.cp_cont_h_alpha85);
        this.hXr = new com.baidu.tieba.write.b();
        this.hXr.CK(R.color.cp_btn_a);
        this.hXr.CL(R.color.cp_cont_h_alpha85);
    }

    public void pd(boolean z) {
        if (this.hXs != null && this.hXs.getText() != null) {
            int selectionEnd = this.hXs.getSelectionEnd();
            SpannableStringBuilder b = this.hXq.b(this.hXs.getText());
            if (b != null) {
                this.hXq.sb(true);
                this.hXs.setText(b);
                if (z && this.hXq.czA() >= 0) {
                    this.hXs.requestFocus();
                    this.hXs.setSelection(this.hXq.czA());
                } else {
                    this.hXs.setSelection(selectionEnd);
                }
                this.hXq.sa(this.hXq.czA() >= 0);
            }
        }
    }

    public void pe(boolean z) {
        if (this.gnm != null && this.gnm.getText() != null) {
            int selectionEnd = this.gnm.getSelectionEnd();
            SpannableStringBuilder b = this.hXr.b(this.gnm.getText());
            if (b != null) {
                this.hXr.sb(true);
                this.gnm.setText(b);
                if (z && this.hXr.czA() >= 0) {
                    this.gnm.requestFocus();
                    this.gnm.setSelection(this.hXr.czA());
                } else {
                    this.gnm.setSelection(selectionEnd);
                }
                this.hXr.sa(this.hXr.czA() >= 0);
            }
        }
    }

    public void bYw() {
        this.hXr.GB(null);
        this.hXr.aI(null);
        this.hXr.sa(false);
    }

    public void bYx() {
        this.hXq.GB(null);
        this.hXq.aI(null);
        this.hXq.sa(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hXq.aI(postWriteCallBackData.getSensitiveWords());
            this.hXq.GB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hXq.czz())) {
                pd(true);
                this.hQd = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hXr.aI(postWriteCallBackData.getSensitiveWords());
            this.hXr.GB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hXr.czz())) {
                pe(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hXs = editText;
    }

    public void l(EditText editText) {
        this.gnm = editText;
    }

    public void onDestroy() {
        this.hXs = null;
        this.gnm = null;
    }

    public void onChangeSkinType() {
        this.hXq.onChangeSkinType();
        this.hXr.onChangeSkinType();
        if (this.hXq.czB()) {
            pd(false);
        }
        if (this.hXr.czB()) {
            pe(false);
        }
    }

    public com.baidu.tieba.write.b bYy() {
        return this.hXq;
    }

    public com.baidu.tieba.write.b bYz() {
        return this.hXr;
    }

    public EditText bYA() {
        return this.gnm;
    }

    public PostWriteCallBackData bYB() {
        return this.hQd;
    }
}
