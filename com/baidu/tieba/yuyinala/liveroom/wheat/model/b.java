package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AddTimeHttpResponseMessage;
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    private TbPageContext mPageContext;
    private a ozQ;
    private HttpMessageListener messageListener = new HttpMessageListener(1031086) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AddTimeHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.brL && b.this.ozQ != null) {
                AddTimeHttpResponseMessage addTimeHttpResponseMessage = (AddTimeHttpResponseMessage) httpResponsedMessage;
                if (addTimeHttpResponseMessage.getError() != 0 || !addTimeHttpResponseMessage.isSuccess()) {
                    b.this.ozQ.onFail(addTimeHttpResponseMessage.getError(), addTimeHttpResponseMessage.getErrorString());
                } else {
                    b.this.ozQ.a(addTimeHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId brL = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void a(AddTimeHttpResponseMessage addTimeHttpResponseMessage);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.brL);
        this.mPageContext = tbPageContext;
        this.ozQ = aVar;
        bim();
        registerListener(this.messageListener);
    }

    private void bim() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031086, com.baidu.live.a.avU + "ala/audio/mode/addTime");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AddTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void A(String str, int i, int i2) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.a(str, i, i2));
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
