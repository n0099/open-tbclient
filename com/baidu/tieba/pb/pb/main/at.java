package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class at {
    private PostWriteCallBackData fPx;
    private com.baidu.tieba.write.b fWH = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fWI;
    private EditText fWJ;
    private EditText fWK;

    public at() {
        this.fWH.xf(d.C0140d.cp_cont_i);
        this.fWH.xg(d.C0140d.cp_cont_h_alpha85);
        this.fWI = new com.baidu.tieba.write.b();
        this.fWI.xf(d.C0140d.cp_cont_i);
        this.fWI.xg(d.C0140d.cp_cont_h_alpha85);
    }

    public void kP(boolean z) {
        if (this.fWJ != null && this.fWJ.getText() != null) {
            int selectionEnd = this.fWJ.getSelectionEnd();
            SpannableStringBuilder b = this.fWH.b(this.fWJ.getText());
            if (b != null) {
                this.fWH.nB(true);
                this.fWJ.setText(b);
                if (z && this.fWH.bFD() >= 0) {
                    this.fWJ.requestFocus();
                    this.fWJ.setSelection(this.fWH.bFD());
                } else {
                    this.fWJ.setSelection(selectionEnd);
                }
                this.fWH.nA(this.fWH.bFD() >= 0);
            }
        }
    }

    public void kQ(boolean z) {
        if (this.fWK != null && this.fWK.getText() != null) {
            int selectionEnd = this.fWK.getSelectionEnd();
            SpannableStringBuilder b = this.fWI.b(this.fWK.getText());
            if (b != null) {
                this.fWI.nB(true);
                this.fWK.setText(b);
                if (z && this.fWI.bFD() >= 0) {
                    this.fWK.requestFocus();
                    this.fWK.setSelection(this.fWI.bFD());
                } else {
                    this.fWK.setSelection(selectionEnd);
                }
                this.fWI.nA(this.fWI.bFD() >= 0);
            }
        }
    }

    public void bfR() {
        this.fWI.un(null);
        this.fWI.aw(null);
        this.fWI.nA(false);
    }

    public void bfS() {
        this.fWH.un(null);
        this.fWH.aw(null);
        this.fWH.nA(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWH.aw(postWriteCallBackData.getSensitiveWords());
            this.fWH.un(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fWH.bFC())) {
                kP(true);
                this.fPx = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWI.aw(postWriteCallBackData.getSensitiveWords());
            this.fWI.un(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fWI.bFC())) {
                kQ(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fWJ = editText;
    }

    public void h(EditText editText) {
        this.fWK = editText;
    }

    public void onDestroy() {
        this.fWJ = null;
        this.fWK = null;
    }

    public void onChangeSkinType() {
        this.fWH.onChangeSkinType();
        this.fWI.onChangeSkinType();
        if (this.fWH.bFE()) {
            kP(false);
        }
        if (this.fWI.bFE()) {
            kQ(false);
        }
    }

    public com.baidu.tieba.write.b bfT() {
        return this.fWH;
    }

    public com.baidu.tieba.write.b bfU() {
        return this.fWI;
    }

    public EditText bfV() {
        return this.fWK;
    }

    public PostWriteCallBackData bfW() {
        return this.fPx;
    }
}
