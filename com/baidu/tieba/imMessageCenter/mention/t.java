package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ l djK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(l lVar, int i) {
        super(i);
        this.djK = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.view.x xVar;
        com.baidu.tbadk.core.view.x xVar2;
        boolean isLogin;
        if (customResponsedMessage != null) {
            xVar = this.djK.mNoDataView;
            if (xVar != null) {
                xVar2 = this.djK.mNoDataView;
                if (xVar2.getVisibility() == 0) {
                    l lVar = this.djK;
                    isLogin = this.djK.isLogin();
                    lVar.s(isLogin, true);
                }
            }
        }
    }
}
