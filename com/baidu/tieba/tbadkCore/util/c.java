package com.baidu.tieba.tbadkCore.util;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ AntiData cua;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, AntiData antiData) {
        this.val$context = context;
        this.cua = antiData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(this.val$context, this.cua.getBlock_forum_id(), this.cua.getUser_id(), this.cua.getUser_name())));
    }
}
