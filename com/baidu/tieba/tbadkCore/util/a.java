package com.baidu.tieba.tbadkCore.util;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.util.PageType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements DialogInterface.OnClickListener {
    private final /* synthetic */ PageType bYK;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, PageType pageType) {
        this.val$context = context;
        this.bYK = pageType;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(this.val$context, this.bYK)));
    }
}
