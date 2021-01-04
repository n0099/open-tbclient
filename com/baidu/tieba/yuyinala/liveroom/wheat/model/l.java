package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaWheatSwitchHttpResponseMessage;
/* loaded from: classes11.dex */
public class l extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oEP;
    private HttpMessageListener messageListener = new HttpMessageListener(1031026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaWheatSwitchHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == l.this.bwz && l.this.oEP != null) {
                AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage = (AlaWheatSwitchHttpResponseMessage) httpResponsedMessage;
                if (alaWheatSwitchHttpResponseMessage.getError() != 0 || !alaWheatSwitchHttpResponseMessage.isSuccess()) {
                    l.this.oEP.b(alaWheatSwitchHttpResponseMessage);
                } else {
                    l.this.oEP.a(alaWheatSwitchHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage);

        void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage);
    }

    public l(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bwz);
        this.mPageContext = tbPageContext;
        this.oEP = aVar;
        bmf();
        registerListener(this.messageListener);
    }

    private void bmf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031026, com.baidu.live.a.aAH + "ala/audio/link/switch");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaWheatSwitchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gS(String str, String str2) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.l(str, str2));
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
