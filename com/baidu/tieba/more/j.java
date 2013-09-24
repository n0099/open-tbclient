package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f1494a = iVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.f1494a.f1493a;
        accountActivity.h();
    }
}
