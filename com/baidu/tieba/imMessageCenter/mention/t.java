package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ l dmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(l lVar, int i) {
        super(i);
        this.dmU = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.view.y yVar;
        com.baidu.tbadk.core.view.y yVar2;
        boolean isLogin;
        if (customResponsedMessage != null) {
            yVar = this.dmU.mNoDataView;
            if (yVar != null) {
                yVar2 = this.dmU.mNoDataView;
                if (yVar2.getVisibility() == 0) {
                    l lVar = this.dmU;
                    isLogin = this.dmU.isLogin();
                    lVar.r(isLogin, true);
                }
            }
        }
    }
}
