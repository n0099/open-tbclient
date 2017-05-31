package com.baidu.tieba.personInfo;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ PersonInfoDelegateStatic eKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PersonInfoDelegateStatic personInfoDelegateStatic, int i) {
        super(i);
        this.eKv = personInfoDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        int i;
        ImageView imageView2;
        Boolean bool;
        Boolean bool2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null) {
            if (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a) {
                this.eKv.eKt = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aDF);
                this.eKv.aDG = ((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aDG;
                imageView2 = this.eKv.dLf;
                bool = this.eKv.eKt;
                imageView2.setVisibility(bool.booleanValue() ? 0 : 8);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                bool2 = this.eKv.eKt;
                if (!bool2.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                }
            }
            imageView = this.eKv.dLf;
            i = this.eKv.aDG;
            PersonInfoDelegateStatic.f(imageView, i);
        }
    }
}
