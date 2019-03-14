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
    private static volatile b igo;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> igp = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> igq = new AtomicReference<>(null);
    private boolean igu = false;
    private boolean igv = false;
    private CustomMessageListener igw = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.awE().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> igr = new HashMap<>();
    private int igs = 0;
    private String igt = bWy();

    public static b bWt() {
        if (igo == null) {
            synchronized (b.class) {
                if (igo == null) {
                    igo = new b();
                }
            }
        }
        return igo;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.igw);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bWu() {
        if (!this.igu) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.igp.get();
                    if (lVar != null) {
                        lVar.a(b.this.igt, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cN */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.vI(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.igr.put(gVar.forumName, gVar);
                                            b.this.igu = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.igp.get() == null) {
                new a(this.igp, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bWz();
        g gVar = this.igr.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.igr.put(gVar.forumName, gVar);
        }
        gVar.ah(z, z2);
        t(this.igr);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.igp.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bWC = entry.getValue().bWC();
                if (bWC != null) {
                    jSONArray.put(bWC);
                }
            }
            lVar.b(this.igt, jSONArray.toString(), 86400000L);
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
        g gVar = this.igr.get(str);
        if (gVar == null || !Bs(bWy())) {
            return 0;
        }
        return gVar.ag(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> vI(String str) {
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
    public void bWv() {
        if (!this.igv) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.igq.get()).a(b.this.igt, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cN */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.igs = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.igs = 0;
                                }
                                b.this.igv = true;
                            }
                        }
                    });
                }
            };
            if (this.igq.get() == null) {
                new a(this.igq, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bWw() {
        com.baidu.adp.lib.cache.l<String> lVar = this.igq.get();
        if (lVar != null) {
            bWz();
            this.igs++;
            lVar.b(this.igt, Integer.toString(this.igs), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bWx() {
        if (Bs(bWy())) {
            return this.igs;
        }
        return 0;
    }

    private String bWy() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Bs(String str) {
        if (TextUtils.isEmpty(this.igt)) {
            return false;
        }
        return this.igt.equals(str);
    }

    private void bWz() {
        String bWy = bWy();
        if (!Bs(bWy)) {
            this.igr.clear();
            this.igs = 0;
            this.igt = bWy;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> igA;
        private final String igB;
        private final Runnable igC;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.igA = atomicReference;
            this.igB = str;
            this.igC = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.igA.get() == null) {
                synchronized (a.class) {
                    if (this.igA.get() == null) {
                        this.igA.set(com.baidu.tbadk.core.c.a.aaW().lv(this.igB));
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
            if (this.igC != null) {
                this.igC.run();
            }
        }
    }
}
