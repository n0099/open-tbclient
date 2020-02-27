package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ap {
    private EditText hgP;
    private PostWriteCallBackData iJz;
    private com.baidu.tieba.write.c iPU = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c iPV;
    private EditText iPW;

    public ap() {
        this.iPU.DZ(R.color.cp_cont_a);
        this.iPU.Ea(R.color.cp_cont_h_alpha85);
        this.iPV = new com.baidu.tieba.write.c();
        this.iPV.DZ(R.color.cp_cont_a);
        this.iPV.Ea(R.color.cp_cont_h_alpha85);
    }

    public void qw(boolean z) {
        if (this.iPW != null && this.iPW.getText() != null) {
            int selectionEnd = this.iPW.getSelectionEnd();
            SpannableStringBuilder a = this.iPU.a(this.iPW.getText());
            if (a != null) {
                this.iPU.tH(true);
                this.iPW.setText(a);
                if (z && this.iPU.cUb() >= 0) {
                    this.iPW.requestFocus();
                    this.iPW.setSelection(this.iPU.cUb());
                } else {
                    this.iPW.setSelection(selectionEnd);
                }
                this.iPU.tG(this.iPU.cUb() >= 0);
            }
        }
    }

    public void qx(boolean z) {
        if (this.hgP != null && this.hgP.getText() != null) {
            int selectionEnd = this.hgP.getSelectionEnd();
            SpannableStringBuilder a = this.iPV.a(this.hgP.getText());
            if (a != null) {
                this.iPV.tH(true);
                this.hgP.setText(a);
                if (z && this.iPV.cUb() >= 0) {
                    this.hgP.requestFocus();
                    this.hgP.setSelection(this.iPV.cUb());
                } else {
                    this.hgP.setSelection(selectionEnd);
                }
                this.iPV.tG(this.iPV.cUb() >= 0);
            }
        }
    }

    public void cqt() {
        this.iPV.KK(null);
        this.iPV.aU(null);
        this.iPV.tG(false);
    }

    public void cqu() {
        this.iPU.KK(null);
        this.iPU.aU(null);
        this.iPU.tG(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iPU.aU(postWriteCallBackData.getSensitiveWords());
            this.iPU.KK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iPU.cUa())) {
                qw(true);
                this.iJz = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iPV.aU(postWriteCallBackData.getSensitiveWords());
            this.iPV.KK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iPV.cUa())) {
                qx(true);
            }
        }
    }

    public void e(EditText editText) {
        this.iPW = editText;
    }

    public void f(EditText editText) {
        this.hgP = editText;
    }

    public void onDestroy() {
        this.iPW = null;
        this.hgP = null;
    }

    public void onChangeSkinType() {
        this.iPU.onChangeSkinType();
        this.iPV.onChangeSkinType();
        if (this.iPU.cUc()) {
            qw(false);
        }
        if (this.iPV.cUc()) {
            qx(false);
        }
    }

    public com.baidu.tieba.write.c cqv() {
        return this.iPU;
    }

    public com.baidu.tieba.write.c cqw() {
        return this.iPV;
    }

    public EditText cqx() {
        return this.hgP;
    }

    public PostWriteCallBackData cqy() {
        return this.iJz;
    }
}
