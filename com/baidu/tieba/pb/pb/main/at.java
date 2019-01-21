package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class at {
    private PostWriteCallBackData gbw;
    private com.baidu.tieba.write.b giK = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b giL;
    private EditText giM;
    private EditText giN;

    public at() {
        this.giK.xk(e.d.cp_cont_i);
        this.giK.xl(e.d.cp_cont_h_alpha85);
        this.giL = new com.baidu.tieba.write.b();
        this.giL.xk(e.d.cp_cont_i);
        this.giL.xl(e.d.cp_cont_h_alpha85);
    }

    public void lA(boolean z) {
        if (this.giM != null && this.giM.getText() != null) {
            int selectionEnd = this.giM.getSelectionEnd();
            SpannableStringBuilder b = this.giK.b(this.giM.getText());
            if (b != null) {
                this.giK.ov(true);
                this.giM.setText(b);
                if (z && this.giK.bOu() >= 0) {
                    this.giM.requestFocus();
                    this.giM.setSelection(this.giK.bOu());
                } else {
                    this.giM.setSelection(selectionEnd);
                }
                this.giK.ou(this.giK.bOu() >= 0);
            }
        }
    }

    public void lB(boolean z) {
        if (this.giN != null && this.giN.getText() != null) {
            int selectionEnd = this.giN.getSelectionEnd();
            SpannableStringBuilder b = this.giL.b(this.giN.getText());
            if (b != null) {
                this.giL.ov(true);
                this.giN.setText(b);
                if (z && this.giL.bOu() >= 0) {
                    this.giN.requestFocus();
                    this.giN.setSelection(this.giL.bOu());
                } else {
                    this.giN.setSelection(selectionEnd);
                }
                this.giL.ou(this.giL.bOu() >= 0);
            }
        }
    }

    public void bne() {
        this.giL.xK(null);
        this.giL.aA(null);
        this.giL.ou(false);
    }

    public void bnf() {
        this.giK.xK(null);
        this.giK.aA(null);
        this.giK.ou(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.giK.aA(postWriteCallBackData.getSensitiveWords());
            this.giK.xK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.giK.bOt())) {
                lA(true);
                this.gbw = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.giL.aA(postWriteCallBackData.getSensitiveWords());
            this.giL.xK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.giL.bOt())) {
                lB(true);
            }
        }
    }

    public void g(EditText editText) {
        this.giM = editText;
    }

    public void h(EditText editText) {
        this.giN = editText;
    }

    public void onDestroy() {
        this.giM = null;
        this.giN = null;
    }

    public void onChangeSkinType() {
        this.giK.onChangeSkinType();
        this.giL.onChangeSkinType();
        if (this.giK.bOv()) {
            lA(false);
        }
        if (this.giL.bOv()) {
            lB(false);
        }
    }

    public com.baidu.tieba.write.b bng() {
        return this.giK;
    }

    public com.baidu.tieba.write.b bnh() {
        return this.giL;
    }

    public EditText bni() {
        return this.giN;
    }

    public PostWriteCallBackData bnj() {
        return this.gbw;
    }
}
