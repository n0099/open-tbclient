package com.baidu.tieba.personPolymeric.b;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnCancelListener {
    final /* synthetic */ b eKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.eKV = bVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BdUniqueId bdUniqueId;
        MessageManager messageManager = MessageManager.getInstance();
        bdUniqueId = this.eKV.eKU;
        messageManager.removeMessage(bdUniqueId);
    }
}
