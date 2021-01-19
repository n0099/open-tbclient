package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private EditText khd;
    private PostWriteCallBackData lKL;
    private com.baidu.tieba.write.c lSf = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lSg;
    private EditText lSh;

    public ar() {
        this.lSf.KH(R.color.CAM_X0101);
        this.lSf.KI(R.color.cp_cont_h_alpha85);
        this.lSg = new com.baidu.tieba.write.c();
        this.lSg.KH(R.color.CAM_X0101);
        this.lSg.KI(R.color.cp_cont_h_alpha85);
    }

    public void vB(boolean z) {
        if (this.lSh != null && this.lSh.getText() != null) {
            int selectionEnd = this.lSh.getSelectionEnd();
            SpannableStringBuilder d = this.lSf.d(this.lSh.getText());
            if (d != null) {
                this.lSf.yY(true);
                this.lSh.setText(d);
                if (z && this.lSf.dUa() >= 0) {
                    this.lSh.requestFocus();
                    this.lSh.setSelection(this.lSf.dUa());
                } else {
                    this.lSh.setSelection(selectionEnd);
                }
                this.lSf.yX(this.lSf.dUa() >= 0);
            }
        }
    }

    public void vC(boolean z) {
        if (this.khd != null && this.khd.getText() != null) {
            int selectionEnd = this.khd.getSelectionEnd();
            SpannableStringBuilder d = this.lSg.d(this.khd.getText());
            if (d != null) {
                this.lSg.yY(true);
                this.khd.setText(d);
                if (z && this.lSg.dUa() >= 0) {
                    this.khd.requestFocus();
                    this.khd.setSelection(this.lSg.dUa());
                } else {
                    this.khd.setSelection(selectionEnd);
                }
                this.lSg.yX(this.lSg.dUa() >= 0);
            }
        }
    }

    public void dpp() {
        this.lSg.TX(null);
        this.lSg.bh(null);
        this.lSg.yX(false);
    }

    public void dpq() {
        this.lSf.TX(null);
        this.lSf.bh(null);
        this.lSf.yX(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lSf.bh(postWriteCallBackData.getSensitiveWords());
            this.lSf.TX(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.lSf.dTZ())) {
                vB(true);
                this.lKL = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lSg.bh(postWriteCallBackData.getSensitiveWords());
            this.lSg.TX(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.lSg.dTZ())) {
                vC(true);
            }
        }
    }

    public void f(EditText editText) {
        this.lSh = editText;
    }

    public void g(EditText editText) {
        this.khd = editText;
    }

    public void onDestroy() {
        this.lSh = null;
        this.khd = null;
    }

    public void onChangeSkinType() {
        this.lSf.onChangeSkinType();
        this.lSg.onChangeSkinType();
        if (this.lSf.dUb()) {
            vB(false);
        }
        if (this.lSg.dUb()) {
            vC(false);
        }
    }

    public com.baidu.tieba.write.c dpr() {
        return this.lSf;
    }

    public com.baidu.tieba.write.c dps() {
        return this.lSg;
    }

    public EditText dpt() {
        return this.khd;
    }

    public PostWriteCallBackData dpu() {
        return this.lKL;
    }
}
