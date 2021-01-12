package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class d extends BdBaseModel {
    private Context bJM;
    private BdUniqueId brL = BdUniqueId.gen();
    private final HttpMessageListener bxB;
    private a okJ;

    /* loaded from: classes10.dex */
    public interface a {
        void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.okJ = aVar;
    }

    public d(Context context) {
        setUniqueId(this.brL);
        this.bJM = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031081, com.baidu.live.a.avU + "ala/audio/xiangqin/activityStage");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(DatingStageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxB = new HttpMessageListener(1031081) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof DatingStageHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.getUniqueId() && d.this.okJ != null) {
                    DatingStageHttpResponseMessage datingStageHttpResponseMessage = (DatingStageHttpResponseMessage) httpResponsedMessage;
                    if (datingStageHttpResponseMessage.getError() != 0 || !datingStageHttpResponseMessage.isSuccess()) {
                        d.this.okJ.onFail(datingStageHttpResponseMessage.getError(), datingStageHttpResponseMessage.getErrorString());
                    } else {
                        d.this.okJ.a(datingStageHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxB);
    }

    public void m(String str, String str2, String str3, int i) {
        c cVar = new c(str, str2, str3, i);
        cVar.setTag(this.brL);
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
