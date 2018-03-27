package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class at {
    private PostWriteCallBackData fPC;
    private com.baidu.tieba.write.b fWM = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fWN;
    private EditText fWO;
    private EditText fWP;

    public at() {
        this.fWM.xg(d.C0141d.cp_cont_i);
        this.fWM.xh(d.C0141d.cp_cont_h_alpha85);
        this.fWN = new com.baidu.tieba.write.b();
        this.fWN.xg(d.C0141d.cp_cont_i);
        this.fWN.xh(d.C0141d.cp_cont_h_alpha85);
    }

    public void kU(boolean z) {
        if (this.fWO != null && this.fWO.getText() != null) {
            int selectionEnd = this.fWO.getSelectionEnd();
            SpannableStringBuilder b = this.fWM.b(this.fWO.getText());
            if (b != null) {
                this.fWM.nG(true);
                this.fWO.setText(b);
                if (z && this.fWM.bFH() >= 0) {
                    this.fWO.requestFocus();
                    this.fWO.setSelection(this.fWM.bFH());
                } else {
                    this.fWO.setSelection(selectionEnd);
                }
                this.fWM.nF(this.fWM.bFH() >= 0);
            }
        }
    }

    public void kV(boolean z) {
        if (this.fWP != null && this.fWP.getText() != null) {
            int selectionEnd = this.fWP.getSelectionEnd();
            SpannableStringBuilder b = this.fWN.b(this.fWP.getText());
            if (b != null) {
                this.fWN.nG(true);
                this.fWP.setText(b);
                if (z && this.fWN.bFH() >= 0) {
                    this.fWP.requestFocus();
                    this.fWP.setSelection(this.fWN.bFH());
                } else {
                    this.fWP.setSelection(selectionEnd);
                }
                this.fWN.nF(this.fWN.bFH() >= 0);
            }
        }
    }

    public void bfR() {
        this.fWN.un(null);
        this.fWN.aw(null);
        this.fWN.nF(false);
    }

    public void bfS() {
        this.fWM.un(null);
        this.fWM.aw(null);
        this.fWM.nF(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWM.aw(postWriteCallBackData.getSensitiveWords());
            this.fWM.un(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fWM.bFG())) {
                kU(true);
                this.fPC = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWN.aw(postWriteCallBackData.getSensitiveWords());
            this.fWN.un(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fWN.bFG())) {
                kV(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fWO = editText;
    }

    public void h(EditText editText) {
        this.fWP = editText;
    }

    public void onDestroy() {
        this.fWO = null;
        this.fWP = null;
    }

    public void onChangeSkinType() {
        this.fWM.onChangeSkinType();
        this.fWN.onChangeSkinType();
        if (this.fWM.bFI()) {
            kU(false);
        }
        if (this.fWN.bFI()) {
            kV(false);
        }
    }

    public com.baidu.tieba.write.b bfT() {
        return this.fWM;
    }

    public com.baidu.tieba.write.b bfU() {
        return this.fWN;
    }

    public EditText bfV() {
        return this.fWP;
    }

    public PostWriteCallBackData bfW() {
        return this.fPC;
    }
}
