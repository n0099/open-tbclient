package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
/* loaded from: classes10.dex */
public class c extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oMe;
    private HttpMessageListener messageListener = new HttpMessageListener(1031006) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetApplyWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.aEw && c.this.oMe != null) {
                AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage = (AlaGetApplyWheatListHttpResponseMessage) httpResponsedMessage;
                if (alaGetApplyWheatListHttpResponseMessage.getError() != 0 || !alaGetApplyWheatListHttpResponseMessage.isSuccess()) {
                    c.this.oMe.onFail(alaGetApplyWheatListHttpResponseMessage.getError(), alaGetApplyWheatListHttpResponseMessage.getErrorString());
                } else {
                    c.this.oMe.a(alaGetApplyWheatListHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage);

        void onFail(int i, String str);
    }

    public c(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aEw);
        this.mPageContext = tbPageContext;
        this.oMe = aVar;
        zK();
        registerListener(this.messageListener);
    }

    private void zK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031006, com.baidu.live.a.axj + "ala/audio/link/getApply");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetApplyWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.f(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp()));
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
