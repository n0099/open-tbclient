package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnFocusChangeListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            BdUtilHelper.a(this.a, view);
        }
    }
}
