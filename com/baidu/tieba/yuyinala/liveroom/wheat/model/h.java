package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaLinkCallBackHttpResponseMessage;
/* loaded from: classes4.dex */
public class h extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oiO;
    private HttpMessageListener messageListener = new HttpMessageListener(1031027) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaLinkCallBackHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == h.this.bmJ && h.this.oiO != null) {
                AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage = (AlaLinkCallBackHttpResponseMessage) httpResponsedMessage;
                if (alaLinkCallBackHttpResponseMessage.getError() != 0 || !alaLinkCallBackHttpResponseMessage.isSuccess()) {
                    h.this.oiO.b(alaLinkCallBackHttpResponseMessage);
                } else {
                    h.this.oiO.a(alaLinkCallBackHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bmJ = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage);

        void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage);
    }

    public h(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bmJ);
        this.mPageContext = tbPageContext;
        this.oiO = aVar;
        bgL();
        registerListener(this.messageListener);
    }

    private void bgL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031027, TbConfig.SERVER_ADDRESS + "ala/audio/link/callback");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLinkCallBackHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request(String str) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.h(str));
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
