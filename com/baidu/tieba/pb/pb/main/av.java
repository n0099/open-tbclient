package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class av {
    private PostWriteCallBackData fAn;
    private com.baidu.tieba.write.b fHD = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fHE;
    private EditText fHF;
    private EditText fHG;

    public av() {
        this.fHD.vi(d.C0140d.cp_cont_i);
        this.fHD.vj(d.C0140d.cp_cont_h_alpha85);
        this.fHE = new com.baidu.tieba.write.b();
        this.fHE.vi(d.C0140d.cp_cont_i);
        this.fHE.vj(d.C0140d.cp_cont_h_alpha85);
    }

    public void ku(boolean z) {
        if (this.fHF != null && this.fHF.getText() != null) {
            int selectionEnd = this.fHF.getSelectionEnd();
            SpannableStringBuilder b = this.fHD.b(this.fHF.getText());
            if (b != null) {
                this.fHD.no(true);
                this.fHF.setText(b);
                if (z && this.fHD.bFk() >= 0) {
                    this.fHF.requestFocus();
                    this.fHF.setSelection(this.fHD.bFk());
                } else {
                    this.fHF.setSelection(selectionEnd);
                }
                this.fHD.nn(this.fHD.bFk() >= 0);
            }
        }
    }

    public void kv(boolean z) {
        if (this.fHG != null && this.fHG.getText() != null) {
            int selectionEnd = this.fHG.getSelectionEnd();
            SpannableStringBuilder b = this.fHE.b(this.fHG.getText());
            if (b != null) {
                this.fHE.no(true);
                this.fHG.setText(b);
                if (z && this.fHE.bFk() >= 0) {
                    this.fHG.requestFocus();
                    this.fHG.setSelection(this.fHE.bFk());
                } else {
                    this.fHG.setSelection(selectionEnd);
                }
                this.fHE.nn(this.fHE.bFk() >= 0);
            }
        }
    }

    public void beO() {
        this.fHE.vv(null);
        this.fHE.az(null);
        this.fHE.nn(false);
    }

    public void beP() {
        this.fHD.vv(null);
        this.fHD.az(null);
        this.fHD.nn(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fHD.az(postWriteCallBackData.getSensitiveWords());
            this.fHD.vv(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.z(this.fHD.bFj())) {
                ku(true);
                this.fAn = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fHE.az(postWriteCallBackData.getSensitiveWords());
            this.fHE.vv(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.z(this.fHE.bFj())) {
                kv(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fHF = editText;
    }

    public void h(EditText editText) {
        this.fHG = editText;
    }

    public void onDestroy() {
        this.fHF = null;
        this.fHG = null;
    }

    public void onChangeSkinType() {
        this.fHD.onChangeSkinType();
        this.fHE.onChangeSkinType();
        if (this.fHD.bFl()) {
            ku(false);
        }
        if (this.fHE.bFl()) {
            kv(false);
        }
    }

    public com.baidu.tieba.write.b beQ() {
        return this.fHD;
    }

    public com.baidu.tieba.write.b beR() {
        return this.fHE;
    }

    public EditText beS() {
        return this.fHG;
    }

    public PostWriteCallBackData beT() {
        return this.fAn;
    }
}
