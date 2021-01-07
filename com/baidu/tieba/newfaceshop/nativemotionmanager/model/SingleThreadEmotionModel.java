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
    private a.InterfaceC0830a lzL;
    private final HttpMessageListener lzP = new HttpMessageListener(1003386) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.SingleThreadEmotionModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003386 && (httpResponsedMessage instanceof SingleThreadEmotionResponseMessage)) {
                SingleThreadEmotionResponseMessage singleThreadEmotionResponseMessage = (SingleThreadEmotionResponseMessage) httpResponsedMessage;
                if (SingleThreadEmotionModel.this.lzL != null) {
                    if (singleThreadEmotionResponseMessage.data != null) {
                        SingleThreadEmotionModel.this.lzL.onSuccess(SingleThreadEmotionModel.this.fe(singleThreadEmotionResponseMessage.data.pkg_list));
                    } else {
                        SingleThreadEmotionModel.this.lzL.onFail();
                    }
                }
            }
        }
    };
    private List<String> lzM = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public List<EmotionPackageData> fe(List<EmotionPackageData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            List<String> dkS = dkS();
            for (EmotionPackageData emotionPackageData : list) {
                if (emotionPackageData.status == 5 || emotionPackageData.status == 1) {
                    if (emotionPackageData.status == 1 && dkS.contains(String.valueOf(emotionPackageData.id))) {
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
        this.lzP.setTag(getUniqueId());
        this.lzP.setSelfListener(true);
        registerListener(this.lzP);
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private WeakReference<SingleThreadEmotionModel> lzU;

        public a(SingleThreadEmotionModel singleThreadEmotionModel) {
            this.lzU = new WeakReference<>(singleThreadEmotionModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleThreadEmotionModel singleThreadEmotionModel = this.lzU.get();
            if (singleThreadEmotionModel != null) {
                singleThreadEmotionModel.sendMessage(new HttpMessage(1003386));
            }
        }
    }

    public void a(a.InterfaceC0830a interfaceC0830a) {
        this.lzL = interfaceC0830a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        com.baidu.tieba.newfaceshop.a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.SingleThreadEmotionModel.2
            @Override // java.lang.Runnable
            public void run() {
                SingleThreadEmotionModel.this.dkR();
                List<MyEmotionGroupData> dkd = c.dkc().dkd();
                JSONArray jSONArray = new JSONArray();
                if (dkd != null && !dkd.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : dkd) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            SingleThreadEmotionModel.this.Pm(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                e.mB().post(new a(SingleThreadEmotionModel.this));
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

    private synchronized List<String> dkS() {
        return new ArrayList(this.lzM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dkR() {
        this.lzM.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Pm(String str) {
        this.lzM.add(str);
    }

    public void dkT() {
        if (this.lzP != null) {
            MessageManager.getInstance().unRegisterListener(this.lzP);
        }
    }
}
