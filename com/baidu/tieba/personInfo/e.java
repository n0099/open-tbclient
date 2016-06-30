package com.baidu.tieba.personInfo;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PersonInfoDelegateStatic eoC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PersonInfoDelegateStatic personInfoDelegateStatic, int i) {
        super(i);
        this.eoC = personInfoDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        Boolean bool2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.eoC.eoA = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).avx);
            imageView = this.eoC.dyI;
            bool = this.eoC.eoA;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            bool2 = this.eoC.eoA;
            if (!bool2.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("member_close_ad_mine_clicked", true);
            }
        }
    }
}
