package com.baidu.tieba.util;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.account.appeal.AppealActivity;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    private final /* synthetic */ AntiData bPT;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, AntiData antiData) {
        this.val$context = context;
        this.bPT = antiData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        AppealActivity.b(this.val$context, this.bPT.getBlock_forum_id(), this.bPT.getUser_id(), this.bPT.getUser_name());
    }
}
