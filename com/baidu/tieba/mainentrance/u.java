package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
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
        this.bCF.bCg = charSequence.toString();
        str = this.bCF.bCg;
        if (str.trim().length() > 0) {
            i6 = this.bCF.mMode;
            if (i6 != 0) {
                i7 = this.bCF.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.bCF;
                    str2 = this.bCF.bCg;
                    squareSearchActivity.z(1, str2);
                    return;
                }
                return;
            }
            this.bCF.Yu();
            return;
        }
        this.bCF.FH();
        i4 = this.bCF.mMode;
        if (i4 != 0) {
            i5 = this.bCF.mMode;
            if (i5 != 3) {
                this.bCF.Yr();
                return;
            } else {
                this.bCF.Ys();
                return;
            }
        }
        z = this.bCF.bCm;
        if (!z) {
            return;
        }
        this.bCF.Yq();
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
            textView3 = this.bCF.bBO;
            textView3.setVisibility(8);
        } else {
            textView = this.bCF.bBO;
            textView.setVisibility(0);
        }
        textView2 = this.bCF.bBP;
        ay.b(textView2, com.baidu.tieba.n.cp_cont_i, 1);
    }
}
