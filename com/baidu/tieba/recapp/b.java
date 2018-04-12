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
    private static volatile b fWh;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> fWi = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> fWj = new AtomicReference<>(null);
    private boolean fWn = false;
    private boolean fWo = false;
    private CustomMessageListener fWp = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Nb().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> fWk = new HashMap<>();
    private int fWl = 0;
    private String fWm = bja();

    public static b biV() {
        if (fWh == null) {
            synchronized (b.class) {
                if (fWh == null) {
                    fWh = new b();
                }
            }
        }
        return fWh;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.fWp);
    }

    @Override // com.baidu.tieba.recapp.j
    public void biW() {
        if (!this.fWn) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.fWi.get();
                    if (lVar != null) {
                        lVar.a(b.this.fWm, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: aX */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.mp(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.fWk.put(gVar.forumName, gVar);
                                            b.this.fWn = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.fWi.get() == null) {
                synchronized (b.class) {
                    new a(this.fWi, "frs.refresh.count", runnable).execute(new Void[0]);
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
        g gVar = this.fWk.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.fWk.put(gVar.forumName, gVar);
        }
        gVar.M(z, z2);
        m(this.fWk);
    }

    private synchronized void m(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.fWi.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bje = entry.getValue().bje();
                if (bje != null) {
                    jSONArray.put(bje);
                }
            }
            lVar.b(this.fWm, jSONArray.toString(), 86400000L);
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
        g gVar = this.fWk.get(str);
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
        if (!this.fWo) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.fWj.get()).a(b.this.fWm, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.fWl = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.fWl = 0;
                                }
                                b.this.fWo = true;
                            }
                        }
                    });
                }
            };
            if (this.fWj.get() == null) {
                synchronized (b.class) {
                    new a(this.fWj, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void biY() {
        com.baidu.adp.lib.cache.l<String> lVar = this.fWj.get();
        if (lVar != null) {
            bjb();
            this.fWl++;
            lVar.b(this.fWm, Integer.toString(this.fWl), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int biZ() {
        if (rO(bja())) {
            return this.fWl;
        }
        return 0;
    }

    private String bja() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean rO(String str) {
        if (TextUtils.isEmpty(this.fWm)) {
            return false;
        }
        return this.fWm.equals(str);
    }

    private void bjb() {
        String bja = bja();
        if (!rO(bja)) {
            this.fWk.clear();
            this.fWl = 0;
            this.fWm = bja;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> fWt;
        private final String fWu;
        private final Runnable fWv;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.fWt = atomicReference;
            this.fWu = str;
            this.fWv = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.fWt.get() == null) {
                synchronized (b.class) {
                    if (this.fWt.get() == null) {
                        this.fWt.set(com.baidu.tbadk.core.c.a.tz().cZ(this.fWu));
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
            if (this.fWv != null) {
                this.fWv.run();
            }
        }
    }
}
