package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
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
        str = this.a.y;
        if (str != null) {
            str2 = this.a.y;
            if (str2.trim().length() >= 1) {
                i = this.a.z;
                if (i != 0) {
                    i2 = this.a.z;
                    if (i2 == 3) {
                        SquareSearchActivity squareSearchActivity = this.a;
                        editText = this.a.c;
                        com.baidu.adp.lib.util.j.a(squareSearchActivity, editText);
                        str4 = this.a.y;
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = this.a.y;
                            if (str5.trim().length() != 0) {
                                SquareSearchActivity squareSearchActivity2 = this.a;
                                str6 = this.a.y;
                                squareSearchActivity2.a(str6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SquareSearchActivity squareSearchActivity3 = this.a;
                    str3 = this.a.y;
                    squareSearchActivity3.a(1, str3);
                    return;
                }
                this.a.d();
                return;
            }
        }
        this.a.showToast(this.a.getResources().getString(com.baidu.tieba.x.write_keyword));
    }
}
