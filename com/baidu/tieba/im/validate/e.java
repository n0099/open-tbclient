package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.f1898a = validateActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        com.baidu.tieba.util.i iVar;
        nVar = this.f1898a.b;
        BdListView f = nVar.f();
        iVar = this.f1898a.h;
        ah.a(f, iVar, 0, 1);
    }
}
