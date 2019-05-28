package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText ggf;
    private PostWriteCallBackData hIU;
    private com.baidu.tieba.write.b hQg = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hQh;
    private EditText hQi;

    public as() {
        this.hQg.Cb(R.color.cp_btn_a);
        this.hQg.Cc(R.color.cp_cont_h_alpha85);
        this.hQh = new com.baidu.tieba.write.b();
        this.hQh.Cb(R.color.cp_btn_a);
        this.hQh.Cc(R.color.cp_cont_h_alpha85);
    }

    public void oO(boolean z) {
        if (this.hQi != null && this.hQi.getText() != null) {
            int selectionEnd = this.hQi.getSelectionEnd();
            SpannableStringBuilder b = this.hQg.b(this.hQi.getText());
            if (b != null) {
                this.hQg.rK(true);
                this.hQi.setText(b);
                if (z && this.hQg.cwf() >= 0) {
                    this.hQi.requestFocus();
                    this.hQi.setSelection(this.hQg.cwf());
                } else {
                    this.hQi.setSelection(selectionEnd);
                }
                this.hQg.rJ(this.hQg.cwf() >= 0);
            }
        }
    }

    public void oP(boolean z) {
        if (this.ggf != null && this.ggf.getText() != null) {
            int selectionEnd = this.ggf.getSelectionEnd();
            SpannableStringBuilder b = this.hQh.b(this.ggf.getText());
            if (b != null) {
                this.hQh.rK(true);
                this.ggf.setText(b);
                if (z && this.hQh.cwf() >= 0) {
                    this.ggf.requestFocus();
                    this.ggf.setSelection(this.hQh.cwf());
                } else {
                    this.ggf.setSelection(selectionEnd);
                }
                this.hQh.rJ(this.hQh.cwf() >= 0);
            }
        }
    }

    public void bVq() {
        this.hQh.FE(null);
        this.hQh.aI(null);
        this.hQh.rJ(false);
    }

    public void bVr() {
        this.hQg.FE(null);
        this.hQg.aI(null);
        this.hQg.rJ(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQg.aI(postWriteCallBackData.getSensitiveWords());
            this.hQg.FE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hQg.cwe())) {
                oO(true);
                this.hIU = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQh.aI(postWriteCallBackData.getSensitiveWords());
            this.hQh.FE(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hQh.cwe())) {
                oP(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hQi = editText;
    }

    public void l(EditText editText) {
        this.ggf = editText;
    }

    public void onDestroy() {
        this.hQi = null;
        this.ggf = null;
    }

    public void onChangeSkinType() {
        this.hQg.onChangeSkinType();
        this.hQh.onChangeSkinType();
        if (this.hQg.cwg()) {
            oO(false);
        }
        if (this.hQh.cwg()) {
            oP(false);
        }
    }

    public com.baidu.tieba.write.b bVs() {
        return this.hQg;
    }

    public com.baidu.tieba.write.b bVt() {
        return this.hQh;
    }

    public EditText bVu() {
        return this.ggf;
    }

    public PostWriteCallBackData bVv() {
        return this.hIU;
    }
}
