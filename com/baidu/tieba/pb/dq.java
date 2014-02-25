package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements View.OnFocusChangeListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        NewPbActivity newPbActivity;
        if (!z) {
            newPbActivity = this.a.h;
            BdUtilHelper.a(newPbActivity, view);
        }
    }
}
