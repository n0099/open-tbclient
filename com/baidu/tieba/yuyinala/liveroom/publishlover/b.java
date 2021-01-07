package com.baidu.tieba.yuyinala.liveroom.publishlover;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class b extends BdBaseModel {
    private final HttpMessageListener bCn;
    private Context bOy;
    private BdUniqueId bwz = BdUniqueId.gen();
    private a osw;

    /* loaded from: classes11.dex */
    public interface a {
        void a(PublishLoverHttpResponseMessage publishLoverHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.osw = aVar;
    }

    public b(Context context) {
        setUniqueId(this.bwz);
        this.bOy = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031082, com.baidu.live.a.aAH + "ala/audio/xiangqin/publish");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(PublishLoverHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bCn = new HttpMessageListener(1031082) { // from class: com.baidu.tieba.yuyinala.liveroom.publishlover.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof PublishLoverHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId() && b.this.osw != null) {
                    PublishLoverHttpResponseMessage publishLoverHttpResponseMessage = (PublishLoverHttpResponseMessage) httpResponsedMessage;
                    if (publishLoverHttpResponseMessage.getError() != 0 || !publishLoverHttpResponseMessage.isSuccess()) {
                        b.this.osw.onFail(publishLoverHttpResponseMessage.getError(), publishLoverHttpResponseMessage.getErrorString());
                    } else {
                        b.this.osw.a(publishLoverHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bCn);
    }

    public void m(String str, String str2, String str3, int i) {
        com.baidu.tieba.yuyinala.liveroom.publishlover.a aVar = new com.baidu.tieba.yuyinala.liveroom.publishlover.a(str, str2, str3, i);
        aVar.setTag(this.bwz);
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
