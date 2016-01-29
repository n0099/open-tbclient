package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements TextWatcher {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.cwZ.cws = charSequence.toString();
        if (this.cwZ.cws.trim().length() > 0) {
            if (this.cwZ.mMode != 0) {
                if (this.cwZ.mMode != 1) {
                    return;
                }
                this.cwZ.K(1, this.cwZ.cws);
                return;
            }
            this.cwZ.akA();
            return;
        }
        this.cwZ.akn();
        if (this.cwZ.mMode != 0) {
            if (this.cwZ.mMode != 3) {
                this.cwZ.akx();
                return;
            } else {
                this.cwZ.aky();
                return;
            }
        }
        z = this.cwZ.cwy;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.cwZ.akw();
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
            textView3 = this.cwZ.cvY;
            textView3.setVisibility(8);
        } else {
            textView = this.cwZ.cvY;
            textView.setVisibility(0);
        }
        textView2 = this.cwZ.cvZ;
        com.baidu.tbadk.core.util.ar.b(textView2, t.d.cp_cont_i, 1);
    }
}
