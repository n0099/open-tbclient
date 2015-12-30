package com.baidu.tieba.supplementSign;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ SupplementSignActivity dEj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SupplementSignActivity supplementSignActivity, int i) {
        super(i);
        this.dEj = supplementSignActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BaseWebView baseWebView;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            baseWebView = this.dEj.mWebView;
            baseWebView.loadUrl("javascript:TbJsBridge.refreshRemainDay()");
        }
    }
}
