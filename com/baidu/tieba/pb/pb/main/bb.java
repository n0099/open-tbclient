package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class bb {
    private EditText iTZ;
    private PostWriteCallBackData kFE;
    private com.baidu.tieba.write.c kMT = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c kMU;
    private EditText kMV;

    public bb() {
        this.kMT.Jr(R.color.cp_cont_a);
        this.kMT.Js(R.color.cp_cont_h_alpha85);
        this.kMU = new com.baidu.tieba.write.c();
        this.kMU.Jr(R.color.cp_cont_a);
        this.kMU.Js(R.color.cp_cont_h_alpha85);
    }

    public void tI(boolean z) {
        if (this.kMV != null && this.kMV.getText() != null) {
            int selectionEnd = this.kMV.getSelectionEnd();
            SpannableStringBuilder c = this.kMT.c(this.kMV.getText());
            if (c != null) {
                this.kMT.wY(true);
                this.kMV.setText(c);
                if (z && this.kMT.dFv() >= 0) {
                    this.kMV.requestFocus();
                    this.kMV.setSelection(this.kMT.dFv());
                } else {
                    this.kMV.setSelection(selectionEnd);
                }
                this.kMT.wX(this.kMT.dFv() >= 0);
            }
        }
    }

    public void tJ(boolean z) {
        if (this.iTZ != null && this.iTZ.getText() != null) {
            int selectionEnd = this.iTZ.getSelectionEnd();
            SpannableStringBuilder c = this.kMU.c(this.iTZ.getText());
            if (c != null) {
                this.kMU.wY(true);
                this.iTZ.setText(c);
                if (z && this.kMU.dFv() >= 0) {
                    this.iTZ.requestFocus();
                    this.iTZ.setSelection(this.kMU.dFv());
                } else {
                    this.iTZ.setSelection(selectionEnd);
                }
                this.kMU.wX(this.kMU.dFv() >= 0);
            }
        }
    }

    public void dbC() {
        this.kMU.Sw(null);
        this.kMU.bf(null);
        this.kMU.wX(false);
    }

    public void dbD() {
        this.kMT.Sw(null);
        this.kMT.bf(null);
        this.kMT.wX(false);
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kMT.bf(postWriteCallBackData.getSensitiveWords());
            this.kMT.Sw(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.kMT.dFu())) {
                tI(true);
                this.kFE = postWriteCallBackData;
            }
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kMU.bf(postWriteCallBackData.getSensitiveWords());
            this.kMU.Sw(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.kMU.dFu())) {
                tJ(true);
            }
        }
    }

    public void f(EditText editText) {
        this.kMV = editText;
    }

    public void g(EditText editText) {
        this.iTZ = editText;
    }

    public void onDestroy() {
        this.kMV = null;
        this.iTZ = null;
    }

    public void onChangeSkinType() {
        this.kMT.onChangeSkinType();
        this.kMU.onChangeSkinType();
        if (this.kMT.dFw()) {
            tI(false);
        }
        if (this.kMU.dFw()) {
            tJ(false);
        }
    }

    public com.baidu.tieba.write.c dbE() {
        return this.kMT;
    }

    public com.baidu.tieba.write.c dbF() {
        return this.kMU;
    }

    public EditText dbG() {
        return this.iTZ;
    }

    public PostWriteCallBackData dbH() {
        return this.kFE;
    }
}
