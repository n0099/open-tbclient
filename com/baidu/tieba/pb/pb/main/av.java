package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class av {
    private PostWriteCallBackData fAb;
    private com.baidu.tieba.write.b fHo = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fHp;
    private EditText fHq;
    private EditText fHr;

    public av() {
        this.fHo.vj(d.C0142d.cp_cont_i);
        this.fHo.vk(d.C0142d.cp_cont_h_alpha85);
        this.fHp = new com.baidu.tieba.write.b();
        this.fHp.vj(d.C0142d.cp_cont_i);
        this.fHp.vk(d.C0142d.cp_cont_h_alpha85);
    }

    public void kI(boolean z) {
        if (this.fHq != null && this.fHq.getText() != null) {
            int selectionEnd = this.fHq.getSelectionEnd();
            SpannableStringBuilder b = this.fHo.b(this.fHq.getText());
            if (b != null) {
                this.fHo.nA(true);
                this.fHq.setText(b);
                if (z && this.fHo.bGz() >= 0) {
                    this.fHq.requestFocus();
                    this.fHq.setSelection(this.fHo.bGz());
                } else {
                    this.fHq.setSelection(selectionEnd);
                }
                this.fHo.nz(this.fHo.bGz() >= 0);
            }
        }
    }

    public void kJ(boolean z) {
        if (this.fHr != null && this.fHr.getText() != null) {
            int selectionEnd = this.fHr.getSelectionEnd();
            SpannableStringBuilder b = this.fHp.b(this.fHr.getText());
            if (b != null) {
                this.fHp.nA(true);
                this.fHr.setText(b);
                if (z && this.fHp.bGz() >= 0) {
                    this.fHr.requestFocus();
                    this.fHr.setSelection(this.fHp.bGz());
                } else {
                    this.fHr.setSelection(selectionEnd);
                }
                this.fHp.nz(this.fHp.bGz() >= 0);
            }
        }
    }

    public void bgv() {
        this.fHp.vu(null);
        this.fHp.aB(null);
        this.fHp.nz(false);
    }

    public void bgw() {
        this.fHo.vu(null);
        this.fHo.aB(null);
        this.fHo.nz(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fHo.aB(postWriteCallBackData.getSensitiveWords());
            this.fHo.vu(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.A(this.fHo.bGy())) {
                kI(true);
                this.fAb = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fHp.aB(postWriteCallBackData.getSensitiveWords());
            this.fHp.vu(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.A(this.fHp.bGy())) {
                kJ(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fHq = editText;
    }

    public void h(EditText editText) {
        this.fHr = editText;
    }

    public void onDestroy() {
        this.fHq = null;
        this.fHr = null;
    }

    public void onChangeSkinType() {
        this.fHo.onChangeSkinType();
        this.fHp.onChangeSkinType();
        if (this.fHo.bGA()) {
            kI(false);
        }
        if (this.fHp.bGA()) {
            kJ(false);
        }
    }

    public com.baidu.tieba.write.b bgx() {
        return this.fHo;
    }

    public com.baidu.tieba.write.b bgy() {
        return this.fHp;
    }

    public EditText bgz() {
        return this.fHr;
    }

    public PostWriteCallBackData bgA() {
        return this.fAb;
    }
}
