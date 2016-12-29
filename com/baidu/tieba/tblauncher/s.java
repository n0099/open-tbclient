package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ACROSS_FORUM_THEME_SHOW, this.this$0.getPageContext()));
            if (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) {
                this.this$0.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                TbadkCoreApplication.m9getInst().setPaymemberInfo((com.baidu.tbadk.data.h) customResponsedMessage.getData());
            }
        }
    }
}
