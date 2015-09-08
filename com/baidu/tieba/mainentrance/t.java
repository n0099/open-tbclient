package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements TextWatcher {
    final /* synthetic */ SquareSearchActivity bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bRF = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        this.bRF.bQZ = charSequence.toString();
        if (this.bRF.bQZ.trim().length() > 0) {
            if (this.bRF.mMode != 0) {
                if (this.bRF.mMode != 1) {
                    return;
                }
                this.bRF.E(1, this.bRF.bQZ);
                return;
            }
            this.bRF.aaf();
            return;
        }
        this.bRF.ZV();
        if (this.bRF.mMode != 0) {
            if (this.bRF.mMode != 3) {
                this.bRF.aac();
                return;
            } else {
                this.bRF.aad();
                return;
            }
        }
        z = this.bRF.bRf;
        if (!z && !SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            return;
        }
        this.bRF.aab();
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
            textView3 = this.bRF.bQI;
            textView3.setVisibility(8);
        } else {
            textView = this.bRF.bQI;
            textView.setVisibility(0);
        }
        textView2 = this.bRF.bQJ;
        com.baidu.tbadk.core.util.al.b(textView2, i.c.cp_cont_i, 1);
    }
}
