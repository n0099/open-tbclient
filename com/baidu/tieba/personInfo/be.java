package com.baidu.tieba.personInfo;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnCancelListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BdUniqueId bdUniqueId;
        MessageManager messageManager = MessageManager.getInstance();
        bdUniqueId = this.this$0.eoX;
        messageManager.removeMessage(bdUniqueId);
    }
}
