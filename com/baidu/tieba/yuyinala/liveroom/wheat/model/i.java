package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaManagerMikeHttpResponseMessage;
/* loaded from: classes4.dex */
public class i extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oxT;
    private HttpMessageListener messageListener = new HttpMessageListener(1031012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaManagerMikeHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == i.this.brR && i.this.oxT != null) {
                AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage = (AlaManagerMikeHttpResponseMessage) httpResponsedMessage;
                if (alaManagerMikeHttpResponseMessage.getError() != 0 || !alaManagerMikeHttpResponseMessage.isSuccess()) {
                    i.this.oxT.b(alaManagerMikeHttpResponseMessage);
                } else {
                    i.this.oxT.a(alaManagerMikeHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId brR = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage);

        void b(AlaManagerMikeHttpResponseMessage alaManagerMikeHttpResponseMessage);
    }

    public i(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.brR);
        this.mPageContext = tbPageContext;
        this.oxT = aVar;
        bjQ();
        registerListener(this.messageListener);
    }

    private void bjQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031012, TbConfig.SERVER_ADDRESS + "ala/audio/link/setMike");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaManagerMikeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aQ(String str, String str2, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.i(str, str2, str3));
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
