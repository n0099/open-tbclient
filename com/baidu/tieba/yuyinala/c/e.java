package com.baidu.tieba.yuyinala.c;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class e extends BdBaseModel {
    private Context bAc;
    private BdUniqueId bnb = BdUniqueId.gen();
    private final HttpMessageListener bsK;
    private a nZK;

    /* loaded from: classes4.dex */
    public interface a {
        void a(JsonHttpResponsedMessage jsonHttpResponsedMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.nZK = aVar;
    }

    public e(Context context) {
        this.bAc = context;
        setUniqueId(this.bnb);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031018, TbConfig.SERVER_ADDRESS + "ala/audio/room/follow");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bsK = new HttpMessageListener(1031018) { // from class: com.baidu.tieba.yuyinala.c.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof JsonHttpResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.nZK != null) {
                    JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                    if (jsonHttpResponsedMessage.getError() != 0 || !jsonHttpResponsedMessage.isSuccess()) {
                        e.this.nZK.onFail(jsonHttpResponsedMessage.getError(), jsonHttpResponsedMessage.getErrorString());
                    } else {
                        e.this.nZK.a(jsonHttpResponsedMessage);
                    }
                }
            }
        };
        registerListener(this.bsK);
    }

    public void v(String str, String str2, int i) {
        com.baidu.tieba.yuyinala.data.e eVar = new com.baidu.tieba.yuyinala.data.e(str, str2, i);
        eVar.setTag(this.bnb);
        sendMessage(eVar);
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
