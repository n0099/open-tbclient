package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ax {
    private EditText iyV;
    private PostWriteCallBackData khu;
    private com.baidu.tieba.write.c koo = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c kop;
    private EditText koq;

    public ax() {
        this.koo.Gz(R.color.cp_cont_a);
        this.koo.GA(R.color.cp_cont_h_alpha85);
        this.kop = new com.baidu.tieba.write.c();
        this.kop.Gz(R.color.cp_cont_a);
        this.kop.GA(R.color.cp_cont_h_alpha85);
    }

    public void st(boolean z) {
        if (this.koq != null && this.koq.getText() != null) {
            int selectionEnd = this.koq.getSelectionEnd();
            SpannableStringBuilder d = this.koo.d(this.koq.getText());
            if (d != null) {
                this.koo.vF(true);
                this.koq.setText(d);
                if (z && this.koo.dqN() >= 0) {
                    this.koq.requestFocus();
                    this.koq.setSelection(this.koo.dqN());
                } else {
                    this.koq.setSelection(selectionEnd);
                }
                this.koo.vE(this.koo.dqN() >= 0);
            }
        }
    }

    public void su(boolean z) {
        if (this.iyV != null && this.iyV.getText() != null) {
            int selectionEnd = this.iyV.getSelectionEnd();
            SpannableStringBuilder d = this.kop.d(this.iyV.getText());
            if (d != null) {
                this.kop.vF(true);
                this.iyV.setText(d);
                if (z && this.kop.dqN() >= 0) {
                    this.iyV.requestFocus();
                    this.iyV.setSelection(this.kop.dqN());
                } else {
                    this.iyV.setSelection(selectionEnd);
                }
                this.kop.vE(this.kop.dqN() >= 0);
            }
        }
    }

    public void cMZ() {
        this.kop.ON(null);
        this.kop.aY(null);
        this.kop.vE(false);
    }

    public void cNa() {
        this.koo.ON(null);
        this.koo.aY(null);
        this.koo.vE(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.koo.aY(postWriteCallBackData.getSensitiveWords());
            this.koo.ON(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.koo.dqM())) {
                st(true);
                this.khu = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kop.aY(postWriteCallBackData.getSensitiveWords());
            this.kop.ON(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.kop.dqM())) {
                su(true);
            }
        }
    }

    public void e(EditText editText) {
        this.koq = editText;
    }

    public void f(EditText editText) {
        this.iyV = editText;
    }

    public void onDestroy() {
        this.koq = null;
        this.iyV = null;
    }

    public void onChangeSkinType() {
        this.koo.onChangeSkinType();
        this.kop.onChangeSkinType();
        if (this.koo.dqO()) {
            st(false);
        }
        if (this.kop.dqO()) {
            su(false);
        }
    }

    public com.baidu.tieba.write.c cNb() {
        return this.koo;
    }

    public com.baidu.tieba.write.c cNc() {
        return this.kop;
    }

    public EditText cNd() {
        return this.iyV;
    }

    public PostWriteCallBackData cNe() {
        return this.khu;
    }
}
