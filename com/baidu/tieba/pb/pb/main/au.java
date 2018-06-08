package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class au {
    private com.baidu.tieba.write.b fDn = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fDo;
    private EditText fDp;
    private EditText fDq;
    private PostWriteCallBackData fwa;

    public au() {
        this.fDn.va(d.C0141d.cp_cont_i);
        this.fDn.vb(d.C0141d.cp_cont_h_alpha85);
        this.fDo = new com.baidu.tieba.write.b();
        this.fDo.va(d.C0141d.cp_cont_i);
        this.fDo.vb(d.C0141d.cp_cont_h_alpha85);
    }

    public void ky(boolean z) {
        if (this.fDp != null && this.fDp.getText() != null) {
            int selectionEnd = this.fDp.getSelectionEnd();
            SpannableStringBuilder b = this.fDn.b(this.fDp.getText());
            if (b != null) {
                this.fDn.ns(true);
                this.fDp.setText(b);
                if (z && this.fDn.bFZ() >= 0) {
                    this.fDp.requestFocus();
                    this.fDp.setSelection(this.fDn.bFZ());
                } else {
                    this.fDp.setSelection(selectionEnd);
                }
                this.fDn.nr(this.fDn.bFZ() >= 0);
            }
        }
    }

    public void kz(boolean z) {
        if (this.fDq != null && this.fDq.getText() != null) {
            int selectionEnd = this.fDq.getSelectionEnd();
            SpannableStringBuilder b = this.fDo.b(this.fDq.getText());
            if (b != null) {
                this.fDo.ns(true);
                this.fDq.setText(b);
                if (z && this.fDo.bFZ() >= 0) {
                    this.fDq.requestFocus();
                    this.fDq.setSelection(this.fDo.bFZ());
                } else {
                    this.fDq.setSelection(selectionEnd);
                }
                this.fDo.nr(this.fDo.bFZ() >= 0);
            }
        }
    }

    public void bfN() {
        this.fDo.vy(null);
        this.fDo.ax(null);
        this.fDo.nr(false);
    }

    public void bfO() {
        this.fDn.vy(null);
        this.fDn.ax(null);
        this.fDn.nr(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fDn.ax(postWriteCallBackData.getSensitiveWords());
            this.fDn.vy(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.z(this.fDn.bFY())) {
                ky(true);
                this.fwa = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fDo.ax(postWriteCallBackData.getSensitiveWords());
            this.fDo.vy(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.z(this.fDo.bFY())) {
                kz(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fDp = editText;
    }

    public void h(EditText editText) {
        this.fDq = editText;
    }

    public void onDestroy() {
        this.fDp = null;
        this.fDq = null;
    }

    public void onChangeSkinType() {
        this.fDn.onChangeSkinType();
        this.fDo.onChangeSkinType();
        if (this.fDn.bGa()) {
            ky(false);
        }
        if (this.fDo.bGa()) {
            kz(false);
        }
    }

    public com.baidu.tieba.write.b bfP() {
        return this.fDn;
    }

    public com.baidu.tieba.write.b bfQ() {
        return this.fDo;
    }

    public EditText bfR() {
        return this.fDq;
    }

    public PostWriteCallBackData bfS() {
        return this.fwa;
    }
}
