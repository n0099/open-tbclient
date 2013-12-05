package com.baidu.tieba.square;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class az implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(SquareSearchActivity squareSearchActivity) {
        this.f2495a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.f2495a.B;
        if (str != null) {
            str2 = this.f2495a.B;
            if (str2.trim().length() >= 1) {
                i = this.f2495a.C;
                if (i == 0) {
                    this.f2495a.d();
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.f2495a;
                str3 = this.f2495a.B;
                squareSearchActivity.a(1, str3);
                return;
            }
        }
        this.f2495a.showToast(this.f2495a.getResources().getString(R.string.write_keyword));
    }
}
