package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import android.util.Pair;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.c;
import com.baidu.tieba.newfaceshop.d;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.EmotionManageResponseMessage;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.NativeManageEmotionModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class MyEmotionManagerModel extends NativeManageEmotionModel implements com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a {
    private TbPageContext<BaseFragmentActivity> kab;
    private a.InterfaceC0830a lzL;
    private List<String> lzM;
    private List<EmotionPackageData> lzN;
    private CustomMessageListener lzO;
    private final HttpMessageListener lzP;

    public MyEmotionManagerModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.lzO = new CustomMessageListener(CmdConfigCustom.CMD_SWAP_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                    Pair pair = (Pair) customResponsedMessage.getData();
                    MyEmotionManagerModel.this.db(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
                }
            }
        };
        this.lzP = new HttpMessageListener(1003385) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003385 && (httpResponsedMessage instanceof EmotionManageResponseMessage)) {
                    EmotionManageResponseMessage emotionManageResponseMessage = (EmotionManageResponseMessage) httpResponsedMessage;
                    if (MyEmotionManagerModel.this.lzL != null) {
                        if (emotionManageResponseMessage.data != null) {
                            MyEmotionManagerModel.this.lzN.clear();
                            if (emotionManageResponseMessage.data.data != null) {
                                MyEmotionManagerModel.this.lzN.addAll(emotionManageResponseMessage.data.data);
                            }
                            Pair fd = MyEmotionManagerModel.this.fd(emotionManageResponseMessage.data.data);
                            MyEmotionManagerModel.this.lzL.onSuccess(new Pair(fd.first, fd.second));
                            return;
                        }
                        MyEmotionManagerModel.this.lzL.onFail();
                    }
                }
            }
        };
        this.kab = tbPageContext;
        this.lzM = new ArrayList();
        this.lzN = new ArrayList();
        registerTask();
        this.lzP.setTag(getUniqueId());
        this.lzP.setSelfListener(true);
        registerListener(this.lzP);
        registerListener(this.lzO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void db(int i, int i2) {
        try {
            this.lzM.add(i2, this.lzM.remove(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<List<EmotionPackageData>, Integer> fd(List<EmotionPackageData> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null) {
            return new Pair<>(arrayList, 0);
        }
        int size = list.size();
        String id = TbadkCoreApplication.getCurrentAccountObj().getID();
        String str = id == null ? "" : id;
        List<String> dkS = dkS();
        for (String str2 : dkS) {
            EmotionPackageData m = m(str2, list);
            if (m != null) {
                m.ishasdownload = true;
                m.typeofemotion = a(m, str);
                arrayList.add(m);
            }
        }
        int size2 = arrayList.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EmotionPackageData emotionPackageData = list.get(i);
            if (emotionPackageData.status == 1 && !dkS.contains(String.valueOf(emotionPackageData.id))) {
                if (!z) {
                    emotionPackageData.isUndownloadheader = true;
                    z = true;
                }
                emotionPackageData.ishasdownload = false;
                emotionPackageData.typeofemotion = a(emotionPackageData, str);
                if (emotionPackageData.typeofemotion == 1) {
                    arrayList2.add(emotionPackageData);
                }
            }
        }
        arrayList.addAll(arrayList2);
        return new Pair<>(arrayList, Integer.valueOf(size2));
    }

    private synchronized int a(EmotionPackageData emotionPackageData, String str) {
        int i = 0;
        synchronized (this) {
            if (emotionPackageData != null) {
                if (str.equals(emotionPackageData.owner)) {
                    i = 1;
                } else if (emotionPackageData.forum_id > 0) {
                    i = 2;
                }
            }
        }
        return i;
    }

    private synchronized EmotionPackageData m(String str, List<EmotionPackageData> list) {
        EmotionPackageData emotionPackageData;
        if (str == null || list == null) {
            emotionPackageData = null;
        } else {
            try {
                Iterator<EmotionPackageData> it = list.iterator();
                while (it.hasNext()) {
                    emotionPackageData = it.next();
                    if (Integer.valueOf(str).intValue() == emotionPackageData.id) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            emotionPackageData = null;
        }
        return emotionPackageData;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003385, TbConfig.SERVER_ADDRESS + Config.EMOTION_MANAGER_GETMEME);
        tbHttpMessageTask.setResponsedClass(EmotionManageResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        com.baidu.tieba.newfaceshop.a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.3
            @Override // java.lang.Runnable
            public void run() {
                MyEmotionManagerModel.this.dkR();
                List<MyEmotionGroupData> dkd = c.dkc().dkd();
                JSONArray jSONArray = new JSONArray();
                if (dkd != null && !dkd.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : dkd) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            MyEmotionManagerModel.this.Pm(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                e.mB().post(new a(MyEmotionManagerModel.this, jSONArray));
            }
        });
        return false;
    }

    public void dkQ() {
        com.baidu.tieba.newfaceshop.a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.4
            @Override // java.lang.Runnable
            public void run() {
                MyEmotionManagerModel.this.dkR();
                List<MyEmotionGroupData> dkd = c.dkc().dkd();
                JSONArray jSONArray = new JSONArray();
                if (dkd != null && !dkd.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : dkd) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            MyEmotionManagerModel.this.Pm(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                if (MyEmotionManagerModel.this.lzL != null) {
                    Pair fd = MyEmotionManagerModel.this.fd(MyEmotionManagerModel.this.lzN);
                    MyEmotionManagerModel.this.lzL.onSuccess(new Pair(fd.first, fd.second));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dkR() {
        this.lzM.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Pm(String str) {
        this.lzM.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized List<String> dkS() {
        return new ArrayList(this.lzM);
    }

    public void dkT() {
        if (this.lzP != null) {
            MessageManager.getInstance().unRegisterListener(this.lzP);
        }
        if (this.lzO != null) {
            MessageManager.getInstance().unRegisterListener(this.lzO);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private WeakReference<MyEmotionManagerModel> lzR;
        private JSONArray lzS;

        public a(MyEmotionManagerModel myEmotionManagerModel, JSONArray jSONArray) {
            this.lzR = new WeakReference<>(myEmotionManagerModel);
            this.lzS = jSONArray;
            if (this.lzS == null) {
                this.lzS = new JSONArray();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            MyEmotionManagerModel myEmotionManagerModel = this.lzR.get();
            if (myEmotionManagerModel != null) {
                HttpMessage httpMessage = new HttpMessage(1003385);
                httpMessage.addParam("ids", this.lzS);
                myEmotionManagerModel.sendMessage(httpMessage);
            }
        }
    }

    public void loadData() {
        LoadData();
    }

    public void dkK() {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.5
            @Override // java.lang.Runnable
            public void run() {
                if (MyEmotionManagerModel.this.lzL != null) {
                    MyEmotionManagerModel.this.lzL.dkK();
                    if (!com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().bOv()) {
                        MyEmotionManagerModel.this.dkU();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkU() {
        if (d.dkg().dkj()) {
            l.showToast(this.kab.getPageActivity(), R.string.face_group_is_syncing);
        } else {
            com.baidu.tieba.newfaceshop.a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.6
                @Override // java.lang.Runnable
                public void run() {
                    c.dkc().v(MyEmotionManagerModel.this.dkS(), true);
                }
            });
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a.InterfaceC0830a interfaceC0830a) {
        this.lzL = interfaceC0830a;
    }
}
