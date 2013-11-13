package com.baidu.tieba.square;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(SquareSearchActivity squareSearchActivity) {
        this.f2396a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.f2396a.B;
        if (str != null) {
            str2 = this.f2396a.B;
            if (str2.trim().length() >= 1) {
                i = this.f2396a.C;
                if (i == 0) {
                    this.f2396a.d();
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.f2396a;
                str3 = this.f2396a.B;
                squareSearchActivity.a(1, str3);
                return;
            }
        }
        this.f2396a.showToast(this.f2396a.getResources().getString(R.string.write_keyword));
    }
}
