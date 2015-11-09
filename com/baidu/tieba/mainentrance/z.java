package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.bWd.bVw = charSequence.toString();
        if (this.bWd.bVw.trim().length() > 0) {
            if (this.bWd.mMode != 0) {
                if (this.bWd.mMode != 1) {
                    return;
                }
                this.bWd.H(1, this.bWd.bVw);
                return;
            }
            this.bWd.abK();
            return;
        }
        this.bWd.abw();
        if (this.bWd.mMode != 0) {
            if (this.bWd.mMode != 3) {
                this.bWd.abH();
                return;
            } else {
                this.bWd.abI();
                return;
            }
        }
        z = this.bWd.bVC;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.bWd.abG();
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
            textView3 = this.bWd.bVc;
            textView3.setVisibility(8);
        } else {
            textView = this.bWd.bVc;
            textView.setVisibility(0);
        }
        textView2 = this.bWd.bVd;
        com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_cont_i, 1);
    }
}
