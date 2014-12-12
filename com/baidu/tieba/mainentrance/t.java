package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
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
        str = this.brF.brr;
        if (str != null) {
            str2 = this.brF.brr;
            if (str2.trim().length() >= 1) {
                i = this.brF.mMode;
                if (i != 0) {
                    i2 = this.brF.mMode;
                    if (i2 == 3) {
                        Activity pageActivity = this.brF.getPageContext().getPageActivity();
                        editText = this.brF.bqY;
                        com.baidu.adp.lib.util.l.c(pageActivity, editText);
                        str4 = this.brF.brr;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.brF.brr;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity = this.brF;
                                str6 = this.brF.brr;
                                squareSearchActivity.brr = str6.trim();
                                SquareSearchActivity squareSearchActivity2 = this.brF;
                                str7 = this.brF.brr;
                                squareSearchActivity2.fR(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity3 = this.brF;
                    str3 = this.brF.brr;
                    squareSearchActivity3.y(1, str3);
                    return;
                }
                z = this.brF.brv;
                if (z) {
                    this.brF.startSearch();
                    return;
                }
                return;
            }
        }
        this.brF.showToast(this.brF.getResources().getString(com.baidu.tieba.z.write_keyword));
    }
}
