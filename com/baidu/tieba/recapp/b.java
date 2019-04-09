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
    private static volatile b igb;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> igc = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> igd = new AtomicReference<>(null);
    private boolean igh = false;
    private boolean igi = false;
    private CustomMessageListener igj = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.awB().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> ige = new HashMap<>();
    private int igf = 0;
    private String igg = bWu();

    public static b bWp() {
        if (igb == null) {
            synchronized (b.class) {
                if (igb == null) {
                    igb = new b();
                }
            }
        }
        return igb;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.igj);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bWq() {
        if (!this.igh) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.igc.get();
                    if (lVar != null) {
                        lVar.a(b.this.igg, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cO */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.vH(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.ige.put(gVar.forumName, gVar);
                                            b.this.igh = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.igc.get() == null) {
                new a(this.igc, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void g(String str, int i, boolean z) {
        if (i == 1) {
            k(str, true, z);
        } else if (i == 2) {
            k(str, false, z);
        }
    }

    private void k(String str, boolean z, boolean z2) {
        bWv();
        g gVar = this.ige.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.ige.put(gVar.forumName, gVar);
        }
        gVar.af(z, z2);
        t(this.ige);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.igc.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bWy = entry.getValue().bWy();
                if (bWy != null) {
                    jSONArray.put(bWy);
                }
            }
            lVar.b(this.igg, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int ar(String str, boolean z) {
        return l(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int as(String str, boolean z) {
        return l(str, false, z);
    }

    private int l(String str, boolean z, boolean z2) {
        g gVar = this.ige.get(str);
        if (gVar == null || !Br(bWu())) {
            return 0;
        }
        return gVar.ae(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> vH(String str) {
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
    public void bWr() {
        if (!this.igi) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.igd.get()).a(b.this.igg, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cO */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.igf = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.igf = 0;
                                }
                                b.this.igi = true;
                            }
                        }
                    });
                }
            };
            if (this.igd.get() == null) {
                new a(this.igd, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bWs() {
        com.baidu.adp.lib.cache.l<String> lVar = this.igd.get();
        if (lVar != null) {
            bWv();
            this.igf++;
            lVar.b(this.igg, Integer.toString(this.igf), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bWt() {
        if (Br(bWu())) {
            return this.igf;
        }
        return 0;
    }

    private String bWu() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Br(String str) {
        if (TextUtils.isEmpty(this.igg)) {
            return false;
        }
        return this.igg.equals(str);
    }

    private void bWv() {
        String bWu = bWu();
        if (!Br(bWu)) {
            this.ige.clear();
            this.igf = 0;
            this.igg = bWu;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> ign;
        private final String igo;
        private final Runnable igp;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.ign = atomicReference;
            this.igo = str;
            this.igp = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.ign.get() == null) {
                synchronized (a.class) {
                    if (this.ign.get() == null) {
                        this.ign.set(com.baidu.tbadk.core.c.a.aaT().lw(this.igo));
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
            if (this.igp != null) {
                this.igp.run();
            }
        }
    }
}
