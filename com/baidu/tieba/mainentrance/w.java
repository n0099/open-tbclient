package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.bVC.mMode != 0) {
                if (this.bVC.mMode == 3) {
                    if (TextUtils.isEmpty(this.bVC.bUV) || this.bVC.bUV.trim().length() <= 0) {
                        return true;
                    }
                    this.bVC.gh(this.bVC.bUV);
                    return true;
                }
                this.bVC.G(1, this.bVC.bUV);
                return true;
            }
            this.bVC.abk();
            return true;
        }
        return false;
    }
}
