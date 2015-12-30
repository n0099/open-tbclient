package com.baidu.tieba.personInfo;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ PersonInfoDelegateStatic cWg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonInfoDelegateStatic personInfoDelegateStatic, int i) {
        super(i);
        this.cWg = personInfoDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.cWg.aRX = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).axi);
            imageView = this.cWg.aRW;
            bool = this.cWg.aRX;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }
}
