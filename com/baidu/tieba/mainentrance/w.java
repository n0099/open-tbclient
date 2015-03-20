package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
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
            i2 = this.bzG.mMode;
            if (i2 != 0) {
                i3 = this.bzG.mMode;
                if (i3 == 3) {
                    str2 = this.bzG.bzm;
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    str3 = this.bzG.bzm;
                    if (str3.trim().length() > 0) {
                        SquareSearchActivity squareSearchActivity = this.bzG;
                        str4 = this.bzG.bzm;
                        squareSearchActivity.fg(str4);
                        return true;
                    }
                    return true;
                }
                SquareSearchActivity squareSearchActivity2 = this.bzG;
                str = this.bzG.bzm;
                squareSearchActivity2.y(1, str);
                return true;
            }
            this.bzG.WL();
            return true;
        }
        return false;
    }
}
