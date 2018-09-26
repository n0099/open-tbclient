package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class at {
    private PostWriteCallBackData fHP;
    private com.baidu.tieba.write.b fOW = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fOX;
    private EditText fOY;
    private EditText fOZ;

    public at() {
        this.fOW.vI(e.d.cp_cont_i);
        this.fOW.vJ(e.d.cp_cont_h_alpha85);
        this.fOX = new com.baidu.tieba.write.b();
        this.fOX.vI(e.d.cp_cont_i);
        this.fOX.vJ(e.d.cp_cont_h_alpha85);
    }

    public void kS(boolean z) {
        if (this.fOY != null && this.fOY.getText() != null) {
            int selectionEnd = this.fOY.getSelectionEnd();
            SpannableStringBuilder b = this.fOW.b(this.fOY.getText());
            if (b != null) {
                this.fOW.nL(true);
                this.fOY.setText(b);
                if (z && this.fOW.bIf() >= 0) {
                    this.fOY.requestFocus();
                    this.fOY.setSelection(this.fOW.bIf());
                } else {
                    this.fOY.setSelection(selectionEnd);
                }
                this.fOW.nK(this.fOW.bIf() >= 0);
            }
        }
    }

    public void kT(boolean z) {
        if (this.fOZ != null && this.fOZ.getText() != null) {
            int selectionEnd = this.fOZ.getSelectionEnd();
            SpannableStringBuilder b = this.fOX.b(this.fOZ.getText());
            if (b != null) {
                this.fOX.nL(true);
                this.fOZ.setText(b);
                if (z && this.fOX.bIf() >= 0) {
                    this.fOZ.requestFocus();
                    this.fOZ.setSelection(this.fOX.bIf());
                } else {
                    this.fOZ.setSelection(selectionEnd);
                }
                this.fOX.nK(this.fOX.bIf() >= 0);
            }
        }
    }

    public void bhj() {
        this.fOX.wi(null);
        this.fOX.aA(null);
        this.fOX.nK(false);
    }

    public void bhk() {
        this.fOW.wi(null);
        this.fOW.aA(null);
        this.fOW.nK(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fOW.aA(postWriteCallBackData.getSensitiveWords());
            this.fOW.wi(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.z(this.fOW.bIe())) {
                kS(true);
                this.fHP = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fOX.aA(postWriteCallBackData.getSensitiveWords());
            this.fOX.wi(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.z(this.fOX.bIe())) {
                kT(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fOY = editText;
    }

    public void h(EditText editText) {
        this.fOZ = editText;
    }

    public void onDestroy() {
        this.fOY = null;
        this.fOZ = null;
    }

    public void onChangeSkinType() {
        this.fOW.onChangeSkinType();
        this.fOX.onChangeSkinType();
        if (this.fOW.bIg()) {
            kS(false);
        }
        if (this.fOX.bIg()) {
            kT(false);
        }
    }

    public com.baidu.tieba.write.b bhl() {
        return this.fOW;
    }

    public com.baidu.tieba.write.b bhm() {
        return this.fOX;
    }

    public EditText bhn() {
        return this.fOZ;
    }

    public PostWriteCallBackData bho() {
        return this.fHP;
    }
}
