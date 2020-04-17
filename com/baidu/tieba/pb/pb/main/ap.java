package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ap {
    private EditText hSn;
    private com.baidu.tieba.write.c jBS = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c jBT;
    private EditText jBU;
    private PostWriteCallBackData jvx;

    public ap() {
        this.jBS.EI(R.color.cp_cont_a);
        this.jBS.EJ(R.color.cp_cont_h_alpha85);
        this.jBT = new com.baidu.tieba.write.c();
        this.jBT.EI(R.color.cp_cont_a);
        this.jBT.EJ(R.color.cp_cont_h_alpha85);
    }

    public void rG(boolean z) {
        if (this.jBU != null && this.jBU.getText() != null) {
            int selectionEnd = this.jBU.getSelectionEnd();
            SpannableStringBuilder a = this.jBS.a(this.jBU.getText());
            if (a != null) {
                this.jBS.uO(true);
                this.jBU.setText(a);
                if (z && this.jBS.deT() >= 0) {
                    this.jBU.requestFocus();
                    this.jBU.setSelection(this.jBS.deT());
                } else {
                    this.jBU.setSelection(selectionEnd);
                }
                this.jBS.uN(this.jBS.deT() >= 0);
            }
        }
    }

    public void rH(boolean z) {
        if (this.hSn != null && this.hSn.getText() != null) {
            int selectionEnd = this.hSn.getSelectionEnd();
            SpannableStringBuilder a = this.jBT.a(this.hSn.getText());
            if (a != null) {
                this.jBT.uO(true);
                this.hSn.setText(a);
                if (z && this.jBT.deT() >= 0) {
                    this.hSn.requestFocus();
                    this.hSn.setSelection(this.jBT.deT());
                } else {
                    this.hSn.setSelection(selectionEnd);
                }
                this.jBT.uN(this.jBT.deT() >= 0);
            }
        }
    }

    public void cBx() {
        this.jBT.Mp(null);
        this.jBT.aW(null);
        this.jBT.uN(false);
    }

    public void cBy() {
        this.jBS.Mp(null);
        this.jBS.aW(null);
        this.jBS.uN(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jBS.aW(postWriteCallBackData.getSensitiveWords());
            this.jBS.Mp(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jBS.deS())) {
                rG(true);
                this.jvx = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jBT.aW(postWriteCallBackData.getSensitiveWords());
            this.jBT.Mp(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jBT.deS())) {
                rH(true);
            }
        }
    }

    public void d(EditText editText) {
        this.jBU = editText;
    }

    public void e(EditText editText) {
        this.hSn = editText;
    }

    public void onDestroy() {
        this.jBU = null;
        this.hSn = null;
    }

    public void onChangeSkinType() {
        this.jBS.onChangeSkinType();
        this.jBT.onChangeSkinType();
        if (this.jBS.deU()) {
            rG(false);
        }
        if (this.jBT.deU()) {
            rH(false);
        }
    }

    public com.baidu.tieba.write.c cBz() {
        return this.jBS;
    }

    public com.baidu.tieba.write.c cBA() {
        return this.jBT;
    }

    public EditText cBB() {
        return this.hSn;
    }

    public PostWriteCallBackData cBC() {
        return this.jvx;
    }
}
