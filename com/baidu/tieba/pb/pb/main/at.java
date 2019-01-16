package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class at {
    private PostWriteCallBackData gbv;
    private com.baidu.tieba.write.b giJ = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b giK;
    private EditText giL;
    private EditText giM;

    public at() {
        this.giJ.xk(e.d.cp_cont_i);
        this.giJ.xl(e.d.cp_cont_h_alpha85);
        this.giK = new com.baidu.tieba.write.b();
        this.giK.xk(e.d.cp_cont_i);
        this.giK.xl(e.d.cp_cont_h_alpha85);
    }

    public void lA(boolean z) {
        if (this.giL != null && this.giL.getText() != null) {
            int selectionEnd = this.giL.getSelectionEnd();
            SpannableStringBuilder b = this.giJ.b(this.giL.getText());
            if (b != null) {
                this.giJ.ov(true);
                this.giL.setText(b);
                if (z && this.giJ.bOu() >= 0) {
                    this.giL.requestFocus();
                    this.giL.setSelection(this.giJ.bOu());
                } else {
                    this.giL.setSelection(selectionEnd);
                }
                this.giJ.ou(this.giJ.bOu() >= 0);
            }
        }
    }

    public void lB(boolean z) {
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

    public void bne() {
        this.giK.xK(null);
        this.giK.aA(null);
        this.giK.ou(false);
    }

    public void bnf() {
        this.giJ.xK(null);
        this.giJ.aA(null);
        this.giJ.ou(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.giJ.aA(postWriteCallBackData.getSensitiveWords());
            this.giJ.xK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.giJ.bOt())) {
                lA(true);
                this.gbv = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.giK.aA(postWriteCallBackData.getSensitiveWords());
            this.giK.xK(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.giK.bOt())) {
                lB(true);
            }
        }
    }

    public void g(EditText editText) {
        this.giL = editText;
    }

    public void h(EditText editText) {
        this.giM = editText;
    }

    public void onDestroy() {
        this.giL = null;
        this.giM = null;
    }

    public void onChangeSkinType() {
        this.giJ.onChangeSkinType();
        this.giK.onChangeSkinType();
        if (this.giJ.bOv()) {
            lA(false);
        }
        if (this.giK.bOv()) {
            lB(false);
        }
    }

    public com.baidu.tieba.write.b bng() {
        return this.giJ;
    }

    public com.baidu.tieba.write.b bnh() {
        return this.giK;
    }

    public EditText bni() {
        return this.giM;
    }

    public PostWriteCallBackData bnj() {
        return this.gbv;
    }
}
