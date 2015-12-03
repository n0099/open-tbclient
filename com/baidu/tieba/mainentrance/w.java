package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.cmr.mMode != 0) {
                if (this.cmr.mMode == 3) {
                    if (TextUtils.isEmpty(this.cmr.clJ) || this.cmr.clJ.trim().length() <= 0) {
                        return true;
                    }
                    this.cmr.gw(this.cmr.clJ);
                    return true;
                }
                this.cmr.I(1, this.cmr.clJ);
                return true;
            }
            this.cmr.afl();
            return true;
        }
        return false;
    }
}
