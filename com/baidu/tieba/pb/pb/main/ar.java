package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private com.baidu.tieba.write.b eUv = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b eUw;
    private EditText eUx;
    private EditText eUy;

    public ar() {
        this.eUv.vc(d.C0080d.cp_cont_i);
        this.eUv.vd(d.C0080d.cp_cont_h_alpha85);
        this.eUw = new com.baidu.tieba.write.b();
        this.eUw.vc(d.C0080d.cp_cont_i);
        this.eUw.vd(d.C0080d.cp_cont_h_alpha85);
    }

    public void ju(boolean z) {
        if (this.eUx != null && this.eUx.getText() != null) {
            int selectionEnd = this.eUx.getSelectionEnd();
            SpannableStringBuilder b = this.eUv.b(this.eUx.getText());
            if (b != null) {
                this.eUv.nj(true);
                this.eUx.setText(b);
                if (z && this.eUv.bCe() >= 0) {
                    this.eUx.requestFocus();
                    this.eUx.setSelection(this.eUv.bCe());
                } else {
                    this.eUx.setSelection(selectionEnd);
                }
                this.eUv.ni(this.eUv.bCe() >= 0);
            }
        }
    }

    public void jv(boolean z) {
        if (this.eUy != null && this.eUy.getText() != null) {
            int selectionEnd = this.eUy.getSelectionEnd();
            SpannableStringBuilder b = this.eUw.b(this.eUy.getText());
            if (b != null) {
                this.eUw.nj(true);
                this.eUy.setText(b);
                if (z && this.eUw.bCe() >= 0) {
                    this.eUy.requestFocus();
                    this.eUy.setSelection(this.eUw.bCe());
                } else {
                    this.eUy.setSelection(selectionEnd);
                }
                this.eUw.ni(this.eUw.bCe() >= 0);
            }
        }
    }

    public void aVc() {
        this.eUw.tI(null);
        this.eUw.aB(null);
        this.eUw.ni(false);
    }

    public void aVd() {
        this.eUv.tI(null);
        this.eUv.aB(null);
        this.eUv.ni(false);
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.eUv.aB(postWriteCallBackData.getSensitiveWords());
            this.eUv.tI(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.v(this.eUv.bCd())) {
                ju(true);
            }
        }
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.eUw.aB(postWriteCallBackData.getSensitiveWords());
            this.eUw.tI(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.v(this.eUw.bCd())) {
                jv(true);
            }
        }
    }

    public void f(EditText editText) {
        this.eUx = editText;
    }

    public void g(EditText editText) {
        this.eUy = editText;
    }

    public void onDestroy() {
        this.eUx = null;
        this.eUy = null;
    }

    public void onChangeSkinType() {
        this.eUv.onChangeSkinType();
        this.eUw.onChangeSkinType();
        if (this.eUv.bCf()) {
            ju(false);
        }
        if (this.eUw.bCf()) {
            jv(false);
        }
    }

    public com.baidu.tieba.write.b aVe() {
        return this.eUv;
    }

    public com.baidu.tieba.write.b aVf() {
        return this.eUw;
    }

    public EditText aVg() {
        return this.eUy;
    }
}
