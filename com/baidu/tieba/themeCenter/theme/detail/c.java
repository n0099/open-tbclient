package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ SkinDetailActivity dOk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SkinDetailActivity skinDetailActivity, int i) {
        super(i);
        this.dOk = skinDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e eVar;
        int i;
        if (customResponsedMessage != null) {
            if (!(customResponsedMessage.getData() instanceof com.baidu.tieba.themeCenter.b)) {
                this.dOk.mSkinType = 1;
            } else {
                com.baidu.tieba.themeCenter.b bVar = (com.baidu.tieba.themeCenter.b) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getSkinType() != 2 || bVar.getId() != TbadkCoreApplication.m411getInst().getUsedThemeId()) {
                    this.dOk.mSkinType = 4;
                } else {
                    this.dOk.mSkinType = 0;
                }
            }
            eVar = this.dOk.dOd;
            i = this.dOk.dOf;
            eVar.nC(i);
        }
    }
}
