package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class ar {
    private com.baidu.tieba.write.b eUQ = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b eUR;
    private EditText eUS;
    private EditText eUT;

    public ar() {
        this.eUQ.vg(d.C0080d.cp_cont_i);
        this.eUQ.vh(d.C0080d.cp_cont_h_alpha85);
        this.eUR = new com.baidu.tieba.write.b();
        this.eUR.vg(d.C0080d.cp_cont_i);
        this.eUR.vh(d.C0080d.cp_cont_h_alpha85);
    }

    public void jA(boolean z) {
        if (this.eUS != null && this.eUS.getText() != null) {
            int selectionEnd = this.eUS.getSelectionEnd();
            SpannableStringBuilder b = this.eUQ.b(this.eUS.getText());
            if (b != null) {
                this.eUQ.nr(true);
                this.eUS.setText(b);
                if (z && this.eUQ.bCq() >= 0) {
                    this.eUS.requestFocus();
                    this.eUS.setSelection(this.eUQ.bCq());
                } else {
                    this.eUS.setSelection(selectionEnd);
                }
                this.eUQ.nq(this.eUQ.bCq() >= 0);
            }
        }
    }

    public void jB(boolean z) {
        if (this.eUT != null && this.eUT.getText() != null) {
            int selectionEnd = this.eUT.getSelectionEnd();
            SpannableStringBuilder b = this.eUR.b(this.eUT.getText());
            if (b != null) {
                this.eUR.nr(true);
                this.eUT.setText(b);
                if (z && this.eUR.bCq() >= 0) {
                    this.eUT.requestFocus();
                    this.eUT.setSelection(this.eUR.bCq());
                } else {
                    this.eUT.setSelection(selectionEnd);
                }
                this.eUR.nq(this.eUR.bCq() >= 0);
            }
        }
    }

    public void aVk() {
        this.eUR.tO(null);
        this.eUR.aB(null);
        this.eUR.nq(false);
    }

    public void aVl() {
        this.eUQ.tO(null);
        this.eUQ.aB(null);
        this.eUQ.nq(false);
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.eUQ.aB(postWriteCallBackData.getSensitiveWords());
            this.eUQ.tO(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.v(this.eUQ.bCp())) {
                jA(true);
            }
        }
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.eUR.aB(postWriteCallBackData.getSensitiveWords());
            this.eUR.tO(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.v(this.eUR.bCp())) {
                jB(true);
            }
        }
    }

    public void f(EditText editText) {
        this.eUS = editText;
    }

    public void g(EditText editText) {
        this.eUT = editText;
    }

    public void onDestroy() {
        this.eUS = null;
        this.eUT = null;
    }

    public void onChangeSkinType() {
        this.eUQ.onChangeSkinType();
        this.eUR.onChangeSkinType();
        if (this.eUQ.bCr()) {
            jA(false);
        }
        if (this.eUR.bCr()) {
            jB(false);
        }
    }

    public com.baidu.tieba.write.b aVm() {
        return this.eUQ;
    }

    public com.baidu.tieba.write.b aVn() {
        return this.eUR;
    }

    public EditText aVo() {
        return this.eUT;
    }
}
