package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class ax {
    private EditText ihd;
    private PostWriteCallBackData jMA;
    private com.baidu.tieba.write.c jTs = new com.baidu.tieba.write.c();
    private com.baidu.tieba.write.c jTt;
    private EditText jTu;

    public ax() {
        this.jTs.Ft(R.color.cp_cont_a);
        this.jTs.Fu(R.color.cp_cont_h_alpha85);
        this.jTt = new com.baidu.tieba.write.c();
        this.jTt.Ft(R.color.cp_cont_a);
        this.jTt.Fu(R.color.cp_cont_h_alpha85);
    }

    public void sf(boolean z) {
        if (this.jTu != null && this.jTu.getText() != null) {
            int selectionEnd = this.jTu.getSelectionEnd();
            SpannableStringBuilder a = this.jTs.a(this.jTu.getText());
            if (a != null) {
                this.jTs.vm(true);
                this.jTu.setText(a);
                if (z && this.jTs.dmh() >= 0) {
                    this.jTu.requestFocus();
                    this.jTu.setSelection(this.jTs.dmh());
                } else {
                    this.jTu.setSelection(selectionEnd);
                }
                this.jTs.vl(this.jTs.dmh() >= 0);
            }
        }
    }

    public void sg(boolean z) {
        if (this.ihd != null && this.ihd.getText() != null) {
            int selectionEnd = this.ihd.getSelectionEnd();
            SpannableStringBuilder a = this.jTt.a(this.ihd.getText());
            if (a != null) {
                this.jTt.vm(true);
                this.ihd.setText(a);
                if (z && this.jTt.dmh() >= 0) {
                    this.ihd.requestFocus();
                    this.ihd.setSelection(this.jTt.dmh());
                } else {
                    this.ihd.setSelection(selectionEnd);
                }
                this.jTt.vl(this.jTt.dmh() >= 0);
            }
        }
    }

    public void cIr() {
        this.jTt.Of(null);
        this.jTt.aX(null);
        this.jTt.vl(false);
    }

    public void cIs() {
        this.jTs.Of(null);
        this.jTs.aX(null);
        this.jTs.vl(false);
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jTs.aX(postWriteCallBackData.getSensitiveWords());
            this.jTs.Of(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jTs.dmg())) {
                sf(true);
                this.jMA = postWriteCallBackData;
            }
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jTt.aX(postWriteCallBackData.getSensitiveWords());
            this.jTt.Of(postWriteCallBackData.getErrorString());
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.jTt.dmg())) {
                sg(true);
            }
        }
    }

    public void d(EditText editText) {
        this.jTu = editText;
    }

    public void e(EditText editText) {
        this.ihd = editText;
    }

    public void onDestroy() {
        this.jTu = null;
        this.ihd = null;
    }

    public void onChangeSkinType() {
        this.jTs.onChangeSkinType();
        this.jTt.onChangeSkinType();
        if (this.jTs.dmi()) {
            sf(false);
        }
        if (this.jTt.dmi()) {
            sg(false);
        }
    }

    public com.baidu.tieba.write.c cIt() {
        return this.jTs;
    }

    public com.baidu.tieba.write.c cIu() {
        return this.jTt;
    }

    public EditText cIv() {
        return this.ihd;
    }

    public PostWriteCallBackData cIw() {
        return this.jMA;
    }
}
