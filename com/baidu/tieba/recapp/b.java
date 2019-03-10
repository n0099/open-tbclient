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
    private static volatile b igu;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> igv = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> igw = new AtomicReference<>(null);
    private boolean igA = false;
    private boolean igB = false;
    private CustomMessageListener igC = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.awF().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> igx = new HashMap<>();
    private int igy = 0;
    private String igz = bWw();

    public static b bWr() {
        if (igu == null) {
            synchronized (b.class) {
                if (igu == null) {
                    igu = new b();
                }
            }
        }
        return igu;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.igC);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bWs() {
        if (!this.igA) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.igv.get();
                    if (lVar != null) {
                        lVar.a(b.this.igz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cN */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.vK(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.igx.put(gVar.forumName, gVar);
                                            b.this.igA = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.igv.get() == null) {
                new a(this.igv, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bWx();
        g gVar = this.igx.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.igx.put(gVar.forumName, gVar);
        }
        gVar.ah(z, z2);
        t(this.igx);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.igv.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bWA = entry.getValue().bWA();
                if (bWA != null) {
                    jSONArray.put(bWA);
                }
            }
            lVar.b(this.igz, jSONArray.toString(), 86400000L);
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
        g gVar = this.igx.get(str);
        if (gVar == null || !Bu(bWw())) {
            return 0;
        }
        return gVar.ag(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> vK(String str) {
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
    public void bWt() {
        if (!this.igB) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.igw.get()).a(b.this.igz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cN */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.igy = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.igy = 0;
                                }
                                b.this.igB = true;
                            }
                        }
                    });
                }
            };
            if (this.igw.get() == null) {
                new a(this.igw, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bWu() {
        com.baidu.adp.lib.cache.l<String> lVar = this.igw.get();
        if (lVar != null) {
            bWx();
            this.igy++;
            lVar.b(this.igz, Integer.toString(this.igy), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bWv() {
        if (Bu(bWw())) {
            return this.igy;
        }
        return 0;
    }

    private String bWw() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Bu(String str) {
        if (TextUtils.isEmpty(this.igz)) {
            return false;
        }
        return this.igz.equals(str);
    }

    private void bWx() {
        String bWw = bWw();
        if (!Bu(bWw)) {
            this.igx.clear();
            this.igy = 0;
            this.igz = bWw;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> igG;
        private final String igH;
        private final Runnable igI;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.igG = atomicReference;
            this.igH = str;
            this.igI = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.igG.get() == null) {
                synchronized (a.class) {
                    if (this.igG.get() == null) {
                        this.igG.set(com.baidu.tbadk.core.c.a.aaW().lv(this.igH));
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
            if (this.igI != null) {
                this.igI.run();
            }
        }
    }
}
