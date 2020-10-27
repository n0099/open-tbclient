package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private TbPageContext mPageContext;
    private a nYK;
    private HttpMessageListener messageListener = new HttpMessageListener(1031006) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetApplyWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.bnb && b.this.nYK != null) {
                AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage = (AlaGetApplyWheatListHttpResponseMessage) httpResponsedMessage;
                if (alaGetApplyWheatListHttpResponseMessage.getError() != 0 || !alaGetApplyWheatListHttpResponseMessage.isSuccess()) {
                    b.this.nYK.onFail(alaGetApplyWheatListHttpResponseMessage.getError(), alaGetApplyWheatListHttpResponseMessage.getErrorString());
                } else {
                    b.this.nYK.a(alaGetApplyWheatListHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bnb = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bnb);
        this.mPageContext = tbPageContext;
        this.nYK = aVar;
        beS();
        registerListener(this.messageListener);
    }

    private void beS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031006, TbConfig.SERVER_ADDRESS + "ala/audio/link/getApply");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetApplyWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa()));
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
