package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
/* loaded from: classes11.dex */
public class e extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oJD;
    private HttpMessageListener messageListener = new HttpMessageListener(1031010) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaCancelApplyOrCancelInviteHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.aCW && e.this.oJD != null) {
                AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage = (AlaCancelApplyOrCancelInviteHttpResponseMessage) httpResponsedMessage;
                if (alaCancelApplyOrCancelInviteHttpResponseMessage.getError() != 0 || !alaCancelApplyOrCancelInviteHttpResponseMessage.isSuccess()) {
                    e.this.oJD.onFail(alaCancelApplyOrCancelInviteHttpResponseMessage.getError(), alaCancelApplyOrCancelInviteHttpResponseMessage.getErrorString());
                } else {
                    e.this.oJD.a(alaCancelApplyOrCancelInviteHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage);

        void onFail(int i, String str);
    }

    public e(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aCW);
        this.mPageContext = tbPageContext;
        this.oJD = aVar;
        zH();
        registerListener(this.messageListener);
    }

    private void zH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031010, com.baidu.live.a.avJ + "ala/audio/link/cancel");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCancelApplyOrCancelInviteHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void gY(String str, String str2) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.d(str, str2));
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
