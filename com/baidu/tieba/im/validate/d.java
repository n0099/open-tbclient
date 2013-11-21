package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.f1798a = validateActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        com.baidu.tieba.util.i iVar;
        mVar = this.f1798a.b;
        BdListView f = mVar.f();
        iVar = this.f1798a.h;
        ak.a(f, iVar, 0, 1);
    }
}
