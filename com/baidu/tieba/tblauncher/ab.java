package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(MainTabActivity mainTabActivity, int i) {
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
        aj ajVar;
        aj ajVar2;
        int i2;
        this.this$0.cvC = false;
        i = this.this$0.cvu;
        if (i <= 0) {
            i2 = this.this$0.cvx;
            if (i2 <= 0) {
                z = false;
                if (z) {
                    ajVar = this.this$0.cvs;
                    ajVar.fo(false);
                    ajVar2 = this.this$0.cvs;
                    ajVar2.aqx().fu(false);
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
