package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ap {
    private EditText hiE;
    private PostWriteCallBackData iLo;
    private com.baidu.tieba.write.c iRJ = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c iRK;
    private EditText iRL;

    public ap() {
        this.iRJ.Eh(R.color.cp_cont_a);
        this.iRJ.Ei(R.color.cp_cont_h_alpha85);
        this.iRK = new com.baidu.tieba.write.c();
        this.iRK.Eh(R.color.cp_cont_a);
        this.iRK.Ei(R.color.cp_cont_h_alpha85);
    }

    public void qC(boolean z) {
        if (this.iRL != null && this.iRL.getText() != null) {
            int selectionEnd = this.iRL.getSelectionEnd();
            SpannableStringBuilder a = this.iRJ.a(this.iRL.getText());
            if (a != null) {
                this.iRJ.tO(true);
                this.iRL.setText(a);
                if (z && this.iRJ.cUy() >= 0) {
                    this.iRL.requestFocus();
                    this.iRL.setSelection(this.iRJ.cUy());
                } else {
                    this.iRL.setSelection(selectionEnd);
                }
                this.iRJ.tN(this.iRJ.cUy() >= 0);
            }
        }
    }

    public void qD(boolean z) {
        if (this.hiE != null && this.hiE.getText() != null) {
            int selectionEnd = this.hiE.getSelectionEnd();
            SpannableStringBuilder a = this.iRK.a(this.hiE.getText());
            if (a != null) {
                this.iRK.tO(true);
                this.hiE.setText(a);
                if (z && this.iRK.cUy() >= 0) {
                    this.hiE.requestFocus();
                    this.hiE.setSelection(this.iRK.cUy());
                } else {
                    this.hiE.setSelection(selectionEnd);
                }
                this.iRK.tN(this.iRK.cUy() >= 0);
            }
        }
    }

    public void cqR() {
        this.iRK.KL(null);
        this.iRK.aU(null);
        this.iRK.tN(false);
    }

    public void cqS() {
        this.iRJ.KL(null);
        this.iRJ.aU(null);
        this.iRJ.tN(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iRJ.aU(postWriteCallBackData.getSensitiveWords());
            this.iRJ.KL(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iRJ.cUx())) {
                qC(true);
                this.iLo = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iRK.aU(postWriteCallBackData.getSensitiveWords());
            this.iRK.KL(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iRK.cUx())) {
                qD(true);
            }
        }
    }

    public void e(EditText editText) {
        this.iRL = editText;
    }

    public void f(EditText editText) {
        this.hiE = editText;
    }

    public void onDestroy() {
        this.iRL = null;
        this.hiE = null;
    }

    public void onChangeSkinType() {
        this.iRJ.onChangeSkinType();
        this.iRK.onChangeSkinType();
        if (this.iRJ.cUz()) {
            qC(false);
        }
        if (this.iRK.cUz()) {
            qD(false);
        }
    }

    public com.baidu.tieba.write.c cqT() {
        return this.iRJ;
    }

    public com.baidu.tieba.write.c cqU() {
        return this.iRK;
    }

    public EditText cqV() {
        return this.hiE;
    }

    public PostWriteCallBackData cqW() {
        return this.iLo;
    }
}
