package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class c extends BdBaseModel {
    private a oqk;
    private HttpMessageListener gOS = new HttpMessageListener(1031038) { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof BannedListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.getUniqueId()) {
                BannedListHttpResponseMessage bannedListHttpResponseMessage = (BannedListHttpResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    if (c.this.oqk != null) {
                        c.this.oqk.a(bannedListHttpResponseMessage.ean());
                    }
                } else if (c.this.oqk != null) {
                    c.this.oqk.A(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    /* loaded from: classes11.dex */
    public interface a {
        void A(int i, String str);

        void a(com.baidu.tieba.yuyinala.charm.bannedpost.a aVar);
    }

    public void a(a aVar) {
        this.oqk = aVar;
    }

    public c(Context context) {
        setUniqueId(this.aCW);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031038, com.baidu.live.a.avJ + "ala/audio/live/blockList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(BannedListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gOS);
    }

    public void H(String str, String str2, String str3, String str4) {
        HttpMessage httpMessage = new HttpMessage(1031038);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("group_id", str2);
        httpMessage.addParam("room_id", str3);
        httpMessage.addParam("type", str4);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gOS);
        MessageManager.getInstance().unRegisterTask(1031038);
        cancelMessage();
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
