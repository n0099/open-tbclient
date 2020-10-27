package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText jEk;
    private PostWriteCallBackData lpZ;
    private com.baidu.tieba.write.c lxq = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lxr;
    private EditText lxs;

    public bb() {
        this.lxq.KT(R.color.cp_cont_a);
        this.lxq.KU(R.color.cp_cont_h_alpha85);
        this.lxr = new com.baidu.tieba.write.c();
        this.lxr.KT(R.color.cp_cont_a);
        this.lxr.KU(R.color.cp_cont_h_alpha85);
    }

    public void uP(boolean z) {
        if (this.lxs != null && this.lxs.getText() != null) {
            int selectionEnd = this.lxs.getSelectionEnd();
            SpannableStringBuilder c = this.lxq.c(this.lxs.getText());
            if (c != null) {
                this.lxq.yh(true);
                this.lxs.setText(c);
                if (z && this.lxq.dQs() >= 0) {
                    this.lxs.requestFocus();
                    this.lxs.setSelection(this.lxq.dQs());
                } else {
                    this.lxs.setSelection(selectionEnd);
                }
                this.lxq.yg(this.lxq.dQs() >= 0);
            }
        }
    }

    public void uQ(boolean z) {
        if (this.jEk != null && this.jEk.getText() != null) {
            int selectionEnd = this.jEk.getSelectionEnd();
            SpannableStringBuilder c = this.lxr.c(this.jEk.getText());
            if (c != null) {
                this.lxr.yh(true);
                this.jEk.setText(c);
                if (z && this.lxr.dQs() >= 0) {
                    this.jEk.requestFocus();
                    this.jEk.setSelection(this.lxr.dQs());
                } else {
                    this.jEk.setSelection(selectionEnd);
                }
                this.lxr.yg(this.lxr.dQs() >= 0);
            }
        }
    }

    public void dlX() {
        this.lxr.Uj(null);
        this.lxr.bk(null);
        this.lxr.yg(false);
    }

    public void dlY() {
        this.lxq.Uj(null);
        this.lxq.bk(null);
        this.lxq.yg(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lxq.bk(postWriteCallBackData.getSensitiveWords());
            this.lxq.Uj(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lxq.dQr())) {
                uP(true);
                this.lpZ = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lxr.bk(postWriteCallBackData.getSensitiveWords());
            this.lxr.Uj(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lxr.dQr())) {
                uQ(true);
            }
        }
    }

    public void e(EditText editText) {
        this.lxs = editText;
    }

    public void f(EditText editText) {
        this.jEk = editText;
    }

    public void onDestroy() {
        this.lxs = null;
        this.jEk = null;
    }

    public void onChangeSkinType() {
        this.lxq.onChangeSkinType();
        this.lxr.onChangeSkinType();
        if (this.lxq.dQt()) {
            uP(false);
        }
        if (this.lxr.dQt()) {
            uQ(false);
        }
    }

    public com.baidu.tieba.write.c dlZ() {
        return this.lxq;
    }

    public com.baidu.tieba.write.c dma() {
        return this.lxr;
    }

    public EditText dmb() {
        return this.jEk;
    }

    public PostWriteCallBackData dmc() {
        return this.lpZ;
    }
}
