package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aq extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SettingStatic.eeq = true;
        SettingStatic.aPg();
    }
}
