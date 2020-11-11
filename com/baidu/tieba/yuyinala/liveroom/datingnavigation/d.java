package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    private Context bGn;
    private BdUniqueId bou = BdUniqueId.gen();
    private final HttpMessageListener bug;
    private a nVR;

    /* loaded from: classes4.dex */
    public interface a {
        void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.nVR = aVar;
    }

    public d(Context context) {
        setUniqueId(this.bou);
        this.bGn = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031081, TbConfig.SERVER_ADDRESS + "ala/audio/xiangqin/activityStage");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(DatingStageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bug = new HttpMessageListener(1031081) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof DatingStageHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.getUniqueId() && d.this.nVR != null) {
                    DatingStageHttpResponseMessage datingStageHttpResponseMessage = (DatingStageHttpResponseMessage) httpResponsedMessage;
                    if (datingStageHttpResponseMessage.getError() != 0 || !datingStageHttpResponseMessage.isSuccess()) {
                        d.this.nVR.onFail(datingStageHttpResponseMessage.getError(), datingStageHttpResponseMessage.getErrorString());
                    } else {
                        d.this.nVR.a(datingStageHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bug);
    }

    public void h(String str, String str2, String str3, int i) {
        c cVar = new c(str, str2, str3, i);
        cVar.setTag(this.bou);
        sendMessage(cVar);
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
