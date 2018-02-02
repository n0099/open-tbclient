package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class au {
    private PostWriteCallBackData fMo;
    private com.baidu.tieba.write.b fTv = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fTw;
    private EditText fTx;
    private EditText fTy;

    public au() {
        this.fTv.xg(d.C0108d.cp_cont_i);
        this.fTv.xh(d.C0108d.cp_cont_h_alpha85);
        this.fTw = new com.baidu.tieba.write.b();
        this.fTw.xg(d.C0108d.cp_cont_i);
        this.fTw.xh(d.C0108d.cp_cont_h_alpha85);
    }

    public void kH(boolean z) {
        if (this.fTx != null && this.fTx.getText() != null) {
            int selectionEnd = this.fTx.getSelectionEnd();
            SpannableStringBuilder b = this.fTv.b(this.fTx.getText());
            if (b != null) {
                this.fTv.nu(true);
                this.fTx.setText(b);
                if (z && this.fTv.bEP() >= 0) {
                    this.fTx.requestFocus();
                    this.fTx.setSelection(this.fTv.bEP());
                } else {
                    this.fTx.setSelection(selectionEnd);
                }
                this.fTv.nt(this.fTv.bEP() >= 0);
            }
        }
    }

    public void kI(boolean z) {
        if (this.fTy != null && this.fTy.getText() != null) {
            int selectionEnd = this.fTy.getSelectionEnd();
            SpannableStringBuilder b = this.fTw.b(this.fTy.getText());
            if (b != null) {
                this.fTw.nu(true);
                this.fTy.setText(b);
                if (z && this.fTw.bEP() >= 0) {
                    this.fTy.requestFocus();
                    this.fTy.setSelection(this.fTw.bEP());
                } else {
                    this.fTy.setSelection(selectionEnd);
                }
                this.fTw.nt(this.fTw.bEP() >= 0);
            }
        }
    }

    public void ber() {
        this.fTw.uh(null);
        this.fTw.av(null);
        this.fTw.nt(false);
    }

    public void bes() {
        this.fTv.uh(null);
        this.fTv.av(null);
        this.fTv.nt(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fTv.av(postWriteCallBackData.getSensitiveWords());
            this.fTv.uh(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fTv.bEO())) {
                kH(true);
                this.fMo = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fTw.av(postWriteCallBackData.getSensitiveWords());
            this.fTw.uh(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fTw.bEO())) {
                kI(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fTx = editText;
    }

    public void h(EditText editText) {
        this.fTy = editText;
    }

    public void onDestroy() {
        this.fTx = null;
        this.fTy = null;
    }

    public void onChangeSkinType() {
        this.fTv.onChangeSkinType();
        this.fTw.onChangeSkinType();
        if (this.fTv.bEQ()) {
            kH(false);
        }
        if (this.fTw.bEQ()) {
            kI(false);
        }
    }

    public com.baidu.tieba.write.b bet() {
        return this.fTv;
    }

    public com.baidu.tieba.write.b beu() {
        return this.fTw;
    }

    public EditText bev() {
        return this.fTy;
    }

    public PostWriteCallBackData bew() {
        return this.fMo;
    }
}
