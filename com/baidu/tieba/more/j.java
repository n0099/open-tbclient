package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f1414a = iVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.f1414a.f1413a;
        accountActivity.g();
    }
}
