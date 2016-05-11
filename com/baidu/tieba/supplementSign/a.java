package com.baidu.tieba.supplementSign;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.c.e;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ SupplementSignActivity epZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SupplementSignActivity supplementSignActivity, int i) {
        super(i);
        this.epZ = supplementSignActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e eVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            eVar = this.epZ.mWebView;
            eVar.loadUrl("javascript:TbJsBridge.refreshRemainDay()");
        }
    }
}
