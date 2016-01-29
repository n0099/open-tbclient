package com.baidu.tieba.personInfo;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PersonInfoDelegateStatic dhP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PersonInfoDelegateStatic personInfoDelegateStatic, int i) {
        super(i);
        this.dhP = personInfoDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.dhP.dhN = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).axZ);
            imageView = this.dhP.dhM;
            bool = this.dhP.dhN;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }
}
