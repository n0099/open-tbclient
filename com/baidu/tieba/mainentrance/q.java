package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
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
        str = this.bzG.bzm;
        if (str != null) {
            str2 = this.bzG.bzm;
            if (str2.trim().length() >= 1) {
                i = this.bzG.mMode;
                if (i != 0) {
                    i2 = this.bzG.mMode;
                    if (i2 == 3) {
                        Activity pageActivity = this.bzG.getPageContext().getPageActivity();
                        editText = this.bzG.byS;
                        com.baidu.adp.lib.util.n.c(pageActivity, editText);
                        str4 = this.bzG.bzm;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.bzG.bzm;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity = this.bzG;
                                str6 = this.bzG.bzm;
                                squareSearchActivity.bzm = str6.trim();
                                SquareSearchActivity squareSearchActivity2 = this.bzG;
                                str7 = this.bzG.bzm;
                                squareSearchActivity2.fg(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity3 = this.bzG;
                    str3 = this.bzG.bzm;
                    squareSearchActivity3.y(1, str3);
                    return;
                }
                z = this.bzG.bzu;
                if (z) {
                    this.bzG.WL();
                    return;
                }
                return;
            }
        }
        this.bzG.showToast(this.bzG.getResources().getString(com.baidu.tieba.y.write_keyword));
    }
}
