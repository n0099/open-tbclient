package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText goC;
    private PostWriteCallBackData hQF;
    private com.baidu.tieba.write.b hXV = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hXW;
    private EditText hXX;

    public as() {
        this.hXV.Bs(R.color.cp_cont_a);
        this.hXV.Bt(R.color.cp_cont_h_alpha85);
        this.hXW = new com.baidu.tieba.write.b();
        this.hXW.Bs(R.color.cp_cont_a);
        this.hXW.Bt(R.color.cp_cont_h_alpha85);
    }

    public void oQ(boolean z) {
        if (this.hXX != null && this.hXX.getText() != null) {
            int selectionEnd = this.hXX.getSelectionEnd();
            SpannableStringBuilder a = this.hXV.a(this.hXX.getText());
            if (a != null) {
                this.hXV.rL(true);
                this.hXX.setText(a);
                if (z && this.hXV.cxz() >= 0) {
                    this.hXX.requestFocus();
                    this.hXX.setSelection(this.hXV.cxz());
                } else {
                    this.hXX.setSelection(selectionEnd);
                }
                this.hXV.rK(this.hXV.cxz() >= 0);
            }
        }
    }

    public void oR(boolean z) {
        if (this.goC != null && this.goC.getText() != null) {
            int selectionEnd = this.goC.getSelectionEnd();
            SpannableStringBuilder a = this.hXW.a(this.goC.getText());
            if (a != null) {
                this.hXW.rL(true);
                this.goC.setText(a);
                if (z && this.hXW.cxz() >= 0) {
                    this.goC.requestFocus();
                    this.goC.setSelection(this.hXW.cxz());
                } else {
                    this.goC.setSelection(selectionEnd);
                }
                this.hXW.rK(this.hXW.cxz() >= 0);
            }
        }
    }

    public void bWl() {
        this.hXW.Fv(null);
        this.hXW.aM(null);
        this.hXW.rK(false);
    }

    public void bWm() {
        this.hXV.Fv(null);
        this.hXV.aM(null);
        this.hXV.rK(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hXV.aM(postWriteCallBackData.getSensitiveWords());
            this.hXV.Fv(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hXV.cxy())) {
                oQ(true);
                this.hQF = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hXW.aM(postWriteCallBackData.getSensitiveWords());
            this.hXW.Fv(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hXW.cxy())) {
                oR(true);
            }
        }
    }

    public void g(EditText editText) {
        this.hXX = editText;
    }

    public void h(EditText editText) {
        this.goC = editText;
    }

    public void onDestroy() {
        this.hXX = null;
        this.goC = null;
    }

    public void onChangeSkinType() {
        this.hXV.onChangeSkinType();
        this.hXW.onChangeSkinType();
        if (this.hXV.cxA()) {
            oQ(false);
        }
        if (this.hXW.cxA()) {
            oR(false);
        }
    }

    public com.baidu.tieba.write.b bWn() {
        return this.hXV;
    }

    public com.baidu.tieba.write.b bWo() {
        return this.hXW;
    }

    public EditText bWp() {
        return this.goC;
    }

    public PostWriteCallBackData bWq() {
        return this.hQF;
    }
}
