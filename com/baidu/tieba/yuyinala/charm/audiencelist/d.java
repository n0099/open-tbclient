package com.baidu.tieba.yuyinala.charm.audiencelist;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class d extends BdBaseModel<YuyinALaAudiencesActivity> {
    private HttpMessageListener gOS;
    private b opI;
    private a opJ;

    /* loaded from: classes11.dex */
    public interface a {
        void A(int i, String str);

        void a(long j, b bVar);
    }

    public d(TbPageContext<YuyinALaAudiencesActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.gOS = new HttpMessageListener(1031031) { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof OnlineListHttpResponseMessage)) {
                    int error = httpResponsedMessage.getError();
                    long j = 0;
                    b bVar = null;
                    if (httpResponsedMessage instanceof OnlineListHttpResponseMessage) {
                        OnlineListHttpResponseMessage onlineListHttpResponseMessage = (OnlineListHttpResponseMessage) httpResponsedMessage;
                        j = onlineListHttpResponseMessage.bTQ();
                        bVar = onlineListHttpResponseMessage.eam();
                    }
                    if (error == 0) {
                        d.this.opI = bVar;
                        if (d.this.opJ != null) {
                            d.this.opJ.a(j, d.this.opI);
                        }
                    } else if (d.this.opJ != null) {
                        d.this.opJ.A(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.opJ = aVar;
        MessageManager.getInstance().registerListener(this.gOS);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031031, com.baidu.live.a.avJ + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(OnlineListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void VJ(String str) {
        HttpMessage httpMessage = new HttpMessage(1031031);
        httpMessage.addParam("live_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gOS);
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
