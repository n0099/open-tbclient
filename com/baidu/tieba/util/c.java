package com.baidu.tieba.util;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.account.appeal.AppealActivity;
import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    private final /* synthetic */ Context a;
    private final /* synthetic */ AntiData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, AntiData antiData) {
        this.a = context;
        this.b = antiData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        AppealActivity.a(this.a, this.b.getBlock_forum_id(), this.b.getUser_id(), this.b.getUser_name());
    }
}
