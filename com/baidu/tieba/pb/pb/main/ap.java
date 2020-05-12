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
                if (z && this.jBW.deR() >= 0) {
                    this.jBY.requestFocus();
                    this.jBY.setSelection(this.jBW.deR());
                } else {
                    this.jBY.setSelection(selectionEnd);
                }
                this.jBW.uN(this.jBW.deR() >= 0);
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
                if (z && this.jBX.deR() >= 0) {
                    this.hSt.requestFocus();
                    this.hSt.setSelection(this.jBX.deR());
                } else {
                    this.hSt.setSelection(selectionEnd);
                }
                this.jBX.uN(this.jBX.deR() >= 0);
            }
        }
    }

    public void cBv() {
        this.jBX.Ms(null);
        this.jBX.aW(null);
        this.jBX.uN(false);
    }

    public void cBw() {
        this.jBW.Ms(null);
        this.jBW.aW(null);
        this.jBW.uN(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jBW.aW(postWriteCallBackData.getSensitiveWords());
            this.jBW.Ms(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jBW.deQ())) {
                rG(true);
                this.jvB = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jBX.aW(postWriteCallBackData.getSensitiveWords());
            this.jBX.Ms(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jBX.deQ())) {
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
        if (this.jBW.deS()) {
            rG(false);
        }
        if (this.jBX.deS()) {
            rH(false);
        }
    }

    public com.baidu.tieba.write.c cBx() {
        return this.jBW;
    }

    public com.baidu.tieba.write.c cBy() {
        return this.jBX;
    }

    public EditText cBz() {
        return this.hSt;
    }

    public PostWriteCallBackData cBA() {
        return this.jvB;
    }
}
