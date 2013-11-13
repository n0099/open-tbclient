package com.baidu.tieba.util;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.tieba.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2472a;
    final /* synthetic */ AntiHelper.PageType b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AntiHelper.PageType pageType) {
        this.f2472a = context;
        this.b = pageType;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        AccountRestoreActivity.startActivity(this.f2472a, this.b);
    }
}
