package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
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
    private static volatile b gBe;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gBf = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gBg = new AtomicReference<>(null);
    private boolean gBk = false;
    private boolean gBl = false;
    private CustomMessageListener gBm = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Uz().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gBh = new HashMap<>();
    private int gBi = 0;
    private String gBj = bnT();

    public static b bnO() {
        if (gBe == null) {
            synchronized (b.class) {
                if (gBe == null) {
                    gBe = new b();
                }
            }
        }
        return gBe;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gBm);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bnP() {
        if (!this.gBk) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gBf.get();
                    if (lVar != null) {
                        lVar.a(b.this.gBj, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: aX */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.mn(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gBh.put(gVar.forumName, gVar);
                                            b.this.gBk = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gBf.get() == null) {
                synchronized (b.class) {
                    new a(this.gBf, "frs.refresh.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            h(str, true, z);
        } else if (i == 2) {
            h(str, false, z);
        }
    }

    private void h(String str, boolean z, boolean z2) {
        bnU();
        g gVar = this.gBh.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gBh.put(gVar.forumName, gVar);
        }
        gVar.S(z, z2);
        l(this.gBh);
    }

    private synchronized void l(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gBf.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bnX = entry.getValue().bnX();
                if (bnX != null) {
                    jSONArray.put(bnX);
                }
            }
            lVar.b(this.gBj, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int U(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int V(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gBh.get(str);
        if (gVar == null || !rI(bnT())) {
            return 0;
        }
        return gVar.R(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> mn(String str) {
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
    public void bnQ() {
        if (!this.gBl) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gBg.get()).a(b.this.gBj, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gBi = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gBi = 0;
                                }
                                b.this.gBl = true;
                            }
                        }
                    });
                }
            };
            if (this.gBg.get() == null) {
                synchronized (b.class) {
                    new a(this.gBg, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bnR() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gBg.get();
        if (lVar != null) {
            bnU();
            this.gBi++;
            lVar.b(this.gBj, Integer.toString(this.gBi), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bnS() {
        if (rI(bnT())) {
            return this.gBi;
        }
        return 0;
    }

    private String bnT() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean rI(String str) {
        if (TextUtils.isEmpty(this.gBj)) {
            return false;
        }
        return this.gBj.equals(str);
    }

    private void bnU() {
        String bnT = bnT();
        if (!rI(bnT)) {
            this.gBh.clear();
            this.gBi = 0;
            this.gBj = bnT;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gBq;
        private final String gBr;
        private final Runnable gBs;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gBq = atomicReference;
            this.gBr = str;
            this.gBs = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gBq.get() == null) {
                synchronized (b.class) {
                    if (this.gBq.get() == null) {
                        this.gBq.set(com.baidu.tbadk.core.c.a.AQ().dh(this.gBr));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            if (this.gBs != null) {
                this.gBs.run();
            }
        }
    }
}
