package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class at {
    private PostWriteCallBackData gay;
    private com.baidu.tieba.write.b ghF = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b ghG;
    private EditText ghH;
    private EditText ghI;

    public at() {
        this.ghF.xi(e.d.cp_cont_i);
        this.ghF.xj(e.d.cp_cont_h_alpha85);
        this.ghG = new com.baidu.tieba.write.b();
        this.ghG.xi(e.d.cp_cont_i);
        this.ghG.xj(e.d.cp_cont_h_alpha85);
    }

    public void lA(boolean z) {
        if (this.ghH != null && this.ghH.getText() != null) {
            int selectionEnd = this.ghH.getSelectionEnd();
            SpannableStringBuilder b = this.ghF.b(this.ghH.getText());
            if (b != null) {
                this.ghF.ou(true);
                this.ghH.setText(b);
                if (z && this.ghF.bNM() >= 0) {
                    this.ghH.requestFocus();
                    this.ghH.setSelection(this.ghF.bNM());
                } else {
                    this.ghH.setSelection(selectionEnd);
                }
                this.ghF.ot(this.ghF.bNM() >= 0);
            }
        }
    }

    public void lB(boolean z) {
        if (this.ghI != null && this.ghI.getText() != null) {
            int selectionEnd = this.ghI.getSelectionEnd();
            SpannableStringBuilder b = this.ghG.b(this.ghI.getText());
            if (b != null) {
                this.ghG.ou(true);
                this.ghI.setText(b);
                if (z && this.ghG.bNM() >= 0) {
                    this.ghI.requestFocus();
                    this.ghI.setSelection(this.ghG.bNM());
                } else {
                    this.ghI.setSelection(selectionEnd);
                }
                this.ghG.ot(this.ghG.bNM() >= 0);
            }
        }
    }

    public void bmw() {
        this.ghG.xu(null);
        this.ghG.aA(null);
        this.ghG.ot(false);
    }

    public void bmx() {
        this.ghF.xu(null);
        this.ghF.aA(null);
        this.ghF.ot(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.ghF.aA(postWriteCallBackData.getSensitiveWords());
            this.ghF.xu(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.ghF.bNL())) {
                lA(true);
                this.gay = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.ghG.aA(postWriteCallBackData.getSensitiveWords());
            this.ghG.xu(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.ghG.bNL())) {
                lB(true);
            }
        }
    }

    public void g(EditText editText) {
        this.ghH = editText;
    }

    public void h(EditText editText) {
        this.ghI = editText;
    }

    public void onDestroy() {
        this.ghH = null;
        this.ghI = null;
    }

    public void onChangeSkinType() {
        this.ghF.onChangeSkinType();
        this.ghG.onChangeSkinType();
        if (this.ghF.bNN()) {
            lA(false);
        }
        if (this.ghG.bNN()) {
            lB(false);
        }
    }

    public com.baidu.tieba.write.b bmy() {
        return this.ghF;
    }

    public com.baidu.tieba.write.b bmz() {
        return this.ghG;
    }

    public EditText bmA() {
        return this.ghI;
    }

    public PostWriteCallBackData bmB() {
        return this.gay;
    }
}
