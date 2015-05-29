package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
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
        str = this.bCE.bCf;
        if (str != null) {
            str2 = this.bCE.bCf;
            if (str2.trim().length() >= 1) {
                i = this.bCE.mMode;
                if (i != 0) {
                    i2 = this.bCE.mMode;
                    if (i2 == 3) {
                        Activity pageActivity = this.bCE.getPageContext().getPageActivity();
                        editText = this.bCE.bBM;
                        com.baidu.adp.lib.util.n.c(pageActivity, editText);
                        str4 = this.bCE.bCf;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.bCE.bCf;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity = this.bCE;
                                str6 = this.bCE.bCf;
                                squareSearchActivity.bCf = str6.trim();
                                SquareSearchActivity squareSearchActivity2 = this.bCE;
                                str7 = this.bCE.bCf;
                                squareSearchActivity2.fE(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity3 = this.bCE;
                    str3 = this.bCE.bCf;
                    squareSearchActivity3.z(1, str3);
                    return;
                }
                z = this.bCE.bCm;
                if (z) {
                    this.bCE.Yo();
                    return;
                }
                return;
            }
        }
        this.bCE.showToast(this.bCE.getResources().getString(com.baidu.tieba.t.write_keyword));
    }
}
