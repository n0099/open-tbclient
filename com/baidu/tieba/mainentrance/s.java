package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
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
            i2 = this.bCF.mMode;
            if (i2 != 0) {
                i3 = this.bCF.mMode;
                if (i3 == 3) {
                    str2 = this.bCF.bCg;
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    str3 = this.bCF.bCg;
                    if (str3.trim().length() > 0) {
                        SquareSearchActivity squareSearchActivity = this.bCF;
                        str4 = this.bCF.bCg;
                        squareSearchActivity.fE(str4);
                        return true;
                    }
                    return true;
                }
                SquareSearchActivity squareSearchActivity2 = this.bCF;
                str = this.bCF.bCg;
                squareSearchActivity2.z(1, str);
                return true;
            }
            this.bCF.Yp();
            return true;
        }
        return false;
    }
}
