package com.baidu.tieba.j;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a fvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.fvW = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.m9getInst().getLastUpdateThemeTime()) {
            this.fvW.fvI = true;
            a aVar = this.fvW;
            z = this.fvW.fvI;
            aVar.fvA = z ? true : this.fvW.fvA;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            this.fvW.beR();
        }
    }
}
