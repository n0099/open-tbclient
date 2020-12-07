package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText jYw;
    private PostWriteCallBackData lJZ;
    private com.baidu.tieba.write.c lRw = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lRx;
    private EditText lRy;

    public bb() {
        this.lRw.MB(R.color.CAM_X0101);
        this.lRw.MC(R.color.cp_cont_h_alpha85);
        this.lRx = new com.baidu.tieba.write.c();
        this.lRx.MB(R.color.CAM_X0101);
        this.lRx.MC(R.color.cp_cont_h_alpha85);
    }

    public void vE(boolean z) {
        if (this.lRy != null && this.lRy.getText() != null) {
            int selectionEnd = this.lRy.getSelectionEnd();
            SpannableStringBuilder c = this.lRw.c(this.lRy.getText());
            if (c != null) {
                this.lRw.zc(true);
                this.lRy.setText(c);
                if (z && this.lRw.dYn() >= 0) {
                    this.lRy.requestFocus();
                    this.lRy.setSelection(this.lRw.dYn());
                } else {
                    this.lRy.setSelection(selectionEnd);
                }
                this.lRw.zb(this.lRw.dYn() >= 0);
            }
        }
    }

    public void vF(boolean z) {
        if (this.jYw != null && this.jYw.getText() != null) {
            int selectionEnd = this.jYw.getSelectionEnd();
            SpannableStringBuilder c = this.lRx.c(this.jYw.getText());
            if (c != null) {
                this.lRx.zc(true);
                this.jYw.setText(c);
                if (z && this.lRx.dYn() >= 0) {
                    this.jYw.requestFocus();
                    this.jYw.setSelection(this.lRx.dYn());
                } else {
                    this.jYw.setSelection(selectionEnd);
                }
                this.lRx.zb(this.lRx.dYn() >= 0);
            }
        }
    }

    public void dtq() {
        this.lRx.VA(null);
        this.lRx.bn(null);
        this.lRx.zb(false);
    }

    public void dtr() {
        this.lRw.VA(null);
        this.lRw.bn(null);
        this.lRw.zb(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lRw.bn(postWriteCallBackData.getSensitiveWords());
            this.lRw.VA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lRw.dYm())) {
                vE(true);
                this.lJZ = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lRx.bn(postWriteCallBackData.getSensitiveWords());
            this.lRx.VA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lRx.dYm())) {
                vF(true);
            }
        }
    }

    public void e(EditText editText) {
        this.lRy = editText;
    }

    public void f(EditText editText) {
        this.jYw = editText;
    }

    public void onDestroy() {
        this.lRy = null;
        this.jYw = null;
    }

    public void onChangeSkinType() {
        this.lRw.onChangeSkinType();
        this.lRx.onChangeSkinType();
        if (this.lRw.dYo()) {
            vE(false);
        }
        if (this.lRx.dYo()) {
            vF(false);
        }
    }

    public com.baidu.tieba.write.c dts() {
        return this.lRw;
    }

    public com.baidu.tieba.write.c dtt() {
        return this.lRx;
    }

    public EditText dtu() {
        return this.jYw;
    }

    public PostWriteCallBackData dtv() {
        return this.lJZ;
    }
}
