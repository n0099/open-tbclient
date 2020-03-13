package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ap {
    private EditText hhd;
    private PostWriteCallBackData iJN;
    private com.baidu.tieba.write.c iQi = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c iQj;
    private EditText iQk;

    public ap() {
        this.iQi.DZ(R.color.cp_cont_a);
        this.iQi.Ea(R.color.cp_cont_h_alpha85);
        this.iQj = new com.baidu.tieba.write.c();
        this.iQj.DZ(R.color.cp_cont_a);
        this.iQj.Ea(R.color.cp_cont_h_alpha85);
    }

    public void qw(boolean z) {
        if (this.iQk != null && this.iQk.getText() != null) {
            int selectionEnd = this.iQk.getSelectionEnd();
            SpannableStringBuilder a = this.iQi.a(this.iQk.getText());
            if (a != null) {
                this.iQi.tH(true);
                this.iQk.setText(a);
                if (z && this.iQi.cUe() >= 0) {
                    this.iQk.requestFocus();
                    this.iQk.setSelection(this.iQi.cUe());
                } else {
                    this.iQk.setSelection(selectionEnd);
                }
                this.iQi.tG(this.iQi.cUe() >= 0);
            }
        }
    }

    public void qx(boolean z) {
        if (this.hhd != null && this.hhd.getText() != null) {
            int selectionEnd = this.hhd.getSelectionEnd();
            SpannableStringBuilder a = this.iQj.a(this.hhd.getText());
            if (a != null) {
                this.iQj.tH(true);
                this.hhd.setText(a);
                if (z && this.iQj.cUe() >= 0) {
                    this.hhd.requestFocus();
                    this.hhd.setSelection(this.iQj.cUe());
                } else {
                    this.hhd.setSelection(selectionEnd);
                }
                this.iQj.tG(this.iQj.cUe() >= 0);
            }
        }
    }

    public void cqw() {
        this.iQj.KL(null);
        this.iQj.aU(null);
        this.iQj.tG(false);
    }

    public void cqx() {
        this.iQi.KL(null);
        this.iQi.aU(null);
        this.iQi.tG(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iQi.aU(postWriteCallBackData.getSensitiveWords());
            this.iQi.KL(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iQi.cUd())) {
                qw(true);
                this.iJN = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iQj.aU(postWriteCallBackData.getSensitiveWords());
            this.iQj.KL(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iQj.cUd())) {
                qx(true);
            }
        }
    }

    public void e(EditText editText) {
        this.iQk = editText;
    }

    public void f(EditText editText) {
        this.hhd = editText;
    }

    public void onDestroy() {
        this.iQk = null;
        this.hhd = null;
    }

    public void onChangeSkinType() {
        this.iQi.onChangeSkinType();
        this.iQj.onChangeSkinType();
        if (this.iQi.cUf()) {
            qw(false);
        }
        if (this.iQj.cUf()) {
            qx(false);
        }
    }

    public com.baidu.tieba.write.c cqy() {
        return this.iQi;
    }

    public com.baidu.tieba.write.c cqz() {
        return this.iQj;
    }

    public EditText cqA() {
        return this.hhd;
    }

    public PostWriteCallBackData cqB() {
        return this.iJN;
    }
}
