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
    private static volatile b gmu;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gmv = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gmw = new AtomicReference<>(null);
    private boolean gmA = false;
    private boolean gmB = false;
    private CustomMessageListener gmC = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.QV().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gmx = new HashMap<>();
    private int gmy = 0;
    private String gmz = boy();

    public static b bot() {
        if (gmu == null) {
            synchronized (b.class) {
                if (gmu == null) {
                    gmu = new b();
                }
            }
        }
        return gmu;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gmC);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bou() {
        if (!this.gmA) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gmv.get();
                    if (lVar != null) {
                        lVar.a(b.this.gmz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: bI */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.na(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gmx.put(gVar.forumName, gVar);
                                            b.this.gmA = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gmv.get() == null) {
                synchronized (b.class) {
                    new a(this.gmv, "frs.refresh.count", runnable).execute(new Void[0]);
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
        boz();
        g gVar = this.gmx.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gmx.put(gVar.forumName, gVar);
        }
        gVar.P(z, z2);
        n(this.gmx);
    }

    private synchronized void n(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gmv.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject boC = entry.getValue().boC();
                if (boC != null) {
                    jSONArray.put(boC);
                }
            }
            lVar.b(this.gmz, jSONArray.toString(), 86400000L);
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
        g gVar = this.gmx.get(str);
        if (gVar == null || !sI(boy())) {
            return 0;
        }
        return gVar.O(z, z2);
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
    public void bov() {
        if (!this.gmB) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gmw.get()).a(b.this.gmz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: bI */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gmy = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gmy = 0;
                                }
                                b.this.gmB = true;
                            }
                        }
                    });
                }
            };
            if (this.gmw.get() == null) {
                synchronized (b.class) {
                    new a(this.gmw, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bow() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gmw.get();
        if (lVar != null) {
            boz();
            this.gmy++;
            lVar.b(this.gmz, Integer.toString(this.gmy), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int box() {
        if (sI(boy())) {
            return this.gmy;
        }
        return 0;
    }

    private String boy() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean sI(String str) {
        if (TextUtils.isEmpty(this.gmz)) {
            return false;
        }
        return this.gmz.equals(str);
    }

    private void boz() {
        String boy = boy();
        if (!sI(boy)) {
            this.gmx.clear();
            this.gmy = 0;
            this.gmz = boy;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gmG;
        private final String gmH;
        private final Runnable gmI;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gmG = atomicReference;
            this.gmH = str;
            this.gmI = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gmG.get() == null) {
                synchronized (b.class) {
                    if (this.gmG.get() == null) {
                        this.gmG.set(com.baidu.tbadk.core.c.a.xj().dB(this.gmH));
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
            if (this.gmI != null) {
                this.gmI.run();
            }
        }
    }
}
