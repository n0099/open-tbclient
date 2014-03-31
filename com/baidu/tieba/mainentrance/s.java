package com.baidu.tieba.mainentrance;

import android.view.View;
/* loaded from: classes.dex */
final class s implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.a.y;
        if (str != null) {
            str2 = this.a.y;
            if (str2.trim().length() > 0) {
                i = this.a.z;
                if (i == 0) {
                    this.a.b();
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.a;
                str3 = this.a.y;
                squareSearchActivity.a(1, str3);
                return;
            }
        }
        this.a.showToast(this.a.getResources().getString(com.baidu.tieba.a.k.write_keyword));
    }
}
