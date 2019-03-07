package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText fPk;
    private PostWriteCallBackData hrF;
    private com.baidu.tieba.write.b hyL = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hyM;
    private EditText hyN;

    public as() {
        this.hyL.AV(d.C0236d.cp_btn_a);
        this.hyL.AW(d.C0236d.cp_cont_h_alpha85);
        this.hyM = new com.baidu.tieba.write.b();
        this.hyM.AV(d.C0236d.cp_btn_a);
        this.hyM.AW(d.C0236d.cp_cont_h_alpha85);
    }

    public void nZ(boolean z) {
        if (this.hyN != null && this.hyN.getText() != null) {
            int selectionEnd = this.hyN.getSelectionEnd();
            SpannableStringBuilder b = this.hyL.b(this.hyN.getText());
            if (b != null) {
                this.hyL.qV(true);
                this.hyN.setText(b);
                if (z && this.hyL.cnM() >= 0) {
                    this.hyN.requestFocus();
                    this.hyN.setSelection(this.hyL.cnM());
                } else {
                    this.hyN.setSelection(selectionEnd);
                }
                this.hyL.qU(this.hyL.cnM() >= 0);
            }
        }
    }

    public void oa(boolean z) {
        if (this.fPk != null && this.fPk.getText() != null) {
            int selectionEnd = this.fPk.getSelectionEnd();
            SpannableStringBuilder b = this.hyM.b(this.fPk.getText());
            if (b != null) {
                this.hyM.qV(true);
                this.fPk.setText(b);
                if (z && this.hyM.cnM() >= 0) {
                    this.fPk.requestFocus();
                    this.fPk.setSelection(this.hyM.cnM());
                } else {
                    this.fPk.setSelection(selectionEnd);
                }
                this.hyM.qU(this.hyM.cnM() >= 0);
            }
        }
    }

    public void bNw() {
        this.hyM.Ei(null);
        this.hyM.aE(null);
        this.hyM.qU(false);
    }

    public void bNx() {
        this.hyL.Ei(null);
        this.hyL.aE(null);
        this.hyL.qU(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyL.aE(postWriteCallBackData.getSensitiveWords());
            this.hyL.Ei(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyL.cnL())) {
                nZ(true);
                this.hrF = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyM.aE(postWriteCallBackData.getSensitiveWords());
            this.hyM.Ei(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyM.cnL())) {
                oa(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hyN = editText;
    }

    public void l(EditText editText) {
        this.fPk = editText;
    }

    public void onDestroy() {
        this.hyN = null;
        this.fPk = null;
    }

    public void onChangeSkinType() {
        this.hyL.onChangeSkinType();
        this.hyM.onChangeSkinType();
        if (this.hyL.cnN()) {
            nZ(false);
        }
        if (this.hyM.cnN()) {
            oa(false);
        }
    }

    public com.baidu.tieba.write.b bNy() {
        return this.hyL;
    }

    public com.baidu.tieba.write.b bNz() {
        return this.hyM;
    }

    public EditText bNA() {
        return this.fPk;
    }

    public PostWriteCallBackData bNB() {
        return this.hrF;
    }
}
