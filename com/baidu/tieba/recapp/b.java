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
    private static volatile b guZ;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gva = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gvb = new AtomicReference<>(null);
    private boolean gvf = false;
    private boolean gvg = false;
    private CustomMessageListener gvh = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.SV().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gvc = new HashMap<>();
    private int gvd = 0;
    private String gve = bpK();

    public static b bpF() {
        if (guZ == null) {
            synchronized (b.class) {
                if (guZ == null) {
                    guZ = new b();
                }
            }
        }
        return guZ;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gvh);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bpG() {
        if (!this.gvf) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gva.get();
                    if (lVar != null) {
                        lVar.a(b.this.gve, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cg */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.nG(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gvc.put(gVar.forumName, gVar);
                                            b.this.gvf = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gva.get() == null) {
                synchronized (b.class) {
                    new a(this.gva, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bpL();
        g gVar = this.gvc.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gvc.put(gVar.forumName, gVar);
        }
        gVar.R(z, z2);
        t(this.gvc);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gva.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bpO = entry.getValue().bpO();
                if (bpO != null) {
                    jSONArray.put(bpO);
                }
            }
            lVar.b(this.gve, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int R(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int S(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gvc.get(str);
        if (gVar == null || !to(bpK())) {
            return 0;
        }
        return gVar.Q(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> nG(String str) {
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
    public void bpH() {
        if (!this.gvg) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gvb.get()).a(b.this.gve, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cg */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gvd = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gvd = 0;
                                }
                                b.this.gvg = true;
                            }
                        }
                    });
                }
            };
            if (this.gvb.get() == null) {
                synchronized (b.class) {
                    new a(this.gvb, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bpI() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gvb.get();
        if (lVar != null) {
            bpL();
            this.gvd++;
            lVar.b(this.gve, Integer.toString(this.gvd), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bpJ() {
        if (to(bpK())) {
            return this.gvd;
        }
        return 0;
    }

    private String bpK() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean to(String str) {
        if (TextUtils.isEmpty(this.gve)) {
            return false;
        }
        return this.gve.equals(str);
    }

    private void bpL() {
        String bpK = bpK();
        if (!to(bpK)) {
            this.gvc.clear();
            this.gvd = 0;
            this.gve = bpK;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gvl;
        private final String gvm;
        private final Runnable gvn;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gvl = atomicReference;
            this.gvm = str;
            this.gvn = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gvl.get() == null) {
                synchronized (b.class) {
                    if (this.gvl.get() == null) {
                        this.gvl.set(com.baidu.tbadk.core.c.a.yh().dQ(this.gvm));
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
            if (this.gvn != null) {
                this.gvn.run();
            }
        }
    }
}
