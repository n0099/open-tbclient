package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.cqu.cpN = charSequence.toString();
        if (this.cqu.cpN.trim().length() > 0) {
            if (this.cqu.mMode != 0) {
                if (this.cqu.mMode != 1) {
                    return;
                }
                this.cqu.I(1, this.cqu.cpN);
                return;
            }
            this.cqu.agz();
            return;
        }
        this.cqu.agl();
        if (this.cqu.mMode != 0) {
            if (this.cqu.mMode != 3) {
                this.cqu.agw();
                return;
            } else {
                this.cqu.agx();
                return;
            }
        }
        z = this.cqu.cpT;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.cqu.agv();
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
            textView3 = this.cqu.cps;
            textView3.setVisibility(8);
        } else {
            textView = this.cqu.cps;
            textView.setVisibility(0);
        }
        textView2 = this.cqu.cpt;
        com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_cont_i, 1);
    }
}
