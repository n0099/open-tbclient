package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ak;
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
        n nVar;
        com.baidu.tieba.util.i iVar;
        nVar = this.a.b;
        BdListView f = nVar.f();
        iVar = this.a.h;
        ak.a(f, iVar, 0, 1);
    }
}
