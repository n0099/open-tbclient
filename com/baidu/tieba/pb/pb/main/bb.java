package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText jYy;
    private PostWriteCallBackData lKb;
    private EditText lRA;
    private com.baidu.tieba.write.c lRy = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lRz;

    public bb() {
        this.lRy.MB(R.color.CAM_X0101);
        this.lRy.MC(R.color.cp_cont_h_alpha85);
        this.lRz = new com.baidu.tieba.write.c();
        this.lRz.MB(R.color.CAM_X0101);
        this.lRz.MC(R.color.cp_cont_h_alpha85);
    }

    public void vE(boolean z) {
        if (this.lRA != null && this.lRA.getText() != null) {
            int selectionEnd = this.lRA.getSelectionEnd();
            SpannableStringBuilder c = this.lRy.c(this.lRA.getText());
            if (c != null) {
                this.lRy.zc(true);
                this.lRA.setText(c);
                if (z && this.lRy.dYo() >= 0) {
                    this.lRA.requestFocus();
                    this.lRA.setSelection(this.lRy.dYo());
                } else {
                    this.lRA.setSelection(selectionEnd);
                }
                this.lRy.zb(this.lRy.dYo() >= 0);
            }
        }
    }

    public void vF(boolean z) {
        if (this.jYy != null && this.jYy.getText() != null) {
            int selectionEnd = this.jYy.getSelectionEnd();
            SpannableStringBuilder c = this.lRz.c(this.jYy.getText());
            if (c != null) {
                this.lRz.zc(true);
                this.jYy.setText(c);
                if (z && this.lRz.dYo() >= 0) {
                    this.jYy.requestFocus();
                    this.jYy.setSelection(this.lRz.dYo());
                } else {
                    this.jYy.setSelection(selectionEnd);
                }
                this.lRz.zb(this.lRz.dYo() >= 0);
            }
        }
    }

    public void dtr() {
        this.lRz.VA(null);
        this.lRz.bn(null);
        this.lRz.zb(false);
    }

    public void dts() {
        this.lRy.VA(null);
        this.lRy.bn(null);
        this.lRy.zb(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lRy.bn(postWriteCallBackData.getSensitiveWords());
            this.lRy.VA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lRy.dYn())) {
                vE(true);
                this.lKb = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lRz.bn(postWriteCallBackData.getSensitiveWords());
            this.lRz.VA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lRz.dYn())) {
                vF(true);
            }
        }
    }

    public void e(EditText editText) {
        this.lRA = editText;
    }

    public void f(EditText editText) {
        this.jYy = editText;
    }

    public void onDestroy() {
        this.lRA = null;
        this.jYy = null;
    }

    public void onChangeSkinType() {
        this.lRy.onChangeSkinType();
        this.lRz.onChangeSkinType();
        if (this.lRy.dYp()) {
            vE(false);
        }
        if (this.lRz.dYp()) {
            vF(false);
        }
    }

    public com.baidu.tieba.write.c dtt() {
        return this.lRy;
    }

    public com.baidu.tieba.write.c dtu() {
        return this.lRz;
    }

    public EditText dtv() {
        return this.jYy;
    }

    public PostWriteCallBackData dtw() {
        return this.lKb;
    }
}
