package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ap {
    private EditText hSt;
    private com.baidu.tieba.write.c jBW = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c jBX;
    private EditText jBY;
    private PostWriteCallBackData jvB;

    public ap() {
        this.jBW.EI(R.color.cp_cont_a);
        this.jBW.EJ(R.color.cp_cont_h_alpha85);
        this.jBX = new com.baidu.tieba.write.c();
        this.jBX.EI(R.color.cp_cont_a);
        this.jBX.EJ(R.color.cp_cont_h_alpha85);
    }

    public void rG(boolean z) {
        if (this.jBY != null && this.jBY.getText() != null) {
            int selectionEnd = this.jBY.getSelectionEnd();
            SpannableStringBuilder a = this.jBW.a(this.jBY.getText());
            if (a != null) {
                this.jBW.uO(true);
                this.jBY.setText(a);
                if (z && this.jBW.deQ() >= 0) {
                    this.jBY.requestFocus();
                    this.jBY.setSelection(this.jBW.deQ());
                } else {
                    this.jBY.setSelection(selectionEnd);
                }
                this.jBW.uN(this.jBW.deQ() >= 0);
            }
        }
    }

    public void rH(boolean z) {
        if (this.hSt != null && this.hSt.getText() != null) {
            int selectionEnd = this.hSt.getSelectionEnd();
            SpannableStringBuilder a = this.jBX.a(this.hSt.getText());
            if (a != null) {
                this.jBX.uO(true);
                this.hSt.setText(a);
                if (z && this.jBX.deQ() >= 0) {
                    this.hSt.requestFocus();
                    this.hSt.setSelection(this.jBX.deQ());
                } else {
                    this.hSt.setSelection(selectionEnd);
                }
                this.jBX.uN(this.jBX.deQ() >= 0);
            }
        }
    }

    public void cBu() {
        this.jBX.Ms(null);
        this.jBX.aW(null);
        this.jBX.uN(false);
    }

    public void cBv() {
        this.jBW.Ms(null);
        this.jBW.aW(null);
        this.jBW.uN(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jBW.aW(postWriteCallBackData.getSensitiveWords());
            this.jBW.Ms(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jBW.deP())) {
                rG(true);
                this.jvB = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jBX.aW(postWriteCallBackData.getSensitiveWords());
            this.jBX.Ms(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jBX.deP())) {
                rH(true);
            }
        }
    }

    public void d(EditText editText) {
        this.jBY = editText;
    }

    public void e(EditText editText) {
        this.hSt = editText;
    }

    public void onDestroy() {
        this.jBY = null;
        this.hSt = null;
    }

    public void onChangeSkinType() {
        this.jBW.onChangeSkinType();
        this.jBX.onChangeSkinType();
        if (this.jBW.deR()) {
            rG(false);
        }
        if (this.jBX.deR()) {
            rH(false);
        }
    }

    public com.baidu.tieba.write.c cBw() {
        return this.jBW;
    }

    public com.baidu.tieba.write.c cBx() {
        return this.jBX;
    }

    public EditText cBy() {
        return this.hSt;
    }

    public PostWriteCallBackData cBz() {
        return this.jvB;
    }
}
