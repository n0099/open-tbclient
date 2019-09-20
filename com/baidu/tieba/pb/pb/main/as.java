package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class as {
    private EditText gpd;
    private PostWriteCallBackData hSa;
    private com.baidu.tieba.write.b hZn = new com.baidu.tieba.write.b();
    private com.baidu.tieba.write.b hZo;
    private EditText hZp;

    public as() {
        this.hZn.CO(R.color.cp_cont_a);
        this.hZn.CP(R.color.cp_cont_h_alpha85);
        this.hZo = new com.baidu.tieba.write.b();
        this.hZo.CO(R.color.cp_cont_a);
        this.hZo.CP(R.color.cp_cont_h_alpha85);
    }

    public void ph(boolean z) {
        if (this.hZp != null && this.hZp.getText() != null) {
            int selectionEnd = this.hZp.getSelectionEnd();
            SpannableStringBuilder b = this.hZn.b(this.hZp.getText());
            if (b != null) {
                this.hZn.se(true);
                this.hZp.setText(b);
                if (z && this.hZn.cAo() >= 0) {
                    this.hZp.requestFocus();
                    this.hZp.setSelection(this.hZn.cAo());
                } else {
                    this.hZp.setSelection(selectionEnd);
                }
                this.hZn.sd(this.hZn.cAo() >= 0);
            }
        }
    }

    public void pi(boolean z) {
        if (this.gpd != null && this.gpd.getText() != null) {
            int selectionEnd = this.gpd.getSelectionEnd();
            SpannableStringBuilder b = this.hZo.b(this.gpd.getText());
            if (b != null) {
                this.hZo.se(true);
                this.gpd.setText(b);
                if (z && this.hZo.cAo() >= 0) {
                    this.gpd.requestFocus();
                    this.gpd.setSelection(this.hZo.cAo());
                } else {
                    this.gpd.setSelection(selectionEnd);
                }
                this.hZo.sd(this.hZo.cAo() >= 0);
            }
        }
    }

    public void bZj() {
        this.hZo.Hb(null);
        this.hZo.aI(null);
        this.hZo.sd(false);
    }

    public void bZk() {
        this.hZn.Hb(null);
        this.hZn.aI(null);
        this.hZn.sd(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hZn.aI(postWriteCallBackData.getSensitiveWords());
            this.hZn.Hb(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hZn.cAn())) {
                ph(true);
                this.hSa = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hZo.aI(postWriteCallBackData.getSensitiveWords());
            this.hZo.Hb(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.aa(this.hZo.cAn())) {
                pi(true);
            }
        }
    }

    public void k(EditText editText) {
        this.hZp = editText;
    }

    public void l(EditText editText) {
        this.gpd = editText;
    }

    public void onDestroy() {
        this.hZp = null;
        this.gpd = null;
    }

    public void onChangeSkinType() {
        this.hZn.onChangeSkinType();
        this.hZo.onChangeSkinType();
        if (this.hZn.cAp()) {
            ph(false);
        }
        if (this.hZo.cAp()) {
            pi(false);
        }
    }

    public com.baidu.tieba.write.b bZl() {
        return this.hZn;
    }

    public com.baidu.tieba.write.b bZm() {
        return this.hZo;
    }

    public EditText bZn() {
        return this.gpd;
    }

    public PostWriteCallBackData bZo() {
        return this.hSa;
    }
}
