package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
/* loaded from: classes10.dex */
public class f extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oMk;
    private HttpMessageListener messageListener = new HttpMessageListener(1031011) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEndConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == f.this.aEw && f.this.oMk != null) {
                AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage = (AlaEndConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaEndConnectionWheatHttpResponseMessage.getError() != 0 || !alaEndConnectionWheatHttpResponseMessage.isSuccess()) {
                    f.this.oMk.onFail(alaEndConnectionWheatHttpResponseMessage.getError(), alaEndConnectionWheatHttpResponseMessage.getErrorString());
                } else {
                    f.this.oMk.a(alaEndConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage);

        void onFail(int i, String str);
    }

    public f(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aEw);
        this.mPageContext = tbPageContext;
        this.oMk = aVar;
        zK();
        registerListener(this.messageListener);
    }

    private void zK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031011, com.baidu.live.a.axj + "ala/audio/link/end");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaEndConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void ha(String str, String str2) {
        d(str, str2, 0, null);
    }

    public void d(String str, String str2, int i, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.e(str, str2, i, str3));
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
