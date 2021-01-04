package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private EditText klJ;
    private PostWriteCallBackData lPq;
    private com.baidu.tieba.write.c lWK = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lWL;
    private EditText lWM;

    public ar() {
        this.lWK.Mo(R.color.CAM_X0101);
        this.lWK.Mp(R.color.cp_cont_h_alpha85);
        this.lWL = new com.baidu.tieba.write.c();
        this.lWL.Mo(R.color.CAM_X0101);
        this.lWL.Mp(R.color.cp_cont_h_alpha85);
    }

    public void vF(boolean z) {
        if (this.lWM != null && this.lWM.getText() != null) {
            int selectionEnd = this.lWM.getSelectionEnd();
            SpannableStringBuilder d = this.lWK.d(this.lWM.getText());
            if (d != null) {
                this.lWK.zc(true);
                this.lWM.setText(d);
                if (z && this.lWK.dXR() >= 0) {
                    this.lWM.requestFocus();
                    this.lWM.setSelection(this.lWK.dXR());
                } else {
                    this.lWM.setSelection(selectionEnd);
                }
                this.lWK.zb(this.lWK.dXR() >= 0);
            }
        }
    }

    public void vG(boolean z) {
        if (this.klJ != null && this.klJ.getText() != null) {
            int selectionEnd = this.klJ.getSelectionEnd();
            SpannableStringBuilder d = this.lWL.d(this.klJ.getText());
            if (d != null) {
                this.lWL.zc(true);
                this.klJ.setText(d);
                if (z && this.lWL.dXR() >= 0) {
                    this.klJ.requestFocus();
                    this.klJ.setSelection(this.lWL.dXR());
                } else {
                    this.klJ.setSelection(selectionEnd);
                }
                this.lWL.zb(this.lWL.dXR() >= 0);
            }
        }
    }

    public void dtg() {
        this.lWL.Vf(null);
        this.lWL.bm(null);
        this.lWL.zb(false);
    }

    public void dth() {
        this.lWK.Vf(null);
        this.lWK.bm(null);
        this.lWK.zb(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lWK.bm(postWriteCallBackData.getSensitiveWords());
            this.lWK.Vf(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.lWK.dXQ())) {
                vF(true);
                this.lPq = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lWL.bm(postWriteCallBackData.getSensitiveWords());
            this.lWL.Vf(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.lWL.dXQ())) {
                vG(true);
            }
        }
    }

    public void f(EditText editText) {
        this.lWM = editText;
    }

    public void g(EditText editText) {
        this.klJ = editText;
    }

    public void onDestroy() {
        this.lWM = null;
        this.klJ = null;
    }

    public void onChangeSkinType() {
        this.lWK.onChangeSkinType();
        this.lWL.onChangeSkinType();
        if (this.lWK.dXS()) {
            vF(false);
        }
        if (this.lWL.dXS()) {
            vG(false);
        }
    }

    public com.baidu.tieba.write.c dti() {
        return this.lWK;
    }

    public com.baidu.tieba.write.c dtj() {
        return this.lWL;
    }

    public EditText dtk() {
        return this.klJ;
    }

    public PostWriteCallBackData dtl() {
        return this.lPq;
    }
}
