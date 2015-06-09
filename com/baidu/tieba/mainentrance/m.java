package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
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
        str = this.bCF.bCg;
        if (str != null) {
            str2 = this.bCF.bCg;
            if (str2.trim().length() >= 1) {
                i = this.bCF.mMode;
                if (i != 0) {
                    i2 = this.bCF.mMode;
                    if (i2 == 3) {
                        Activity pageActivity = this.bCF.getPageContext().getPageActivity();
                        editText = this.bCF.bBN;
                        com.baidu.adp.lib.util.n.c(pageActivity, editText);
                        str4 = this.bCF.bCg;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.bCF.bCg;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity = this.bCF;
                                str6 = this.bCF.bCg;
                                squareSearchActivity.bCg = str6.trim();
                                SquareSearchActivity squareSearchActivity2 = this.bCF;
                                str7 = this.bCF.bCg;
                                squareSearchActivity2.fE(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity3 = this.bCF;
                    str3 = this.bCF.bCg;
                    squareSearchActivity3.z(1, str3);
                    return;
                }
                z = this.bCF.bCn;
                if (z) {
                    this.bCF.Yp();
                    return;
                }
                return;
            }
        }
        this.bCF.showToast(this.bCF.getResources().getString(com.baidu.tieba.t.write_keyword));
    }
}
