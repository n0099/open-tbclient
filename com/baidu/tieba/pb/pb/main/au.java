package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class au {
    private PostWriteCallBackData fkF;
    private com.baidu.tieba.write.b frW = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b frX;
    private EditText frY;
    private EditText frZ;

    public au() {
        this.frW.uJ(d.C0126d.cp_cont_i);
        this.frW.uK(d.C0126d.cp_cont_h_alpha85);
        this.frX = new com.baidu.tieba.write.b();
        this.frX.uJ(d.C0126d.cp_cont_i);
        this.frX.uK(d.C0126d.cp_cont_h_alpha85);
    }

    public void ks(boolean z) {
        if (this.frY != null && this.frY.getText() != null) {
            int selectionEnd = this.frY.getSelectionEnd();
            SpannableStringBuilder b = this.frW.b(this.frY.getText());
            if (b != null) {
                this.frW.nk(true);
                this.frY.setText(b);
                if (z && this.frW.bAT() >= 0) {
                    this.frY.requestFocus();
                    this.frY.setSelection(this.frW.bAT());
                } else {
                    this.frY.setSelection(selectionEnd);
                }
                this.frW.nj(this.frW.bAT() >= 0);
            }
        }
    }

    public void kt(boolean z) {
        if (this.frZ != null && this.frZ.getText() != null) {
            int selectionEnd = this.frZ.getSelectionEnd();
            SpannableStringBuilder b = this.frX.b(this.frZ.getText());
            if (b != null) {
                this.frX.nk(true);
                this.frZ.setText(b);
                if (z && this.frX.bAT() >= 0) {
                    this.frZ.requestFocus();
                    this.frZ.setSelection(this.frX.bAT());
                } else {
                    this.frZ.setSelection(selectionEnd);
                }
                this.frX.nj(this.frX.bAT() >= 0);
            }
        }
    }

    public void baO() {
        this.frX.uE(null);
        this.frX.ax(null);
        this.frX.nj(false);
    }

    public void baP() {
        this.frW.uE(null);
        this.frW.ax(null);
        this.frW.nj(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.frW.ax(postWriteCallBackData.getSensitiveWords());
            this.frW.uE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.frW.bAS())) {
                ks(true);
                this.fkF = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.frX.ax(postWriteCallBackData.getSensitiveWords());
            this.frX.uE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.frX.bAS())) {
                kt(true);
            }
        }
    }

    public void g(EditText editText) {
        this.frY = editText;
    }

    public void h(EditText editText) {
        this.frZ = editText;
    }

    public void onDestroy() {
        this.frY = null;
        this.frZ = null;
    }

    public void onChangeSkinType() {
        this.frW.onChangeSkinType();
        this.frX.onChangeSkinType();
        if (this.frW.bAU()) {
            ks(false);
        }
        if (this.frX.bAU()) {
            kt(false);
        }
    }

    public com.baidu.tieba.write.b baQ() {
        return this.frW;
    }

    public com.baidu.tieba.write.b baR() {
        return this.frX;
    }

    public EditText baS() {
        return this.frZ;
    }

    public PostWriteCallBackData baT() {
        return this.fkF;
    }
}
