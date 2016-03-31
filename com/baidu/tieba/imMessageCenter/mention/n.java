package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ k cxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, int i) {
        super(i);
        this.cxu = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.view.p pVar;
        com.baidu.tbadk.core.view.p pVar2;
        if (customResponsedMessage != null) {
            pVar = this.cxu.mNoDataView;
            if (pVar != null) {
                pVar2 = this.cxu.mNoDataView;
                if (pVar2.getVisibility() == 0) {
                    this.cxu.o(TbadkCoreApplication.isLogin(), true);
                }
            }
        }
    }
}
