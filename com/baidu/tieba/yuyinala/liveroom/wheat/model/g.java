package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.FrameNumCallBackHttpResponseMessage;
/* loaded from: classes10.dex */
public class g extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oMm;
    private HttpMessageListener messageListener = new HttpMessageListener(1031090) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FrameNumCallBackHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == g.this.aEw && g.this.oMm != null) {
                FrameNumCallBackHttpResponseMessage frameNumCallBackHttpResponseMessage = (FrameNumCallBackHttpResponseMessage) httpResponsedMessage;
                if (frameNumCallBackHttpResponseMessage.getError() != 0 || !frameNumCallBackHttpResponseMessage.isSuccess()) {
                    g.this.oMm.onFail(frameNumCallBackHttpResponseMessage.getError(), frameNumCallBackHttpResponseMessage.getErrorString());
                } else {
                    g.this.oMm.a(frameNumCallBackHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void a(FrameNumCallBackHttpResponseMessage frameNumCallBackHttpResponseMessage);

        void onFail(int i, String str);
    }

    public g(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aEw);
        this.mPageContext = tbPageContext;
        this.oMm = aVar;
        zK();
        registerListener(this.messageListener);
    }

    private void zK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031090, com.baidu.live.a.axj + "/ala/audio/phoneframe/numCallBack");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrameNumCallBackHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request(String str) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.m(str));
    }

    public void ha(String str, String str2) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.wheat.message.m(str, str2));
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
