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
    private Context bJM;
    private BdUniqueId brL = BdUniqueId.gen();
    private final HttpMessageListener bxB;
    private a opp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.opp = aVar;
    }

    public h(Context context) {
        this.bJM = context;
        setUniqueId(this.brL);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031018, com.baidu.live.a.avU + "ala/audio/room/follow");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetCollectRoomHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxB = new HttpMessageListener(1031018) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetCollectRoomHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == h.this.getUniqueId() && h.this.opp != null) {
                    AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage = (AlaGetCollectRoomHttpResponseMessage) httpResponsedMessage;
                    if (alaGetCollectRoomHttpResponseMessage.getError() != 0 || !alaGetCollectRoomHttpResponseMessage.isSuccess()) {
                        h.this.opp.onFail(alaGetCollectRoomHttpResponseMessage.getError(), alaGetCollectRoomHttpResponseMessage.getErrorString());
                    } else {
                        h.this.opp.a(alaGetCollectRoomHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxB);
    }

    public void y(String str, String str2, int i) {
        b bVar = new b(str, str2, i);
        bVar.setTag(this.brL);
        sendMessage(bVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bxB);
        MessageManager.getInstance().unRegisterTask(1031018);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
