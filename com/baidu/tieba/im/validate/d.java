package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.f1720a = validateActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        com.baidu.tieba.util.a aVar;
        mVar = this.f1720a.b;
        BdListView f = mVar.f();
        aVar = this.f1720a.j;
        ab.a(f, aVar, 0, 1);
    }
}
