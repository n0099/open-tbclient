package com.baidu.tieba.yuyinala.liveroom.chooselover;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private Context bEC;
    private BdUniqueId bmJ = BdUniqueId.gen();
    private final HttpMessageListener bst;
    private InterfaceC0907a nWI;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.chooselover.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0907a {
        void a(ChooseLoverHttpResponseMessage chooseLoverHttpResponseMessage);

        void onFail(int i, String str);
    }

    public void a(InterfaceC0907a interfaceC0907a) {
        this.nWI = interfaceC0907a;
    }

    public a(Context context) {
        setUniqueId(this.bmJ);
        this.bEC = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031080, TbConfig.SERVER_ADDRESS + "ala/audio/xiangqin/chooser");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(ChooseLoverHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.bst = new HttpMessageListener(1031080) { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChooseLoverHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId() && a.this.nWI != null) {
                    ChooseLoverHttpResponseMessage chooseLoverHttpResponseMessage = (ChooseLoverHttpResponseMessage) httpResponsedMessage;
                    if (chooseLoverHttpResponseMessage.getError() != 0 || !chooseLoverHttpResponseMessage.isSuccess()) {
                        a.this.nWI.onFail(chooseLoverHttpResponseMessage.getError(), chooseLoverHttpResponseMessage.getErrorString());
                    } else {
                        a.this.nWI.a(chooseLoverHttpResponseMessage);
                    }
                }
            }
        };
        registerListener(this.bst);
    }

    public void h(String str, String str2, String str3, int i) {
        c cVar = new c(str, str2, str3, i);
        cVar.setTag(this.bmJ);
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
