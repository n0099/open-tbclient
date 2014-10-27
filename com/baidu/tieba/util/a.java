package com.baidu.tieba.util;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.tieba.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements DialogInterface.OnClickListener {
    private final /* synthetic */ AntiHelper.PageType bPS;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AntiHelper.PageType pageType) {
        this.val$context = context;
        this.bPS = pageType;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        AccountRestoreActivity.startActivity(this.val$context, this.bPS);
    }
}
