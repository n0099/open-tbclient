package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.bQZ.bQt = charSequence.toString();
        if (this.bQZ.bQt.trim().length() > 0) {
            if (this.bQZ.mMode != 0) {
                if (this.bQZ.mMode != 1) {
                    return;
                }
                this.bQZ.G(1, this.bQZ.bQt);
                return;
            }
            this.bQZ.aaa();
            return;
        }
        this.bQZ.Gt();
        if (this.bQZ.mMode != 0) {
            if (this.bQZ.mMode != 3) {
                this.bQZ.ZX();
                return;
            } else {
                this.bQZ.ZY();
                return;
            }
        }
        z = this.bQZ.bQz;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.bQZ.ZW();
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
            textView3 = this.bQZ.bQc;
            textView3.setVisibility(8);
        } else {
            textView = this.bQZ.bQc;
            textView.setVisibility(0);
        }
        textView2 = this.bQZ.bQd;
        com.baidu.tbadk.core.util.al.b(textView2, i.c.cp_cont_i, 1);
    }
}
