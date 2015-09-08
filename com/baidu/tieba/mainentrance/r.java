package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.bRF = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.bRF.mMode != 0) {
                if (this.bRF.mMode == 3) {
                    if (TextUtils.isEmpty(this.bRF.bQZ) || this.bRF.bQZ.trim().length() <= 0) {
                        return true;
                    }
                    this.bRF.ge(this.bRF.bQZ);
                    return true;
                }
                this.bRF.E(1, this.bRF.bQZ);
                return true;
            }
            this.bRF.aaa();
            return true;
        }
        return false;
    }
}
