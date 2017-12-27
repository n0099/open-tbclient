package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class au {
    private PostWriteCallBackData fKt;
    private com.baidu.tieba.write.b fRA = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fRB;
    private EditText fRC;
    private EditText fRD;

    public au() {
        this.fRA.yD(d.C0108d.cp_cont_i);
        this.fRA.yE(d.C0108d.cp_cont_h_alpha85);
        this.fRB = new com.baidu.tieba.write.b();
        this.fRB.yD(d.C0108d.cp_cont_i);
        this.fRB.yE(d.C0108d.cp_cont_h_alpha85);
    }

    public void kC(boolean z) {
        if (this.fRC != null && this.fRC.getText() != null) {
            int selectionEnd = this.fRC.getSelectionEnd();
            SpannableStringBuilder b = this.fRA.b(this.fRC.getText());
            if (b != null) {
                this.fRA.oo(true);
                this.fRC.setText(b);
                if (z && this.fRA.bLn() >= 0) {
                    this.fRC.requestFocus();
                    this.fRC.setSelection(this.fRA.bLn());
                } else {
                    this.fRC.setSelection(selectionEnd);
                }
                this.fRA.on(this.fRA.bLn() >= 0);
            }
        }
    }

    public void kD(boolean z) {
        if (this.fRD != null && this.fRD.getText() != null) {
            int selectionEnd = this.fRD.getSelectionEnd();
            SpannableStringBuilder b = this.fRB.b(this.fRD.getText());
            if (b != null) {
                this.fRB.oo(true);
                this.fRD.setText(b);
                if (z && this.fRB.bLn() >= 0) {
                    this.fRD.requestFocus();
                    this.fRD.setSelection(this.fRB.bLn());
                } else {
                    this.fRD.setSelection(selectionEnd);
                }
                this.fRB.on(this.fRB.bLn() >= 0);
            }
        }
    }

    public void bei() {
        this.fRB.uE(null);
        this.fRB.aB(null);
        this.fRB.on(false);
    }

    public void bej() {
        this.fRA.uE(null);
        this.fRA.aB(null);
        this.fRA.on(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fRA.aB(postWriteCallBackData.getSensitiveWords());
            this.fRA.uE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.G(this.fRA.bLm())) {
                kC(true);
                this.fKt = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fRB.aB(postWriteCallBackData.getSensitiveWords());
            this.fRB.uE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.G(this.fRB.bLm())) {
                kD(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fRC = editText;
    }

    public void h(EditText editText) {
        this.fRD = editText;
    }

    public void onDestroy() {
        this.fRC = null;
        this.fRD = null;
    }

    public void onChangeSkinType() {
        this.fRA.onChangeSkinType();
        this.fRB.onChangeSkinType();
        if (this.fRA.bLo()) {
            kC(false);
        }
        if (this.fRB.bLo()) {
            kD(false);
        }
    }

    public com.baidu.tieba.write.b bek() {
        return this.fRA;
    }

    public com.baidu.tieba.write.b bel() {
        return this.fRB;
    }

    public EditText bem() {
        return this.fRD;
    }

    public PostWriteCallBackData ben() {
        return this.fKt;
    }
}
