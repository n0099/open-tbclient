package com.baidu.tieba.tbadkCore.util;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    private final /* synthetic */ AntiData caD;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, AntiData antiData) {
        this.val$context = context;
        this.caD = antiData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(this.val$context, this.caD.getBlock_forum_id(), this.caD.getUser_id(), this.caD.getUser_name())));
    }
}
