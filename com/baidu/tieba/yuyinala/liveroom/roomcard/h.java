package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class h extends BdBaseModel {
    private Context bJK;
    private BdUniqueId brR = BdUniqueId.gen();
    private final HttpMessageListener bxC;
    private a oqD;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.oqD = aVar;
    }

    public h(Context context) {
        this.bJK = context;
        setUniqueId(this.brR);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031018, TbConfig.SERVER_ADDRESS + "ala/audio/room/follow");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetCollectRoomHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxC = new HttpMessageListener(1031018) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetCollectRoomHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == h.this.getUniqueId() && h.this.oqD != null) {
                    AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage = (AlaGetCollectRoomHttpResponseMessage) httpResponsedMessage;
                    if (alaGetCollectRoomHttpResponseMessage.getError() != 0 || !alaGetCollectRoomHttpResponseMessage.isSuccess()) {
                        h.this.oqD.onFail(alaGetCollectRoomHttpResponseMessage.getError(), alaGetCollectRoomHttpResponseMessage.getErrorString());
                    } else {
                        h.this.oqD.a(alaGetCollectRoomHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxC);
    }

    public void w(String str, String str2, int i) {
        b bVar = new b(str, str2, i);
        bVar.setTag(this.brR);
        sendMessage(bVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bxC);
        MessageManager.getInstance().unRegisterTask(1031018);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
