package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.widget.richText.b;
/* loaded from: classes.dex */
class ak extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.eye = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
            b.a aVar = (b.a) customResponsedMessage.getData();
            com.baidu.tbadk.widget.richText.b.a(this.eye.getPageContext(), aVar.type, aVar.url, aVar.subType);
        }
    }
}
