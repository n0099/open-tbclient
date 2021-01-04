package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
/* loaded from: classes11.dex */
public class j extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oEL;
    private HttpMessageListener messageListener = new HttpMessageListener(1031012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaManagerMikeHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == j.this.bwz && j.this.oEL != null) {
                AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage = (AlaManagerMikeHttpResponseMessage) httpResponsedMessage;
                if (alaManagerMikeHttpResponseMessage.getError() != 0 || !alaManagerMikeHttpResponseMessage.isSuccess()) {
                    j.this.oEL.b(alaManagerMikeHttpResponseMessage);
                } else {
                    j.this.oEL.a(alaManagerMikeHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage);

        void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage);
    }

    public j(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bwz);
        this.mPageContext = tbPageContext;
        this.oEL = aVar;
        bmf();
        registerListener(this.messageListener);
    }

    private void bmf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031012, com.baidu.live.a.aAH + "ala/audio/link/setMike");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaManagerMikeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aU(String str, String str2, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.j(str, str2, str3));
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
