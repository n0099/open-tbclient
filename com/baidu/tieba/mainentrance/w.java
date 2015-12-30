package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.cqu.mMode != 0) {
                if (this.cqu.mMode == 3) {
                    if (TextUtils.isEmpty(this.cqu.cpN) || this.cqu.cpN.trim().length() <= 0) {
                        return true;
                    }
                    this.cqu.gA(this.cqu.cpN);
                    return true;
                }
                this.cqu.I(1, this.cqu.cpN);
                return true;
            }
            this.cqu.agu();
            return true;
        }
        return false;
    }
}
