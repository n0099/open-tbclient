package com.baidu.tieba.write;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.message.ResponseBubbleListMessage;
/* loaded from: classes.dex */
class ac extends HttpMessageListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(WriteActivity writeActivity, int i) {
        super(i);
        this.bUm = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        BubbleListData bubbleListData;
        String str;
        String str2;
        if ((httpResponsedMessage instanceof ResponseBubbleListMessage) && httpResponsedMessage.getError() == 0 && (bubbleListData = ((ResponseBubbleListMessage) httpResponsedMessage).getBubbleListData()) != null && bubbleListData.getB_info() != null && bubbleListData.getB_info().size() > 0) {
            for (BubbleListData.BubbleData bubbleData : bubbleListData.getB_info()) {
                if (bubbleData.getIs_free() == 1) {
                    String b_url = bubbleData.getB_url();
                    if (b_url != null) {
                        str = this.bUm.aqi;
                        if (!b_url.equals(str)) {
                            this.bUm.aqi = b_url;
                            this.bUm.eM(true);
                            TbadkApplication m251getInst = TbadkApplication.m251getInst();
                            str2 = this.bUm.aqi;
                            m251getInst.setDefaultBubble(str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }
}
