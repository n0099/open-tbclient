package com.baidu.tieba.personInfo;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements DialogInterface.OnCancelListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(h hVar) {
        this.this$0 = hVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BdUniqueId bdUniqueId;
        MessageManager messageManager = MessageManager.getInstance();
        bdUniqueId = this.this$0.eAN;
        messageManager.removeMessage(bdUniqueId);
    }
}
