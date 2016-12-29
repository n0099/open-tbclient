package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(o oVar, int i) {
        super(i);
        this.dcz = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.view.w wVar;
        com.baidu.tbadk.core.view.w wVar2;
        boolean isLogin;
        if (customResponsedMessage != null) {
            wVar = this.dcz.mNoDataView;
            if (wVar != null) {
                wVar2 = this.dcz.mNoDataView;
                if (wVar2.getVisibility() == 0) {
                    o oVar = this.dcz;
                    isLogin = this.dcz.isLogin();
                    oVar.u(isLogin, true);
                }
            }
        }
    }
}
