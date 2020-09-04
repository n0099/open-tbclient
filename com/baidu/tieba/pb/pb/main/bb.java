package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText iUf;
    private PostWriteCallBackData kFL;
    private com.baidu.tieba.write.c kNa = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c kNb;
    private EditText kNc;

    public bb() {
        this.kNa.Jr(R.color.cp_cont_a);
        this.kNa.Js(R.color.cp_cont_h_alpha85);
        this.kNb = new com.baidu.tieba.write.c();
        this.kNb.Jr(R.color.cp_cont_a);
        this.kNb.Js(R.color.cp_cont_h_alpha85);
    }

    public void tK(boolean z) {
        if (this.kNc != null && this.kNc.getText() != null) {
            int selectionEnd = this.kNc.getSelectionEnd();
            SpannableStringBuilder c = this.kNa.c(this.kNc.getText());
            if (c != null) {
                this.kNa.xa(true);
                this.kNc.setText(c);
                if (z && this.kNa.dFE() >= 0) {
                    this.kNc.requestFocus();
                    this.kNc.setSelection(this.kNa.dFE());
                } else {
                    this.kNc.setSelection(selectionEnd);
                }
                this.kNa.wZ(this.kNa.dFE() >= 0);
            }
        }
    }

    public void tL(boolean z) {
        if (this.iUf != null && this.iUf.getText() != null) {
            int selectionEnd = this.iUf.getSelectionEnd();
            SpannableStringBuilder c = this.kNb.c(this.iUf.getText());
            if (c != null) {
                this.kNb.xa(true);
                this.iUf.setText(c);
                if (z && this.kNb.dFE() >= 0) {
                    this.iUf.requestFocus();
                    this.iUf.setSelection(this.kNb.dFE());
                } else {
                    this.iUf.setSelection(selectionEnd);
                }
                this.kNb.wZ(this.kNb.dFE() >= 0);
            }
        }
    }

    public void dbD() {
        this.kNb.Sw(null);
        this.kNb.bf(null);
        this.kNb.wZ(false);
    }

    public void dbE() {
        this.kNa.Sw(null);
        this.kNa.bf(null);
        this.kNa.wZ(false);
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kNa.bf(postWriteCallBackData.getSensitiveWords());
            this.kNa.Sw(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.kNa.dFD())) {
                tK(true);
                this.kFL = postWriteCallBackData;
            }
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kNb.bf(postWriteCallBackData.getSensitiveWords());
            this.kNb.Sw(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.kNb.dFD())) {
                tL(true);
            }
        }
    }

    public void f(EditText editText) {
        this.kNc = editText;
    }

    public void g(EditText editText) {
        this.iUf = editText;
    }

    public void onDestroy() {
        this.kNc = null;
        this.iUf = null;
    }

    public void onChangeSkinType() {
        this.kNa.onChangeSkinType();
        this.kNb.onChangeSkinType();
        if (this.kNa.dFF()) {
            tK(false);
        }
        if (this.kNb.dFF()) {
            tL(false);
        }
    }

    public com.baidu.tieba.write.c dbF() {
        return this.kNa;
    }

    public com.baidu.tieba.write.c dbG() {
        return this.kNb;
    }

    public EditText dbH() {
        return this.iUf;
    }

    public PostWriteCallBackData dbI() {
        return this.kFL;
    }
}
