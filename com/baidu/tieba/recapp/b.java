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
    private static volatile b jEw;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jEx = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> jEy = new AtomicReference<>(null);
    private boolean jEC = false;
    private boolean jED = false;
    private CustomMessageListener jEE = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aVI().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> jEz = new HashMap<>();
    private int jEA = 0;
    private String jEB = cAL();

    public static b cAG() {
        if (jEw == null) {
            synchronized (b.class) {
                if (jEw == null) {
                    jEw = new b();
                }
            }
        }
        return jEw;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.jEE);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cAH() {
        if (!this.jEC) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.jEx.get();
                    if (lVar != null) {
                        lVar.a(b.this.jEB, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dk */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Ht(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.jEz.put(gVar.forumName, gVar);
                                            b.this.jEC = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.jEx.get() == null) {
                new a(this.jEx, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cAM();
        g gVar = this.jEz.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.jEz.put(gVar.forumName, gVar);
        }
        gVar.ak(z, z2);
        s(this.jEz);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.jEx.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject GQ = entry.getValue().GQ();
                if (GQ != null) {
                    jSONArray.put(GQ);
                }
            }
            lVar.asyncSet(this.jEB, jSONArray.toString(), 86400000L);
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
        g gVar = this.jEz.get(str);
        if (gVar == null || !Hu(cAL())) {
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
    public void cAI() {
        if (!this.jED) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.jEy.get()).a(b.this.jEB, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dk */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.jEA = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.jEA = 0;
                                }
                                b.this.jED = true;
                            }
                        }
                    });
                }
            };
            if (this.jEy.get() == null) {
                new a(this.jEy, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cAJ() {
        com.baidu.adp.lib.cache.l<String> lVar = this.jEy.get();
        if (lVar != null) {
            cAM();
            this.jEA++;
            lVar.asyncSet(this.jEB, Integer.toString(this.jEA), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cAK() {
        if (Hu(cAL())) {
            return this.jEA;
        }
        return 0;
    }

    private String cAL() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Hu(String str) {
        if (TextUtils.isEmpty(this.jEB)) {
            return false;
        }
        return this.jEB.equals(str);
    }

    private void cAM() {
        String cAL = cAL();
        if (!Hu(cAL)) {
            this.jEz.clear();
            this.jEA = 0;
            this.jEB = cAL;
        }
    }

    /* loaded from: classes11.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jEI;
        private final String jEJ;
        private final Runnable jEK;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.jEI = atomicReference;
            this.jEJ = str;
            this.jEK = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.jEI.get() == null) {
                synchronized (a.class) {
                    if (this.jEI.get() == null) {
                        this.jEI.set(com.baidu.tbadk.core.c.a.aCo().sA(this.jEJ));
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
            if (this.jEK != null) {
                this.jEK.run();
            }
        }
    }
}
