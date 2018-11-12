package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class at {
    private PostWriteCallBackData fQQ;
    private com.baidu.tieba.write.b fXW = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b fXX;
    private EditText fXY;
    private EditText fXZ;

    public at() {
        this.fXW.wy(e.d.cp_cont_i);
        this.fXW.wz(e.d.cp_cont_h_alpha85);
        this.fXX = new com.baidu.tieba.write.b();
        this.fXX.wy(e.d.cp_cont_i);
        this.fXX.wz(e.d.cp_cont_h_alpha85);
    }

    public void lu(boolean z) {
        if (this.fXY != null && this.fXY.getText() != null) {
            int selectionEnd = this.fXY.getSelectionEnd();
            SpannableStringBuilder b = this.fXW.b(this.fXY.getText());
            if (b != null) {
                this.fXW.op(true);
                this.fXY.setText(b);
                if (z && this.fXW.bKQ() >= 0) {
                    this.fXY.requestFocus();
                    this.fXY.setSelection(this.fXW.bKQ());
                } else {
                    this.fXY.setSelection(selectionEnd);
                }
                this.fXW.oo(this.fXW.bKQ() >= 0);
            }
        }
    }

    public void lv(boolean z) {
        if (this.fXZ != null && this.fXZ.getText() != null) {
            int selectionEnd = this.fXZ.getSelectionEnd();
            SpannableStringBuilder b = this.fXX.b(this.fXZ.getText());
            if (b != null) {
                this.fXX.op(true);
                this.fXZ.setText(b);
                if (z && this.fXX.bKQ() >= 0) {
                    this.fXZ.requestFocus();
                    this.fXZ.setSelection(this.fXX.bKQ());
                } else {
                    this.fXZ.setSelection(selectionEnd);
                }
                this.fXX.oo(this.fXX.bKQ() >= 0);
            }
        }
    }

    public void bjS() {
        this.fXX.wO(null);
        this.fXX.az(null);
        this.fXX.oo(false);
    }

    public void bjT() {
        this.fXW.wO(null);
        this.fXW.az(null);
        this.fXW.oo(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fXW.az(postWriteCallBackData.getSensitiveWords());
            this.fXW.wO(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.fXW.bKP())) {
                lu(true);
                this.fQQ = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fXX.az(postWriteCallBackData.getSensitiveWords());
            this.fXX.wO(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.I(this.fXX.bKP())) {
                lv(true);
            }
        }
    }

    public void g(EditText editText) {
        this.fXY = editText;
    }

    public void h(EditText editText) {
        this.fXZ = editText;
    }

    public void onDestroy() {
        this.fXY = null;
        this.fXZ = null;
    }

    public void onChangeSkinType() {
        this.fXW.onChangeSkinType();
        this.fXX.onChangeSkinType();
        if (this.fXW.bKR()) {
            lu(false);
        }
        if (this.fXX.bKR()) {
            lv(false);
        }
    }

    public com.baidu.tieba.write.b bjU() {
        return this.fXW;
    }

    public com.baidu.tieba.write.b bjV() {
        return this.fXX;
    }

    public EditText bjW() {
        return this.fXZ;
    }

    public PostWriteCallBackData bjX() {
        return this.fQQ;
    }
}
