package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.content.Context;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class i extends BdBaseModel {
    private Context bJK;
    private final HttpMessageListener bxC;
    private a onF;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.onF = aVar;
    }

    public i(Context context) {
        this.bJK = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031021, TbConfig.SERVER_ADDRESS + "ala/audio/room/gameIntroduct");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRoomPlayIntroduceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxC = new HttpMessageListener(1031021) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetRoomPlayIntroduceHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == i.this.getUniqueId() && i.this.onF != null) {
                    AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage = (AlaGetRoomPlayIntroduceHttpResponseMessage) httpResponsedMessage;
                    if (alaGetRoomPlayIntroduceHttpResponseMessage.getError() != 0 || !alaGetRoomPlayIntroduceHttpResponseMessage.isSuccess()) {
                        i.this.onF.onFail(alaGetRoomPlayIntroduceHttpResponseMessage.getError(), alaGetRoomPlayIntroduceHttpResponseMessage.getErrorString());
                    } else {
                        i.this.onF.a(alaGetRoomPlayIntroduceHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxC);
    }

    public void request(String str) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.introduce.a(str));
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
