package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class c extends BdBaseModel {
    private BdUniqueId aCW = BdUniqueId.gen();
    private final HttpMessageListener bBe;
    private Context bNw;
    private a ovc;

    /* loaded from: classes11.dex */
    public interface a {
        void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.ovc = aVar;
    }

    public c(Context context) {
        setUniqueId(this.aCW);
        this.bNw = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031081, com.baidu.live.a.avJ + "ala/audio/xiangqin/activityStage");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(DatingStageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bBe = new HttpMessageListener(1031081) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof DatingStageHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.getUniqueId() && c.this.ovc != null) {
                    DatingStageHttpResponseMessage datingStageHttpResponseMessage = (DatingStageHttpResponseMessage) httpResponsedMessage;
                    if (datingStageHttpResponseMessage.getError() != 0 || !datingStageHttpResponseMessage.isSuccess()) {
                        c.this.ovc.onFail(datingStageHttpResponseMessage.getError(), datingStageHttpResponseMessage.getErrorString());
                    } else {
                        c.this.ovc.a(datingStageHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bBe);
    }

    public void m(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, str3, i);
        bVar.setTag(this.aCW);
        sendMessage(bVar);
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
