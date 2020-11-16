package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.content.Context;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class g extends BdBaseModel {
    private Context bEC;
    private final HttpMessageListener bst;
    private a obz;

    /* loaded from: classes4.dex */
    public interface a {
        void b(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.obz = aVar;
    }

    public g(Context context) {
        this.bEC = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031019, TbConfig.SERVER_ADDRESS + "ala/audio/room/showInfo");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRoomCardInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bst = new HttpMessageListener(1031019) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetRoomCardInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == g.this.getUniqueId() && g.this.obz != null) {
                    AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage = (AlaGetRoomCardInfoHttpResponseMessage) httpResponsedMessage;
                    if (alaGetRoomCardInfoHttpResponseMessage.getError() != 0 || !alaGetRoomCardInfoHttpResponseMessage.isSuccess()) {
                        g.this.obz.onFail(alaGetRoomCardInfoHttpResponseMessage.getError(), alaGetRoomCardInfoHttpResponseMessage.getErrorString());
                    } else {
                        g.this.obz.b(alaGetRoomCardInfoHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bst);
    }

    public void request(String str) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.roomcard.a(str));
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
