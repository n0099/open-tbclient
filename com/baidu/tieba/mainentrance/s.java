package com.baidu.tieba.mainentrance;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
        if (r0.equals(r1) == false) goto L16;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        str = this.a.y;
        if (str != null) {
            str2 = this.a.y;
            if (str2.trim().length() >= 1) {
                i = this.a.z;
                if (i != 0) {
                    str3 = this.a.A;
                    if (str3 != null) {
                        str6 = this.a.A;
                        str7 = this.a.y;
                    }
                    SquareSearchActivity squareSearchActivity = this.a;
                    str4 = this.a.y;
                    squareSearchActivity.a(1, str4);
                    SquareSearchActivity squareSearchActivity2 = this.a;
                    str5 = this.a.y;
                    squareSearchActivity2.A = str5;
                    return;
                }
                this.a.d();
                return;
            }
        }
        this.a.showToast(this.a.getResources().getString(com.baidu.tieba.u.write_keyword));
    }
}
