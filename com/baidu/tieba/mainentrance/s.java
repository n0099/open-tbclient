package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
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
            i2 = this.bCE.mMode;
            if (i2 != 0) {
                i3 = this.bCE.mMode;
                if (i3 == 3) {
                    str2 = this.bCE.bCf;
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    str3 = this.bCE.bCf;
                    if (str3.trim().length() > 0) {
                        SquareSearchActivity squareSearchActivity = this.bCE;
                        str4 = this.bCE.bCf;
                        squareSearchActivity.fE(str4);
                        return true;
                    }
                    return true;
                }
                SquareSearchActivity squareSearchActivity2 = this.bCE;
                str = this.bCE.bCf;
                squareSearchActivity2.z(1, str);
                return true;
            }
            this.bCE.Yo();
            return true;
        }
        return false;
    }
}
