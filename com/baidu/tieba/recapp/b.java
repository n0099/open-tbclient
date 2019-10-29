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
/* loaded from: classes3.dex */
public class b implements j, l {
    private static volatile b iHt;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iHu = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iHv = new AtomicReference<>(null);
    private boolean iHz = false;
    private boolean iHA = false;
    private CustomMessageListener iHB = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aDy().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iHw = new HashMap<>();
    private int iHx = 0;
    private String iHy = cfA();

    public static b cfv() {
        if (iHt == null) {
            synchronized (b.class) {
                if (iHt == null) {
                    iHt = new b();
                }
            }
        }
        return iHt;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iHB);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cfw() {
        if (!this.iHz) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iHu.get();
                    if (lVar != null) {
                        lVar.a(b.this.iHy, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cP */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Cv(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iHw.put(gVar.forumName, gVar);
                                            b.this.iHz = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iHu.get() == null) {
                new a(this.iHu, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cfB();
        g gVar = this.iHw.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iHw.put(gVar.forumName, gVar);
        }
        gVar.aj(z, z2);
        t(this.iHw);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iHu.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject cfE = entry.getValue().cfE();
                if (cfE != null) {
                    jSONArray.put(cfE);
                }
            }
            lVar.asyncSet(this.iHy, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int as(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int at(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        g gVar = this.iHw.get(str);
        if (gVar == null || !Cw(cfA())) {
            return 0;
        }
        return gVar.ai(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Cv(String str) {
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
    public void cfx() {
        if (!this.iHA) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iHv.get()).a(b.this.iHy, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cP */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iHx = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iHx = 0;
                                }
                                b.this.iHA = true;
                            }
                        }
                    });
                }
            };
            if (this.iHv.get() == null) {
                new a(this.iHv, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cfy() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iHv.get();
        if (lVar != null) {
            cfB();
            this.iHx++;
            lVar.asyncSet(this.iHy, Integer.toString(this.iHx), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cfz() {
        if (Cw(cfA())) {
            return this.iHx;
        }
        return 0;
    }

    private String cfA() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Cw(String str) {
        if (TextUtils.isEmpty(this.iHy)) {
            return false;
        }
        return this.iHy.equals(str);
    }

    private void cfB() {
        String cfA = cfA();
        if (!Cw(cfA)) {
            this.iHw.clear();
            this.iHx = 0;
            this.iHy = cfA;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iHF;
        private final String iHG;
        private final Runnable iHH;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.iHF = atomicReference;
            this.iHG = str;
            this.iHH = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.iHF.get() == null) {
                synchronized (a.class) {
                    if (this.iHF.get() == null) {
                        this.iHF.set(com.baidu.tbadk.core.d.a.akN().nl(this.iHG));
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
            if (this.iHH != null) {
                this.iHH.run();
            }
        }
    }
}
