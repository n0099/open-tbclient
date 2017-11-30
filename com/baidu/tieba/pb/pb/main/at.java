package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class at {
    private PostWriteCallBackData eWx;
    private com.baidu.tieba.write.b fdB = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fdC;
    private EditText fdD;
    private EditText fdE;

    public at() {
        this.fdB.vA(d.C0082d.cp_cont_i);
        this.fdB.vB(d.C0082d.cp_cont_h_alpha85);
        this.fdC = new com.baidu.tieba.write.b();
        this.fdC.vA(d.C0082d.cp_cont_i);
        this.fdC.vB(d.C0082d.cp_cont_h_alpha85);
    }

    public void jZ(boolean z) {
        if (this.fdD != null && this.fdD.getText() != null) {
            int selectionEnd = this.fdD.getSelectionEnd();
            SpannableStringBuilder b = this.fdB.b(this.fdD.getText());
            if (b != null) {
                this.fdB.nT(true);
                this.fdD.setText(b);
                if (z && this.fdB.bET() >= 0) {
                    this.fdD.requestFocus();
                    this.fdD.setSelection(this.fdB.bET());
                } else {
                    this.fdD.setSelection(selectionEnd);
                }
                this.fdB.nS(this.fdB.bET() >= 0);
            }
        }
    }

    public void ka(boolean z) {
        if (this.fdE != null && this.fdE.getText() != null) {
            int selectionEnd = this.fdE.getSelectionEnd();
            SpannableStringBuilder b = this.fdC.b(this.fdE.getText());
            if (b != null) {
                this.fdC.nT(true);
                this.fdE.setText(b);
                if (z && this.fdC.bET() >= 0) {
                    this.fdE.requestFocus();
                    this.fdE.setSelection(this.fdC.bET());
                } else {
                    this.fdE.setSelection(selectionEnd);
                }
                this.fdC.nS(this.fdC.bET() >= 0);
            }
        }
    }

    public void aWL() {
        this.fdC.uw(null);
        this.fdC.aB(null);
        this.fdC.nS(false);
    }

    public void aWM() {
        this.fdB.uw(null);
        this.fdB.aB(null);
        this.fdB.nS(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fdB.aB(postWriteCallBackData.getSensitiveWords());
            this.fdB.uw(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.fdB.bES())) {
                jZ(true);
                this.eWx = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fdC.aB(postWriteCallBackData.getSensitiveWords());
            this.fdC.uw(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.fdC.bES())) {
                ka(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fdD = editText;
    }

    public void h(EditText editText) {
        this.fdE = editText;
    }

    public void onDestroy() {
        this.fdD = null;
        this.fdE = null;
    }

    public void onChangeSkinType() {
        this.fdB.onChangeSkinType();
        this.fdC.onChangeSkinType();
        if (this.fdB.bEU()) {
            jZ(false);
        }
        if (this.fdC.bEU()) {
            ka(false);
        }
    }

    public com.baidu.tieba.write.b aWN() {
        return this.fdB;
    }

    public com.baidu.tieba.write.b aWO() {
        return this.fdC;
    }

    public EditText aWP() {
        return this.fdE;
    }

    public PostWriteCallBackData aWQ() {
        return this.eWx;
    }
}
