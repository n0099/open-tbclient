package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    private BdUniqueId brL = BdUniqueId.gen();
    private final HttpMessageListener bxB;
    private a opG;

    /* loaded from: classes10.dex */
    public interface a {
        void a(TimeSettingResponseMessage timeSettingResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.opG = aVar;
    }

    public b(Context context) {
        setUniqueId(this.brL);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031085, com.baidu.live.a.avU + "ala/audio/mode/changeStage");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(TimeSettingResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxB = new HttpMessageListener(1031085) { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof TimeSettingResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId() && b.this.opG != null) {
                    TimeSettingResponseMessage timeSettingResponseMessage = (TimeSettingResponseMessage) httpResponsedMessage;
                    if (timeSettingResponseMessage.getError() != 0 || !timeSettingResponseMessage.isSuccess()) {
                        b.this.opG.onFail(timeSettingResponseMessage.getError(), timeSettingResponseMessage.getErrorString());
                    } else {
                        b.this.opG.a(timeSettingResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxB);
    }

    public void A(String str, int i, int i2) {
        c cVar = new c(i, i2, str);
        cVar.setTag(this.brL);
        sendMessage(cVar);
    }

    public void d(String str, int i, int i2, int i3, String str2, String str3) {
        c cVar = new c(i, i2, str, i3, Integer.parseInt(str2), Integer.parseInt(str3));
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
