package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class at {
    private PostWriteCallBackData fPq;
    private com.baidu.tieba.write.b fWw = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fWx;
    private EditText fWy;
    private EditText fWz;

    public at() {
        this.fWw.wf(e.d.cp_cont_i);
        this.fWw.wg(e.d.cp_cont_h_alpha85);
        this.fWx = new com.baidu.tieba.write.b();
        this.fWx.wf(e.d.cp_cont_i);
        this.fWx.wg(e.d.cp_cont_h_alpha85);
    }

    public void lj(boolean z) {
        if (this.fWy != null && this.fWy.getText() != null) {
            int selectionEnd = this.fWy.getSelectionEnd();
            SpannableStringBuilder b = this.fWw.b(this.fWy.getText());
            if (b != null) {
                this.fWw.ob(true);
                this.fWy.setText(b);
                if (z && this.fWw.bLr() >= 0) {
                    this.fWy.requestFocus();
                    this.fWy.setSelection(this.fWw.bLr());
                } else {
                    this.fWy.setSelection(selectionEnd);
                }
                this.fWw.oa(this.fWw.bLr() >= 0);
            }
        }
    }

    public void lk(boolean z) {
        if (this.fWz != null && this.fWz.getText() != null) {
            int selectionEnd = this.fWz.getSelectionEnd();
            SpannableStringBuilder b = this.fWx.b(this.fWz.getText());
            if (b != null) {
                this.fWx.ob(true);
                this.fWz.setText(b);
                if (z && this.fWx.bLr() >= 0) {
                    this.fWz.requestFocus();
                    this.fWz.setSelection(this.fWx.bLr());
                } else {
                    this.fWz.setSelection(selectionEnd);
                }
                this.fWx.oa(this.fWx.bLr() >= 0);
            }
        }
    }

    public void bkv() {
        this.fWx.wJ(null);
        this.fWx.aA(null);
        this.fWx.oa(false);
    }

    public void bkw() {
        this.fWw.wJ(null);
        this.fWw.aA(null);
        this.fWw.oa(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWw.aA(postWriteCallBackData.getSensitiveWords());
            this.fWw.wJ(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.J(this.fWw.bLq())) {
                lj(true);
                this.fPq = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fWx.aA(postWriteCallBackData.getSensitiveWords());
            this.fWx.wJ(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.J(this.fWx.bLq())) {
                lk(true);
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
        if (this.fWw.bLs()) {
            lj(false);
        }
        if (this.fWx.bLs()) {
            lk(false);
        }
    }

    public com.baidu.tieba.write.b bkx() {
        return this.fWw;
    }

    public com.baidu.tieba.write.b bky() {
        return this.fWx;
    }

    public EditText bkz() {
        return this.fWz;
    }

    public PostWriteCallBackData bkA() {
        return this.fPq;
    }
}
