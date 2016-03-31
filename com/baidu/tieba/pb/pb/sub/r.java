package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.widget.richText.h;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.doF = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h.a)) {
            h.a aVar = (h.a) customResponsedMessage.getData();
            com.baidu.tbadk.widget.richText.h.a(this.doF.getPageContext(), aVar.type, aVar.url, aVar.subType);
        }
    }
}
