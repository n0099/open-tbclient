package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar;
        com.baidu.tieba.util.i iVar;
        rVar = this.a.b;
        BdListView d = rVar.d();
        iVar = this.a.h;
        ap.a(d, iVar, 0, 1);
    }
}
