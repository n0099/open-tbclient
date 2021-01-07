package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class e extends BdBaseModel {
    private final HttpMessageListener bCn;
    private Context bOy;
    private BdUniqueId bwz = BdUniqueId.gen();
    private a oqM;

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage);

        void n(int i, String str, String str2);
    }

    public void a(a aVar) {
        this.oqM = aVar;
    }

    public e(Context context) {
        this.bOy = context;
        setUniqueId(this.bwz);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031034, com.baidu.live.a.aAH + "ala/audio/room/modifyGame");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaModifyRoomIntroduceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bCn = new HttpMessageListener(1031034) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaModifyRoomIntroduceHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.oqM != null) {
                    AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage = (AlaModifyRoomIntroduceHttpResponseMessage) httpResponsedMessage;
                    if (alaModifyRoomIntroduceHttpResponseMessage.getError() == 0 && alaModifyRoomIntroduceHttpResponseMessage.isSuccess()) {
                        e.this.oqM.a(alaModifyRoomIntroduceHttpResponseMessage);
                    } else {
                        e.this.oqM.n(alaModifyRoomIntroduceHttpResponseMessage.getError(), alaModifyRoomIntroduceHttpResponseMessage.getErrorString(), alaModifyRoomIntroduceHttpResponseMessage.edb().oqO.usermsg);
                    }
                }
            }
        };
        registerListener(this.bCn);
    }

    public void K(String str, String str2, String str3, String str4) {
        b bVar = new b(str, str2, str3, str4);
        bVar.setTag(this.bwz);
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
