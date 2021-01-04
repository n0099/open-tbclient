package com.baidu.tieba.yuyinala.c;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class e extends BdBaseModel {
    private final HttpMessageListener bCn;
    private Context bOy;
    private BdUniqueId bwz = BdUniqueId.gen();
    private a oGP;

    /* loaded from: classes11.dex */
    public interface a {
        void a(JsonHttpResponsedMessage jsonHttpResponsedMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.oGP = aVar;
    }

    public e(Context context) {
        this.bOy = context;
        setUniqueId(this.bwz);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031018, com.baidu.live.a.aAH + "ala/audio/room/follow");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bCn = new HttpMessageListener(1031018) { // from class: com.baidu.tieba.yuyinala.c.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof JsonHttpResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.oGP != null) {
                    JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                    if (jsonHttpResponsedMessage.getError() != 0 || !jsonHttpResponsedMessage.isSuccess()) {
                        e.this.oGP.onFail(jsonHttpResponsedMessage.getError(), jsonHttpResponsedMessage.getErrorString());
                    } else {
                        e.this.oGP.a(jsonHttpResponsedMessage);
                    }
                }
            }
        };
        registerListener(this.bCn);
    }

    public void y(String str, String str2, int i) {
        com.baidu.tieba.yuyinala.data.e eVar = new com.baidu.tieba.yuyinala.data.e(str, str2, i);
        eVar.setTag(this.bwz);
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
