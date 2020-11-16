package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private TbPageContext mPageContext;
    private InterfaceC0927a oiA;
    private HttpMessageListener messageListener = new HttpMessageListener(1031009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaAcceptConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.bmJ && a.this.oiA != null) {
                AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage = (AlaAcceptConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaAcceptConnectionWheatHttpResponseMessage.getError() != 0 || !alaAcceptConnectionWheatHttpResponseMessage.isSuccess()) {
                    a.this.oiA.b(alaAcceptConnectionWheatHttpResponseMessage);
                } else {
                    a.this.oiA.a(alaAcceptConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bmJ = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0927a {
        void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);

        void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);
    }

    public a(TbPageContext tbPageContext, InterfaceC0927a interfaceC0927a) {
        setUniqueId(this.bmJ);
        this.mPageContext = tbPageContext;
        this.oiA = interfaceC0927a;
        bgL();
        registerListener(this.messageListener);
    }

    private void bgL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031009, TbConfig.SERVER_ADDRESS + "ala/audio/link/accept");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAcceptConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aN(String str, String str2, String str3) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.a(str, str2, str3));
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
