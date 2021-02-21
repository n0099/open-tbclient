package com.baidu.tieba.yuyinala.liveroom.rename;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class e extends BdBaseModel {
    private BdUniqueId aCW = BdUniqueId.gen();
    private final HttpMessageListener bBe;
    private Context bNw;
    private a oyN;

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage);

        void n(int i, String str, String str2);
    }

    public void a(a aVar) {
        this.oyN = aVar;
    }

    public e(Context context) {
        this.bNw = context;
        setUniqueId(this.aCW);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031020, com.baidu.live.a.avJ + "ala/audio/room/modify");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRoomNameRenameHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bBe = new HttpMessageListener(1031020) { // from class: com.baidu.tieba.yuyinala.liveroom.rename.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetRoomNameRenameHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.oyN != null) {
                    AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage = (AlaGetRoomNameRenameHttpResponseMessage) httpResponsedMessage;
                    if (alaGetRoomNameRenameHttpResponseMessage.getError() != 0 || !alaGetRoomNameRenameHttpResponseMessage.isSuccess()) {
                        e.this.oyN.n(alaGetRoomNameRenameHttpResponseMessage.getError(), alaGetRoomNameRenameHttpResponseMessage.getErrorString(), alaGetRoomNameRenameHttpResponseMessage.ebO().usermsg);
                    } else {
                        e.this.oyN.a(alaGetRoomNameRenameHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bBe);
    }

    public void e(String str, int i, String str2, String str3) {
        com.baidu.tieba.yuyinala.liveroom.rename.a aVar = new com.baidu.tieba.yuyinala.liveroom.rename.a(str, i, str2, str3);
        aVar.setTag(this.aCW);
        sendMessage(aVar);
    }

    public void f(String str, int i, String str2, String str3) {
        com.baidu.tieba.yuyinala.liveroom.rename.a aVar = new com.baidu.tieba.yuyinala.liveroom.rename.a(str, i, str2, str3);
        aVar.setTag(this.aCW);
        sendMessage(aVar);
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
