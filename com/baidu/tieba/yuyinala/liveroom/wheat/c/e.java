package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class e extends BdBaseModel {
    private TbPageContext mPageContext;
    private a nYQ;
    private HttpMessageListener messageListener = new HttpMessageListener(1031011) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEndConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.bnb && e.this.nYQ != null) {
                AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage = (AlaEndConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaEndConnectionWheatHttpResponseMessage.getError() != 0 || !alaEndConnectionWheatHttpResponseMessage.isSuccess()) {
                    e.this.nYQ.onFail(alaEndConnectionWheatHttpResponseMessage.getError(), alaEndConnectionWheatHttpResponseMessage.getErrorString());
                } else {
                    e.this.nYQ.a(alaEndConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bnb = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage);

        void onFail(int i, String str);
    }

    public e(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bnb);
        this.mPageContext = tbPageContext;
        this.nYQ = aVar;
        beS();
        registerListener(this.messageListener);
    }

    private void beS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031011, TbConfig.SERVER_ADDRESS + "ala/audio/link/end");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaEndConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gN(String str, String str2) {
        a(str, str2, 0, null);
    }

    public void a(String str, String str2, int i, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.d(str, str2, i, str3));
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
