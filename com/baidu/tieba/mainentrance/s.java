package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
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
        str = this.bnc.bmO;
        if (str != null) {
            str2 = this.bnc.bmO;
            if (str2.trim().length() >= 1) {
                i = this.bnc.mMode;
                if (i != 0) {
                    i2 = this.bnc.mMode;
                    if (i2 == 3) {
                        SquareSearchActivity squareSearchActivity = this.bnc;
                        editText = this.bnc.bmv;
                        com.baidu.adp.lib.util.m.b(squareSearchActivity, editText);
                        str4 = this.bnc.bmO;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.bnc.bmO;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity2 = this.bnc;
                                str6 = this.bnc.bmO;
                                squareSearchActivity2.bmO = str6.trim();
                                SquareSearchActivity squareSearchActivity3 = this.bnc;
                                str7 = this.bnc.bmO;
                                squareSearchActivity3.fz(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity4 = this.bnc;
                    str3 = this.bnc.bmO;
                    squareSearchActivity4.o(1, str3);
                    return;
                }
                z = this.bnc.bmS;
                if (z) {
                    this.bnc.startSearch();
                    return;
                }
                return;
            }
        }
        this.bnc.showToast(this.bnc.getResources().getString(com.baidu.tieba.y.write_keyword));
    }
}
