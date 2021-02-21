package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaApplyWheatHttpResponseMessage;
/* loaded from: classes11.dex */
public class d extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oKb;
    private HttpMessageListener messageListener = new HttpMessageListener(1031007) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaApplyWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.aCW && d.this.oKb != null) {
                AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage = (AlaApplyWheatHttpResponseMessage) httpResponsedMessage;
                if (alaApplyWheatHttpResponseMessage.getError() != 0 || !alaApplyWheatHttpResponseMessage.isSuccess()) {
                    d.this.oKb.c(alaApplyWheatHttpResponseMessage);
                } else {
                    d.this.oKb.b(alaApplyWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage);

        void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage);
    }

    public d(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aCW);
        this.mPageContext = tbPageContext;
        this.oKb = aVar;
        zH();
        registerListener(this.messageListener);
    }

    private void zH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031007, com.baidu.live.a.avJ + "ala/audio/link/apply");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AlaApplyWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, String str2, String str3, long j, long j2, String str4) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.c(str, str2, str3, j, j2, str4));
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
