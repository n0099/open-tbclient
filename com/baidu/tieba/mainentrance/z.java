package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.bVr.bUK = charSequence.toString();
        if (this.bVr.bUK.trim().length() > 0) {
            if (this.bVr.mMode != 0) {
                if (this.bVr.mMode != 1) {
                    return;
                }
                this.bVr.G(1, this.bVr.bUK);
                return;
            }
            this.bVr.abt();
            return;
        }
        this.bVr.abf();
        if (this.bVr.mMode != 0) {
            if (this.bVr.mMode != 3) {
                this.bVr.abq();
                return;
            } else {
                this.bVr.abr();
                return;
            }
        }
        z = this.bVr.bUQ;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.bVr.abp();
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
            textView3 = this.bVr.bUq;
            textView3.setVisibility(8);
        } else {
            textView = this.bVr.bUq;
            textView.setVisibility(0);
        }
        textView2 = this.bVr.bUr;
        com.baidu.tbadk.core.util.am.b(textView2, i.c.cp_cont_i, 1);
    }
}
