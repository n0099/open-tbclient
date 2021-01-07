package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
/* loaded from: classes11.dex */
public class c extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oEw;
    private HttpMessageListener messageListener = new HttpMessageListener(1031006) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetApplyWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.bwz && c.this.oEw != null) {
                AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage = (AlaGetApplyWheatListHttpResponseMessage) httpResponsedMessage;
                if (alaGetApplyWheatListHttpResponseMessage.getError() != 0 || !alaGetApplyWheatListHttpResponseMessage.isSuccess()) {
                    c.this.oEw.onFail(alaGetApplyWheatListHttpResponseMessage.getError(), alaGetApplyWheatListHttpResponseMessage.getErrorString());
                } else {
                    c.this.oEw.a(alaGetApplyWheatListHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage);

        void onFail(int i, String str);
    }

    public c(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bwz);
        this.mPageContext = tbPageContext;
        this.oEw = aVar;
        bmg();
        registerListener(this.messageListener);
    }

    private void bmg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031006, com.baidu.live.a.aAH + "ala/audio/link/getApply");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetApplyWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.f(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq()));
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
