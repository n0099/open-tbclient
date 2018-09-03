package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class av {
    private PostWriteCallBackData fAg;
    private com.baidu.tieba.write.b fHw = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fHx;
    private EditText fHy;
    private EditText fHz;

    public av() {
        this.fHw.vi(f.d.cp_cont_i);
        this.fHw.vj(f.d.cp_cont_h_alpha85);
        this.fHx = new com.baidu.tieba.write.b();
        this.fHx.vi(f.d.cp_cont_i);
        this.fHx.vj(f.d.cp_cont_h_alpha85);
    }

    public void ku(boolean z) {
        if (this.fHy != null && this.fHy.getText() != null) {
            int selectionEnd = this.fHy.getSelectionEnd();
            SpannableStringBuilder b = this.fHw.b(this.fHy.getText());
            if (b != null) {
                this.fHw.no(true);
                this.fHy.setText(b);
                if (z && this.fHw.bFo() >= 0) {
                    this.fHy.requestFocus();
                    this.fHy.setSelection(this.fHw.bFo());
                } else {
                    this.fHy.setSelection(selectionEnd);
                }
                this.fHw.nn(this.fHw.bFo() >= 0);
            }
        }
    }

    public void kv(boolean z) {
        if (this.fHz != null && this.fHz.getText() != null) {
            int selectionEnd = this.fHz.getSelectionEnd();
            SpannableStringBuilder b = this.fHx.b(this.fHz.getText());
            if (b != null) {
                this.fHx.no(true);
                this.fHz.setText(b);
                if (z && this.fHx.bFo() >= 0) {
                    this.fHz.requestFocus();
                    this.fHz.setSelection(this.fHx.bFo());
                } else {
                    this.fHz.setSelection(selectionEnd);
                }
                this.fHx.nn(this.fHx.bFo() >= 0);
            }
        }
    }

    public void beJ() {
        this.fHx.vz(null);
        this.fHx.az(null);
        this.fHx.nn(false);
    }

    public void beK() {
        this.fHw.vz(null);
        this.fHw.az(null);
        this.fHw.nn(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fHw.az(postWriteCallBackData.getSensitiveWords());
            this.fHw.vz(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.z(this.fHw.bFn())) {
                ku(true);
                this.fAg = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fHx.az(postWriteCallBackData.getSensitiveWords());
            this.fHx.vz(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.z(this.fHx.bFn())) {
                kv(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fHy = editText;
    }

    public void h(EditText editText) {
        this.fHz = editText;
    }

    public void onDestroy() {
        this.fHy = null;
        this.fHz = null;
    }

    public void onChangeSkinType() {
        this.fHw.onChangeSkinType();
        this.fHx.onChangeSkinType();
        if (this.fHw.bFp()) {
            ku(false);
        }
        if (this.fHx.bFp()) {
            kv(false);
        }
    }

    public com.baidu.tieba.write.b beL() {
        return this.fHw;
    }

    public com.baidu.tieba.write.b beM() {
        return this.fHx;
    }

    public EditText beN() {
        return this.fHz;
    }

    public PostWriteCallBackData beO() {
        return this.fAg;
    }
}
