package com.baidu.tieba.tbadkCore.util;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.util.PageType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ PageType cpF;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, PageType pageType) {
        this.val$context = context;
        this.cpF = pageType;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(this.val$context, this.cpF)));
    }
}
