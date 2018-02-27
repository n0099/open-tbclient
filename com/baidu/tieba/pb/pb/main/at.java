package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class at {
    private PostWriteCallBackData fPm;
    private com.baidu.tieba.write.b fWw = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fWx;
    private EditText fWy;
    private EditText fWz;

    public at() {
        this.fWw.xg(d.C0141d.cp_cont_i);
        this.fWw.xh(d.C0141d.cp_cont_h_alpha85);
        this.fWx = new com.baidu.tieba.write.b();
        this.fWx.xg(d.C0141d.cp_cont_i);
        this.fWx.xh(d.C0141d.cp_cont_h_alpha85);
    }

    public void kP(boolean z) {
        if (this.fWy != null && this.fWy.getText() != null) {
            int selectionEnd = this.fWy.getSelectionEnd();
            SpannableStringBuilder b = this.fWw.b(this.fWy.getText());
            if (b != null) {
                this.fWw.nB(true);
                this.fWy.setText(b);
                if (z && this.fWw.bFC() >= 0) {
                    this.fWy.requestFocus();
                    this.fWy.setSelection(this.fWw.bFC());
                } else {
                    this.fWy.setSelection(selectionEnd);
                }
                this.fWw.nA(this.fWw.bFC() >= 0);
            }
        }
    }

    public void kQ(boolean z) {
        if (this.fWz != null && this.fWz.getText() != null) {
            int selectionEnd = this.fWz.getSelectionEnd();
            SpannableStringBuilder b = this.fWx.b(this.fWz.getText());
            if (b != null) {
                this.fWx.nB(true);
                this.fWz.setText(b);
                if (z && this.fWx.bFC() >= 0) {
                    this.fWz.requestFocus();
                    this.fWz.setSelection(this.fWx.bFC());
                } else {
                    this.fWz.setSelection(selectionEnd);
                }
                this.fWx.nA(this.fWx.bFC() >= 0);
            }
        }
    }

    public void bfQ() {
        this.fWx.un(null);
        this.fWx.aw(null);
        this.fWx.nA(false);
    }

    public void bfR() {
        this.fWw.un(null);
        this.fWw.aw(null);
        this.fWw.nA(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWw.aw(postWriteCallBackData.getSensitiveWords());
            this.fWw.un(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fWw.bFB())) {
                kP(true);
                this.fPm = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWx.aw(postWriteCallBackData.getSensitiveWords());
            this.fWx.un(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.E(this.fWx.bFB())) {
                kQ(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fWy = editText;
    }

    public void h(EditText editText) {
        this.fWz = editText;
    }

    public void onDestroy() {
        this.fWy = null;
        this.fWz = null;
    }

    public void onChangeSkinType() {
        this.fWw.onChangeSkinType();
        this.fWx.onChangeSkinType();
        if (this.fWw.bFD()) {
            kP(false);
        }
        if (this.fWx.bFD()) {
            kQ(false);
        }
    }

    public com.baidu.tieba.write.b bfS() {
        return this.fWw;
    }

    public com.baidu.tieba.write.b bfT() {
        return this.fWx;
    }

    public EditText bfU() {
        return this.fWz;
    }

    public PostWriteCallBackData bfV() {
        return this.fPm;
    }
}
