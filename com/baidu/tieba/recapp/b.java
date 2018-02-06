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
    private static volatile b gBt;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gBu = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gBv = new AtomicReference<>(null);
    private boolean gBz = false;
    private boolean gBA = false;
    private CustomMessageListener gBB = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.UA().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gBw = new HashMap<>();
    private int gBx = 0;
    private String gBy = bnU();

    public static b bnP() {
        if (gBt == null) {
            synchronized (b.class) {
                if (gBt == null) {
                    gBt = new b();
                }
            }
        }
        return gBt;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gBB);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bnQ() {
        if (!this.gBz) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gBu.get();
                    if (lVar != null) {
                        lVar.a(b.this.gBy, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: aX */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.mn(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gBw.put(gVar.forumName, gVar);
                                            b.this.gBz = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gBu.get() == null) {
                synchronized (b.class) {
                    new a(this.gBu, "frs.refresh.count", runnable).execute(new Void[0]);
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
        g gVar = this.gBw.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gBw.put(gVar.forumName, gVar);
        }
        gVar.S(z, z2);
        l(this.gBw);
    }

    private synchronized void l(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gBu.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bnY = entry.getValue().bnY();
                if (bnY != null) {
                    jSONArray.put(bnY);
                }
            }
            lVar.b(this.gBy, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int V(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int W(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gBw.get(str);
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
        if (!this.gBA) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gBv.get()).a(b.this.gBy, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gBx = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gBx = 0;
                                }
                                b.this.gBA = true;
                            }
                        }
                    });
                }
            };
            if (this.gBv.get() == null) {
                synchronized (b.class) {
                    new a(this.gBv, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bnS() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gBv.get();
        if (lVar != null) {
            bnV();
            this.gBx++;
            lVar.b(this.gBy, Integer.toString(this.gBx), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bnT() {
        if (rI(bnU())) {
            return this.gBx;
        }
        return 0;
    }

    private String bnU() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean rI(String str) {
        if (TextUtils.isEmpty(this.gBy)) {
            return false;
        }
        return this.gBy.equals(str);
    }

    private void bnV() {
        String bnU = bnU();
        if (!rI(bnU)) {
            this.gBw.clear();
            this.gBx = 0;
            this.gBy = bnU;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gBF;
        private final String gBG;
        private final Runnable gBH;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gBF = atomicReference;
            this.gBG = str;
            this.gBH = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gBF.get() == null) {
                synchronized (b.class) {
                    if (this.gBF.get() == null) {
                        this.gBF.set(com.baidu.tbadk.core.c.a.AQ().dh(this.gBG));
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
            if (this.gBH != null) {
                this.gBH.run();
            }
        }
    }
}
