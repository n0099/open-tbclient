package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes10.dex */
public class b implements j, l {
    private static volatile b jAU;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jAV = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> jAW = new AtomicReference<>(null);
    private boolean jBa = false;
    private boolean jBb = false;
    private CustomMessageListener jBc = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aVp().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> jAX = new HashMap<>();
    private int jAY = 0;
    private String jAZ = czE();

    public static b czz() {
        if (jAU == null) {
            synchronized (b.class) {
                if (jAU == null) {
                    jAU = new b();
                }
            }
        }
        return jAU;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.jBc);
    }

    @Override // com.baidu.tieba.recapp.j
    public void czA() {
        if (!this.jBa) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.jAV.get();
                    if (lVar != null) {
                        lVar.a(b.this.jAZ, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: di */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Hj(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.jAX.put(gVar.forumName, gVar);
                                            b.this.jBa = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.jAV.get() == null) {
                new a(this.jAV, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void g(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        czF();
        g gVar = this.jAX.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.jAX.put(gVar.forumName, gVar);
        }
        gVar.ak(z, z2);
        s(this.jAX);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.jAV.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject Gu = entry.getValue().Gu();
                if (Gu != null) {
                    jSONArray.put(Gu);
                }
            }
            lVar.asyncSet(this.jAZ, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int ax(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ay(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        g gVar = this.jAX.get(str);
        if (gVar == null || !Hk(czE())) {
            return 0;
        }
        return gVar.aj(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Hj(String str) {
        ArrayList<g> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new g(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.recapp.l
    public void czB() {
        if (!this.jBb) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.jAW.get()).a(b.this.jAZ, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: di */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.jAY = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.jAY = 0;
                                }
                                b.this.jBb = true;
                            }
                        }
                    });
                }
            };
            if (this.jAW.get() == null) {
                new a(this.jAW, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void czC() {
        com.baidu.adp.lib.cache.l<String> lVar = this.jAW.get();
        if (lVar != null) {
            czF();
            this.jAY++;
            lVar.asyncSet(this.jAZ, Integer.toString(this.jAY), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int czD() {
        if (Hk(czE())) {
            return this.jAY;
        }
        return 0;
    }

    private String czE() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Hk(String str) {
        if (TextUtils.isEmpty(this.jAZ)) {
            return false;
        }
        return this.jAZ.equals(str);
    }

    private void czF() {
        String czE = czE();
        if (!Hk(czE)) {
            this.jAX.clear();
            this.jAY = 0;
            this.jAZ = czE;
        }
    }

    /* loaded from: classes10.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jBg;
        private final String jBh;
        private final Runnable jBi;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.jBg = atomicReference;
            this.jBh = str;
            this.jBi = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.jBg.get() == null) {
                synchronized (a.class) {
                    if (this.jBg.get() == null) {
                        this.jBg.set(com.baidu.tbadk.core.c.a.aBV().sx(this.jBh));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((a) r2);
            if (this.jBi != null) {
                this.jBi.run();
            }
        }
    }
}
