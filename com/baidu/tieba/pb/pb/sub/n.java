package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.widget.richText.g;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.cfY = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g.a)) {
            g.a aVar = (g.a) customResponsedMessage.getData();
            com.baidu.tbadk.widget.richText.g.a(this.cfY.getPageContext(), aVar.type, aVar.url, aVar.subType);
        }
    }
}
