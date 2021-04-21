package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import java.util.List;
/* loaded from: classes3.dex */
public class BubbleListModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public c f18572e;

    /* renamed from: f  reason: collision with root package name */
    public d f18573f;

    /* renamed from: g  reason: collision with root package name */
    public int f18574g;

    /* renamed from: h  reason: collision with root package name */
    public int f18575h;
    public final HttpMessageListener i;
    public final HttpMessageListener j;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001500 || BubbleListModel.this.f18572e == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof ResponseBubbleListMessage)) {
                BubbleListModel.this.f18572e.a(null);
                return;
            }
            ResponseBubbleListMessage responseBubbleListMessage = (ResponseBubbleListMessage) httpResponsedMessage;
            if (statusCode != 200 || error != 0) {
                BubbleListModel.this.f18572e.a(responseBubbleListMessage.getBubbleListData());
            } else if (responseBubbleListMessage.getBubbleListData() == null) {
                BubbleListModel.this.f18572e.a(responseBubbleListMessage.getBubbleListData());
            } else {
                BubbleListModel.this.f18572e.b(responseBubbleListMessage.getBubbleListData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001501 || BubbleListModel.this.f18573f == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof ResponseSetBubbleMessage)) {
                BubbleListModel.this.f18573f.b(null);
                return;
            }
            ResponseSetBubbleMessage responseSetBubbleMessage = (ResponseSetBubbleMessage) httpResponsedMessage;
            if (statusCode != 200 || error != 0) {
                BubbleListModel.this.f18573f.b(responseSetBubbleMessage.getSetBubbleResultData());
            } else if (responseSetBubbleMessage.getSetBubbleResultData() == null) {
                BubbleListModel.this.f18573f.b(responseSetBubbleMessage.getSetBubbleResultData());
            } else {
                BubbleListModel.this.f18573f.a(responseSetBubbleMessage.getSetBubbleResultData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(BubbleListData bubbleListData);

        void b(BubbleListData bubbleListData);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(SetBubbleResultData setBubbleResultData);

        void b(SetBubbleResultData setBubbleResultData);
    }

    public BubbleListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.i = new a(CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.j = new b(CmdConfigHttp.SET_BUBBLE_CMD);
    }

    public static boolean u(List<BubbleListData.BubbleData> list) {
        if (list == null || list.size() <= 0) {
            return true;
        }
        for (BubbleListData.BubbleData bubbleData : list) {
            if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                return false;
            }
        }
        return true;
    }

    public void A(int i, int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        httpMessage.addParam(Config.PACKAGE_NAME, String.valueOf(i));
        httpMessage.addParam("rn", String.valueOf(i2));
        httpMessage.addParam("scr_w", String.valueOf(i3));
        httpMessage.addParam("scr_h", String.valueOf(i4));
        sendMessage(httpMessage);
    }

    public void B(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_BUBBLE_CMD);
        httpMessage.addParam("bcode", String.valueOf(i));
        httpMessage.addParam("scr_w", String.valueOf(i2));
        httpMessage.addParam("scr_h", String.valueOf(i3));
        sendMessage(httpMessage);
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "consume_20", null);
    }

    public void C(int i) {
        this.f18574g = i;
    }

    public void D(int i) {
        this.f18575h = i;
    }

    public void E(c cVar) {
        this.f18572e = cVar;
    }

    public void F(d dVar) {
        this.f18573f = dVar;
    }

    public void G(CustomMessageListener customMessageListener) {
        MessageManager.getInstance().unRegisterListener(customMessageListener);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void unRegisterListener() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.j);
        messageManager.unRegisterListener(this.i);
    }

    public int v() {
        return this.f18574g;
    }

    public int w() {
        return this.f18575h;
    }

    public void x() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REQUEST_BUBBLELIST_CMD, TbConfig.SERVER_ADDRESS + "c/e/bu/getbubblelist");
        tbHttpMessageTask.setResponsedClass(ResponseBubbleListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.i);
    }

    public void y() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_BUBBLE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.BUBBLE_SET);
        tbHttpMessageTask.setResponsedClass(ResponseSetBubbleMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.j);
    }

    public void z(CustomMessageListener customMessageListener) {
        registerListener(customMessageListener);
    }
}
