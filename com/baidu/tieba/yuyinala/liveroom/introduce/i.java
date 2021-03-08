package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.content.Context;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class i extends BdBaseModel {
    private final HttpMessageListener bCE;
    private Context bOW;
    private a oyK;

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.oyK = aVar;
    }

    public i(Context context) {
        this.bOW = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031021, com.baidu.live.a.axj + "ala/audio/room/gameIntroduct");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRoomPlayIntroduceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bCE = new HttpMessageListener(1031021) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetRoomPlayIntroduceHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == i.this.getUniqueId() && i.this.oyK != null) {
                    AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage = (AlaGetRoomPlayIntroduceHttpResponseMessage) httpResponsedMessage;
                    if (alaGetRoomPlayIntroduceHttpResponseMessage.getError() != 0 || !alaGetRoomPlayIntroduceHttpResponseMessage.isSuccess()) {
                        i.this.oyK.onFail(alaGetRoomPlayIntroduceHttpResponseMessage.getError(), alaGetRoomPlayIntroduceHttpResponseMessage.getErrorString());
                    } else {
                        i.this.oyK.a(alaGetRoomPlayIntroduceHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bCE);
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
