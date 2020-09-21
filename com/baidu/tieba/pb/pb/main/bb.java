package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText jcL;
    private PostWriteCallBackData kOk;
    private com.baidu.tieba.write.c kVA = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c kVB;
    private EditText kVC;

    public bb() {
        this.kVA.JV(R.color.cp_cont_a);
        this.kVA.JW(R.color.cp_cont_h_alpha85);
        this.kVB = new com.baidu.tieba.write.c();
        this.kVB.JV(R.color.cp_cont_a);
        this.kVB.JW(R.color.cp_cont_h_alpha85);
    }

    public void tR(boolean z) {
        if (this.kVC != null && this.kVC.getText() != null) {
            int selectionEnd = this.kVC.getSelectionEnd();
            SpannableStringBuilder c = this.kVA.c(this.kVC.getText());
            if (c != null) {
                this.kVA.xj(true);
                this.kVC.setText(c);
                if (z && this.kVA.dJy() >= 0) {
                    this.kVC.requestFocus();
                    this.kVC.setSelection(this.kVA.dJy());
                } else {
                    this.kVC.setSelection(selectionEnd);
                }
                this.kVA.xi(this.kVA.dJy() >= 0);
            }
        }
    }

    public void tS(boolean z) {
        if (this.jcL != null && this.jcL.getText() != null) {
            int selectionEnd = this.jcL.getSelectionEnd();
            SpannableStringBuilder c = this.kVB.c(this.jcL.getText());
            if (c != null) {
                this.kVB.xj(true);
                this.jcL.setText(c);
                if (z && this.kVB.dJy() >= 0) {
                    this.jcL.requestFocus();
                    this.jcL.setSelection(this.kVB.dJy());
                } else {
                    this.jcL.setSelection(selectionEnd);
                }
                this.kVB.xi(this.kVB.dJy() >= 0);
            }
        }
    }

    public void dfh() {
        this.kVB.SW(null);
        this.kVB.bh(null);
        this.kVB.xi(false);
    }

    public void dfi() {
        this.kVA.SW(null);
        this.kVA.bh(null);
        this.kVA.xi(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kVA.bh(postWriteCallBackData.getSensitiveWords());
            this.kVA.SW(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.kVA.dJx())) {
                tR(true);
                this.kOk = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kVB.bh(postWriteCallBackData.getSensitiveWords());
            this.kVB.SW(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.kVB.dJx())) {
                tS(true);
            }
        }
    }

    public void e(EditText editText) {
        this.kVC = editText;
    }

    public void f(EditText editText) {
        this.jcL = editText;
    }

    public void onDestroy() {
        this.kVC = null;
        this.jcL = null;
    }

    public void onChangeSkinType() {
        this.kVA.onChangeSkinType();
        this.kVB.onChangeSkinType();
        if (this.kVA.dJz()) {
            tR(false);
        }
        if (this.kVB.dJz()) {
            tS(false);
        }
    }

    public com.baidu.tieba.write.c dfj() {
        return this.kVA;
    }

    public com.baidu.tieba.write.c dfk() {
        return this.kVB;
    }

    public EditText dfl() {
        return this.jcL;
    }

    public PostWriteCallBackData dfm() {
        return this.kOk;
    }
}
