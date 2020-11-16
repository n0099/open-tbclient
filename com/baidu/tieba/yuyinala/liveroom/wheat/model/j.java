package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaOnLineHttpResponseMessage;
/* loaded from: classes4.dex */
public class j extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oiS;
    private HttpMessageListener messageListener = new HttpMessageListener(1031036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaOnLineHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == j.this.bmJ && j.this.oiS != null) {
                AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage = (AlaOnLineHttpResponseMessage) httpResponsedMessage;
                if (alaOnLineHttpResponseMessage.getError() != 0 || !alaOnLineHttpResponseMessage.isSuccess()) {
                    j.this.oiS.onFail(alaOnLineHttpResponseMessage.getError(), alaOnLineHttpResponseMessage.getErrorString());
                } else {
                    j.this.oiS.a(alaOnLineHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bmJ = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage);

        void onFail(int i, String str);
    }

    public j(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.bmJ);
        this.mPageContext = tbPageContext;
        this.oiS = aVar;
        bgL();
        registerListener(this.messageListener);
    }

    private void bgL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031036, TbConfig.SERVER_ADDRESS + "ala/audio/link/isOnLine");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaOnLineHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.j());
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
    }
}
