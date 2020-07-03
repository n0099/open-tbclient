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
                if (z && this.koo.dqJ() >= 0) {
                    this.koq.requestFocus();
                    this.koq.setSelection(this.koo.dqJ());
                } else {
                    this.koq.setSelection(selectionEnd);
                }
                this.koo.vE(this.koo.dqJ() >= 0);
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
                if (z && this.kop.dqJ() >= 0) {
                    this.iyV.requestFocus();
                    this.iyV.setSelection(this.kop.dqJ());
                } else {
                    this.iyV.setSelection(selectionEnd);
                }
                this.kop.vE(this.kop.dqJ() >= 0);
            }
        }
    }

    public void cMY() {
        this.kop.OM(null);
        this.kop.aY(null);
        this.kop.vE(false);
    }

    public void cMZ() {
        this.koo.OM(null);
        this.koo.aY(null);
        this.koo.vE(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.koo.aY(postWriteCallBackData.getSensitiveWords());
            this.koo.OM(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.koo.dqI())) {
                st(true);
                this.khu = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kop.aY(postWriteCallBackData.getSensitiveWords());
            this.kop.OM(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.kop.dqI())) {
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
        if (this.koo.dqK()) {
            st(false);
        }
        if (this.kop.dqK()) {
            su(false);
        }
    }

    public com.baidu.tieba.write.c cNa() {
        return this.koo;
    }

    public com.baidu.tieba.write.c cNb() {
        return this.kop;
    }

    public EditText cNc() {
        return this.iyV;
    }

    public PostWriteCallBackData cNd() {
        return this.khu;
    }
}
