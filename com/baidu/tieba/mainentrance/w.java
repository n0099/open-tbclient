package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.bVr.mMode != 0) {
                if (this.bVr.mMode == 3) {
                    if (TextUtils.isEmpty(this.bVr.bUK) || this.bVr.bUK.trim().length() <= 0) {
                        return true;
                    }
                    this.bVr.gh(this.bVr.bUK);
                    return true;
                }
                this.bVr.G(1, this.bVr.bUK);
                return true;
            }
            this.bVr.abo();
            return true;
        }
        return false;
    }
}
