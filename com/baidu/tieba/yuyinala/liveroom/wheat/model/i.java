package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaLinkCallBackHttpResponseMessage;
/* loaded from: classes11.dex */
public class i extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oEI;
    private HttpMessageListener messageListener = new HttpMessageListener(1031027) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaLinkCallBackHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == i.this.bwz && i.this.oEI != null) {
                AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage = (AlaLinkCallBackHttpResponseMessage) httpResponsedMessage;
                if (alaLinkCallBackHttpResponseMessage.getError() != 0 || !alaLinkCallBackHttpResponseMessage.isSuccess()) {
                    i.this.oEI.b(alaLinkCallBackHttpResponseMessage);
                } else {
                    i.this.oEI.a(alaLinkCallBackHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage);

        void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage);
    }

    public i(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bwz);
        this.mPageContext = tbPageContext;
        this.oEI = aVar;
        bmg();
        registerListener(this.messageListener);
    }

    private void bmg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031027, com.baidu.live.a.aAH + "ala/audio/link/callback");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLinkCallBackHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request(String str) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.i(str));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.messageListener);
    }
}
