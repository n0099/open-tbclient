package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.bVC.bUV = charSequence.toString();
        if (this.bVC.bUV.trim().length() > 0) {
            if (this.bVC.mMode != 0) {
                if (this.bVC.mMode != 1) {
                    return;
                }
                this.bVC.G(1, this.bVC.bUV);
                return;
            }
            this.bVC.abt();
            return;
        }
        this.bVC.abf();
        if (this.bVC.mMode != 0) {
            if (this.bVC.mMode != 3) {
                this.bVC.abq();
                return;
            } else {
                this.bVC.abr();
                return;
            }
        }
        z = this.bVC.bVb;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.bVC.abp();
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
            textView3 = this.bVC.bUB;
            textView3.setVisibility(8);
        } else {
            textView = this.bVC.bUB;
            textView.setVisibility(0);
        }
        textView2 = this.bVC.bUC;
        com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_cont_i, 1);
    }
}
