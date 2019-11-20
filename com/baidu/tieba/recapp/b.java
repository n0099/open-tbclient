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
    private static volatile b iGC;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iGD = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iGE = new AtomicReference<>(null);
    private boolean iGI = false;
    private boolean iGJ = false;
    private CustomMessageListener iGK = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aDw().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iGF = new HashMap<>();
    private int iGG = 0;
    private String iGH = cfy();

    public static b cft() {
        if (iGC == null) {
            synchronized (b.class) {
                if (iGC == null) {
                    iGC = new b();
                }
            }
        }
        return iGC;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iGK);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cfu() {
        if (!this.iGI) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iGD.get();
                    if (lVar != null) {
                        lVar.a(b.this.iGH, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cP */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Cv(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iGF.put(gVar.forumName, gVar);
                                            b.this.iGI = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iGD.get() == null) {
                new a(this.iGD, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cfz();
        g gVar = this.iGF.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iGF.put(gVar.forumName, gVar);
        }
        gVar.aj(z, z2);
        t(this.iGF);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iGD.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject cfC = entry.getValue().cfC();
                if (cfC != null) {
                    jSONArray.put(cfC);
                }
            }
            lVar.asyncSet(this.iGH, jSONArray.toString(), 86400000L);
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
        g gVar = this.iGF.get(str);
        if (gVar == null || !Cw(cfy())) {
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
    public void cfv() {
        if (!this.iGJ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iGE.get()).a(b.this.iGH, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cP */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iGG = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iGG = 0;
                                }
                                b.this.iGJ = true;
                            }
                        }
                    });
                }
            };
            if (this.iGE.get() == null) {
                new a(this.iGE, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cfw() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iGE.get();
        if (lVar != null) {
            cfz();
            this.iGG++;
            lVar.asyncSet(this.iGH, Integer.toString(this.iGG), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cfx() {
        if (Cw(cfy())) {
            return this.iGG;
        }
        return 0;
    }

    private String cfy() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Cw(String str) {
        if (TextUtils.isEmpty(this.iGH)) {
            return false;
        }
        return this.iGH.equals(str);
    }

    private void cfz() {
        String cfy = cfy();
        if (!Cw(cfy)) {
            this.iGF.clear();
            this.iGG = 0;
            this.iGH = cfy;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iGO;
        private final String iGP;
        private final Runnable iGQ;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.iGO = atomicReference;
            this.iGP = str;
            this.iGQ = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.iGO.get() == null) {
                synchronized (a.class) {
                    if (this.iGO.get() == null) {
                        this.iGO.set(com.baidu.tbadk.core.d.a.akL().nl(this.iGP));
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
            if (this.iGQ != null) {
                this.iGQ.run();
            }
        }
    }
}
