package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
/* loaded from: classes10.dex */
public class h extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oMo;
    private HttpMessageListener messageListener = new HttpMessageListener(1031014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetInviteConnectionWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == h.this.aEw && h.this.oMo != null) {
                AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage = (AlaGetInviteConnectionWheatListHttpResponseMessage) httpResponsedMessage;
                if (alaGetInviteConnectionWheatListHttpResponseMessage.getError() != 0 || !alaGetInviteConnectionWheatListHttpResponseMessage.isSuccess()) {
                    h.this.oMo.onFail(alaGetInviteConnectionWheatListHttpResponseMessage.getError(), alaGetInviteConnectionWheatListHttpResponseMessage.getErrorString());
                } else {
                    h.this.oMo.a(alaGetInviteConnectionWheatListHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage);

        void onFail(int i, String str);
    }

    public h(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aEw);
        this.mPageContext = tbPageContext;
        this.oMo = aVar;
        zK();
        registerListener(this.messageListener);
    }

    private void zK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031014, com.baidu.live.a.axj + "/ala/audio/link/getInvite");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetInviteConnectionWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.g(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp()));
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
