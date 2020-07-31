package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes16.dex */
public class bb {
    private EditText iEZ;
    private PostWriteCallBackData kqk;
    private com.baidu.tieba.write.c kxm = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c kxn;
    private EditText kxo;

    public bb() {
        this.kxm.GV(R.color.cp_cont_a);
        this.kxm.GW(R.color.cp_cont_h_alpha85);
        this.kxn = new com.baidu.tieba.write.c();
        this.kxn.GV(R.color.cp_cont_a);
        this.kxn.GW(R.color.cp_cont_h_alpha85);
    }

    public void sZ(boolean z) {
        if (this.kxo != null && this.kxo.getText() != null) {
            int selectionEnd = this.kxo.getSelectionEnd();
            SpannableStringBuilder d = this.kxm.d(this.kxo.getText());
            if (d != null) {
                this.kxm.wj(true);
                this.kxo.setText(d);
                if (z && this.kxm.dtZ() >= 0) {
                    this.kxo.requestFocus();
                    this.kxo.setSelection(this.kxm.dtZ());
                } else {
                    this.kxo.setSelection(selectionEnd);
                }
                this.kxm.wi(this.kxm.dtZ() >= 0);
            }
        }
    }

    public void ta(boolean z) {
        if (this.iEZ != null && this.iEZ.getText() != null) {
            int selectionEnd = this.iEZ.getSelectionEnd();
            SpannableStringBuilder d = this.kxn.d(this.iEZ.getText());
            if (d != null) {
                this.kxn.wj(true);
                this.iEZ.setText(d);
                if (z && this.kxn.dtZ() >= 0) {
                    this.iEZ.requestFocus();
                    this.iEZ.setSelection(this.kxn.dtZ());
                } else {
                    this.iEZ.setSelection(selectionEnd);
                }
                this.kxn.wi(this.kxn.dtZ() >= 0);
            }
        }
    }

    public void cQM() {
        this.kxn.Py(null);
        this.kxn.aZ(null);
        this.kxn.wi(false);
    }

    public void cQN() {
        this.kxm.Py(null);
        this.kxm.aZ(null);
        this.kxm.wi(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kxm.aZ(postWriteCallBackData.getSensitiveWords());
            this.kxm.Py(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.kxm.dtY())) {
                sZ(true);
                this.kqk = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kxn.aZ(postWriteCallBackData.getSensitiveWords());
            this.kxn.Py(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.kxn.dtY())) {
                ta(true);
            }
        }
    }

    public void e(EditText editText) {
        this.kxo = editText;
    }

    public void f(EditText editText) {
        this.iEZ = editText;
    }

    public void onDestroy() {
        this.kxo = null;
        this.iEZ = null;
    }

    public void onChangeSkinType() {
        this.kxm.onChangeSkinType();
        this.kxn.onChangeSkinType();
        if (this.kxm.dua()) {
            sZ(false);
        }
        if (this.kxn.dua()) {
            ta(false);
        }
    }

    public com.baidu.tieba.write.c cQO() {
        return this.kxm;
    }

    public com.baidu.tieba.write.c cQP() {
        return this.kxn;
    }

    public EditText cQQ() {
        return this.iEZ;
    }

    public PostWriteCallBackData cQR() {
        return this.kqk;
    }
}
