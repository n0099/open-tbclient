package com.baidu.tieba.square;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2335a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.f2335a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.f2335a.E;
        if (str != null) {
            str2 = this.f2335a.E;
            if (str2.trim().length() >= 1) {
                i = this.f2335a.F;
                if (i == 0) {
                    this.f2335a.e();
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.f2335a;
                str3 = this.f2335a.E;
                squareSearchActivity.a(1, str3);
                return;
            }
        }
        this.f2335a.a(this.f2335a.getResources().getString(R.string.write_keyword));
    }
}
