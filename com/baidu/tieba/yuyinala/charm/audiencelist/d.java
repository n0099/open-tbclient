package com.baidu.tieba.yuyinala.charm.audiencelist;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class d extends BdBaseModel<YuyinALaAudiencesActivity> {
    private HttpMessageListener gER;
    private b oih;
    private a oii;

    /* loaded from: classes4.dex */
    public interface a {
        void a(long j, b bVar);

        void t(int i, String str);
    }

    public d(TbPageContext<YuyinALaAudiencesActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.gER = new HttpMessageListener(1031031) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof OnlineListHttpResponseMessage)) {
                    int error = httpResponsedMessage.getError();
                    long j = 0;
                    b bVar = null;
                    if (httpResponsedMessage instanceof OnlineListHttpResponseMessage) {
                        OnlineListHttpResponseMessage onlineListHttpResponseMessage = (OnlineListHttpResponseMessage) httpResponsedMessage;
                        j = onlineListHttpResponseMessage.bUs();
                        bVar = onlineListHttpResponseMessage.ecN();
                    }
                    if (error == 0) {
                        d.this.oih = bVar;
                        if (d.this.oii != null) {
                            d.this.oii.a(j, d.this.oih);
                        }
                    } else if (d.this.oii != null) {
                        d.this.oii.t(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.oii = aVar;
        MessageManager.getInstance().registerListener(this.gER);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031031, TbConfig.SERVER_ADDRESS + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(OnlineListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Wh(String str) {
        HttpMessage httpMessage = new HttpMessage(1031031);
        httpMessage.addParam("live_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gER);
        MessageManager.getInstance().unRegisterTask(1031031);
        cancelMessage();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
