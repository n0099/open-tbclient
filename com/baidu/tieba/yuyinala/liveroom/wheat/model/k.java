package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaWheatSwitchHttpResponseMessage;
/* loaded from: classes4.dex */
public class k extends BdBaseModel {
    private TbPageContext mPageContext;
    private a ohr;
    private HttpMessageListener messageListener = new HttpMessageListener(1031026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaWheatSwitchHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == k.this.bou && k.this.ohr != null) {
                AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage = (AlaWheatSwitchHttpResponseMessage) httpResponsedMessage;
                if (alaWheatSwitchHttpResponseMessage.getError() != 0 || !alaWheatSwitchHttpResponseMessage.isSuccess()) {
                    k.this.ohr.b(alaWheatSwitchHttpResponseMessage);
                } else {
                    k.this.ohr.a(alaWheatSwitchHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bou = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage);

        void b(AlaWheatSwitchHttpResponseMessage alaWheatSwitchHttpResponseMessage);
    }

    public k(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bou);
        this.mPageContext = tbPageContext;
        this.ohr = aVar;
        bhs();
        registerListener(this.messageListener);
    }

    private void bhs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031026, TbConfig.SERVER_ADDRESS + "ala/audio/link/switch");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaWheatSwitchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gP(String str, String str2) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.k(str, str2));
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
