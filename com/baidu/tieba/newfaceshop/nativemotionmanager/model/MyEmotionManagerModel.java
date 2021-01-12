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
/* loaded from: classes8.dex */
public class MyEmotionManagerModel extends NativeManageEmotionModel implements com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a {
    private TbPageContext<BaseFragmentActivity> jVw;
    private a.InterfaceC0813a lvf;
    private List<String> lvg;
    private List<EmotionPackageData> lvh;
    private CustomMessageListener lvi;
    private final HttpMessageListener lvj;

    public MyEmotionManagerModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.lvi = new CustomMessageListener(CmdConfigCustom.CMD_SWAP_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                    Pair pair = (Pair) customResponsedMessage.getData();
                    MyEmotionManagerModel.this.db(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
                }
            }
        };
        this.lvj = new HttpMessageListener(1003385) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003385 && (httpResponsedMessage instanceof EmotionManageResponseMessage)) {
                    EmotionManageResponseMessage emotionManageResponseMessage = (EmotionManageResponseMessage) httpResponsedMessage;
                    if (MyEmotionManagerModel.this.lvf != null) {
                        if (emotionManageResponseMessage.data != null) {
                            MyEmotionManagerModel.this.lvh.clear();
                            if (emotionManageResponseMessage.data.data != null) {
                                MyEmotionManagerModel.this.lvh.addAll(emotionManageResponseMessage.data.data);
                            }
                            Pair fd = MyEmotionManagerModel.this.fd(emotionManageResponseMessage.data.data);
                            MyEmotionManagerModel.this.lvf.onSuccess(new Pair(fd.first, fd.second));
                            return;
                        }
                        MyEmotionManagerModel.this.lvf.onFail();
                    }
                }
            }
        };
        this.jVw = tbPageContext;
        this.lvg = new ArrayList();
        this.lvh = new ArrayList();
        registerTask();
        this.lvj.setTag(getUniqueId());
        this.lvj.setSelfListener(true);
        registerListener(this.lvj);
        registerListener(this.lvi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void db(int i, int i2) {
        try {
            this.lvg.add(i2, this.lvg.remove(i));
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
        List<String> dha = dha();
        for (String str2 : dha) {
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
            if (emotionPackageData.status == 1 && !dha.contains(String.valueOf(emotionPackageData.id))) {
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
        com.baidu.tieba.newfaceshop.a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.3
            @Override // java.lang.Runnable
            public void run() {
                MyEmotionManagerModel.this.dgZ();
                List<MyEmotionGroupData> dgl = c.dgk().dgl();
                JSONArray jSONArray = new JSONArray();
                if (dgl != null && !dgl.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : dgl) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            MyEmotionManagerModel.this.Oe(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                e.mB().post(new a(MyEmotionManagerModel.this, jSONArray));
            }
        });
        return false;
    }

    public void dgY() {
        com.baidu.tieba.newfaceshop.a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.4
            @Override // java.lang.Runnable
            public void run() {
                MyEmotionManagerModel.this.dgZ();
                List<MyEmotionGroupData> dgl = c.dgk().dgl();
                JSONArray jSONArray = new JSONArray();
                if (dgl != null && !dgl.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : dgl) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            MyEmotionManagerModel.this.Oe(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                if (MyEmotionManagerModel.this.lvf != null) {
                    Pair fd = MyEmotionManagerModel.this.fd(MyEmotionManagerModel.this.lvh);
                    MyEmotionManagerModel.this.lvf.onSuccess(new Pair(fd.first, fd.second));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dgZ() {
        this.lvg.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Oe(String str) {
        this.lvg.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized List<String> dha() {
        return new ArrayList(this.lvg);
    }

    public void dhb() {
        if (this.lvj != null) {
            MessageManager.getInstance().unRegisterListener(this.lvj);
        }
        if (this.lvi != null) {
            MessageManager.getInstance().unRegisterListener(this.lvi);
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private WeakReference<MyEmotionManagerModel> lvl;
        private JSONArray lvm;

        public a(MyEmotionManagerModel myEmotionManagerModel, JSONArray jSONArray) {
            this.lvl = new WeakReference<>(myEmotionManagerModel);
            this.lvm = jSONArray;
            if (this.lvm == null) {
                this.lvm = new JSONArray();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            MyEmotionManagerModel myEmotionManagerModel = this.lvl.get();
            if (myEmotionManagerModel != null) {
                HttpMessage httpMessage = new HttpMessage(1003385);
                httpMessage.addParam("ids", this.lvm);
                myEmotionManagerModel.sendMessage(httpMessage);
            }
        }
    }

    public void loadData() {
        LoadData();
    }

    public void dgS() {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.5
            @Override // java.lang.Runnable
            public void run() {
                if (MyEmotionManagerModel.this.lvf != null) {
                    MyEmotionManagerModel.this.lvf.dgS();
                    if (!com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().bKD()) {
                        MyEmotionManagerModel.this.dhc();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhc() {
        if (d.dgo().dgr()) {
            l.showToast(this.jVw.getPageActivity(), R.string.face_group_is_syncing);
        } else {
            com.baidu.tieba.newfaceshop.a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel.6
                @Override // java.lang.Runnable
                public void run() {
                    c.dgk().v(MyEmotionManagerModel.this.dha(), true);
                }
            });
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a.InterfaceC0813a interfaceC0813a) {
        this.lvf = interfaceC0813a;
    }
}
