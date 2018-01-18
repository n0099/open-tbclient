package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class au {
    private PostWriteCallBackData fLT;
    private com.baidu.tieba.write.b fTa = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fTb;
    private EditText fTc;
    private EditText fTd;

    public au() {
        this.fTa.xg(d.C0107d.cp_cont_i);
        this.fTa.xh(d.C0107d.cp_cont_h_alpha85);
        this.fTb = new com.baidu.tieba.write.b();
        this.fTb.xg(d.C0107d.cp_cont_i);
        this.fTb.xh(d.C0107d.cp_cont_h_alpha85);
    }

    public void kE(boolean z) {
        if (this.fTc != null && this.fTc.getText() != null) {
            int selectionEnd = this.fTc.getSelectionEnd();
            SpannableStringBuilder b = this.fTa.b(this.fTc.getText());
            if (b != null) {
                this.fTa.nr(true);
                this.fTc.setText(b);
                if (z && this.fTa.bEN() >= 0) {
                    this.fTc.requestFocus();
                    this.fTc.setSelection(this.fTa.bEN());
                } else {
                    this.fTc.setSelection(selectionEnd);
                }
                this.fTa.nq(this.fTa.bEN() >= 0);
            }
        }
    }

    public void kF(boolean z) {
        if (this.fTd != null && this.fTd.getText() != null) {
            int selectionEnd = this.fTd.getSelectionEnd();
            SpannableStringBuilder b = this.fTb.b(this.fTd.getText());
            if (b != null) {
                this.fTb.nr(true);
                this.fTd.setText(b);
                if (z && this.fTb.bEN() >= 0) {
                    this.fTd.requestFocus();
                    this.fTd.setSelection(this.fTb.bEN());
                } else {
                    this.fTd.setSelection(selectionEnd);
                }
                this.fTb.nq(this.fTb.bEN() >= 0);
            }
        }
    }

    public void bem() {
        this.fTb.tZ(null);
        this.fTb.av(null);
        this.fTb.nq(false);
    }

    public void ben() {
        this.fTa.tZ(null);
        this.fTa.av(null);
        this.fTa.nq(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fTa.av(postWriteCallBackData.getSensitiveWords());
            this.fTa.tZ(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fTa.bEM())) {
                kE(true);
                this.fLT = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fTb.av(postWriteCallBackData.getSensitiveWords());
            this.fTb.tZ(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fTb.bEM())) {
                kF(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fTc = editText;
    }

    public void h(EditText editText) {
        this.fTd = editText;
    }

    public void onDestroy() {
        this.fTc = null;
        this.fTd = null;
    }

    public void onChangeSkinType() {
        this.fTa.onChangeSkinType();
        this.fTb.onChangeSkinType();
        if (this.fTa.bEO()) {
            kE(false);
        }
        if (this.fTb.bEO()) {
            kF(false);
        }
    }

    public com.baidu.tieba.write.b beo() {
        return this.fTa;
    }

    public com.baidu.tieba.write.b bep() {
        return this.fTb;
    }

    public EditText beq() {
        return this.fTd;
    }

    public PostWriteCallBackData ber() {
        return this.fLT;
    }
}
