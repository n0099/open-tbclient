package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class bb {
    private EditText jKT;
    private com.baidu.tieba.write.c lDF = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c lDG;
    private EditText lDH;
    private PostWriteCallBackData lwm;

    public bb() {
        this.lDF.LJ(R.color.CAM_X0101);
        this.lDF.LK(R.color.cp_cont_h_alpha85);
        this.lDG = new com.baidu.tieba.write.c();
        this.lDG.LJ(R.color.CAM_X0101);
        this.lDG.LK(R.color.cp_cont_h_alpha85);
    }

    public void vb(boolean z) {
        if (this.lDH != null && this.lDH.getText() != null) {
            int selectionEnd = this.lDH.getSelectionEnd();
            SpannableStringBuilder c = this.lDF.c(this.lDH.getText());
            if (c != null) {
                this.lDF.yx(true);
                this.lDH.setText(c);
                if (z && this.lDF.dST() >= 0) {
                    this.lDH.requestFocus();
                    this.lDH.setSelection(this.lDF.dST());
                } else {
                    this.lDH.setSelection(selectionEnd);
                }
                this.lDF.yw(this.lDF.dST() >= 0);
            }
        }
    }

    public void vc(boolean z) {
        if (this.jKT != null && this.jKT.getText() != null) {
            int selectionEnd = this.jKT.getSelectionEnd();
            SpannableStringBuilder c = this.lDG.c(this.jKT.getText());
            if (c != null) {
                this.lDG.yx(true);
                this.jKT.setText(c);
                if (z && this.lDG.dST() >= 0) {
                    this.jKT.requestFocus();
                    this.jKT.setSelection(this.lDG.dST());
                } else {
                    this.jKT.setSelection(selectionEnd);
                }
                this.lDG.yw(this.lDG.dST() >= 0);
            }
        }
    }

    public void dnZ() {
        this.lDG.Ul(null);
        this.lDG.bl(null);
        this.lDG.yw(false);
    }

    public void doa() {
        this.lDF.Ul(null);
        this.lDF.bl(null);
        this.lDF.yw(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lDF.bl(postWriteCallBackData.getSensitiveWords());
            this.lDF.Ul(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lDF.dSS())) {
                vb(true);
                this.lwm = postWriteCallBackData;
            }
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lDG.bl(postWriteCallBackData.getSensitiveWords());
            this.lDG.Ul(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.lDG.dSS())) {
                vc(true);
            }
        }
    }

    public void e(EditText editText) {
        this.lDH = editText;
    }

    public void f(EditText editText) {
        this.jKT = editText;
    }

    public void onDestroy() {
        this.lDH = null;
        this.jKT = null;
    }

    public void onChangeSkinType() {
        this.lDF.onChangeSkinType();
        this.lDG.onChangeSkinType();
        if (this.lDF.dSU()) {
            vb(false);
        }
        if (this.lDG.dSU()) {
            vc(false);
        }
    }

    public com.baidu.tieba.write.c dob() {
        return this.lDF;
    }

    public com.baidu.tieba.write.c doc() {
        return this.lDG;
    }

    public EditText dod() {
        return this.jKT;
    }

    public PostWriteCallBackData doe() {
        return this.lwm;
    }
}
