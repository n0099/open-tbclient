package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText gmu;
    private PostWriteCallBackData hPi;
    private com.baidu.tieba.write.b hWu = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hWv;
    private EditText hWw;

    public as() {
        this.hWu.CI(R.color.cp_btn_a);
        this.hWu.CJ(R.color.cp_cont_h_alpha85);
        this.hWv = new com.baidu.tieba.write.b();
        this.hWv.CI(R.color.cp_btn_a);
        this.hWv.CJ(R.color.cp_cont_h_alpha85);
    }

    public void pd(boolean z) {
        if (this.hWw != null && this.hWw.getText() != null) {
            int selectionEnd = this.hWw.getSelectionEnd();
            SpannableStringBuilder b = this.hWu.b(this.hWw.getText());
            if (b != null) {
                this.hWu.sa(true);
                this.hWw.setText(b);
                if (z && this.hWu.czf() >= 0) {
                    this.hWw.requestFocus();
                    this.hWw.setSelection(this.hWu.czf());
                } else {
                    this.hWw.setSelection(selectionEnd);
                }
                this.hWu.rZ(this.hWu.czf() >= 0);
            }
        }
    }

    public void pe(boolean z) {
        if (this.gmu != null && this.gmu.getText() != null) {
            int selectionEnd = this.gmu.getSelectionEnd();
            SpannableStringBuilder b = this.hWv.b(this.gmu.getText());
            if (b != null) {
                this.hWv.sa(true);
                this.gmu.setText(b);
                if (z && this.hWv.czf() >= 0) {
                    this.gmu.requestFocus();
                    this.gmu.setSelection(this.hWv.czf());
                } else {
                    this.gmu.setSelection(selectionEnd);
                }
                this.hWv.rZ(this.hWv.czf() >= 0);
            }
        }
    }

    public void bYf() {
        this.hWv.GA(null);
        this.hWv.aI(null);
        this.hWv.rZ(false);
    }

    public void bYg() {
        this.hWu.GA(null);
        this.hWu.aI(null);
        this.hWu.rZ(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hWu.aI(postWriteCallBackData.getSensitiveWords());
            this.hWu.GA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hWu.cze())) {
                pd(true);
                this.hPi = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hWv.aI(postWriteCallBackData.getSensitiveWords());
            this.hWv.GA(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hWv.cze())) {
                pe(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hWw = editText;
    }

    public void l(EditText editText) {
        this.gmu = editText;
    }

    public void onDestroy() {
        this.hWw = null;
        this.gmu = null;
    }

    public void onChangeSkinType() {
        this.hWu.onChangeSkinType();
        this.hWv.onChangeSkinType();
        if (this.hWu.czg()) {
            pd(false);
        }
        if (this.hWv.czg()) {
            pe(false);
        }
    }

    public com.baidu.tieba.write.b bYh() {
        return this.hWu;
    }

    public com.baidu.tieba.write.b bYi() {
        return this.hWv;
    }

    public EditText bYj() {
        return this.gmu;
    }

    public PostWriteCallBackData bYk() {
        return this.hPi;
    }
}
