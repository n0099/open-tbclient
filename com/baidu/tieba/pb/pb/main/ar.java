package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private EditText kpz;
    private PostWriteCallBackData lTW;
    private com.baidu.tieba.write.c mbt = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c mbu;
    private EditText mbv;

    public ar() {
        this.mbt.Ld(R.color.CAM_X0101);
        this.mbt.Le(R.color.cp_cont_h_alpha85);
        this.mbu = new com.baidu.tieba.write.c();
        this.mbu.Ld(R.color.CAM_X0101);
        this.mbu.Le(R.color.cp_cont_h_alpha85);
    }

    public void vQ(boolean z) {
        if (this.mbv != null && this.mbv.getText() != null) {
            int selectionEnd = this.mbv.getSelectionEnd();
            SpannableStringBuilder d = this.mbt.d(this.mbv.getText());
            if (d != null) {
                this.mbt.zu(true);
                this.mbv.setText(d);
                if (z && this.mbt.dWw() >= 0) {
                    this.mbv.requestFocus();
                    this.mbv.setSelection(this.mbt.dWw());
                } else {
                    this.mbv.setSelection(selectionEnd);
                }
                this.mbt.zt(this.mbt.dWw() >= 0);
            }
        }
    }

    public void vR(boolean z) {
        if (this.kpz != null && this.kpz.getText() != null) {
            int selectionEnd = this.kpz.getSelectionEnd();
            SpannableStringBuilder d = this.mbu.d(this.kpz.getText());
            if (d != null) {
                this.mbu.zu(true);
                this.kpz.setText(d);
                if (z && this.mbu.dWw() >= 0) {
                    this.kpz.requestFocus();
                    this.kpz.setSelection(this.mbu.dWw());
                } else {
                    this.kpz.setSelection(selectionEnd);
                }
                this.mbu.zt(this.mbu.dWw() >= 0);
            }
        }
    }

    public void drK() {
        this.mbu.Vh(null);
        this.mbu.bg(null);
        this.mbu.zt(false);
    }

    public void drL() {
        this.mbt.Vh(null);
        this.mbt.bg(null);
        this.mbt.zt(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mbt.bg(postWriteCallBackData.getSensitiveWords());
            this.mbt.Vh(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mbt.dWv())) {
                vQ(true);
                this.lTW = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mbu.bg(postWriteCallBackData.getSensitiveWords());
            this.mbu.Vh(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mbu.dWv())) {
                vR(true);
            }
        }
    }

    public void f(EditText editText) {
        this.mbv = editText;
    }

    public void g(EditText editText) {
        this.kpz = editText;
    }

    public void onDestroy() {
        this.mbv = null;
        this.kpz = null;
    }

    public void onChangeSkinType() {
        this.mbt.onChangeSkinType();
        this.mbu.onChangeSkinType();
        if (this.mbt.dWx()) {
            vQ(false);
        }
        if (this.mbu.dWx()) {
            vR(false);
        }
    }

    public com.baidu.tieba.write.c drM() {
        return this.mbt;
    }

    public com.baidu.tieba.write.c drN() {
        return this.mbu;
    }

    public EditText drO() {
        return this.kpz;
    }

    public PostWriteCallBackData drP() {
        return this.lTW;
    }
}
