package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText jrK;
    private PostWriteCallBackData ldw;
    private com.baidu.tieba.write.c lkN = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lkO;
    private EditText lkP;

    public bb() {
        this.lkN.KB(R.color.cp_cont_a);
        this.lkN.KC(R.color.cp_cont_h_alpha85);
        this.lkO = new com.baidu.tieba.write.c();
        this.lkO.KB(R.color.cp_cont_a);
        this.lkO.KC(R.color.cp_cont_h_alpha85);
    }

    public void uy(boolean z) {
        if (this.lkP != null && this.lkP.getText() != null) {
            int selectionEnd = this.lkP.getSelectionEnd();
            SpannableStringBuilder c = this.lkN.c(this.lkP.getText());
            if (c != null) {
                this.lkN.xQ(true);
                this.lkP.setText(c);
                if (z && this.lkN.dNk() >= 0) {
                    this.lkP.requestFocus();
                    this.lkP.setSelection(this.lkN.dNk());
                } else {
                    this.lkP.setSelection(selectionEnd);
                }
                this.lkN.xP(this.lkN.dNk() >= 0);
            }
        }
    }

    public void uz(boolean z) {
        if (this.jrK != null && this.jrK.getText() != null) {
            int selectionEnd = this.jrK.getSelectionEnd();
            SpannableStringBuilder c = this.lkO.c(this.jrK.getText());
            if (c != null) {
                this.lkO.xQ(true);
                this.jrK.setText(c);
                if (z && this.lkO.dNk() >= 0) {
                    this.jrK.requestFocus();
                    this.jrK.setSelection(this.lkO.dNk());
                } else {
                    this.jrK.setSelection(selectionEnd);
                }
                this.lkO.xP(this.lkO.dNk() >= 0);
            }
        }
    }

    public void diQ() {
        this.lkO.TK(null);
        this.lkO.bh(null);
        this.lkO.xP(false);
    }

    public void diR() {
        this.lkN.TK(null);
        this.lkN.bh(null);
        this.lkN.xP(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lkN.bh(postWriteCallBackData.getSensitiveWords());
            this.lkN.TK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lkN.dNj())) {
                uy(true);
                this.ldw = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lkO.bh(postWriteCallBackData.getSensitiveWords());
            this.lkO.TK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lkO.dNj())) {
                uz(true);
            }
        }
    }

    public void e(EditText editText) {
        this.lkP = editText;
    }

    public void f(EditText editText) {
        this.jrK = editText;
    }

    public void onDestroy() {
        this.lkP = null;
        this.jrK = null;
    }

    public void onChangeSkinType() {
        this.lkN.onChangeSkinType();
        this.lkO.onChangeSkinType();
        if (this.lkN.dNl()) {
            uy(false);
        }
        if (this.lkO.dNl()) {
            uz(false);
        }
    }

    public com.baidu.tieba.write.c diS() {
        return this.lkN;
    }

    public com.baidu.tieba.write.c diT() {
        return this.lkO;
    }

    public EditText diU() {
        return this.jrK;
    }

    public PostWriteCallBackData diV() {
        return this.ldw;
    }
}
