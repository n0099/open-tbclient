package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ah extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        an anVar;
        an anVar2;
        int i2;
        this.this$0.cba = false;
        i = this.this$0.caW;
        if (i <= 0) {
            i2 = this.this$0.caY;
            if (i2 <= 0) {
                z = false;
                if (z) {
                    anVar = this.this$0.caU;
                    anVar.eE(false);
                    anVar2 = this.this$0.caU;
                    anVar2.aja().eH(false);
                    return;
                }
                return;
            }
        }
        z = true;
        if (z) {
        }
    }
}
