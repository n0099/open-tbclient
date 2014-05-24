package com.baidu.tieba.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.message.ResponseBubbleListMessage;
import com.baidu.tieba.message.ResponseSetBubbleMessage;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.b {
    private i a;
    private j b;
    private int c;
    private int d;
    private HttpMessageListener e = new g(this, CmdConfig.REQUEST_BUBBLELIST_CMD);
    private HttpMessageListener f = new h(this, CmdConfig.SET_BUBBLE_CMD);

    public void a(i iVar) {
        this.a = iVar;
    }

    public void a(j jVar) {
        this.b = jVar;
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int b() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public static boolean a(List<BubbleListData.BubbleData> list) {
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
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    public void c() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfig.REQUEST_BUBBLELIST_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/bu/getbubblelist");
        tbHttpMessageTask.setResponsedClass(ResponseBubbleListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.e);
    }

    public void a(int i, int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(CmdConfig.REQUEST_BUBBLELIST_CMD);
        httpMessage.setTag(CmdConfig.REQUEST_BUBBLELIST_CMD);
        httpMessage.addParam("pn", String.valueOf(i));
        httpMessage.addParam("rn", String.valueOf(i2));
        httpMessage.addParam("scr_w", String.valueOf(i3));
        httpMessage.addParam("scr_h", String.valueOf(i4));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfig.SET_BUBBLE_CMD);
        httpMessage.setTag(CmdConfig.SET_BUBBLE_CMD);
        httpMessage.addParam("bcode", String.valueOf(i));
        httpMessage.addParam("scr_w", String.valueOf(i2));
        httpMessage.addParam("scr_h", String.valueOf(i3));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfig.SET_BUBBLE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/bu/setbubble");
        tbHttpMessageTask.setResponsedClass(ResponseSetBubbleMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.f);
    }

    public void e() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.f);
        messageManager.unRegisterListener(this.e);
    }

    public void b(CustomMessageListener customMessageListener) {
        MessageManager.getInstance().unRegisterListener(customMessageListener);
    }
}
