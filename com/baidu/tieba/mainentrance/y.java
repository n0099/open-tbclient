package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements TextWatcher {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.cMQ.cMj = charSequence.toString();
        if (this.cMQ.cMj.trim().length() > 0) {
            if (this.cMQ.mMode != 0) {
                if (this.cMQ.mMode != 1) {
                    return;
                }
                this.cMQ.C(1, this.cMQ.cMj);
                return;
            }
            this.cMQ.aoN();
            return;
        }
        this.cMQ.aoA();
        if (this.cMQ.mMode != 0) {
            if (this.cMQ.mMode != 3) {
                this.cMQ.aoK();
                return;
            } else {
                this.cMQ.aoL();
                return;
            }
        }
        z = this.cMQ.cMp;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.cMQ.aoJ();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (editable.toString().trim().length() == 0) {
            textView3 = this.cMQ.cLP;
            textView3.setVisibility(8);
        } else {
            textView = this.cMQ.cLP;
            textView.setVisibility(0);
        }
        textView2 = this.cMQ.cLQ;
        com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_cont_i, 1);
    }
}
