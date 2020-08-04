package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes16.dex */
public class bb {
    private EditText iFb;
    private PostWriteCallBackData kqm;
    private com.baidu.tieba.write.c kxo = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c kxp;
    private EditText kxq;

    public bb() {
        this.kxo.GV(R.color.cp_cont_a);
        this.kxo.GW(R.color.cp_cont_h_alpha85);
        this.kxp = new com.baidu.tieba.write.c();
        this.kxp.GV(R.color.cp_cont_a);
        this.kxp.GW(R.color.cp_cont_h_alpha85);
    }

    public void sZ(boolean z) {
        if (this.kxq != null && this.kxq.getText() != null) {
            int selectionEnd = this.kxq.getSelectionEnd();
            SpannableStringBuilder d = this.kxo.d(this.kxq.getText());
            if (d != null) {
                this.kxo.wj(true);
                this.kxq.setText(d);
                if (z && this.kxo.dua() >= 0) {
                    this.kxq.requestFocus();
                    this.kxq.setSelection(this.kxo.dua());
                } else {
                    this.kxq.setSelection(selectionEnd);
                }
                this.kxo.wi(this.kxo.dua() >= 0);
            }
        }
    }

    public void ta(boolean z) {
        if (this.iFb != null && this.iFb.getText() != null) {
            int selectionEnd = this.iFb.getSelectionEnd();
            SpannableStringBuilder d = this.kxp.d(this.iFb.getText());
            if (d != null) {
                this.kxp.wj(true);
                this.iFb.setText(d);
                if (z && this.kxp.dua() >= 0) {
                    this.iFb.requestFocus();
                    this.iFb.setSelection(this.kxp.dua());
                } else {
                    this.iFb.setSelection(selectionEnd);
                }
                this.kxp.wi(this.kxp.dua() >= 0);
            }
        }
    }

    public void cQM() {
        this.kxp.Py(null);
        this.kxp.aZ(null);
        this.kxp.wi(false);
    }

    public void cQN() {
        this.kxo.Py(null);
        this.kxo.aZ(null);
        this.kxo.wi(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kxo.aZ(postWriteCallBackData.getSensitiveWords());
            this.kxo.Py(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.kxo.dtZ())) {
                sZ(true);
                this.kqm = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kxp.aZ(postWriteCallBackData.getSensitiveWords());
            this.kxp.Py(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.kxp.dtZ())) {
                ta(true);
            }
        }
    }

    public void e(EditText editText) {
        this.kxq = editText;
    }

    public void f(EditText editText) {
        this.iFb = editText;
    }

    public void onDestroy() {
        this.kxq = null;
        this.iFb = null;
    }

    public void onChangeSkinType() {
        this.kxo.onChangeSkinType();
        this.kxp.onChangeSkinType();
        if (this.kxo.dub()) {
            sZ(false);
        }
        if (this.kxp.dub()) {
            ta(false);
        }
    }

    public com.baidu.tieba.write.c cQO() {
        return this.kxo;
    }

    public com.baidu.tieba.write.c cQP() {
        return this.kxp;
    }

    public EditText cQQ() {
        return this.iFb;
    }

    public PostWriteCallBackData cQR() {
        return this.kqm;
    }
}
