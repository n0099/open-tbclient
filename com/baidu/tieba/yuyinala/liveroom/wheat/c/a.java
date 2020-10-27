package com.baidu.tieba.yuyinala.liveroom.wheat.c;

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
    private InterfaceC0908a nYI;
    private HttpMessageListener messageListener = new HttpMessageListener(1031009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaAcceptConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.bnb && a.this.nYI != null) {
                AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage = (AlaAcceptConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaAcceptConnectionWheatHttpResponseMessage.getError() != 0 || !alaAcceptConnectionWheatHttpResponseMessage.isSuccess()) {
                    a.this.nYI.b(alaAcceptConnectionWheatHttpResponseMessage);
                } else {
                    a.this.nYI.a(alaAcceptConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId bnb = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0908a {
        void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);

        void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);
    }

    public a(TbPageContext tbPageContext, InterfaceC0908a interfaceC0908a) {
        setUniqueId(this.bnb);
        this.mPageContext = tbPageContext;
        this.nYI = interfaceC0908a;
        beS();
        registerListener(this.messageListener);
    }

    private void beS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031009, TbConfig.SERVER_ADDRESS + "ala/audio/link/accept");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAcceptConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aL(String str, String str2, String str3) {
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
