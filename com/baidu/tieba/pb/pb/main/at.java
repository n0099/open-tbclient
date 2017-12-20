package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class at {
    private PostWriteCallBackData eXA;
    private com.baidu.tieba.write.b feC = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b feD;
    private EditText feE;
    private EditText feF;

    public at() {
        this.feC.vM(d.C0096d.cp_cont_i);
        this.feC.vN(d.C0096d.cp_cont_h_alpha85);
        this.feD = new com.baidu.tieba.write.b();
        this.feD.vM(d.C0096d.cp_cont_i);
        this.feD.vN(d.C0096d.cp_cont_h_alpha85);
    }

    public void ka(boolean z) {
        if (this.feE != null && this.feE.getText() != null) {
            int selectionEnd = this.feE.getSelectionEnd();
            SpannableStringBuilder b = this.feC.b(this.feE.getText());
            if (b != null) {
                this.feC.nU(true);
                this.feE.setText(b);
                if (z && this.feC.bFE() >= 0) {
                    this.feE.requestFocus();
                    this.feE.setSelection(this.feC.bFE());
                } else {
                    this.feE.setSelection(selectionEnd);
                }
                this.feC.nT(this.feC.bFE() >= 0);
            }
        }
    }

    public void kb(boolean z) {
        if (this.feF != null && this.feF.getText() != null) {
            int selectionEnd = this.feF.getSelectionEnd();
            SpannableStringBuilder b = this.feD.b(this.feF.getText());
            if (b != null) {
                this.feD.nU(true);
                this.feF.setText(b);
                if (z && this.feD.bFE() >= 0) {
                    this.feF.requestFocus();
                    this.feF.setSelection(this.feD.bFE());
                } else {
                    this.feF.setSelection(selectionEnd);
                }
                this.feD.nT(this.feD.bFE() >= 0);
            }
        }
    }

    public void aWT() {
        this.feD.uB(null);
        this.feD.aC(null);
        this.feD.nT(false);
    }

    public void aWU() {
        this.feC.uB(null);
        this.feC.aC(null);
        this.feC.nT(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.feC.aC(postWriteCallBackData.getSensitiveWords());
            this.feC.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.feC.bFD())) {
                ka(true);
                this.eXA = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.feD.aC(postWriteCallBackData.getSensitiveWords());
            this.feD.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.feD.bFD())) {
                kb(true);
            }
        }
    }

    public void g(EditText editText) {
        this.feE = editText;
    }

    public void h(EditText editText) {
        this.feF = editText;
    }

    public void onDestroy() {
        this.feE = null;
        this.feF = null;
    }

    public void onChangeSkinType() {
        this.feC.onChangeSkinType();
        this.feD.onChangeSkinType();
        if (this.feC.bFF()) {
            ka(false);
        }
        if (this.feD.bFF()) {
            kb(false);
        }
    }

    public com.baidu.tieba.write.b aWV() {
        return this.feC;
    }

    public com.baidu.tieba.write.b aWW() {
        return this.feD;
    }

    public EditText aWX() {
        return this.feF;
    }

    public PostWriteCallBackData aWY() {
        return this.eXA;
    }
}
