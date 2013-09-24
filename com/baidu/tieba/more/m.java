package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class m implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f1497a = lVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.f1497a.f1496a;
        accountActivity.h();
    }
}
