package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
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
            i2 = this.a.z;
            if (i2 != 0) {
                i3 = this.a.z;
                if (i3 == 3) {
                    str2 = this.a.y;
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    str3 = this.a.y;
                    if (str3.trim().length() > 0) {
                        SquareSearchActivity squareSearchActivity = this.a;
                        str4 = this.a.y;
                        squareSearchActivity.a(str4);
                        return true;
                    }
                    return true;
                }
                SquareSearchActivity squareSearchActivity2 = this.a;
                str = this.a.y;
                squareSearchActivity2.a(1, str);
                return true;
            }
            this.a.d();
            return true;
        }
        return false;
    }
}
