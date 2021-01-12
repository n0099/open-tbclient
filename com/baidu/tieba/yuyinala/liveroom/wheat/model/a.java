package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private TbPageContext mPageContext;
    private InterfaceC0941a ozN;
    private HttpMessageListener messageListener = new HttpMessageListener(1031009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaAcceptConnectionWheatHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.brL && a.this.ozN != null) {
                AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage = (AlaAcceptConnectionWheatHttpResponseMessage) httpResponsedMessage;
                if (alaAcceptConnectionWheatHttpResponseMessage.getError() != 0 || !alaAcceptConnectionWheatHttpResponseMessage.isSuccess()) {
                    a.this.ozN.b(alaAcceptConnectionWheatHttpResponseMessage);
                } else {
                    a.this.ozN.a(alaAcceptConnectionWheatHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId brL = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0941a {
        void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);

        void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage);
    }

    public a(TbPageContext tbPageContext, InterfaceC0941a interfaceC0941a) {
        setUniqueId(this.brL);
        this.mPageContext = tbPageContext;
        this.ozN = interfaceC0941a;
        bim();
        registerListener(this.messageListener);
    }

    private void bim() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031009, com.baidu.live.a.avU + "ala/audio/link/accept");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAcceptConnectionWheatHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aT(String str, String str2, String str3) {
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
