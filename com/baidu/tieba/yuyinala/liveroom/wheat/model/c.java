package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaApplyWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oiE;
    private HttpMessageListener messageListener = new HttpMessageListener(1031007) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaApplyWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.bmJ && c.this.oiE != null) {
                AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage = (AlaApplyWheatHttpResponseMessage) httpResponsedMessage;
                if (alaApplyWheatHttpResponseMessage.getError() != 0 || !alaApplyWheatHttpResponseMessage.isSuccess()) {
                    c.this.oiE.c(alaApplyWheatHttpResponseMessage);
                } else {
                    c.this.oiE.b(alaApplyWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bmJ = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage);

        void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage);
    }

    public c(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bmJ);
        this.mPageContext = tbPageContext;
        this.oiE = aVar;
        bgL();
        registerListener(this.messageListener);
    }

    private void bgL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031007, TbConfig.SERVER_ADDRESS + "ala/audio/link/apply");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AlaApplyWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void L(String str, String str2, String str3, String str4) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.b(str, str2, str3, str4));
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
