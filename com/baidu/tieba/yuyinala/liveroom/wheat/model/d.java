package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oxH;
    private HttpMessageListener messageListener = new HttpMessageListener(1031010) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaCancelApplyOrCancelInviteHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.brR && d.this.oxH != null) {
                AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage = (AlaCancelApplyOrCancelInviteHttpResponseMessage) httpResponsedMessage;
                if (alaCancelApplyOrCancelInviteHttpResponseMessage.getError() != 0 || !alaCancelApplyOrCancelInviteHttpResponseMessage.isSuccess()) {
                    d.this.oxH.onFail(alaCancelApplyOrCancelInviteHttpResponseMessage.getError(), alaCancelApplyOrCancelInviteHttpResponseMessage.getErrorString());
                } else {
                    d.this.oxH.a(alaCancelApplyOrCancelInviteHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId brR = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage);

        void onFail(int i, String str);
    }

    public d(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.brR);
        this.mPageContext = tbPageContext;
        this.oxH = aVar;
        bjQ();
        registerListener(this.messageListener);
    }

    private void bjQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031010, TbConfig.SERVER_ADDRESS + "ala/audio/link/cancel");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCancelApplyOrCancelInviteHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gU(String str, String str2) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.c(str, str2));
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
