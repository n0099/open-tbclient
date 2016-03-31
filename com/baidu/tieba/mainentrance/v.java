package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.cLU.mMode != 0) {
                if (this.cLU.mMode == 3) {
                    if (TextUtils.isEmpty(this.cLU.cLn) || this.cLU.cLn.trim().length() <= 0) {
                        return true;
                    }
                    this.cLU.gM(this.cLU.cLn);
                    return true;
                }
                this.cLU.D(1, this.cLU.cLn);
                return true;
            }
            this.cLU.aoE();
            return true;
        }
        return false;
    }
}
