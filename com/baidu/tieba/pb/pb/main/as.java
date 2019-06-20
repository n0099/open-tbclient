package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText ggh;
    private PostWriteCallBackData hIV;
    private com.baidu.tieba.write.b hQh = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hQi;
    private EditText hQj;

    public as() {
        this.hQh.Cb(R.color.cp_btn_a);
        this.hQh.Cc(R.color.cp_cont_h_alpha85);
        this.hQi = new com.baidu.tieba.write.b();
        this.hQi.Cb(R.color.cp_btn_a);
        this.hQi.Cc(R.color.cp_cont_h_alpha85);
    }

    public void oP(boolean z) {
        if (this.hQj != null && this.hQj.getText() != null) {
            int selectionEnd = this.hQj.getSelectionEnd();
            SpannableStringBuilder b = this.hQh.b(this.hQj.getText());
            if (b != null) {
                this.hQh.rL(true);
                this.hQj.setText(b);
                if (z && this.hQh.cwe() >= 0) {
                    this.hQj.requestFocus();
                    this.hQj.setSelection(this.hQh.cwe());
                } else {
                    this.hQj.setSelection(selectionEnd);
                }
                this.hQh.rK(this.hQh.cwe() >= 0);
            }
        }
    }

    public void oQ(boolean z) {
        if (this.ggh != null && this.ggh.getText() != null) {
            int selectionEnd = this.ggh.getSelectionEnd();
            SpannableStringBuilder b = this.hQi.b(this.ggh.getText());
            if (b != null) {
                this.hQi.rL(true);
                this.ggh.setText(b);
                if (z && this.hQi.cwe() >= 0) {
                    this.ggh.requestFocus();
                    this.ggh.setSelection(this.hQi.cwe());
                } else {
                    this.ggh.setSelection(selectionEnd);
                }
                this.hQi.rK(this.hQi.cwe() >= 0);
            }
        }
    }

    public void bVr() {
        this.hQi.FG(null);
        this.hQi.aI(null);
        this.hQi.rK(false);
    }

    public void bVs() {
        this.hQh.FG(null);
        this.hQh.aI(null);
        this.hQh.rK(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQh.aI(postWriteCallBackData.getSensitiveWords());
            this.hQh.FG(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hQh.cwd())) {
                oP(true);
                this.hIV = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQi.aI(postWriteCallBackData.getSensitiveWords());
            this.hQi.FG(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hQi.cwd())) {
                oQ(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hQj = editText;
    }

    public void l(EditText editText) {
        this.ggh = editText;
    }

    public void onDestroy() {
        this.hQj = null;
        this.ggh = null;
    }

    public void onChangeSkinType() {
        this.hQh.onChangeSkinType();
        this.hQi.onChangeSkinType();
        if (this.hQh.cwf()) {
            oP(false);
        }
        if (this.hQi.cwf()) {
            oQ(false);
        }
    }

    public com.baidu.tieba.write.b bVt() {
        return this.hQh;
    }

    public com.baidu.tieba.write.b bVu() {
        return this.hQi;
    }

    public EditText bVv() {
        return this.ggh;
    }

    public PostWriteCallBackData bVw() {
        return this.hIV;
    }
}
