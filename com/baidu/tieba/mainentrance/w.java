package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.bWd.mMode != 0) {
                if (this.bWd.mMode == 3) {
                    if (TextUtils.isEmpty(this.bWd.bVw) || this.bWd.bVw.trim().length() <= 0) {
                        return true;
                    }
                    this.bWd.gj(this.bWd.bVw);
                    return true;
                }
                this.bWd.H(1, this.bWd.bVw);
                return true;
            }
            this.bWd.abF();
            return true;
        }
        return false;
    }
}
