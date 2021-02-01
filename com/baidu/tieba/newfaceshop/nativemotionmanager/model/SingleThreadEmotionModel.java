package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.f.e;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.c;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.NativeManageEmotionModel;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.SingleThreadEmotionResponseMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class SingleThreadEmotionModel extends NativeManageEmotionModel implements com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a {
    private a.InterfaceC0814a lDj;
    private final HttpMessageListener lDn = new HttpMessageListener(1003386) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.SingleThreadEmotionModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003386 && (httpResponsedMessage instanceof SingleThreadEmotionResponseMessage)) {
                SingleThreadEmotionResponseMessage singleThreadEmotionResponseMessage = (SingleThreadEmotionResponseMessage) httpResponsedMessage;
                if (SingleThreadEmotionModel.this.lDj != null) {
                    if (singleThreadEmotionResponseMessage.data != null) {
                        SingleThreadEmotionModel.this.lDj.onSuccess(SingleThreadEmotionModel.this.fc(singleThreadEmotionResponseMessage.data.pkg_list));
                    } else {
                        SingleThreadEmotionModel.this.lDj.onFail();
                    }
                }
            }
        }
    };
    private List<String> lDk = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public List<EmotionPackageData> fc(List<EmotionPackageData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            List<String> djb = djb();
            for (EmotionPackageData emotionPackageData : list) {
                if (emotionPackageData.status == 5 || emotionPackageData.status == 1) {
                    if (emotionPackageData.status == 1 && djb.contains(String.valueOf(emotionPackageData.id))) {
                        emotionPackageData.ishasdownload = true;
                    }
                    arrayList.add(emotionPackageData);
                }
            }
        }
        return arrayList;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003386, TbConfig.SERVER_ADDRESS + Config.EMOTION_MANAGER_FORUMPACKAGE);
        tbHttpMessageTask.setResponsedClass(SingleThreadEmotionResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public SingleThreadEmotionModel() {
        registerTask();
        this.lDn.setTag(getUniqueId());
        this.lDn.setSelfListener(true);
        registerListener(this.lDn);
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private WeakReference<SingleThreadEmotionModel> lDs;

        public a(SingleThreadEmotionModel singleThreadEmotionModel) {
            this.lDs = new WeakReference<>(singleThreadEmotionModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleThreadEmotionModel singleThreadEmotionModel = this.lDs.get();
            if (singleThreadEmotionModel != null) {
                singleThreadEmotionModel.sendMessage(new HttpMessage(1003386));
            }
        }
    }

    public void a(a.InterfaceC0814a interfaceC0814a) {
        this.lDj = interfaceC0814a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.SingleThreadEmotionModel.2
            @Override // java.lang.Runnable
            public void run() {
                SingleThreadEmotionModel.this.dja();
                List<MyEmotionGroupData> dim = c.dil().dim();
                JSONArray jSONArray = new JSONArray();
                if (dim != null && !dim.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : dim) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            SingleThreadEmotionModel.this.OU(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                e.mA().post(new a(SingleThreadEmotionModel.this));
            }
        });
        return false;
    }

    public void loadData() {
        LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private synchronized List<String> djb() {
        return new ArrayList(this.lDk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dja() {
        this.lDk.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void OU(String str) {
        this.lDk.add(str);
    }

    public void djc() {
        if (this.lDn != null) {
            MessageManager.getInstance().unRegisterListener(this.lDn);
        }
    }
}
