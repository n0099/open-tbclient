package com.baidu.tieba.square;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f1814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.f1814a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.f1814a.E;
        if (str != null) {
            str2 = this.f1814a.E;
            if (str2.trim().length() >= 1) {
                i = this.f1814a.F;
                if (i == 0) {
                    this.f1814a.e();
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.f1814a;
                str3 = this.f1814a.E;
                squareSearchActivity.a(1, str3);
                return;
            }
        }
        this.f1814a.a(this.f1814a.getResources().getString(R.string.write_keyword));
    }
}
