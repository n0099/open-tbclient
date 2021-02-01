package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleListModel extends BdBaseModel {
    private a lkI;
    private b lkJ;
    private int lkU;
    private int lkV;
    private final HttpMessageListener lkW;
    private final HttpMessageListener lkX;

    /* loaded from: classes9.dex */
    public interface a {
        void a(BubbleListData bubbleListData);

        void b(BubbleListData bubbleListData);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(SetBubbleResultData setBubbleResultData);

        void b(SetBubbleResultData setBubbleResultData);
    }

    public BubbleListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lkW = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.memberCenter.bubble.BubbleListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001500 && BubbleListModel.this.lkI != null) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (!(httpResponsedMessage instanceof ResponseBubbleListMessage)) {
                        BubbleListModel.this.lkI.b(null);
                        return;
                    }
                    ResponseBubbleListMessage responseBubbleListMessage = (ResponseBubbleListMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        BubbleListModel.this.lkI.b(responseBubbleListMessage.getBubbleListData());
                    } else if (responseBubbleListMessage.getBubbleListData() == null) {
                        BubbleListModel.this.lkI.b(responseBubbleListMessage.getBubbleListData());
                    } else {
                        BubbleListModel.this.lkI.a(responseBubbleListMessage.getBubbleListData());
                    }
                }
            }
        };
        this.lkX = new HttpMessageListener(1001501) { // from class: com.baidu.tieba.memberCenter.bubble.BubbleListModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001501 && BubbleListModel.this.lkJ != null) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (!(httpResponsedMessage instanceof ResponseSetBubbleMessage)) {
                        BubbleListModel.this.lkJ.b(null);
                        return;
                    }
                    ResponseSetBubbleMessage responseSetBubbleMessage = (ResponseSetBubbleMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        BubbleListModel.this.lkJ.b(responseSetBubbleMessage.getSetBubbleResultData());
                    } else if (responseSetBubbleMessage.getSetBubbleResultData() == null) {
                        BubbleListModel.this.lkJ.b(responseSetBubbleMessage.getSetBubbleResultData());
                    } else {
                        BubbleListModel.this.lkJ.a(responseSetBubbleMessage.getSetBubbleResultData());
                    }
                }
            }
        };
    }

    public void a(a aVar) {
        this.lkI = aVar;
    }

    public void a(b bVar) {
        this.lkJ = bVar;
    }

    public int deW() {
        return this.lkU;
    }

    public void Eq(int i) {
        this.lkU = i;
    }

    public int deX() {
        return this.lkV;
    }

    public void Er(int i) {
        this.lkV = i;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public static boolean eR(List<BubbleListData.BubbleData> list) {
        if (list != null && list.size() > 0) {
            for (BubbleListData.BubbleData bubbleData : list) {
                if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void a(CustomMessageListener customMessageListener) {
        registerListener(customMessageListener);
    }

    public void deY() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001500, TbConfig.SERVER_ADDRESS + Config.REQUEST_BUBBLE_LIST);
        tbHttpMessageTask.setResponsedClass(ResponseBubbleListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.lkW);
    }

    public void I(int i, int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(1001500);
        httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(i));
        httpMessage.addParam("rn", String.valueOf(i2));
        httpMessage.addParam("scr_w", String.valueOf(i3));
        httpMessage.addParam("scr_h", String.valueOf(i4));
        sendMessage(httpMessage);
    }

    public void W(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(1001501);
        httpMessage.addParam("bcode", String.valueOf(i));
        httpMessage.addParam("scr_w", String.valueOf(i2));
        httpMessage.addParam("scr_h", String.valueOf(i3));
        sendMessage(httpMessage);
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "consume_20", null);
    }

    public void deZ() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001501, TbConfig.SERVER_ADDRESS + "c/e/bu/setbubble");
        tbHttpMessageTask.setResponsedClass(ResponseSetBubbleMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.lkX);
    }

    public void unRegisterListener() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.lkX);
        messageManager.unRegisterListener(this.lkW);
    }

    public void b(CustomMessageListener customMessageListener) {
        MessageManager.getInstance().unRegisterListener(customMessageListener);
    }
}
