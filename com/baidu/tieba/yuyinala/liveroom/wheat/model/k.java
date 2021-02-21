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
public class k extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oKp;
    private HttpMessageListener messageListener = new HttpMessageListener(1031012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaManagerMikeHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == k.this.aCW && k.this.oKp != null) {
                AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage = (AlaManagerMikeHttpResponseMessage) httpResponsedMessage;
                if (alaManagerMikeHttpResponseMessage.getError() != 0 || !alaManagerMikeHttpResponseMessage.isSuccess()) {
                    k.this.oKp.b(alaManagerMikeHttpResponseMessage);
                } else {
                    k.this.oKp.a(alaManagerMikeHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage);

        void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage);
    }

    public k(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aCW);
        this.mPageContext = tbPageContext;
        this.oKp = aVar;
        zH();
        registerListener(this.messageListener);
    }

    private void zH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031012, com.baidu.live.a.avJ + "ala/audio/link/setMike");
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
