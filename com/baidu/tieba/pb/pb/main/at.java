package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class at {
    private PostWriteCallBackData fXG;
    private com.baidu.tieba.write.b geN = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b geO;
    private EditText geP;
    private EditText geQ;

    public at() {
        this.geN.wV(e.d.cp_cont_i);
        this.geN.wW(e.d.cp_cont_h_alpha85);
        this.geO = new com.baidu.tieba.write.b();
        this.geO.wV(e.d.cp_cont_i);
        this.geO.wW(e.d.cp_cont_h_alpha85);
    }

    public void lx(boolean z) {
        if (this.geP != null && this.geP.getText() != null) {
            int selectionEnd = this.geP.getSelectionEnd();
            SpannableStringBuilder b = this.geN.b(this.geP.getText());
            if (b != null) {
                this.geN.or(true);
                this.geP.setText(b);
                if (z && this.geN.bMW() >= 0) {
                    this.geP.requestFocus();
                    this.geP.setSelection(this.geN.bMW());
                } else {
                    this.geP.setSelection(selectionEnd);
                }
                this.geN.oq(this.geN.bMW() >= 0);
            }
        }
    }

    public void ly(boolean z) {
        if (this.geQ != null && this.geQ.getText() != null) {
            int selectionEnd = this.geQ.getSelectionEnd();
            SpannableStringBuilder b = this.geO.b(this.geQ.getText());
            if (b != null) {
                this.geO.or(true);
                this.geQ.setText(b);
                if (z && this.geO.bMW() >= 0) {
                    this.geQ.requestFocus();
                    this.geQ.setSelection(this.geO.bMW());
                } else {
                    this.geQ.setSelection(selectionEnd);
                }
                this.geO.oq(this.geO.bMW() >= 0);
            }
        }
    }

    public void blL() {
        this.geO.xr(null);
        this.geO.az(null);
        this.geO.oq(false);
    }

    public void blM() {
        this.geN.xr(null);
        this.geN.az(null);
        this.geN.oq(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.geN.az(postWriteCallBackData.getSensitiveWords());
            this.geN.xr(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.geN.bMV())) {
                lx(true);
                this.fXG = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.geO.az(postWriteCallBackData.getSensitiveWords());
            this.geO.xr(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.geO.bMV())) {
                ly(true);
            }
        }
    }

    public void g(EditText editText) {
        this.geP = editText;
    }

    public void h(EditText editText) {
        this.geQ = editText;
    }

    public void onDestroy() {
        this.geP = null;
        this.geQ = null;
    }

    public void onChangeSkinType() {
        this.geN.onChangeSkinType();
        this.geO.onChangeSkinType();
        if (this.geN.bMX()) {
            lx(false);
        }
        if (this.geO.bMX()) {
            ly(false);
        }
    }

    public com.baidu.tieba.write.b blN() {
        return this.geN;
    }

    public com.baidu.tieba.write.b blO() {
        return this.geO;
    }

    public EditText blP() {
        return this.geQ;
    }

    public PostWriteCallBackData blQ() {
        return this.fXG;
    }
}
