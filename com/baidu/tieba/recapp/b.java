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
    private static volatile b fWe;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> fWf = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> fWg = new AtomicReference<>(null);
    private boolean fWk = false;
    private boolean fWl = false;
    private CustomMessageListener fWm = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Nb().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> fWh = new HashMap<>();
    private int fWi = 0;
    private String fWj = bja();

    public static b biV() {
        if (fWe == null) {
            synchronized (b.class) {
                if (fWe == null) {
                    fWe = new b();
                }
            }
        }
        return fWe;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.fWm);
    }

    @Override // com.baidu.tieba.recapp.j
    public void biW() {
        if (!this.fWk) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.fWf.get();
                    if (lVar != null) {
                        lVar.a(b.this.fWj, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: aX */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.mp(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.fWh.put(gVar.forumName, gVar);
                                            b.this.fWk = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.fWf.get() == null) {
                synchronized (b.class) {
                    new a(this.fWf, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bjb();
        g gVar = this.fWh.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.fWh.put(gVar.forumName, gVar);
        }
        gVar.M(z, z2);
        m(this.fWh);
    }

    private synchronized void m(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.fWf.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bje = entry.getValue().bje();
                if (bje != null) {
                    jSONArray.put(bje);
                }
            }
            lVar.b(this.fWj, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int Q(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int R(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.fWh.get(str);
        if (gVar == null || !rO(bja())) {
            return 0;
        }
        return gVar.L(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> mp(String str) {
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
    public void biX() {
        if (!this.fWl) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.fWg.get()).a(b.this.fWj, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.fWi = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.fWi = 0;
                                }
                                b.this.fWl = true;
                            }
                        }
                    });
                }
            };
            if (this.fWg.get() == null) {
                synchronized (b.class) {
                    new a(this.fWg, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void biY() {
        com.baidu.adp.lib.cache.l<String> lVar = this.fWg.get();
        if (lVar != null) {
            bjb();
            this.fWi++;
            lVar.b(this.fWj, Integer.toString(this.fWi), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int biZ() {
        if (rO(bja())) {
            return this.fWi;
        }
        return 0;
    }

    private String bja() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean rO(String str) {
        if (TextUtils.isEmpty(this.fWj)) {
            return false;
        }
        return this.fWj.equals(str);
    }

    private void bjb() {
        String bja = bja();
        if (!rO(bja)) {
            this.fWh.clear();
            this.fWi = 0;
            this.fWj = bja;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> fWq;
        private final String fWr;
        private final Runnable fWs;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.fWq = atomicReference;
            this.fWr = str;
            this.fWs = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.fWq.get() == null) {
                synchronized (b.class) {
                    if (this.fWq.get() == null) {
                        this.fWq.set(com.baidu.tbadk.core.c.a.tz().cZ(this.fWr));
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
            if (this.fWs != null) {
                this.fWs.run();
            }
        }
    }
}
