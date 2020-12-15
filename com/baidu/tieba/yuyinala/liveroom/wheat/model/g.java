package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaInviteConnectionWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class g extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oxP;
    private HttpMessageListener messageListener = new HttpMessageListener(1031008) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaInviteConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == g.this.brR && g.this.oxP != null) {
                AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage = (AlaInviteConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaInviteConnectionWheatHttpResponseMessage.getError() != 0 || !alaInviteConnectionWheatHttpResponseMessage.isSuccess()) {
                    g.this.oxP.b(alaInviteConnectionWheatHttpResponseMessage);
                } else {
                    g.this.oxP.a(alaInviteConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId brR = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage);

        void b(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage);
    }

    public g(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.brR);
        this.mPageContext = tbPageContext;
        this.oxP = aVar;
        bjQ();
        registerListener(this.messageListener);
    }

    private void bjQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031008, TbConfig.SERVER_ADDRESS + "ala/audio/link/invite");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaInviteConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aQ(String str, String str2, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.g(str, str2, str3));
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
