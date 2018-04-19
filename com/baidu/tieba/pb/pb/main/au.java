package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class au {
    private PostWriteCallBackData fjB;
    private com.baidu.tieba.write.b fqR = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fqS;
    private EditText fqT;
    private EditText fqU;

    public au() {
        this.fqR.uK(d.C0126d.cp_cont_i);
        this.fqR.uL(d.C0126d.cp_cont_h_alpha85);
        this.fqS = new com.baidu.tieba.write.b();
        this.fqS.uK(d.C0126d.cp_cont_i);
        this.fqS.uL(d.C0126d.cp_cont_h_alpha85);
    }

    public void kr(boolean z) {
        if (this.fqT != null && this.fqT.getText() != null) {
            int selectionEnd = this.fqT.getSelectionEnd();
            SpannableStringBuilder b = this.fqR.b(this.fqT.getText());
            if (b != null) {
                this.fqR.nj(true);
                this.fqT.setText(b);
                if (z && this.fqR.bAV() >= 0) {
                    this.fqT.requestFocus();
                    this.fqT.setSelection(this.fqR.bAV());
                } else {
                    this.fqT.setSelection(selectionEnd);
                }
                this.fqR.ni(this.fqR.bAV() >= 0);
            }
        }
    }

    public void ks(boolean z) {
        if (this.fqU != null && this.fqU.getText() != null) {
            int selectionEnd = this.fqU.getSelectionEnd();
            SpannableStringBuilder b = this.fqS.b(this.fqU.getText());
            if (b != null) {
                this.fqS.nj(true);
                this.fqU.setText(b);
                if (z && this.fqS.bAV() >= 0) {
                    this.fqU.requestFocus();
                    this.fqU.setSelection(this.fqS.bAV());
                } else {
                    this.fqU.setSelection(selectionEnd);
                }
                this.fqS.ni(this.fqS.bAV() >= 0);
            }
        }
    }

    public void baO() {
        this.fqS.uB(null);
        this.fqS.ax(null);
        this.fqS.ni(false);
    }

    public void baP() {
        this.fqR.uB(null);
        this.fqR.ax(null);
        this.fqR.ni(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fqR.ax(postWriteCallBackData.getSensitiveWords());
            this.fqR.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.fqR.bAU())) {
                kr(true);
                this.fjB = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fqS.ax(postWriteCallBackData.getSensitiveWords());
            this.fqS.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.fqS.bAU())) {
                ks(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fqT = editText;
    }

    public void h(EditText editText) {
        this.fqU = editText;
    }

    public void onDestroy() {
        this.fqT = null;
        this.fqU = null;
    }

    public void onChangeSkinType() {
        this.fqR.onChangeSkinType();
        this.fqS.onChangeSkinType();
        if (this.fqR.bAW()) {
            kr(false);
        }
        if (this.fqS.bAW()) {
            ks(false);
        }
    }

    public com.baidu.tieba.write.b baQ() {
        return this.fqR;
    }

    public com.baidu.tieba.write.b baR() {
        return this.fqS;
    }

    public EditText baS() {
        return this.fqU;
    }

    public PostWriteCallBackData baT() {
        return this.fjB;
    }
}
