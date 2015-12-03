package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.cmr.clJ = charSequence.toString();
        if (this.cmr.clJ.trim().length() > 0) {
            if (this.cmr.mMode != 0) {
                if (this.cmr.mMode != 1) {
                    return;
                }
                this.cmr.I(1, this.cmr.clJ);
                return;
            }
            this.cmr.afq();
            return;
        }
        this.cmr.afc();
        if (this.cmr.mMode != 0) {
            if (this.cmr.mMode != 3) {
                this.cmr.afn();
                return;
            } else {
                this.cmr.afo();
                return;
            }
        }
        z = this.cmr.clP;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.cmr.afm();
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
            textView3 = this.cmr.clo;
            textView3.setVisibility(8);
        } else {
            textView = this.cmr.clo;
            textView.setVisibility(0);
        }
        textView2 = this.cmr.clp;
        com.baidu.tbadk.core.util.as.b(textView2, n.c.cp_cont_i, 1);
    }
}
