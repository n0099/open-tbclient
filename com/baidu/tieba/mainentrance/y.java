package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements TextWatcher {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.cLU.cLn = charSequence.toString();
        if (this.cLU.cLn.trim().length() > 0) {
            if (this.cLU.mMode != 0) {
                if (this.cLU.mMode != 1) {
                    return;
                }
                this.cLU.D(1, this.cLU.cLn);
                return;
            }
            this.cLU.aoJ();
            return;
        }
        this.cLU.aow();
        if (this.cLU.mMode != 0) {
            if (this.cLU.mMode != 3) {
                this.cLU.aoG();
                return;
            } else {
                this.cLU.aoH();
                return;
            }
        }
        z = this.cLU.cLt;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.cLU.aoF();
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
            textView3 = this.cLU.cKT;
            textView3.setVisibility(8);
        } else {
            textView = this.cLU.cKT;
            textView.setVisibility(0);
        }
        textView2 = this.cLU.cKU;
        com.baidu.tbadk.core.util.at.b(textView2, t.d.cp_cont_i, 1);
    }
}
