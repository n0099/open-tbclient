package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private TbPageContext mPageContext;
    private InterfaceC0958a oEs;
    private HttpMessageListener messageListener = new HttpMessageListener(1031009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaAcceptConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.bwz && a.this.oEs != null) {
                AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage = (AlaAcceptConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaAcceptConnectionWheatHttpResponseMessage.getError() != 0 || !alaAcceptConnectionWheatHttpResponseMessage.isSuccess()) {
                    a.this.oEs.b(alaAcceptConnectionWheatHttpResponseMessage);
                } else {
                    a.this.oEs.a(alaAcceptConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0958a {
        void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);

        void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);
    }

    public a(TbPageContext tbPageContext, InterfaceC0958a interfaceC0958a) {
        setUniqueId(this.bwz);
        this.mPageContext = tbPageContext;
        this.oEs = interfaceC0958a;
        bmg();
        registerListener(this.messageListener);
    }

    private void bmg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031009, com.baidu.live.a.aAH + "ala/audio/link/accept");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAcceptConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aU(String str, String str2, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.b(str, str2, str3));
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
