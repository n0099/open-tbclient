package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText fPk;
    private PostWriteCallBackData hrG;
    private com.baidu.tieba.write.b hyM = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hyN;
    private EditText hyO;

    public as() {
        this.hyM.AW(d.C0236d.cp_btn_a);
        this.hyM.AX(d.C0236d.cp_cont_h_alpha85);
        this.hyN = new com.baidu.tieba.write.b();
        this.hyN.AW(d.C0236d.cp_btn_a);
        this.hyN.AX(d.C0236d.cp_cont_h_alpha85);
    }

    public void nZ(boolean z) {
        if (this.hyO != null && this.hyO.getText() != null) {
            int selectionEnd = this.hyO.getSelectionEnd();
            SpannableStringBuilder b = this.hyM.b(this.hyO.getText());
            if (b != null) {
                this.hyM.qV(true);
                this.hyO.setText(b);
                if (z && this.hyM.cnW() >= 0) {
                    this.hyO.requestFocus();
                    this.hyO.setSelection(this.hyM.cnW());
                } else {
                    this.hyO.setSelection(selectionEnd);
                }
                this.hyM.qU(this.hyM.cnW() >= 0);
            }
        }
    }

    public void oa(boolean z) {
        if (this.fPk != null && this.fPk.getText() != null) {
            int selectionEnd = this.fPk.getSelectionEnd();
            SpannableStringBuilder b = this.hyN.b(this.fPk.getText());
            if (b != null) {
                this.hyN.qV(true);
                this.fPk.setText(b);
                if (z && this.hyN.cnW() >= 0) {
                    this.fPk.requestFocus();
                    this.fPk.setSelection(this.hyN.cnW());
                } else {
                    this.fPk.setSelection(selectionEnd);
                }
                this.hyN.qU(this.hyN.cnW() >= 0);
            }
        }
    }

    public void bNx() {
        this.hyN.El(null);
        this.hyN.aE(null);
        this.hyN.qU(false);
    }

    public void bNy() {
        this.hyM.El(null);
        this.hyM.aE(null);
        this.hyM.qU(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyM.aE(postWriteCallBackData.getSensitiveWords());
            this.hyM.El(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyM.cnV())) {
                nZ(true);
                this.hrG = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyN.aE(postWriteCallBackData.getSensitiveWords());
            this.hyN.El(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyN.cnV())) {
                oa(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hyO = editText;
    }

    public void l(EditText editText) {
        this.fPk = editText;
    }

    public void onDestroy() {
        this.hyO = null;
        this.fPk = null;
    }

    public void onChangeSkinType() {
        this.hyM.onChangeSkinType();
        this.hyN.onChangeSkinType();
        if (this.hyM.cnX()) {
            nZ(false);
        }
        if (this.hyN.cnX()) {
            oa(false);
        }
    }

    public com.baidu.tieba.write.b bNz() {
        return this.hyM;
    }

    public com.baidu.tieba.write.b bNA() {
        return this.hyN;
    }

    public EditText bNB() {
        return this.fPk;
    }

    public PostWriteCallBackData bNC() {
        return this.hrG;
    }
}
