package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class au {
    private PostWriteCallBackData fjy;
    private com.baidu.tieba.write.b fqO = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fqP;
    private EditText fqQ;
    private EditText fqR;

    public au() {
        this.fqO.uK(d.C0126d.cp_cont_i);
        this.fqO.uL(d.C0126d.cp_cont_h_alpha85);
        this.fqP = new com.baidu.tieba.write.b();
        this.fqP.uK(d.C0126d.cp_cont_i);
        this.fqP.uL(d.C0126d.cp_cont_h_alpha85);
    }

    public void kr(boolean z) {
        if (this.fqQ != null && this.fqQ.getText() != null) {
            int selectionEnd = this.fqQ.getSelectionEnd();
            SpannableStringBuilder b = this.fqO.b(this.fqQ.getText());
            if (b != null) {
                this.fqO.nj(true);
                this.fqQ.setText(b);
                if (z && this.fqO.bAV() >= 0) {
                    this.fqQ.requestFocus();
                    this.fqQ.setSelection(this.fqO.bAV());
                } else {
                    this.fqQ.setSelection(selectionEnd);
                }
                this.fqO.ni(this.fqO.bAV() >= 0);
            }
        }
    }

    public void ks(boolean z) {
        if (this.fqR != null && this.fqR.getText() != null) {
            int selectionEnd = this.fqR.getSelectionEnd();
            SpannableStringBuilder b = this.fqP.b(this.fqR.getText());
            if (b != null) {
                this.fqP.nj(true);
                this.fqR.setText(b);
                if (z && this.fqP.bAV() >= 0) {
                    this.fqR.requestFocus();
                    this.fqR.setSelection(this.fqP.bAV());
                } else {
                    this.fqR.setSelection(selectionEnd);
                }
                this.fqP.ni(this.fqP.bAV() >= 0);
            }
        }
    }

    public void baO() {
        this.fqP.uB(null);
        this.fqP.ax(null);
        this.fqP.ni(false);
    }

    public void baP() {
        this.fqO.uB(null);
        this.fqO.ax(null);
        this.fqO.ni(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fqO.ax(postWriteCallBackData.getSensitiveWords());
            this.fqO.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.fqO.bAU())) {
                kr(true);
                this.fjy = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fqP.ax(postWriteCallBackData.getSensitiveWords());
            this.fqP.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.fqP.bAU())) {
                ks(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fqQ = editText;
    }

    public void h(EditText editText) {
        this.fqR = editText;
    }

    public void onDestroy() {
        this.fqQ = null;
        this.fqR = null;
    }

    public void onChangeSkinType() {
        this.fqO.onChangeSkinType();
        this.fqP.onChangeSkinType();
        if (this.fqO.bAW()) {
            kr(false);
        }
        if (this.fqP.bAW()) {
            ks(false);
        }
    }

    public com.baidu.tieba.write.b baQ() {
        return this.fqO;
    }

    public com.baidu.tieba.write.b baR() {
        return this.fqP;
    }

    public EditText baS() {
        return this.fqR;
    }

    public PostWriteCallBackData baT() {
        return this.fjy;
    }
}
