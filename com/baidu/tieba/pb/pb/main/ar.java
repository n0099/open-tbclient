package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private EditText klJ;
    private PostWriteCallBackData lPp;
    private com.baidu.tieba.write.c lWJ = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lWK;
    private EditText lWL;

    public ar() {
        this.lWJ.Mo(R.color.CAM_X0101);
        this.lWJ.Mp(R.color.cp_cont_h_alpha85);
        this.lWK = new com.baidu.tieba.write.c();
        this.lWK.Mo(R.color.CAM_X0101);
        this.lWK.Mp(R.color.cp_cont_h_alpha85);
    }

    public void vF(boolean z) {
        if (this.lWL != null && this.lWL.getText() != null) {
            int selectionEnd = this.lWL.getSelectionEnd();
            SpannableStringBuilder d = this.lWJ.d(this.lWL.getText());
            if (d != null) {
                this.lWJ.zc(true);
                this.lWL.setText(d);
                if (z && this.lWJ.dXS() >= 0) {
                    this.lWL.requestFocus();
                    this.lWL.setSelection(this.lWJ.dXS());
                } else {
                    this.lWL.setSelection(selectionEnd);
                }
                this.lWJ.zb(this.lWJ.dXS() >= 0);
            }
        }
    }

    public void vG(boolean z) {
        if (this.klJ != null && this.klJ.getText() != null) {
            int selectionEnd = this.klJ.getSelectionEnd();
            SpannableStringBuilder d = this.lWK.d(this.klJ.getText());
            if (d != null) {
                this.lWK.zc(true);
                this.klJ.setText(d);
                if (z && this.lWK.dXS() >= 0) {
                    this.klJ.requestFocus();
                    this.klJ.setSelection(this.lWK.dXS());
                } else {
                    this.klJ.setSelection(selectionEnd);
                }
                this.lWK.zb(this.lWK.dXS() >= 0);
            }
        }
    }

    public void dth() {
        this.lWK.Ve(null);
        this.lWK.bm(null);
        this.lWK.zb(false);
    }

    public void dti() {
        this.lWJ.Ve(null);
        this.lWJ.bm(null);
        this.lWJ.zb(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lWJ.bm(postWriteCallBackData.getSensitiveWords());
            this.lWJ.Ve(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.lWJ.dXR())) {
                vF(true);
                this.lPp = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lWK.bm(postWriteCallBackData.getSensitiveWords());
            this.lWK.Ve(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.lWK.dXR())) {
                vG(true);
            }
        }
    }

    public void f(EditText editText) {
        this.lWL = editText;
    }

    public void g(EditText editText) {
        this.klJ = editText;
    }

    public void onDestroy() {
        this.lWL = null;
        this.klJ = null;
    }

    public void onChangeSkinType() {
        this.lWJ.onChangeSkinType();
        this.lWK.onChangeSkinType();
        if (this.lWJ.dXT()) {
            vF(false);
        }
        if (this.lWK.dXT()) {
            vG(false);
        }
    }

    public com.baidu.tieba.write.c dtj() {
        return this.lWJ;
    }

    public com.baidu.tieba.write.c dtk() {
        return this.lWK;
    }

    public EditText dtl() {
        return this.klJ;
    }

    public PostWriteCallBackData dtm() {
        return this.lPp;
    }
}
