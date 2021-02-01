package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private EditText kpl;
    private PostWriteCallBackData lTH;
    private com.baidu.tieba.write.c mbe = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c mbf;
    private EditText mbg;

    public ar() {
        this.mbe.Lc(R.color.CAM_X0101);
        this.mbe.Ld(R.color.cp_cont_h_alpha85);
        this.mbf = new com.baidu.tieba.write.c();
        this.mbf.Lc(R.color.CAM_X0101);
        this.mbf.Ld(R.color.cp_cont_h_alpha85);
    }

    public void vQ(boolean z) {
        if (this.mbg != null && this.mbg.getText() != null) {
            int selectionEnd = this.mbg.getSelectionEnd();
            SpannableStringBuilder d = this.mbe.d(this.mbg.getText());
            if (d != null) {
                this.mbe.zu(true);
                this.mbg.setText(d);
                if (z && this.mbe.dWo() >= 0) {
                    this.mbg.requestFocus();
                    this.mbg.setSelection(this.mbe.dWo());
                } else {
                    this.mbg.setSelection(selectionEnd);
                }
                this.mbe.zt(this.mbe.dWo() >= 0);
            }
        }
    }

    public void vR(boolean z) {
        if (this.kpl != null && this.kpl.getText() != null) {
            int selectionEnd = this.kpl.getSelectionEnd();
            SpannableStringBuilder d = this.mbf.d(this.kpl.getText());
            if (d != null) {
                this.mbf.zu(true);
                this.kpl.setText(d);
                if (z && this.mbf.dWo() >= 0) {
                    this.kpl.requestFocus();
                    this.kpl.setSelection(this.mbf.dWo());
                } else {
                    this.kpl.setSelection(selectionEnd);
                }
                this.mbf.zt(this.mbf.dWo() >= 0);
            }
        }
    }

    public void drD() {
        this.mbf.UV(null);
        this.mbf.bg(null);
        this.mbf.zt(false);
    }

    public void drE() {
        this.mbe.UV(null);
        this.mbe.bg(null);
        this.mbe.zt(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mbe.bg(postWriteCallBackData.getSensitiveWords());
            this.mbe.UV(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mbe.dWn())) {
                vQ(true);
                this.lTH = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mbf.bg(postWriteCallBackData.getSensitiveWords());
            this.mbf.UV(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mbf.dWn())) {
                vR(true);
            }
        }
    }

    public void f(EditText editText) {
        this.mbg = editText;
    }

    public void g(EditText editText) {
        this.kpl = editText;
    }

    public void onDestroy() {
        this.mbg = null;
        this.kpl = null;
    }

    public void onChangeSkinType() {
        this.mbe.onChangeSkinType();
        this.mbf.onChangeSkinType();
        if (this.mbe.dWp()) {
            vQ(false);
        }
        if (this.mbf.dWp()) {
            vR(false);
        }
    }

    public com.baidu.tieba.write.c drF() {
        return this.mbe;
    }

    public com.baidu.tieba.write.c drG() {
        return this.mbf;
    }

    public EditText drH() {
        return this.kpl;
    }

    public PostWriteCallBackData drI() {
        return this.lTH;
    }
}
