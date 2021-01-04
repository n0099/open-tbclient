package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
/* loaded from: classes11.dex */
public class g extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oEF;
    private HttpMessageListener messageListener = new HttpMessageListener(1031014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetInviteConnectionWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == g.this.bwz && g.this.oEF != null) {
                AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage = (AlaGetInviteConnectionWheatListHttpResponseMessage) httpResponsedMessage;
                if (alaGetInviteConnectionWheatListHttpResponseMessage.getError() != 0 || !alaGetInviteConnectionWheatListHttpResponseMessage.isSuccess()) {
                    g.this.oEF.onFail(alaGetInviteConnectionWheatListHttpResponseMessage.getError(), alaGetInviteConnectionWheatListHttpResponseMessage.getErrorString());
                } else {
                    g.this.oEF.a(alaGetInviteConnectionWheatListHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage);

        void onFail(int i, String str);
    }

    public g(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bwz);
        this.mPageContext = tbPageContext;
        this.oEF = aVar;
        bmf();
        registerListener(this.messageListener);
    }

    private void bmf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031014, com.baidu.live.a.aAH + "/ala/audio/link/getInvite");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetInviteConnectionWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.g(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq()));
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
        MessageManager.getInstance().unRegisterTask(1031014);
    }
}
