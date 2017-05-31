package com.baidu.tieba.pluginCenter;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* loaded from: classes2.dex */
class f extends CustomMessageListener {
    final /* synthetic */ PluginDetailActivity fcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PluginDetailActivity pluginDetailActivity, int i) {
        super(i);
        this.fcA = pluginDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.i.hk()) {
            this.fcA.aYg();
        }
    }
}
