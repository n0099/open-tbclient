package com.baidu.tieba.yuyinala.liveroom.rename;

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
    private a opN;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage);

        void p(int i, String str, String str2);
    }

    public void a(a aVar) {
        this.opN = aVar;
    }

    public e(Context context) {
        this.bJK = context;
        setUniqueId(this.brR);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031020, TbConfig.SERVER_ADDRESS + "ala/audio/room/modify");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRoomNameRenameHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxC = new HttpMessageListener(1031020) { // from class: com.baidu.tieba.yuyinala.liveroom.rename.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetRoomNameRenameHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == e.this.getUniqueId() && e.this.opN != null) {
                    AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage = (AlaGetRoomNameRenameHttpResponseMessage) httpResponsedMessage;
                    if (alaGetRoomNameRenameHttpResponseMessage.getError() != 0 || !alaGetRoomNameRenameHttpResponseMessage.isSuccess()) {
                        e.this.opN.p(alaGetRoomNameRenameHttpResponseMessage.getError(), alaGetRoomNameRenameHttpResponseMessage.getErrorString(), alaGetRoomNameRenameHttpResponseMessage.edS().usermsg);
                    } else {
                        e.this.opN.a(alaGetRoomNameRenameHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxC);
    }

    public void e(String str, int i, String str2, String str3) {
        com.baidu.tieba.yuyinala.liveroom.rename.a aVar = new com.baidu.tieba.yuyinala.liveroom.rename.a(str, i, str2, str3);
        aVar.setTag(this.brR);
        sendMessage(aVar);
    }

    public void f(String str, int i, String str2, String str3) {
        com.baidu.tieba.yuyinala.liveroom.rename.a aVar = new com.baidu.tieba.yuyinala.liveroom.rename.a(str, i, str2, str3);
        aVar.setTag(this.brR);
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
