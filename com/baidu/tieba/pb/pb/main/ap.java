package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ap {
    private EditText hgR;
    private PostWriteCallBackData iJB;
    private com.baidu.tieba.write.c iPW = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c iPX;
    private EditText iPY;

    public ap() {
        this.iPW.DZ(R.color.cp_cont_a);
        this.iPW.Ea(R.color.cp_cont_h_alpha85);
        this.iPX = new com.baidu.tieba.write.c();
        this.iPX.DZ(R.color.cp_cont_a);
        this.iPX.Ea(R.color.cp_cont_h_alpha85);
    }

    public void qw(boolean z) {
        if (this.iPY != null && this.iPY.getText() != null) {
            int selectionEnd = this.iPY.getSelectionEnd();
            SpannableStringBuilder a = this.iPW.a(this.iPY.getText());
            if (a != null) {
                this.iPW.tH(true);
                this.iPY.setText(a);
                if (z && this.iPW.cUd() >= 0) {
                    this.iPY.requestFocus();
                    this.iPY.setSelection(this.iPW.cUd());
                } else {
                    this.iPY.setSelection(selectionEnd);
                }
                this.iPW.tG(this.iPW.cUd() >= 0);
            }
        }
    }

    public void qx(boolean z) {
        if (this.hgR != null && this.hgR.getText() != null) {
            int selectionEnd = this.hgR.getSelectionEnd();
            SpannableStringBuilder a = this.iPX.a(this.hgR.getText());
            if (a != null) {
                this.iPX.tH(true);
                this.hgR.setText(a);
                if (z && this.iPX.cUd() >= 0) {
                    this.hgR.requestFocus();
                    this.hgR.setSelection(this.iPX.cUd());
                } else {
                    this.hgR.setSelection(selectionEnd);
                }
                this.iPX.tG(this.iPX.cUd() >= 0);
            }
        }
    }

    public void cqv() {
        this.iPX.KK(null);
        this.iPX.aU(null);
        this.iPX.tG(false);
    }

    public void cqw() {
        this.iPW.KK(null);
        this.iPW.aU(null);
        this.iPW.tG(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iPW.aU(postWriteCallBackData.getSensitiveWords());
            this.iPW.KK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iPW.cUc())) {
                qw(true);
                this.iJB = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iPX.aU(postWriteCallBackData.getSensitiveWords());
            this.iPX.KK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iPX.cUc())) {
                qx(true);
            }
        }
    }

    public void e(EditText editText) {
        this.iPY = editText;
    }

    public void f(EditText editText) {
        this.hgR = editText;
    }

    public void onDestroy() {
        this.iPY = null;
        this.hgR = null;
    }

    public void onChangeSkinType() {
        this.iPW.onChangeSkinType();
        this.iPX.onChangeSkinType();
        if (this.iPW.cUe()) {
            qw(false);
        }
        if (this.iPX.cUe()) {
            qx(false);
        }
    }

    public com.baidu.tieba.write.c cqx() {
        return this.iPW;
    }

    public com.baidu.tieba.write.c cqy() {
        return this.iPX;
    }

    public EditText cqz() {
        return this.hgR;
    }

    public PostWriteCallBackData cqA() {
        return this.iJB;
    }
}
