package com.baidu.tieba.square;

import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        String str;
        if (i == 2) {
            i2 = this.a.D;
            if (i2 == 0) {
                this.a.d();
                return true;
            }
            SquareSearchActivity squareSearchActivity = this.a;
            str = this.a.C;
            squareSearchActivity.a(1, str);
            return true;
        }
        return false;
    }
}
