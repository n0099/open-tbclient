package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.message.ResponseBubbleListMessage;
import com.baidu.tieba.message.ResponseSetBubbleMessage;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private h aje;
    private i ajf;
    private int bor;
    private int bos;
    private final HttpMessageListener bot;
    private final HttpMessageListener bou;

    public e(Context context) {
        super(context);
        this.bot = new f(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.bou = new g(this, CmdConfigHttp.SET_BUBBLE_CMD);
    }

    public void a(h hVar) {
        this.aje = hVar;
    }

    public void a(i iVar) {
        this.ajf = iVar;
    }

    public int Tg() {
        return this.bor;
    }

    public void gy(int i) {
        this.bor = i;
    }

    public int Th() {
        return this.bos;
    }

    public void gz(int i) {
        this.bos = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public static boolean ag(List<BubbleListData.BubbleData> list) {
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

    public void Ti() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REQUEST_BUBBLELIST_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/bu/getbubblelist");
        tbHttpMessageTask.setResponsedClass(ResponseBubbleListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bot);
    }

    public void h(int i, int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        httpMessage.addParam("pn", String.valueOf(i));
        httpMessage.addParam("rn", String.valueOf(i2));
        httpMessage.addParam("scr_w", String.valueOf(i3));
        httpMessage.addParam("scr_h", String.valueOf(i4));
        sendMessage(httpMessage);
    }

    public void p(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_BUBBLE_CMD);
        httpMessage.addParam("bcode", String.valueOf(i));
        httpMessage.addParam("scr_w", String.valueOf(i2));
        httpMessage.addParam("scr_h", String.valueOf(i3));
        sendMessage(httpMessage);
    }

    public void Tj() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_BUBBLE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/bu/setbubble");
        tbHttpMessageTask.setResponsedClass(ResponseSetBubbleMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bou);
    }

    public void unRegisterListener() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.bou);
        messageManager.unRegisterListener(this.bot);
    }

    public void b(CustomMessageListener customMessageListener) {
        MessageManager.getInstance().unRegisterListener(customMessageListener);
    }
}
