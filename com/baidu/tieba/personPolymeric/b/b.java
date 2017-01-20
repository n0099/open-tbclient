package com.baidu.tieba.personPolymeric.b;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ a eDg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eDg = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BdUniqueId bdUniqueId;
        MessageManager messageManager = MessageManager.getInstance();
        bdUniqueId = this.eDg.eDf;
        messageManager.removeMessage(bdUniqueId);
    }
}
