package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.themeCenter.bubble.all.BubbleSetResponseMessage;
import com.baidu.tieba.themeCenter.bubble.group.d;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ d dNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.dNh = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        d.a aVar;
        k kVar;
        List<c> list;
        BubbleGroupActivity bubbleGroupActivity;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003056) {
            BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
            if (bubbleSetResponseMessage.getError() != 0) {
                bubbleGroupActivity = this.dNh.dNf;
                bubbleGroupActivity.showToast(bubbleSetResponseMessage.getErrorString());
                return;
            }
            this.dNh.ny(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
            aVar = this.dNh.dNg;
            int error = httpResponsedMessage.getError();
            String errorString = httpResponsedMessage.getErrorString();
            kVar = this.dNh.mRecommand;
            list = this.dNh.dLY;
            aVar.a(error, errorString, kVar, list);
        }
    }
}
