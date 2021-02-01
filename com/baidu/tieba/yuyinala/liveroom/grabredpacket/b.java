package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class b extends BdBaseModel {
    private final HttpMessageListener bBe;
    private a ouL;

    /* loaded from: classes11.dex */
    public interface a {
        void a(LootGiftHttpResponseMessage lootGiftHttpResponseMessage);

        void onFail(int i, String str);
    }

    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031083, com.baidu.live.a.avJ + "ala/audio/xiangqin/lootGift");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LootGiftHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bBe = new HttpMessageListener(1031083) { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof LootGiftHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId() && b.this.ouL != null) {
                    LootGiftHttpResponseMessage lootGiftHttpResponseMessage = (LootGiftHttpResponseMessage) httpResponsedMessage;
                    if (lootGiftHttpResponseMessage.getError() != 0 || !lootGiftHttpResponseMessage.isSuccess()) {
                        b.this.ouL.onFail(lootGiftHttpResponseMessage.getError(), lootGiftHttpResponseMessage.getErrorString());
                    } else {
                        b.this.ouL.a(lootGiftHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bBe);
    }

    public void j(String str, String str2, String str3, String str4, String str5, String str6) {
        sendMessage(new com.baidu.tieba.yuyinala.liveroom.grabredpacket.a(str, str2, str3, str4, str5, str6));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.ouL = aVar;
    }
}
