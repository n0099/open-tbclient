package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
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
        str = this.bmO.bmA;
        if (str != null) {
            str2 = this.bmO.bmA;
            if (str2.trim().length() >= 1) {
                i = this.bmO.mMode;
                if (i != 0) {
                    i2 = this.bmO.mMode;
                    if (i2 == 3) {
                        SquareSearchActivity squareSearchActivity = this.bmO;
                        editText = this.bmO.bmh;
                        com.baidu.adp.lib.util.m.b(squareSearchActivity, editText);
                        str4 = this.bmO.bmA;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.bmO.bmA;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity2 = this.bmO;
                                str6 = this.bmO.bmA;
                                squareSearchActivity2.bmA = str6.trim();
                                SquareSearchActivity squareSearchActivity3 = this.bmO;
                                str7 = this.bmO.bmA;
                                squareSearchActivity3.fz(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity4 = this.bmO;
                    str3 = this.bmO.bmA;
                    squareSearchActivity4.o(1, str3);
                    return;
                }
                z = this.bmO.bmE;
                if (z) {
                    this.bmO.startSearch();
                    return;
                }
                return;
            }
        }
        this.bmO.showToast(this.bmO.getResources().getString(com.baidu.tieba.y.write_keyword));
    }
}
