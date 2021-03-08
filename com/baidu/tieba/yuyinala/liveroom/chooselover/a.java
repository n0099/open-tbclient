package com.baidu.tieba.yuyinala.liveroom.chooselover;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private BdUniqueId aEw = BdUniqueId.gen();
    private final HttpMessageListener bCE;
    private Context bOW;
    private InterfaceC0931a owv;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.chooselover.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0931a {
        void a(ChooseLoverHttpResponseMessage chooseLoverHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(InterfaceC0931a interfaceC0931a) {
        this.owv = interfaceC0931a;
    }

    public a(Context context) {
        setUniqueId(this.aEw);
        this.bOW = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031080, com.baidu.live.a.axj + "ala/audio/xiangqin/chooser");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(ChooseLoverHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bCE = new HttpMessageListener(1031080) { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChooseLoverHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId() && a.this.owv != null) {
                    ChooseLoverHttpResponseMessage chooseLoverHttpResponseMessage = (ChooseLoverHttpResponseMessage) httpResponsedMessage;
                    if (chooseLoverHttpResponseMessage.getError() != 0 || !chooseLoverHttpResponseMessage.isSuccess()) {
                        a.this.owv.onFail(chooseLoverHttpResponseMessage.getError(), chooseLoverHttpResponseMessage.getErrorString());
                    } else {
                        a.this.owv.a(chooseLoverHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bCE);
    }

    public void m(String str, String str2, String str3, int i) {
        c cVar = new c(str, str2, str3, i);
        cVar.setTag(this.aEw);
        sendMessage(cVar);
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
