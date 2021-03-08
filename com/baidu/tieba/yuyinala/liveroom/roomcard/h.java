package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class h extends BdBaseModel {
    private BdUniqueId aEw = BdUniqueId.gen();
    private final HttpMessageListener bCE;
    private Context bOW;
    private a oBM;

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.oBM = aVar;
    }

    public h(Context context) {
        this.bOW = context;
        setUniqueId(this.aEw);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031018, com.baidu.live.a.axj + "ala/audio/room/follow");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetCollectRoomHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bCE = new HttpMessageListener(1031018) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetCollectRoomHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == h.this.getUniqueId() && h.this.oBM != null) {
                    AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage = (AlaGetCollectRoomHttpResponseMessage) httpResponsedMessage;
                    if (alaGetCollectRoomHttpResponseMessage.getError() != 0 || !alaGetCollectRoomHttpResponseMessage.isSuccess()) {
                        h.this.oBM.onFail(alaGetCollectRoomHttpResponseMessage.getError(), alaGetCollectRoomHttpResponseMessage.getErrorString());
                    } else {
                        h.this.oBM.a(alaGetCollectRoomHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bCE);
    }

    public void y(String str, String str2, int i) {
        b bVar = new b(str, str2, i);
        bVar.setTag(this.aEw);
        sendMessage(bVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bCE);
        MessageManager.getInstance().unRegisterTask(1031018);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
