package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.widget.richText.g;
/* loaded from: classes.dex */
class bn extends CustomMessageListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(PbActivity pbActivity, int i) {
        super(i);
        this.cNq = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g.a)) {
            g.a aVar = (g.a) customResponsedMessage.getData();
            com.baidu.tbadk.widget.richText.g.a(this.cNq.getPageContext(), aVar.type, aVar.url, aVar.subType);
        }
    }
}
