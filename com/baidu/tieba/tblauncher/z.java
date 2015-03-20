package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(MainTabActivity mainTabActivity, int i) {
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
        ai aiVar;
        ai aiVar2;
        int i2;
        this.this$0.cre = false;
        i = this.this$0.cqX;
        if (i <= 0) {
            i2 = this.this$0.cqZ;
            if (i2 <= 0) {
                z = false;
                if (z) {
                    aiVar = this.this$0.cqV;
                    aiVar.eW(false);
                    aiVar2 = this.this$0.cqV;
                    aiVar2.aor().fa(false);
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
