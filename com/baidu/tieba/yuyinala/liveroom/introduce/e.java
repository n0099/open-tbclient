package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class e extends BdBaseModel {
    private Context bAc;
    private BdUniqueId bnb = BdUniqueId.gen();
    private final HttpMessageListener bsK;
    private a nPK;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage);

        void n(int i, String str, String str2);
    }

    public void a(a aVar) {
        this.nPK = aVar;
    }

    public e(Context context) {
        this.bAc = context;
        setUniqueId(this.bnb);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031034, TbConfig.SERVER_ADDRESS + "ala/audio/room/modifyGame");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaModifyRoomIntroduceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bsK = new HttpMessageListener(1031034) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaModifyRoomIntroduceHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.nPK != null) {
                    AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage = (AlaModifyRoomIntroduceHttpResponseMessage) httpResponsedMessage;
                    if (alaModifyRoomIntroduceHttpResponseMessage.getError() == 0 && alaModifyRoomIntroduceHttpResponseMessage.isSuccess()) {
                        e.this.nPK.a(alaModifyRoomIntroduceHttpResponseMessage);
                    } else {
                        e.this.nPK.n(alaModifyRoomIntroduceHttpResponseMessage.getError(), alaModifyRoomIntroduceHttpResponseMessage.getErrorString(), alaModifyRoomIntroduceHttpResponseMessage.dVq().nPM.usermsg);
                    }
                }
            }
        };
        registerListener(this.bsK);
    }

    public void L(String str, String str2, String str3, String str4) {
        b bVar = new b(str, str2, str3, str4);
        bVar.setTag(this.bnb);
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
