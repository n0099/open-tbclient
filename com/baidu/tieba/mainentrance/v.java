package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 2) {
            i2 = this.bzT.mMode;
            if (i2 != 0) {
                i3 = this.bzT.mMode;
                if (i3 == 3) {
                    str2 = this.bzT.bzz;
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    str3 = this.bzT.bzz;
                    if (str3.trim().length() > 0) {
                        SquareSearchActivity squareSearchActivity = this.bzT;
                        str4 = this.bzT.bzz;
                        squareSearchActivity.fj(str4);
                        return true;
                    }
                    return true;
                }
                this.bzT.WV();
                SquareSearchActivity squareSearchActivity2 = this.bzT;
                str = this.bzT.bzz;
                squareSearchActivity2.y(1, str);
                return true;
            }
            this.bzT.WW();
            return true;
        }
        return false;
    }
}
