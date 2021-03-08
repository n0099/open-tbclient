package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class e extends BdBaseModel {
    private BdUniqueId aEw = BdUniqueId.gen();
    private final HttpMessageListener bCE;
    private Context bOW;
    private a oyD;

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage);

        void n(int i, String str, String str2);
    }

    public void a(a aVar) {
        this.oyD = aVar;
    }

    public e(Context context) {
        this.bOW = context;
        setUniqueId(this.aEw);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031034, com.baidu.live.a.axj + "ala/audio/room/modifyGame");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaModifyRoomIntroduceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bCE = new HttpMessageListener(1031034) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaModifyRoomIntroduceHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.oyD != null) {
                    AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage = (AlaModifyRoomIntroduceHttpResponseMessage) httpResponsedMessage;
                    if (alaModifyRoomIntroduceHttpResponseMessage.getError() == 0 && alaModifyRoomIntroduceHttpResponseMessage.isSuccess()) {
                        e.this.oyD.a(alaModifyRoomIntroduceHttpResponseMessage);
                    } else {
                        e.this.oyD.n(alaModifyRoomIntroduceHttpResponseMessage.getError(), alaModifyRoomIntroduceHttpResponseMessage.getErrorString(), alaModifyRoomIntroduceHttpResponseMessage.ebL().oyF.usermsg);
                    }
                }
            }
        };
        registerListener(this.bCE);
    }

    public void I(String str, String str2, String str3, String str4) {
        b bVar = new b(str, str2, str3, str4);
        bVar.setTag(this.aEw);
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
