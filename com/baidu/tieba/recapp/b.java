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
    private static volatile b fXk;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> fXl = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> fXm = new AtomicReference<>(null);
    private boolean fXq = false;
    private boolean fXr = false;
    private CustomMessageListener fXs = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.MZ().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> fXn = new HashMap<>();
    private int fXo = 0;
    private String fXp = biZ();

    public static b biU() {
        if (fXk == null) {
            synchronized (b.class) {
                if (fXk == null) {
                    fXk = new b();
                }
            }
        }
        return fXk;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.fXs);
    }

    @Override // com.baidu.tieba.recapp.j
    public void biV() {
        if (!this.fXq) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.fXl.get();
                    if (lVar != null) {
                        lVar.a(b.this.fXp, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: aX */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.ms(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.fXn.put(gVar.forumName, gVar);
                                            b.this.fXq = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.fXl.get() == null) {
                synchronized (b.class) {
                    new a(this.fXl, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bja();
        g gVar = this.fXn.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.fXn.put(gVar.forumName, gVar);
        }
        gVar.M(z, z2);
        m(this.fXn);
    }

    private synchronized void m(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.fXl.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bjd = entry.getValue().bjd();
                if (bjd != null) {
                    jSONArray.put(bjd);
                }
            }
            lVar.b(this.fXp, jSONArray.toString(), 86400000L);
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
        g gVar = this.fXn.get(str);
        if (gVar == null || !rR(biZ())) {
            return 0;
        }
        return gVar.L(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> ms(String str) {
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
    public void biW() {
        if (!this.fXr) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.fXm.get()).a(b.this.fXp, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: aX */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.fXo = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.fXo = 0;
                                }
                                b.this.fXr = true;
                            }
                        }
                    });
                }
            };
            if (this.fXm.get() == null) {
                synchronized (b.class) {
                    new a(this.fXm, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void biX() {
        com.baidu.adp.lib.cache.l<String> lVar = this.fXm.get();
        if (lVar != null) {
            bja();
            this.fXo++;
            lVar.b(this.fXp, Integer.toString(this.fXo), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int biY() {
        if (rR(biZ())) {
            return this.fXo;
        }
        return 0;
    }

    private String biZ() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean rR(String str) {
        if (TextUtils.isEmpty(this.fXp)) {
            return false;
        }
        return this.fXp.equals(str);
    }

    private void bja() {
        String biZ = biZ();
        if (!rR(biZ)) {
            this.fXn.clear();
            this.fXo = 0;
            this.fXp = biZ;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> fXw;
        private final String fXx;
        private final Runnable fXy;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.fXw = atomicReference;
            this.fXx = str;
            this.fXy = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.fXw.get() == null) {
                synchronized (b.class) {
                    if (this.fXw.get() == null) {
                        this.fXw.set(com.baidu.tbadk.core.c.a.ty().cZ(this.fXx));
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
            if (this.fXy != null) {
                this.fXy.run();
            }
        }
    }
}
