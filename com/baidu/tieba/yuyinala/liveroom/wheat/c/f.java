package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
/* loaded from: classes4.dex */
public class f extends BdBaseModel {
    private TbPageContext mPageContext;
    private a nYS;
    private HttpMessageListener messageListener = new HttpMessageListener(1031014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetInviteConnectionWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == f.this.bnb && f.this.nYS != null) {
                AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage = (AlaGetInviteConnectionWheatListHttpResponseMessage) httpResponsedMessage;
                if (alaGetInviteConnectionWheatListHttpResponseMessage.getError() != 0 || !alaGetInviteConnectionWheatListHttpResponseMessage.isSuccess()) {
                    f.this.nYS.onFail(alaGetInviteConnectionWheatListHttpResponseMessage.getError(), alaGetInviteConnectionWheatListHttpResponseMessage.getErrorString());
                } else {
                    f.this.nYS.a(alaGetInviteConnectionWheatListHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bnb = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage);

        void onFail(int i, String str);
    }

    public f(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bnb);
        this.mPageContext = tbPageContext;
        this.nYS = aVar;
        beS();
        registerListener(this.messageListener);
    }

    private void beS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031014, TbConfig.SERVER_ADDRESS + "/ala/audio/link/getInvite");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetInviteConnectionWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.f(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa()));
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
