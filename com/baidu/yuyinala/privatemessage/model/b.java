package com.baidu.yuyinala.privatemessage.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.yuyinala.privatemessage.model.response.NickNameListResponse;
import com.baidu.yuyinala.privatemessage.session.b.f;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends BdBaseModel {
    private a pcm;
    private HttpMessageListener pcn = new HttpMessageListener(1031060) { // from class: com.baidu.yuyinala.privatemessage.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof NickNameListResponse)) {
                if (httpResponsedMessage.getError() != 0 || !httpResponsedMessage.isSuccess()) {
                    if (b.this.pcm != null) {
                        b.this.pcm.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (b.this.pcm != null) {
                    b.this.pcm.gC(((NickNameListResponse) httpResponsedMessage).pcA);
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void gC(List<f> list);

        void onFail(int i, String str);
    }

    public b() {
        eob();
    }

    private void eob() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031060, com.baidu.live.a.aAH + "ala/audio/user/getUserInfo");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(NickNameListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.pcn);
    }

    public void a(String str, a aVar) {
        this.pcm = aVar;
        HttpMessage httpMessage = new HttpMessage(1031060);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("uks", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.pcn);
        MessageManager.getInstance().unRegisterTask(1031060);
    }
}
