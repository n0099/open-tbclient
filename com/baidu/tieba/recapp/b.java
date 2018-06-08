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
    private static volatile b giC;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> giD = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> giE = new AtomicReference<>(null);
    private boolean giI = false;
    private boolean giJ = false;
    private CustomMessageListener giK = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Qy().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> giF = new HashMap<>();
    private int giG = 0;
    private String giH = bnY();

    public static b bnT() {
        if (giC == null) {
            synchronized (b.class) {
                if (giC == null) {
                    giC = new b();
                }
            }
        }
        return giC;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.giK);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bnU() {
        if (!this.giI) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.giD.get();
                    if (lVar != null) {
                        lVar.a(b.this.giH, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: bE */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.na(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.giF.put(gVar.forumName, gVar);
                                            b.this.giI = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.giD.get() == null) {
                synchronized (b.class) {
                    new a(this.giD, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bnZ();
        g gVar = this.giF.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.giF.put(gVar.forumName, gVar);
        }
        gVar.M(z, z2);
        n(this.giF);
    }

    private synchronized void n(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.giD.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject boc = entry.getValue().boc();
                if (boc != null) {
                    jSONArray.put(boc);
                }
            }
            lVar.b(this.giH, jSONArray.toString(), 86400000L);
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
        g gVar = this.giF.get(str);
        if (gVar == null || !sJ(bnY())) {
            return 0;
        }
        return gVar.L(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> na(String str) {
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
    public void bnV() {
        if (!this.giJ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.giE.get()).a(b.this.giH, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: bE */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.giG = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.giG = 0;
                                }
                                b.this.giJ = true;
                            }
                        }
                    });
                }
            };
            if (this.giE.get() == null) {
                synchronized (b.class) {
                    new a(this.giE, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bnW() {
        com.baidu.adp.lib.cache.l<String> lVar = this.giE.get();
        if (lVar != null) {
            bnZ();
            this.giG++;
            lVar.b(this.giH, Integer.toString(this.giG), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bnX() {
        if (sJ(bnY())) {
            return this.giG;
        }
        return 0;
    }

    private String bnY() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean sJ(String str) {
        if (TextUtils.isEmpty(this.giH)) {
            return false;
        }
        return this.giH.equals(str);
    }

    private void bnZ() {
        String bnY = bnY();
        if (!sJ(bnY)) {
            this.giF.clear();
            this.giG = 0;
            this.giH = bnY;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> giO;
        private final String giP;
        private final Runnable giQ;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.giO = atomicReference;
            this.giP = str;
            this.giQ = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.giO.get() == null) {
                synchronized (b.class) {
                    if (this.giO.get() == null) {
                        this.giO.set(com.baidu.tbadk.core.c.a.wW().dy(this.giP));
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
            if (this.giQ != null) {
                this.giQ.run();
            }
        }
    }
}
