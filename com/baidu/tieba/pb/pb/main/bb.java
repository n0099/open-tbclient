package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText jKi;
    private com.baidu.tieba.write.c lDn = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lDo;
    private EditText lDp;
    private PostWriteCallBackData lvW;

    public bb() {
        this.lDn.Lg(R.color.cp_cont_a);
        this.lDn.Lh(R.color.cp_cont_h_alpha85);
        this.lDo = new com.baidu.tieba.write.c();
        this.lDo.Lg(R.color.cp_cont_a);
        this.lDo.Lh(R.color.cp_cont_h_alpha85);
    }

    public void uY(boolean z) {
        if (this.lDp != null && this.lDp.getText() != null) {
            int selectionEnd = this.lDp.getSelectionEnd();
            SpannableStringBuilder c = this.lDn.c(this.lDp.getText());
            if (c != null) {
                this.lDn.yq(true);
                this.lDp.setText(c);
                if (z && this.lDn.dSU() >= 0) {
                    this.lDp.requestFocus();
                    this.lDp.setSelection(this.lDn.dSU());
                } else {
                    this.lDp.setSelection(selectionEnd);
                }
                this.lDn.yp(this.lDn.dSU() >= 0);
            }
        }
    }

    public void uZ(boolean z) {
        if (this.jKi != null && this.jKi.getText() != null) {
            int selectionEnd = this.jKi.getSelectionEnd();
            SpannableStringBuilder c = this.lDo.c(this.jKi.getText());
            if (c != null) {
                this.lDo.yq(true);
                this.jKi.setText(c);
                if (z && this.lDo.dSU() >= 0) {
                    this.jKi.requestFocus();
                    this.jKi.setSelection(this.lDo.dSU());
                } else {
                    this.jKi.setSelection(selectionEnd);
                }
                this.lDo.yp(this.lDo.dSU() >= 0);
            }
        }
    }

    public void doA() {
        this.lDo.UA(null);
        this.lDo.bk(null);
        this.lDo.yp(false);
    }

    public void doB() {
        this.lDn.UA(null);
        this.lDn.bk(null);
        this.lDn.yp(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lDn.bk(postWriteCallBackData.getSensitiveWords());
            this.lDn.UA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lDn.dST())) {
                uY(true);
                this.lvW = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lDo.bk(postWriteCallBackData.getSensitiveWords());
            this.lDo.UA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lDo.dST())) {
                uZ(true);
            }
        }
    }

    public void e(EditText editText) {
        this.lDp = editText;
    }

    public void f(EditText editText) {
        this.jKi = editText;
    }

    public void onDestroy() {
        this.lDp = null;
        this.jKi = null;
    }

    public void onChangeSkinType() {
        this.lDn.onChangeSkinType();
        this.lDo.onChangeSkinType();
        if (this.lDn.dSV()) {
            uY(false);
        }
        if (this.lDo.dSV()) {
            uZ(false);
        }
    }

    public com.baidu.tieba.write.c doC() {
        return this.lDn;
    }

    public com.baidu.tieba.write.c doD() {
        return this.lDo;
    }

    public EditText doE() {
        return this.jKi;
    }

    public PostWriteCallBackData doF() {
        return this.lvW;
    }
}
