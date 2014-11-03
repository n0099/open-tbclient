package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
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
            i2 = this.bnc.mMode;
            if (i2 != 0) {
                i3 = this.bnc.mMode;
                if (i3 == 3) {
                    str2 = this.bnc.bmO;
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    str3 = this.bnc.bmO;
                    if (str3.trim().length() > 0) {
                        SquareSearchActivity squareSearchActivity = this.bnc;
                        str4 = this.bnc.bmO;
                        squareSearchActivity.fz(str4);
                        return true;
                    }
                    return true;
                }
                SquareSearchActivity squareSearchActivity2 = this.bnc;
                str = this.bnc.bmO;
                squareSearchActivity2.o(1, str);
                return true;
            }
            this.bnc.startSearch();
            return true;
        }
        return false;
    }
}
