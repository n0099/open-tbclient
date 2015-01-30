package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
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
        str = this.btb.bsO;
        if (str != null) {
            str2 = this.btb.bsO;
            if (str2.trim().length() >= 1) {
                i = this.btb.mMode;
                if (i != 0) {
                    i2 = this.btb.mMode;
                    if (i2 == 3) {
                        Activity pageActivity = this.btb.getPageContext().getPageActivity();
                        editText = this.btb.bsw;
                        com.baidu.adp.lib.util.l.c(pageActivity, editText);
                        str4 = this.btb.bsO;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.btb.bsO;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity = this.btb;
                                str6 = this.btb.bsO;
                                squareSearchActivity.bsO = str6.trim();
                                SquareSearchActivity squareSearchActivity2 = this.btb;
                                str7 = this.btb.bsO;
                                squareSearchActivity2.fW(str7);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity3 = this.btb;
                    str3 = this.btb.bsO;
                    squareSearchActivity3.y(1, str3);
                    return;
                }
                this.btb.Uh();
                return;
            }
        }
        this.btb.showToast(this.btb.getResources().getString(com.baidu.tieba.z.write_keyword));
    }
}
