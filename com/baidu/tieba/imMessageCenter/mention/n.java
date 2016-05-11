package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ k cys;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, int i) {
        super(i);
        this.cys = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.view.q qVar;
        com.baidu.tbadk.core.view.q qVar2;
        if (customResponsedMessage != null) {
            qVar = this.cys.mNoDataView;
            if (qVar != null) {
                qVar2 = this.cys.mNoDataView;
                if (qVar2.getVisibility() == 0) {
                    this.cys.n(TbadkCoreApplication.isLogin(), true);
                }
            }
        }
    }
}
