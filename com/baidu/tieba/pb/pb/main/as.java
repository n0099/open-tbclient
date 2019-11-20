package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText gnL;
    private PostWriteCallBackData hPO;
    private com.baidu.tieba.write.b hXe = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hXf;
    private EditText hXg;

    public as() {
        this.hXe.Br(R.color.cp_cont_a);
        this.hXe.Bs(R.color.cp_cont_h_alpha85);
        this.hXf = new com.baidu.tieba.write.b();
        this.hXf.Br(R.color.cp_cont_a);
        this.hXf.Bs(R.color.cp_cont_h_alpha85);
    }

    public void oQ(boolean z) {
        if (this.hXg != null && this.hXg.getText() != null) {
            int selectionEnd = this.hXg.getSelectionEnd();
            SpannableStringBuilder a = this.hXe.a(this.hXg.getText());
            if (a != null) {
                this.hXe.rL(true);
                this.hXg.setText(a);
                if (z && this.hXe.cxx() >= 0) {
                    this.hXg.requestFocus();
                    this.hXg.setSelection(this.hXe.cxx());
                } else {
                    this.hXg.setSelection(selectionEnd);
                }
                this.hXe.rK(this.hXe.cxx() >= 0);
            }
        }
    }

    public void oR(boolean z) {
        if (this.gnL != null && this.gnL.getText() != null) {
            int selectionEnd = this.gnL.getSelectionEnd();
            SpannableStringBuilder a = this.hXf.a(this.gnL.getText());
            if (a != null) {
                this.hXf.rL(true);
                this.gnL.setText(a);
                if (z && this.hXf.cxx() >= 0) {
                    this.gnL.requestFocus();
                    this.gnL.setSelection(this.hXf.cxx());
                } else {
                    this.gnL.setSelection(selectionEnd);
                }
                this.hXf.rK(this.hXf.cxx() >= 0);
            }
        }
    }

    public void bWj() {
        this.hXf.Fv(null);
        this.hXf.aM(null);
        this.hXf.rK(false);
    }

    public void bWk() {
        this.hXe.Fv(null);
        this.hXe.aM(null);
        this.hXe.rK(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hXe.aM(postWriteCallBackData.getSensitiveWords());
            this.hXe.Fv(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hXe.cxw())) {
                oQ(true);
                this.hPO = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hXf.aM(postWriteCallBackData.getSensitiveWords());
            this.hXf.Fv(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hXf.cxw())) {
                oR(true);
            }
        }
    }

    public void g(EditText editText) {
        this.hXg = editText;
    }

    public void h(EditText editText) {
        this.gnL = editText;
    }

    public void onDestroy() {
        this.hXg = null;
        this.gnL = null;
    }

    public void onChangeSkinType() {
        this.hXe.onChangeSkinType();
        this.hXf.onChangeSkinType();
        if (this.hXe.cxy()) {
            oQ(false);
        }
        if (this.hXf.cxy()) {
            oR(false);
        }
    }

    public com.baidu.tieba.write.b bWl() {
        return this.hXe;
    }

    public com.baidu.tieba.write.b bWm() {
        return this.hXf;
    }

    public EditText bWn() {
        return this.gnL;
    }

    public PostWriteCallBackData bWo() {
        return this.hPO;
    }
}
