package com.baidu.tieba.personPolymeric.b;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ a ePO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ePO = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BdUniqueId bdUniqueId;
        MessageManager messageManager = MessageManager.getInstance();
        bdUniqueId = this.ePO.ePN;
        messageManager.removeMessage(bdUniqueId);
    }
}
