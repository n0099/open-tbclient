package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.FrameNumCallBackHttpResponseMessage;
/* loaded from: classes11.dex */
public class g extends BdBaseModel {
    private TbPageContext mPageContext;
    private a oKh;
    private HttpMessageListener messageListener = new HttpMessageListener(1031090) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FrameNumCallBackHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == g.this.aCW && g.this.oKh != null) {
                FrameNumCallBackHttpResponseMessage frameNumCallBackHttpResponseMessage = (FrameNumCallBackHttpResponseMessage) httpResponsedMessage;
                if (frameNumCallBackHttpResponseMessage.getError() != 0 || !frameNumCallBackHttpResponseMessage.isSuccess()) {
                    g.this.oKh.onFail(frameNumCallBackHttpResponseMessage.getError(), frameNumCallBackHttpResponseMessage.getErrorString());
                } else {
                    g.this.oKh.a(frameNumCallBackHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void a(FrameNumCallBackHttpResponseMessage frameNumCallBackHttpResponseMessage);

        void onFail(int i, String str);
    }

    public g(TbPageContext tbPageContext, a aVar) {
        setUniqueId(this.aCW);
        this.mPageContext = tbPageContext;
        this.oKh = aVar;
        zH();
        registerListener(this.messageListener);
    }

    private void zH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031090, com.baidu.live.a.avJ + "/ala/audio/phoneframe/numCallBack");
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
