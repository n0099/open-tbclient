package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a implements j, l {
    private static volatile a lKO;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lKP = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> lKQ = new AtomicReference<>(null);
    private boolean lKU = false;
    private boolean lKV = false;
    private CustomMessageListener lKW = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bCg().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> lKR = new HashMap<>();
    private int lKS = 0;
    private String lKT = dqK();

    public static a dqF() {
        if (lKO == null) {
            synchronized (a.class) {
                if (lKO == null) {
                    lKO = new a();
                }
            }
        }
        return lKO;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.lKW);
    }

    @Override // com.baidu.tieba.recapp.j
    public void dqG() {
        if (!this.lKU) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.lKP.get();
                    if (lVar != null) {
                        lVar.a(a.this.lKT, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eL */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.PI(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.lKR.put(fVar.forumName, fVar);
                                            a.this.lKU = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.lKP.get() == null) {
                new C0785a(this.lKP, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        dqL();
        f fVar = this.lKR.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.lKR.put(fVar.forumName, fVar);
        }
        fVar.ay(z, z2);
        G(this.lKR);
    }

    private synchronized void G(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.lKP.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject aca = entry.getValue().aca();
                if (aca != null) {
                    jSONArray.put(aca);
                }
            }
            lVar.asyncSet(this.lKT, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aT(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int aU(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.lKR.get(str);
        if (fVar == null || !PJ(dqK())) {
            return 0;
        }
        return fVar.ax(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> PI(String str) {
        ArrayList<f> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new f(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.recapp.l
    public void dqH() {
        if (!this.lKV) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.lKQ.get()).a(a.this.lKT, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eL */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.lKS = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.lKS = 0;
                                }
                                a.this.lKV = true;
                            }
                        }
                    });
                }
            };
            if (this.lKQ.get() == null) {
                new C0785a(this.lKQ, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void dqI() {
        com.baidu.adp.lib.cache.l<String> lVar = this.lKQ.get();
        if (lVar != null) {
            dqL();
            this.lKS++;
            lVar.asyncSet(this.lKT, Integer.toString(this.lKS), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int dqJ() {
        if (PJ(dqK())) {
            return this.lKS;
        }
        return 0;
    }

    private String dqK() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean PJ(String str) {
        if (TextUtils.isEmpty(this.lKT)) {
            return false;
        }
        return this.lKT.equals(str);
    }

    private void dqL() {
        String dqK = dqK();
        if (!PJ(dqK)) {
            this.lKR.clear();
            this.lKS = 0;
            this.lKT = dqK;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static final class C0785a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lLa;
        private final String lLb;
        private final Runnable lLc;

        private C0785a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.lLa = atomicReference;
            this.lLb = str;
            this.lLc = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.lLa.get() == null) {
                synchronized (C0785a.class) {
                    if (this.lLa.get() == null) {
                        this.lLa.set(com.baidu.tbadk.core.c.a.bhV().zT(this.lLb));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0785a) r2);
            if (this.lLc != null) {
                this.lLc.run();
            }
        }
    }
}
