package com.baidu.tieba.square;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.a.C;
        if (str != null) {
            str2 = this.a.C;
            if (str2.trim().length() >= 1) {
                i = this.a.D;
                if (i == 0) {
                    this.a.d();
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.a;
                str3 = this.a.C;
                squareSearchActivity.a(1, str3);
                return;
            }
        }
        this.a.showToast(this.a.getResources().getString(R.string.write_keyword));
    }
}
