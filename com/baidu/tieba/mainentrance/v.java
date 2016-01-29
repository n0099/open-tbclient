package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.cwZ.mMode != 0) {
                if (this.cwZ.mMode == 3) {
                    if (TextUtils.isEmpty(this.cwZ.cws) || this.cwZ.cws.trim().length() <= 0) {
                        return true;
                    }
                    this.cwZ.gA(this.cwZ.cws);
                    return true;
                }
                this.cwZ.K(1, this.cwZ.cws);
                return true;
            }
            this.cwZ.akv();
            return true;
        }
        return false;
    }
}
