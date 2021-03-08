package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class f extends BdBaseModel {
    private a osA;
    private HttpMessageListener osB = new HttpMessageListener(1031039) { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof CancelBlockSpeakHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == f.this.getUniqueId()) {
                CancelBlockSpeakHttpResponseMessage cancelBlockSpeakHttpResponseMessage = (CancelBlockSpeakHttpResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    if (f.this.osA != null) {
                        f.this.osA.a(null);
                    }
                } else if (f.this.osA != null) {
                    f.this.osA.A(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void A(int i, String str);

        void a(com.baidu.tieba.yuyinala.charm.bannedpost.a aVar);
    }

    public void a(a aVar) {
        this.osA = aVar;
    }

    public f(Context context) {
        setUniqueId(this.aEw);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031039, com.baidu.live.a.axj + "ala/audio/live/blockIm");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(CancelBlockSpeakHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.osB);
    }

    public void l(String str, String str2, String str3, int i) {
        HttpMessage httpMessage = new HttpMessage(1031039);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("block_group_id", str2);
        httpMessage.addParam("block_user_uk", str3);
        httpMessage.addParam("block_type", i);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
