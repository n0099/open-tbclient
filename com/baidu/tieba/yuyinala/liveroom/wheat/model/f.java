package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
/* loaded from: classes4.dex */
public class f extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oiK;
    private HttpMessageListener messageListener = new HttpMessageListener(1031014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetInviteConnectionWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == f.this.bmJ && f.this.oiK != null) {
                AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage = (AlaGetInviteConnectionWheatListHttpResponseMessage) httpResponsedMessage;
                if (alaGetInviteConnectionWheatListHttpResponseMessage.getError() != 0 || !alaGetInviteConnectionWheatListHttpResponseMessage.isSuccess()) {
                    f.this.oiK.onFail(alaGetInviteConnectionWheatListHttpResponseMessage.getError(), alaGetInviteConnectionWheatListHttpResponseMessage.getErrorString());
                } else {
                    f.this.oiK.a(alaGetInviteConnectionWheatListHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bmJ = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage);

        void onFail(int i, String str);
    }

    public f(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bmJ);
        this.mPageContext = tbPageContext;
        this.oiK = aVar;
        bgL();
        registerListener(this.messageListener);
    }

    private void bgL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031014, TbConfig.SERVER_ADDRESS + "/ala/audio/link/getInvite");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetInviteConnectionWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.f(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br()));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterTask(1031014);
    }
}
