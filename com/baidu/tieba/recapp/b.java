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
    private static volatile b iyP;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iyQ = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iyR = new AtomicReference<>(null);
    private boolean iyV = false;
    private boolean iyW = false;
    private CustomMessageListener iyX = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aBK().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iyS = new HashMap<>();
    private int iyT = 0;
    private String iyU = ceA();

    public static b cev() {
        if (iyP == null) {
            synchronized (b.class) {
                if (iyP == null) {
                    iyP = new b();
                }
            }
        }
        return iyP;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iyX);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cew() {
        if (!this.iyV) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iyQ.get();
                    if (lVar != null) {
                        lVar.a(b.this.iyU, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: db */
                            public void h(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.CM(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iyS.put(gVar.forumName, gVar);
                                            b.this.iyV = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iyQ.get() == null) {
                new a(this.iyQ, "frs.refresh.count", runnable).execute(new Void[0]);
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
        ceB();
        g gVar = this.iyS.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iyS.put(gVar.forumName, gVar);
        }
        gVar.ag(z, z2);
        t(this.iyS);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iyQ.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject ceE = entry.getValue().ceE();
                if (ceE != null) {
                    jSONArray.put(ceE);
                }
            }
            lVar.b(this.iyU, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int at(String str, boolean z) {
        return l(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int au(String str, boolean z) {
        return l(str, false, z);
    }

    private int l(String str, boolean z, boolean z2) {
        g gVar = this.iyS.get(str);
        if (gVar == null || !CN(ceA())) {
            return 0;
        }
        return gVar.af(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> CM(String str) {
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
    public void cex() {
        if (!this.iyW) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iyR.get()).a(b.this.iyU, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: db */
                        public void h(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iyT = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iyT = 0;
                                }
                                b.this.iyW = true;
                            }
                        }
                    });
                }
            };
            if (this.iyR.get() == null) {
                new a(this.iyR, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cey() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iyR.get();
        if (lVar != null) {
            ceB();
            this.iyT++;
            lVar.b(this.iyU, Integer.toString(this.iyT), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cez() {
        if (CN(ceA())) {
            return this.iyT;
        }
        return 0;
    }

    private String ceA() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean CN(String str) {
        if (TextUtils.isEmpty(this.iyU)) {
            return false;
        }
        return this.iyU.equals(str);
    }

    private void ceB() {
        String ceA = ceA();
        if (!CN(ceA)) {
            this.iyS.clear();
            this.iyT = 0;
            this.iyU = ceA;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> izb;
        private final String izc;
        private final Runnable izd;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.izb = atomicReference;
            this.izc = str;
            this.izd = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.izb.get() == null) {
                synchronized (a.class) {
                    if (this.izb.get() == null) {
                        this.izb.set(com.baidu.tbadk.core.c.a.afD().mB(this.izc));
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
            if (this.izd != null) {
                this.izd.run();
            }
        }
    }
}
