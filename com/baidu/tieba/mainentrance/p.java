package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        int i2;
        String str3;
        EditText editText;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        str = this.bzT.bzz;
        if (str != null) {
            str2 = this.bzT.bzz;
            if (str2.trim().length() >= 1) {
                i = this.bzT.mMode;
                if (i != 0) {
                    i2 = this.bzT.mMode;
                    if (i2 == 3) {
                        Activity pageActivity = this.bzT.getPageContext().getPageActivity();
                        editText = this.bzT.bze;
                        com.baidu.adp.lib.util.n.c(pageActivity, editText);
                        str4 = this.bzT.bzz;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.bzT.bzz;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity = this.bzT;
                                str6 = this.bzT.bzz;
                                squareSearchActivity.bzz = str6.trim();
                                SquareSearchActivity squareSearchActivity2 = this.bzT;
                                str7 = this.bzT.bzz;
                                squareSearchActivity2.fj(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.bzT.WV();
                    SquareSearchActivity squareSearchActivity3 = this.bzT;
                    str3 = this.bzT.bzz;
                    squareSearchActivity3.y(1, str3);
                    return;
                }
                z = this.bzT.bzH;
                if (z) {
                    this.bzT.WW();
                    return;
                }
                return;
            }
        }
        this.bzT.showToast(this.bzT.getResources().getString(com.baidu.tieba.y.write_keyword));
    }
}
