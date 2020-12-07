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
    private Context bJK;
    private BdUniqueId brR = BdUniqueId.gen();
    private final HttpMessageListener bxC;
    private a onw;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage);

        void p(int i, String str, String str2);
    }

    public void a(a aVar) {
        this.onw = aVar;
    }

    public e(Context context) {
        this.bJK = context;
        setUniqueId(this.brR);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031034, TbConfig.SERVER_ADDRESS + "ala/audio/room/modifyGame");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaModifyRoomIntroduceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxC = new HttpMessageListener(1031034) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaModifyRoomIntroduceHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.onw != null) {
                    AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage = (AlaModifyRoomIntroduceHttpResponseMessage) httpResponsedMessage;
                    if (alaModifyRoomIntroduceHttpResponseMessage.getError() == 0 && alaModifyRoomIntroduceHttpResponseMessage.isSuccess()) {
                        e.this.onw.a(alaModifyRoomIntroduceHttpResponseMessage);
                    } else {
                        e.this.onw.p(alaModifyRoomIntroduceHttpResponseMessage.getError(), alaModifyRoomIntroduceHttpResponseMessage.getErrorString(), alaModifyRoomIntroduceHttpResponseMessage.edI().ony.usermsg);
                    }
                }
            }
        };
        registerListener(this.bxC);
    }

    public void L(String str, String str2, String str3, String str4) {
        b bVar = new b(str, str2, str3, str4);
        bVar.setTag(this.brR);
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
