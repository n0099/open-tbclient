package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar;
        com.baidu.tieba.util.i iVar;
        rVar = this.a.b;
        BdListView f = rVar.f();
        iVar = this.a.h;
        ap.a(f, iVar, 0, 1);
    }
}
