package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
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
            i2 = this.btb.mMode;
            if (i2 != 0) {
                i3 = this.btb.mMode;
                if (i3 == 3) {
                    str2 = this.btb.bsO;
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    str3 = this.btb.bsO;
                    if (str3.trim().length() > 0) {
                        SquareSearchActivity squareSearchActivity = this.btb;
                        str4 = this.btb.bsO;
                        squareSearchActivity.fW(str4);
                        return true;
                    }
                    return true;
                }
                SquareSearchActivity squareSearchActivity2 = this.btb;
                str = this.btb.bsO;
                squareSearchActivity2.y(1, str);
                return true;
            }
            this.btb.Uh();
            return true;
        }
        return false;
    }
}
