package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText gge;
    private PostWriteCallBackData hIR;
    private com.baidu.tieba.write.b hQd = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hQe;
    private EditText hQf;

    public as() {
        this.hQd.Cb(R.color.cp_btn_a);
        this.hQd.Cc(R.color.cp_cont_h_alpha85);
        this.hQe = new com.baidu.tieba.write.b();
        this.hQe.Cb(R.color.cp_btn_a);
        this.hQe.Cc(R.color.cp_cont_h_alpha85);
    }

    public void oO(boolean z) {
        if (this.hQf != null && this.hQf.getText() != null) {
            int selectionEnd = this.hQf.getSelectionEnd();
            SpannableStringBuilder b = this.hQd.b(this.hQf.getText());
            if (b != null) {
                this.hQd.rK(true);
                this.hQf.setText(b);
                if (z && this.hQd.cwd() >= 0) {
                    this.hQf.requestFocus();
                    this.hQf.setSelection(this.hQd.cwd());
                } else {
                    this.hQf.setSelection(selectionEnd);
                }
                this.hQd.rJ(this.hQd.cwd() >= 0);
            }
        }
    }

    public void oP(boolean z) {
        if (this.gge != null && this.gge.getText() != null) {
            int selectionEnd = this.gge.getSelectionEnd();
            SpannableStringBuilder b = this.hQe.b(this.gge.getText());
            if (b != null) {
                this.hQe.rK(true);
                this.gge.setText(b);
                if (z && this.hQe.cwd() >= 0) {
                    this.gge.requestFocus();
                    this.gge.setSelection(this.hQe.cwd());
                } else {
                    this.gge.setSelection(selectionEnd);
                }
                this.hQe.rJ(this.hQe.cwd() >= 0);
            }
        }
    }

    public void bVn() {
        this.hQe.FE(null);
        this.hQe.aI(null);
        this.hQe.rJ(false);
    }

    public void bVo() {
        this.hQd.FE(null);
        this.hQd.aI(null);
        this.hQd.rJ(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQd.aI(postWriteCallBackData.getSensitiveWords());
            this.hQd.FE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hQd.cwc())) {
                oO(true);
                this.hIR = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQe.aI(postWriteCallBackData.getSensitiveWords());
            this.hQe.FE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hQe.cwc())) {
                oP(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hQf = editText;
    }

    public void l(EditText editText) {
        this.gge = editText;
    }

    public void onDestroy() {
        this.hQf = null;
        this.gge = null;
    }

    public void onChangeSkinType() {
        this.hQd.onChangeSkinType();
        this.hQe.onChangeSkinType();
        if (this.hQd.cwe()) {
            oO(false);
        }
        if (this.hQe.cwe()) {
            oP(false);
        }
    }

    public com.baidu.tieba.write.b bVp() {
        return this.hQd;
    }

    public com.baidu.tieba.write.b bVq() {
        return this.hQe;
    }

    public EditText bVr() {
        return this.gge;
    }

    public PostWriteCallBackData bVs() {
        return this.hIR;
    }
}
