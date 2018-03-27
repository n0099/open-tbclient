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
    private static volatile b gBu;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gBv = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gBw = new AtomicReference<>(null);
    private boolean gBA = false;
    private boolean gBB = false;
    private CustomMessageListener gBC = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.UA().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gBx = new HashMap<>();
    private int gBy = 0;
    private String gBz = bnU();

    public static b bnP() {
        if (gBu == null) {
            synchronized (b.class) {
                if (gBu == null) {
                    gBu = new b();
                }
            }
        }
        return gBu;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gBC);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bnQ() {
        if (!this.gBA) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gBv.get();
                    if (lVar != null) {
                        lVar.a(b.this.gBz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: aX */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.mn(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gBx.put(gVar.forumName, gVar);
                                            b.this.gBA = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gBv.get() == null) {
                synchronized (b.class) {
                    new a(this.gBv, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bnV();
        g gVar = this.gBx.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gBx.put(gVar.forumName, gVar);
        }
        gVar.S(z, z2);
        l(this.gBx);
    }

    private synchronized void l(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gBv.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bnY = entry.getValue().bnY();
                if (bnY != null) {
                    jSONArray.put(bnY);
                }
            }
            lVar.b(this.gBz, jSONArray.toString(), 86400000L);
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
        g gVar = this.gBx.get(str);
        if (gVar == null || !rI(bnU())) {
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
    public void bnR() {
        if (!this.gBB) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gBw.get()).a(b.this.gBz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gBy = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gBy = 0;
                                }
                                b.this.gBB = true;
                            }
                        }
                    });
                }
            };
            if (this.gBw.get() == null) {
                synchronized (b.class) {
                    new a(this.gBw, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bnS() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gBw.get();
        if (lVar != null) {
            bnV();
            this.gBy++;
            lVar.b(this.gBz, Integer.toString(this.gBy), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bnT() {
        if (rI(bnU())) {
            return this.gBy;
        }
        return 0;
    }

    private String bnU() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean rI(String str) {
        if (TextUtils.isEmpty(this.gBz)) {
            return false;
        }
        return this.gBz.equals(str);
    }

    private void bnV() {
        String bnU = bnU();
        if (!rI(bnU)) {
            this.gBx.clear();
            this.gBy = 0;
            this.gBz = bnU;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gBG;
        private final String gBH;
        private final Runnable gBI;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gBG = atomicReference;
            this.gBH = str;
            this.gBI = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gBG.get() == null) {
                synchronized (b.class) {
                    if (this.gBG.get() == null) {
                        this.gBG.set(com.baidu.tbadk.core.c.a.AR().dh(this.gBH));
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
            if (this.gBI != null) {
                this.gBI.run();
            }
        }
    }
}
