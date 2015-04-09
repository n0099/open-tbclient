package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
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
        this.bzT.bzz = charSequence.toString();
        str = this.bzT.bzz;
        if (str.trim().length() > 0) {
            i6 = this.bzT.mMode;
            if (i6 != 0) {
                i7 = this.bzT.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.bzT;
                    str2 = this.bzT.bzz;
                    squareSearchActivity.y(1, str2);
                    this.bzT.WV();
                    return;
                }
                return;
            }
            this.bzT.Xa();
            return;
        }
        this.bzT.EO();
        i4 = this.bzT.mMode;
        if (i4 != 0) {
            i5 = this.bzT.mMode;
            if (i5 != 3) {
                this.bzT.WY();
                return;
            } else {
                this.bzT.WZ();
                return;
            }
        }
        z = this.bzT.bzE;
        if (!z) {
            return;
        }
        this.bzT.WX();
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
            textView3 = this.bzT.bzf;
            textView3.setVisibility(8);
        } else {
            textView = this.bzT.bzf;
            textView.setVisibility(0);
        }
        textView2 = this.bzT.bzg;
        ba.b(textView2, com.baidu.tieba.s.cp_cont_i, 1);
    }
}
