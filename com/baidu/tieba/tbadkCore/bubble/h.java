package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
import java.util.List;
/* loaded from: classes.dex */
public class h extends f {
    private k bTk;
    private l bTl;
    private int bVT;
    private int bVU;
    private final HttpMessageListener bVV;
    private final HttpMessageListener bVW;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bVV = new i(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.bVW = new j(this, CmdConfigHttp.SET_BUBBLE_CMD);
    }

    public void a(k kVar) {
        this.bTk = kVar;
    }

    public void a(l lVar) {
        this.bTl = lVar;
    }

    public int ago() {
        return this.bVT;
    }

    public void hL(int i) {
        this.bVT = i;
    }

    public int agp() {
        return this.bVU;
    }

    public void hM(int i) {
        this.bVU = i;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public static boolean aF(List<BubbleListData.BubbleData> list) {
        if (list != null && list.size() > 0) {
            for (BubbleListData.BubbleData bubbleData : list) {
                if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void b(CustomMessageListener customMessageListener) {
        registerListener(customMessageListener);
    }

    public void agq() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REQUEST_BUBBLELIST_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/bu/getbubblelist");
        tbHttpMessageTask.setResponsedClass(ResponseBubbleListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bVV);
    }

    public void g(int i, int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        httpMessage.addParam("pn", String.valueOf(i));
        httpMessage.addParam("rn", String.valueOf(i2));
        httpMessage.addParam("scr_w", String.valueOf(i3));
        httpMessage.addParam("scr_h", String.valueOf(i4));
        sendMessage(httpMessage);
    }

    public void w(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_BUBBLE_CMD);
        httpMessage.addParam("bcode", String.valueOf(i));
        httpMessage.addParam("scr_w", String.valueOf(i2));
        httpMessage.addParam("scr_h", String.valueOf(i3));
        sendMessage(httpMessage);
    }

    public void agr() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_BUBBLE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/bu/setbubble");
        tbHttpMessageTask.setResponsedClass(ResponseSetBubbleMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bVW);
    }

    public void unRegisterListener() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.bVW);
        messageManager.unRegisterListener(this.bVV);
    }

    public void c(CustomMessageListener customMessageListener) {
        MessageManager.getInstance().unRegisterListener(customMessageListener);
    }
}
