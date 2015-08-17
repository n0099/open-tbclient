package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.bQZ.mMode != 0) {
                if (this.bQZ.mMode == 3) {
                    if (TextUtils.isEmpty(this.bQZ.bQt) || this.bQZ.bQt.trim().length() <= 0) {
                        return true;
                    }
                    this.bQZ.fX(this.bQZ.bQt);
                    return true;
                }
                this.bQZ.G(1, this.bQZ.bQt);
                return true;
            }
            this.bQZ.ZV();
            return true;
        }
        return false;
    }
}
