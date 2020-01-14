package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes7.dex */
public class as {
    private EditText heP;
    private PostWriteCallBackData iHZ;
    private com.baidu.tieba.write.c iOA;
    private EditText iOB;
    private com.baidu.tieba.write.c iOz = new com.baidu.tieba.write.c();

    public as() {
        this.iOz.DU(R.color.cp_cont_a);
        this.iOz.DV(R.color.cp_cont_h_alpha85);
        this.iOA = new com.baidu.tieba.write.c();
        this.iOA.DU(R.color.cp_cont_a);
        this.iOA.DV(R.color.cp_cont_h_alpha85);
    }

    public void qt(boolean z) {
        if (this.iOB != null && this.iOB.getText() != null) {
            int selectionEnd = this.iOB.getSelectionEnd();
            SpannableStringBuilder a = this.iOz.a(this.iOB.getText());
            if (a != null) {
                this.iOz.tD(true);
                this.iOB.setText(a);
                if (z && this.iOz.cSN() >= 0) {
                    this.iOB.requestFocus();
                    this.iOB.setSelection(this.iOz.cSN());
                } else {
                    this.iOB.setSelection(selectionEnd);
                }
                this.iOz.tC(this.iOz.cSN() >= 0);
            }
        }
    }

    public void qu(boolean z) {
        if (this.heP != null && this.heP.getText() != null) {
            int selectionEnd = this.heP.getSelectionEnd();
            SpannableStringBuilder a = this.iOA.a(this.heP.getText());
            if (a != null) {
                this.iOA.tD(true);
                this.heP.setText(a);
                if (z && this.iOA.cSN() >= 0) {
                    this.heP.requestFocus();
                    this.heP.setSelection(this.iOA.cSN());
                } else {
                    this.heP.setSelection(selectionEnd);
                }
                this.iOA.tC(this.iOA.cSN() >= 0);
            }
        }
    }

    public void cpb() {
        this.iOA.Kx(null);
        this.iOA.aV(null);
        this.iOA.tC(false);
    }

    public void cpc() {
        this.iOz.Kx(null);
        this.iOz.aV(null);
        this.iOz.tC(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iOz.aV(postWriteCallBackData.getSensitiveWords());
            this.iOz.Kx(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iOz.cSM())) {
                qt(true);
                this.iHZ = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iOA.aV(postWriteCallBackData.getSensitiveWords());
            this.iOA.Kx(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iOA.cSM())) {
                qu(true);
            }
        }
    }

    public void e(EditText editText) {
        this.iOB = editText;
    }

    public void f(EditText editText) {
        this.heP = editText;
    }

    public void onDestroy() {
        this.iOB = null;
        this.heP = null;
    }

    public void onChangeSkinType() {
        this.iOz.onChangeSkinType();
        this.iOA.onChangeSkinType();
        if (this.iOz.cSO()) {
            qt(false);
        }
        if (this.iOA.cSO()) {
            qu(false);
        }
    }

    public com.baidu.tieba.write.c cpd() {
        return this.iOz;
    }

    public com.baidu.tieba.write.c cpe() {
        return this.iOA;
    }

    public EditText cpf() {
        return this.heP;
    }

    public PostWriteCallBackData cpg() {
        return this.iHZ;
    }
}
