package com.baidu.tieba.personInfo;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ PersonInfoDelegateStatic ePq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PersonInfoDelegateStatic personInfoDelegateStatic, int i) {
        super(i);
        this.ePq = personInfoDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        Boolean bool2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.ePq.ePo = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).azO);
            imageView = this.ePq.dWb;
            bool = this.ePq.ePo;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            bool2 = this.ePq.ePo;
            if (!bool2.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("member_close_ad_mine_clicked", true);
            }
        }
    }
}
