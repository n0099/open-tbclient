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
/* loaded from: classes11.dex */
public class b implements j, l {
    private static volatile b jEB;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jEC = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> jED = new AtomicReference<>(null);
    private boolean jEH = false;
    private boolean jEI = false;
    private CustomMessageListener jEJ = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aVI().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> jEE = new HashMap<>();
    private int jEF = 0;
    private String jEG = cAN();

    public static b cAI() {
        if (jEB == null) {
            synchronized (b.class) {
                if (jEB == null) {
                    jEB = new b();
                }
            }
        }
        return jEB;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.jEJ);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cAJ() {
        if (!this.jEH) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.jEC.get();
                    if (lVar != null) {
                        lVar.a(b.this.jEG, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dk */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Ht(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.jEE.put(gVar.forumName, gVar);
                                            b.this.jEH = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.jEC.get() == null) {
                new a(this.jEC, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cAO();
        g gVar = this.jEE.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.jEE.put(gVar.forumName, gVar);
        }
        gVar.ak(z, z2);
        s(this.jEE);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.jEC.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject GQ = entry.getValue().GQ();
                if (GQ != null) {
                    jSONArray.put(GQ);
                }
            }
            lVar.asyncSet(this.jEG, jSONArray.toString(), 86400000L);
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
        g gVar = this.jEE.get(str);
        if (gVar == null || !Hu(cAN())) {
            return 0;
        }
        return gVar.aj(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Ht(String str) {
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
    public void cAK() {
        if (!this.jEI) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.jED.get()).a(b.this.jEG, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dk */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.jEF = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.jEF = 0;
                                }
                                b.this.jEI = true;
                            }
                        }
                    });
                }
            };
            if (this.jED.get() == null) {
                new a(this.jED, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cAL() {
        com.baidu.adp.lib.cache.l<String> lVar = this.jED.get();
        if (lVar != null) {
            cAO();
            this.jEF++;
            lVar.asyncSet(this.jEG, Integer.toString(this.jEF), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cAM() {
        if (Hu(cAN())) {
            return this.jEF;
        }
        return 0;
    }

    private String cAN() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Hu(String str) {
        if (TextUtils.isEmpty(this.jEG)) {
            return false;
        }
        return this.jEG.equals(str);
    }

    private void cAO() {
        String cAN = cAN();
        if (!Hu(cAN)) {
            this.jEE.clear();
            this.jEF = 0;
            this.jEG = cAN;
        }
    }

    /* loaded from: classes11.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jEN;
        private final String jEO;
        private final Runnable jEP;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.jEN = atomicReference;
            this.jEO = str;
            this.jEP = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.jEN.get() == null) {
                synchronized (a.class) {
                    if (this.jEN.get() == null) {
                        this.jEN.set(com.baidu.tbadk.core.c.a.aCo().sA(this.jEO));
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
            if (this.jEP != null) {
                this.jEP.run();
            }
        }
    }
}
