package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaOnLineHttpResponseMessage;
/* loaded from: classes11.dex */
public class l extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oKr;
    private HttpMessageListener messageListener = new HttpMessageListener(1031036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaOnLineHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == l.this.aCW && l.this.oKr != null) {
                AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage = (AlaOnLineHttpResponseMessage) httpResponsedMessage;
                if (alaOnLineHttpResponseMessage.getError() != 0 || !alaOnLineHttpResponseMessage.isSuccess()) {
                    l.this.oKr.onFail(alaOnLineHttpResponseMessage.getError(), alaOnLineHttpResponseMessage.getErrorString());
                } else {
                    l.this.oKr.a(alaOnLineHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage);

        void onFail(int i, String str);
    }

    public l(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aCW);
        this.mPageContext = tbPageContext;
        this.oKr = aVar;
        zH();
        registerListener(this.messageListener);
    }

    private void zH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031036, com.baidu.live.a.avJ + "ala/audio/link/isOnLine");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaOnLineHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.k());
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
