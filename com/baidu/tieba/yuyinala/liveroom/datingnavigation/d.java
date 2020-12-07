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
    private Context bJK;
    private BdUniqueId brR = BdUniqueId.gen();
    private final HttpMessageListener bxC;
    private a oms;

    /* loaded from: classes4.dex */
    public interface a {
        void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.oms = aVar;
    }

    public d(Context context) {
        setUniqueId(this.brR);
        this.bJK = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031081, TbConfig.SERVER_ADDRESS + "ala/audio/xiangqin/activityStage");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(DatingStageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxC = new HttpMessageListener(1031081) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof DatingStageHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.getUniqueId() && d.this.oms != null) {
                    DatingStageHttpResponseMessage datingStageHttpResponseMessage = (DatingStageHttpResponseMessage) httpResponsedMessage;
                    if (datingStageHttpResponseMessage.getError() != 0 || !datingStageHttpResponseMessage.isSuccess()) {
                        d.this.oms.onFail(datingStageHttpResponseMessage.getError(), datingStageHttpResponseMessage.getErrorString());
                    } else {
                        d.this.oms.a(datingStageHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxC);
    }

    public void h(String str, String str2, String str3, int i) {
        c cVar = new c(str, str2, str3, i);
        cVar.setTag(this.brR);
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
