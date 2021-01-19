package com.baidu.tieba.yuyinala.liveroom.publishlover;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    private Context bJM;
    private BdUniqueId brL = BdUniqueId.gen();
    private final HttpMessageListener bxB;
    private a onQ;

    /* loaded from: classes10.dex */
    public interface a {
        void a(PublishLoverHttpResponseMessage publishLoverHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(a aVar) {
        this.onQ = aVar;
    }

    public b(Context context) {
        setUniqueId(this.brL);
        this.bJM = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031082, com.baidu.live.a.avU + "ala/audio/xiangqin/publish");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(PublishLoverHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bxB = new HttpMessageListener(1031082) { // from class: com.baidu.tieba.yuyinala.liveroom.publishlover.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof PublishLoverHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId() && b.this.onQ != null) {
                    PublishLoverHttpResponseMessage publishLoverHttpResponseMessage = (PublishLoverHttpResponseMessage) httpResponsedMessage;
                    if (publishLoverHttpResponseMessage.getError() != 0 || !publishLoverHttpResponseMessage.isSuccess()) {
                        b.this.onQ.onFail(publishLoverHttpResponseMessage.getError(), publishLoverHttpResponseMessage.getErrorString());
                    } else {
                        b.this.onQ.a(publishLoverHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bxB);
    }

    public void m(String str, String str2, String str3, int i) {
        com.baidu.tieba.yuyinala.liveroom.publishlover.a aVar = new com.baidu.tieba.yuyinala.liveroom.publishlover.a(str, str2, str3, i);
        aVar.setTag(this.brL);
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
