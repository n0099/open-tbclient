package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
final class z implements View.OnFocusChangeListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            BdUtilHelper.a(this.a, view);
        }
    }
}
