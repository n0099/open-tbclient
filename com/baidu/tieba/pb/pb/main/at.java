package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class at {
    private PostWriteCallBackData eXF;
    private com.baidu.tieba.write.b feH = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b feI;
    private EditText feJ;
    private EditText feK;

    public at() {
        this.feH.vM(d.C0095d.cp_cont_i);
        this.feH.vN(d.C0095d.cp_cont_h_alpha85);
        this.feI = new com.baidu.tieba.write.b();
        this.feI.vM(d.C0095d.cp_cont_i);
        this.feI.vN(d.C0095d.cp_cont_h_alpha85);
    }

    public void ka(boolean z) {
        if (this.feJ != null && this.feJ.getText() != null) {
            int selectionEnd = this.feJ.getSelectionEnd();
            SpannableStringBuilder b = this.feH.b(this.feJ.getText());
            if (b != null) {
                this.feH.nU(true);
                this.feJ.setText(b);
                if (z && this.feH.bFF() >= 0) {
                    this.feJ.requestFocus();
                    this.feJ.setSelection(this.feH.bFF());
                } else {
                    this.feJ.setSelection(selectionEnd);
                }
                this.feH.nT(this.feH.bFF() >= 0);
            }
        }
    }

    public void kb(boolean z) {
        if (this.feK != null && this.feK.getText() != null) {
            int selectionEnd = this.feK.getSelectionEnd();
            SpannableStringBuilder b = this.feI.b(this.feK.getText());
            if (b != null) {
                this.feI.nU(true);
                this.feK.setText(b);
                if (z && this.feI.bFF() >= 0) {
                    this.feK.requestFocus();
                    this.feK.setSelection(this.feI.bFF());
                } else {
                    this.feK.setSelection(selectionEnd);
                }
                this.feI.nT(this.feI.bFF() >= 0);
            }
        }
    }

    public void aWU() {
        this.feI.uB(null);
        this.feI.aC(null);
        this.feI.nT(false);
    }

    public void aWV() {
        this.feH.uB(null);
        this.feH.aC(null);
        this.feH.nT(false);
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.feH.aC(postWriteCallBackData.getSensitiveWords());
            this.feH.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.feH.bFE())) {
                ka(true);
                this.eXF = postWriteCallBackData;
            }
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.feI.aC(postWriteCallBackData.getSensitiveWords());
            this.feI.uB(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.w(this.feI.bFE())) {
                kb(true);
            }
        }
    }

    public void g(EditText editText) {
        this.feJ = editText;
    }

    public void h(EditText editText) {
        this.feK = editText;
    }

    public void onDestroy() {
        this.feJ = null;
        this.feK = null;
    }

    public void onChangeSkinType() {
        this.feH.onChangeSkinType();
        this.feI.onChangeSkinType();
        if (this.feH.bFG()) {
            ka(false);
        }
        if (this.feI.bFG()) {
            kb(false);
        }
    }

    public com.baidu.tieba.write.b aWW() {
        return this.feH;
    }

    public com.baidu.tieba.write.b aWX() {
        return this.feI;
    }

    public EditText aWY() {
        return this.feK;
    }

    public PostWriteCallBackData aWZ() {
        return this.eXF;
    }
}
