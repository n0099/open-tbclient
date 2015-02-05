package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bta = squareSearchActivity;
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
        str = this.bta.bsN;
        if (str != null) {
            str2 = this.bta.bsN;
            if (str2.trim().length() >= 1) {
                i = this.bta.mMode;
                if (i != 0) {
                    i2 = this.bta.mMode;
                    if (i2 == 3) {
                        Activity pageActivity = this.bta.getPageContext().getPageActivity();
                        editText = this.bta.bsv;
                        com.baidu.adp.lib.util.l.c(pageActivity, editText);
                        str4 = this.bta.bsN;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.bta.bsN;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity = this.bta;
                                str6 = this.bta.bsN;
                                squareSearchActivity.bsN = str6.trim();
                                SquareSearchActivity squareSearchActivity2 = this.bta;
                                str7 = this.bta.bsN;
                                squareSearchActivity2.fT(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity3 = this.bta;
                    str3 = this.bta.bsN;
                    squareSearchActivity3.y(1, str3);
                    return;
                }
                this.bta.Uc();
                return;
            }
        }
        this.bta.showToast(this.bta.getResources().getString(com.baidu.tieba.z.write_keyword));
    }
}
