package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseFragmentActivity f2134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BaseFragmentActivity baseFragmentActivity) {
        this.f2134a = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2134a.f1004a = null;
    }
}
