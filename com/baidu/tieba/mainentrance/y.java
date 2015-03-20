package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        String str2;
        this.bzG.bzm = charSequence.toString();
        str = this.bzG.bzm;
        if (str.trim().length() > 0) {
            i6 = this.bzG.mMode;
            if (i6 != 0) {
                i7 = this.bzG.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.bzG;
                    str2 = this.bzG.bzm;
                    squareSearchActivity.y(1, str2);
                    return;
                }
                return;
            }
            this.bzG.WP();
            return;
        }
        this.bzG.EI();
        i4 = this.bzG.mMode;
        if (i4 != 0) {
            i5 = this.bzG.mMode;
            if (i5 != 3) {
                this.bzG.WN();
                return;
            } else {
                this.bzG.WO();
                return;
            }
        }
        z = this.bzG.bzr;
        if (!z) {
            return;
        }
        this.bzG.WM();
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
            textView3 = this.bzG.byT;
            textView3.setVisibility(8);
        } else {
            textView = this.bzG.byT;
            textView.setVisibility(0);
        }
        textView2 = this.bzG.byU;
        ba.b(textView2, com.baidu.tieba.s.cp_cont_i, 1);
    }
}
