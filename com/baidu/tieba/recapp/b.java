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
    private static volatile b igt;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> igu = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> igv = new AtomicReference<>(null);
    private boolean igz = false;
    private boolean igA = false;
    private CustomMessageListener igB = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.awE().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> igw = new HashMap<>();
    private int igx = 0;
    private String igy = bWv();

    public static b bWq() {
        if (igt == null) {
            synchronized (b.class) {
                if (igt == null) {
                    igt = new b();
                }
            }
        }
        return igt;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.igB);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bWr() {
        if (!this.igz) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.igu.get();
                    if (lVar != null) {
                        lVar.a(b.this.igy, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cN */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.vJ(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.igw.put(gVar.forumName, gVar);
                                            b.this.igz = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.igu.get() == null) {
                new a(this.igu, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bWw();
        g gVar = this.igw.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.igw.put(gVar.forumName, gVar);
        }
        gVar.ah(z, z2);
        t(this.igw);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.igu.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bWz = entry.getValue().bWz();
                if (bWz != null) {
                    jSONArray.put(bWz);
                }
            }
            lVar.b(this.igy, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aq(String str, boolean z) {
        return l(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ar(String str, boolean z) {
        return l(str, false, z);
    }

    private int l(String str, boolean z, boolean z2) {
        g gVar = this.igw.get(str);
        if (gVar == null || !Bt(bWv())) {
            return 0;
        }
        return gVar.ag(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> vJ(String str) {
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
    public void bWs() {
        if (!this.igA) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.igv.get()).a(b.this.igy, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cN */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.igx = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.igx = 0;
                                }
                                b.this.igA = true;
                            }
                        }
                    });
                }
            };
            if (this.igv.get() == null) {
                new a(this.igv, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bWt() {
        com.baidu.adp.lib.cache.l<String> lVar = this.igv.get();
        if (lVar != null) {
            bWw();
            this.igx++;
            lVar.b(this.igy, Integer.toString(this.igx), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bWu() {
        if (Bt(bWv())) {
            return this.igx;
        }
        return 0;
    }

    private String bWv() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Bt(String str) {
        if (TextUtils.isEmpty(this.igy)) {
            return false;
        }
        return this.igy.equals(str);
    }

    private void bWw() {
        String bWv = bWv();
        if (!Bt(bWv)) {
            this.igw.clear();
            this.igx = 0;
            this.igy = bWv;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> igF;
        private final String igG;
        private final Runnable igH;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.igF = atomicReference;
            this.igG = str;
            this.igH = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.igF.get() == null) {
                synchronized (a.class) {
                    if (this.igF.get() == null) {
                        this.igF.set(com.baidu.tbadk.core.c.a.aaW().lv(this.igG));
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
            if (this.igH != null) {
                this.igH.run();
            }
        }
    }
}
