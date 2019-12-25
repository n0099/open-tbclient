package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class as {
    private EditText hbm;
    private PostWriteCallBackData iEv;
    private com.baidu.tieba.write.c iKV = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c iKW;
    private EditText iKX;

    public as() {
        this.iKV.DO(R.color.cp_cont_a);
        this.iKV.DP(R.color.cp_cont_h_alpha85);
        this.iKW = new com.baidu.tieba.write.c();
        this.iKW.DO(R.color.cp_cont_a);
        this.iKW.DP(R.color.cp_cont_h_alpha85);
    }

    public void qh(boolean z) {
        if (this.iKX != null && this.iKX.getText() != null) {
            int selectionEnd = this.iKX.getSelectionEnd();
            SpannableStringBuilder a = this.iKV.a(this.iKX.getText());
            if (a != null) {
                this.iKV.tr(true);
                this.iKX.setText(a);
                if (z && this.iKV.cRI() >= 0) {
                    this.iKX.requestFocus();
                    this.iKX.setSelection(this.iKV.cRI());
                } else {
                    this.iKX.setSelection(selectionEnd);
                }
                this.iKV.tq(this.iKV.cRI() >= 0);
            }
        }
    }

    public void qi(boolean z) {
        if (this.hbm != null && this.hbm.getText() != null) {
            int selectionEnd = this.hbm.getSelectionEnd();
            SpannableStringBuilder a = this.iKW.a(this.hbm.getText());
            if (a != null) {
                this.iKW.tr(true);
                this.hbm.setText(a);
                if (z && this.iKW.cRI() >= 0) {
                    this.hbm.requestFocus();
                    this.hbm.setSelection(this.iKW.cRI());
                } else {
                    this.hbm.setSelection(selectionEnd);
                }
                this.iKW.tq(this.iKW.cRI() >= 0);
            }
        }
    }

    public void cnU() {
        this.iKW.Kn(null);
        this.iKW.aV(null);
        this.iKW.tq(false);
    }

    public void cnV() {
        this.iKV.Kn(null);
        this.iKV.aV(null);
        this.iKV.tq(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iKV.aV(postWriteCallBackData.getSensitiveWords());
            this.iKV.Kn(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iKV.cRH())) {
                qh(true);
                this.iEv = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iKW.aV(postWriteCallBackData.getSensitiveWords());
            this.iKW.Kn(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.iKW.cRH())) {
                qi(true);
            }
        }
    }

    public void e(EditText editText) {
        this.iKX = editText;
    }

    public void f(EditText editText) {
        this.hbm = editText;
    }

    public void onDestroy() {
        this.iKX = null;
        this.hbm = null;
    }

    public void onChangeSkinType() {
        this.iKV.onChangeSkinType();
        this.iKW.onChangeSkinType();
        if (this.iKV.cRJ()) {
            qh(false);
        }
        if (this.iKW.cRJ()) {
            qi(false);
        }
    }

    public com.baidu.tieba.write.c cnW() {
        return this.iKV;
    }

    public com.baidu.tieba.write.c cnX() {
        return this.iKW;
    }

    public EditText cnY() {
        return this.hbm;
    }

    public PostWriteCallBackData cnZ() {
        return this.iEv;
    }
}
