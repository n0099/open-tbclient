package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ax {
    private EditText ihQ;
    private PostWriteCallBackData jNG;
    private EditText jUA;
    private com.baidu.tieba.write.c jUy = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c jUz;

    public ax() {
        this.jUy.Fv(R.color.cp_cont_a);
        this.jUy.Fw(R.color.cp_cont_h_alpha85);
        this.jUz = new com.baidu.tieba.write.c();
        this.jUz.Fv(R.color.cp_cont_a);
        this.jUz.Fw(R.color.cp_cont_h_alpha85);
    }

    public void sf(boolean z) {
        if (this.jUA != null && this.jUA.getText() != null) {
            int selectionEnd = this.jUA.getSelectionEnd();
            SpannableStringBuilder a = this.jUy.a(this.jUA.getText());
            if (a != null) {
                this.jUy.vn(true);
                this.jUA.setText(a);
                if (z && this.jUy.dmw() >= 0) {
                    this.jUA.requestFocus();
                    this.jUA.setSelection(this.jUy.dmw());
                } else {
                    this.jUA.setSelection(selectionEnd);
                }
                this.jUy.vm(this.jUy.dmw() >= 0);
            }
        }
    }

    public void sg(boolean z) {
        if (this.ihQ != null && this.ihQ.getText() != null) {
            int selectionEnd = this.ihQ.getSelectionEnd();
            SpannableStringBuilder a = this.jUz.a(this.ihQ.getText());
            if (a != null) {
                this.jUz.vn(true);
                this.ihQ.setText(a);
                if (z && this.jUz.dmw() >= 0) {
                    this.ihQ.requestFocus();
                    this.ihQ.setSelection(this.jUz.dmw());
                } else {
                    this.ihQ.setSelection(selectionEnd);
                }
                this.jUz.vm(this.jUz.dmw() >= 0);
            }
        }
    }

    public void cIH() {
        this.jUz.Og(null);
        this.jUz.aX(null);
        this.jUz.vm(false);
    }

    public void cII() {
        this.jUy.Og(null);
        this.jUy.aX(null);
        this.jUy.vm(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jUy.aX(postWriteCallBackData.getSensitiveWords());
            this.jUy.Og(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jUy.dmv())) {
                sf(true);
                this.jNG = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jUz.aX(postWriteCallBackData.getSensitiveWords());
            this.jUz.Og(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jUz.dmv())) {
                sg(true);
            }
        }
    }

    public void e(EditText editText) {
        this.jUA = editText;
    }

    public void f(EditText editText) {
        this.ihQ = editText;
    }

    public void onDestroy() {
        this.jUA = null;
        this.ihQ = null;
    }

    public void onChangeSkinType() {
        this.jUy.onChangeSkinType();
        this.jUz.onChangeSkinType();
        if (this.jUy.dmx()) {
            sf(false);
        }
        if (this.jUz.dmx()) {
            sg(false);
        }
    }

    public com.baidu.tieba.write.c cIJ() {
        return this.jUy;
    }

    public com.baidu.tieba.write.c cIK() {
        return this.jUz;
    }

    public EditText cIL() {
        return this.ihQ;
    }

    public PostWriteCallBackData cIM() {
        return this.jNG;
    }
}
