package com.baidu.tieba.util;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.tieba.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2508a;
    final /* synthetic */ AntiHelper.PageType b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, AntiHelper.PageType pageType) {
        this.f2508a = context;
        this.b = pageType;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        AccountRestoreActivity.startActivity(this.f2508a, this.b);
    }
}
