package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
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
        this.bCE.bCf = charSequence.toString();
        str = this.bCE.bCf;
        if (str.trim().length() > 0) {
            i6 = this.bCE.mMode;
            if (i6 != 0) {
                i7 = this.bCE.mMode;
                if (i7 == 1) {
                    SquareSearchActivity squareSearchActivity = this.bCE;
                    str2 = this.bCE.bCf;
                    squareSearchActivity.z(1, str2);
                    return;
                }
                return;
            }
            this.bCE.Yt();
            return;
        }
        this.bCE.FG();
        i4 = this.bCE.mMode;
        if (i4 != 0) {
            i5 = this.bCE.mMode;
            if (i5 != 3) {
                this.bCE.Yq();
                return;
            } else {
                this.bCE.Yr();
                return;
            }
        }
        z = this.bCE.bCl;
        if (!z) {
            return;
        }
        this.bCE.Yp();
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
            textView3 = this.bCE.bBN;
            textView3.setVisibility(8);
        } else {
            textView = this.bCE.bBN;
            textView.setVisibility(0);
        }
        textView2 = this.bCE.bBO;
        ay.b(textView2, com.baidu.tieba.n.cp_cont_i, 1);
    }
}
