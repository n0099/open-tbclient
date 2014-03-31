package com.baidu.tieba.mainentrance;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
final class i implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        String str;
        if (i == 2) {
            i2 = this.a.z;
            if (i2 == 0) {
                this.a.b();
                return true;
            }
            SquareSearchActivity squareSearchActivity = this.a;
            str = this.a.y;
            squareSearchActivity.a(1, str);
            return true;
        }
        return false;
    }
}
