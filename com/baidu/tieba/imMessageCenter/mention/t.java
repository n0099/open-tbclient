package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ l dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(l lVar, int i) {
        super(i);
        this.dmu = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.view.y yVar;
        com.baidu.tbadk.core.view.y yVar2;
        boolean isLogin;
        if (customResponsedMessage != null) {
            yVar = this.dmu.mNoDataView;
            if (yVar != null) {
                yVar2 = this.dmu.mNoDataView;
                if (yVar2.getVisibility() == 0) {
                    l lVar = this.dmu;
                    isLogin = this.dmu.isLogin();
                    lVar.u(isLogin, true);
                }
            }
        }
    }
}
