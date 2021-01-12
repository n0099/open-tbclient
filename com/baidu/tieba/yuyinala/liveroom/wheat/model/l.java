package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaWheatSwitchHttpResponseMessage;
/* loaded from: classes10.dex */
public class l extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oAj;
    private HttpMessageListener messageListener = new HttpMessageListener(1031026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaWheatSwitchHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == l.this.brL && l.this.oAj != null) {
                AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage = (AlaWheatSwitchHttpResponseMessage) httpResponsedMessage;
                if (alaWheatSwitchHttpResponseMessage.getError() != 0 || !alaWheatSwitchHttpResponseMessage.isSuccess()) {
                    l.this.oAj.b(alaWheatSwitchHttpResponseMessage);
                } else {
                    l.this.oAj.a(alaWheatSwitchHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId brL = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage);

        void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage);
    }

    public l(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.brL);
        this.mPageContext = tbPageContext;
        this.oAj = aVar;
        bim();
        registerListener(this.messageListener);
    }

    private void bim() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031026, com.baidu.live.a.avU + "ala/audio/link/switch");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaWheatSwitchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gR(String str, String str2) {
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
