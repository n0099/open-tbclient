package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private EditText krB;
    private PostWriteCallBackData lVY;
    private com.baidu.tieba.write.c mdv = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c mdw;
    private EditText mdx;

    public ar() {
        this.mdv.Lh(R.color.CAM_X0101);
        this.mdv.Li(R.color.cp_cont_h_alpha85);
        this.mdw = new com.baidu.tieba.write.c();
        this.mdw.Lh(R.color.CAM_X0101);
        this.mdw.Li(R.color.cp_cont_h_alpha85);
    }

    public void vQ(boolean z) {
        if (this.mdx != null && this.mdx.getText() != null) {
            int selectionEnd = this.mdx.getSelectionEnd();
            SpannableStringBuilder d = this.mdv.d(this.mdx.getText());
            if (d != null) {
                this.mdv.zt(true);
                this.mdx.setText(d);
                if (z && this.mdv.dWE() >= 0) {
                    this.mdx.requestFocus();
                    this.mdx.setSelection(this.mdv.dWE());
                } else {
                    this.mdx.setSelection(selectionEnd);
                }
                this.mdv.zs(this.mdv.dWE() >= 0);
            }
        }
    }

    public void vR(boolean z) {
        if (this.krB != null && this.krB.getText() != null) {
            int selectionEnd = this.krB.getSelectionEnd();
            SpannableStringBuilder d = this.mdw.d(this.krB.getText());
            if (d != null) {
                this.mdw.zt(true);
                this.krB.setText(d);
                if (z && this.mdw.dWE() >= 0) {
                    this.krB.requestFocus();
                    this.krB.setSelection(this.mdw.dWE());
                } else {
                    this.krB.setSelection(selectionEnd);
                }
                this.mdw.zs(this.mdw.dWE() >= 0);
            }
        }
    }

    public void drT() {
        this.mdw.Vo(null);
        this.mdw.bg(null);
        this.mdw.zs(false);
    }

    public void drU() {
        this.mdv.Vo(null);
        this.mdv.bg(null);
        this.mdv.zs(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mdv.bg(postWriteCallBackData.getSensitiveWords());
            this.mdv.Vo(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mdv.dWD())) {
                vQ(true);
                this.lVY = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mdw.bg(postWriteCallBackData.getSensitiveWords());
            this.mdw.Vo(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mdw.dWD())) {
                vR(true);
            }
        }
    }

    public void f(EditText editText) {
        this.mdx = editText;
    }

    public void g(EditText editText) {
        this.krB = editText;
    }

    public void onDestroy() {
        this.mdx = null;
        this.krB = null;
    }

    public void onChangeSkinType() {
        this.mdv.onChangeSkinType();
        this.mdw.onChangeSkinType();
        if (this.mdv.dWF()) {
            vQ(false);
        }
        if (this.mdw.dWF()) {
            vR(false);
        }
    }

    public com.baidu.tieba.write.c drV() {
        return this.mdv;
    }

    public com.baidu.tieba.write.c drW() {
        return this.mdw;
    }

    public EditText drX() {
        return this.krB;
    }

    public PostWriteCallBackData drY() {
        return this.lVY;
    }
}
