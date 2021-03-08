package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaInviteConnectionWheatHttpResponseMessage;
/* loaded from: classes10.dex */
public class i extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oMq;
    private HttpMessageListener messageListener = new HttpMessageListener(1031008) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaInviteConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == i.this.aEw && i.this.oMq != null) {
                AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage = (AlaInviteConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaInviteConnectionWheatHttpResponseMessage.getError() != 0 || !alaInviteConnectionWheatHttpResponseMessage.isSuccess()) {
                    i.this.oMq.b(alaInviteConnectionWheatHttpResponseMessage);
                } else {
                    i.this.oMq.a(alaInviteConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage);

        void b(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage);
    }

    public i(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aEw);
        this.mPageContext = tbPageContext;
        this.oMq = aVar;
        zK();
        registerListener(this.messageListener);
    }

    private void zK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031008, com.baidu.live.a.axj + "ala/audio/link/invite");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaInviteConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aU(String str, String str2, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.h(str, str2, str3));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
