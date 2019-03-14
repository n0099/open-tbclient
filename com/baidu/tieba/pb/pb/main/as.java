package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText fPj;
    private PostWriteCallBackData hrz;
    private com.baidu.tieba.write.b hyG = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hyH;
    private EditText hyI;

    public as() {
        this.hyG.AW(d.C0277d.cp_btn_a);
        this.hyG.AX(d.C0277d.cp_cont_h_alpha85);
        this.hyH = new com.baidu.tieba.write.b();
        this.hyH.AW(d.C0277d.cp_btn_a);
        this.hyH.AX(d.C0277d.cp_cont_h_alpha85);
    }

    public void nZ(boolean z) {
        if (this.hyI != null && this.hyI.getText() != null) {
            int selectionEnd = this.hyI.getSelectionEnd();
            SpannableStringBuilder b = this.hyG.b(this.hyI.getText());
            if (b != null) {
                this.hyG.qV(true);
                this.hyI.setText(b);
                if (z && this.hyG.cnZ() >= 0) {
                    this.hyI.requestFocus();
                    this.hyI.setSelection(this.hyG.cnZ());
                } else {
                    this.hyI.setSelection(selectionEnd);
                }
                this.hyG.qU(this.hyG.cnZ() >= 0);
            }
        }
    }

    public void oa(boolean z) {
        if (this.fPj != null && this.fPj.getText() != null) {
            int selectionEnd = this.fPj.getSelectionEnd();
            SpannableStringBuilder b = this.hyH.b(this.fPj.getText());
            if (b != null) {
                this.hyH.qV(true);
                this.fPj.setText(b);
                if (z && this.hyH.cnZ() >= 0) {
                    this.fPj.requestFocus();
                    this.fPj.setSelection(this.hyH.cnZ());
                } else {
                    this.fPj.setSelection(selectionEnd);
                }
                this.hyH.qU(this.hyH.cnZ() >= 0);
            }
        }
    }

    public void bNx() {
        this.hyH.Ej(null);
        this.hyH.aE(null);
        this.hyH.qU(false);
    }

    public void bNy() {
        this.hyG.Ej(null);
        this.hyG.aE(null);
        this.hyG.qU(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyG.aE(postWriteCallBackData.getSensitiveWords());
            this.hyG.Ej(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyG.cnY())) {
                nZ(true);
                this.hrz = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hyH.aE(postWriteCallBackData.getSensitiveWords());
            this.hyH.Ej(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.T(this.hyH.cnY())) {
                oa(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hyI = editText;
    }

    public void l(EditText editText) {
        this.fPj = editText;
    }

    public void onDestroy() {
        this.hyI = null;
        this.fPj = null;
    }

    public void onChangeSkinType() {
        this.hyG.onChangeSkinType();
        this.hyH.onChangeSkinType();
        if (this.hyG.coa()) {
            nZ(false);
        }
        if (this.hyH.coa()) {
            oa(false);
        }
    }

    public com.baidu.tieba.write.b bNz() {
        return this.hyG;
    }

    public com.baidu.tieba.write.b bNA() {
        return this.hyH;
    }

    public EditText bNB() {
        return this.fPj;
    }

    public PostWriteCallBackData bNC() {
        return this.hrz;
    }
}
