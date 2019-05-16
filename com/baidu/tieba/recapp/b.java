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
    private static volatile b iyN;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iyO = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iyP = new AtomicReference<>(null);
    private boolean iyT = false;
    private boolean iyU = false;
    private CustomMessageListener iyV = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aBH().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iyQ = new HashMap<>();
    private int iyR = 0;
    private String iyS = cey();

    public static b cet() {
        if (iyN == null) {
            synchronized (b.class) {
                if (iyN == null) {
                    iyN = new b();
                }
            }
        }
        return iyN;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iyV);
    }

    @Override // com.baidu.tieba.recapp.j
    public void ceu() {
        if (!this.iyT) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iyO.get();
                    if (lVar != null) {
                        lVar.a(b.this.iyS, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: db */
                            public void h(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.CM(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iyQ.put(gVar.forumName, gVar);
                                            b.this.iyT = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iyO.get() == null) {
                new a(this.iyO, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cez();
        g gVar = this.iyQ.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iyQ.put(gVar.forumName, gVar);
        }
        gVar.ag(z, z2);
        t(this.iyQ);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iyO.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject ceC = entry.getValue().ceC();
                if (ceC != null) {
                    jSONArray.put(ceC);
                }
            }
            lVar.b(this.iyS, jSONArray.toString(), 86400000L);
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
        g gVar = this.iyQ.get(str);
        if (gVar == null || !CN(cey())) {
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
    public void cev() {
        if (!this.iyU) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iyP.get()).a(b.this.iyS, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: db */
                        public void h(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iyR = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iyR = 0;
                                }
                                b.this.iyU = true;
                            }
                        }
                    });
                }
            };
            if (this.iyP.get() == null) {
                new a(this.iyP, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cew() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iyP.get();
        if (lVar != null) {
            cez();
            this.iyR++;
            lVar.b(this.iyS, Integer.toString(this.iyR), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cex() {
        if (CN(cey())) {
            return this.iyR;
        }
        return 0;
    }

    private String cey() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean CN(String str) {
        if (TextUtils.isEmpty(this.iyS)) {
            return false;
        }
        return this.iyS.equals(str);
    }

    private void cez() {
        String cey = cey();
        if (!CN(cey)) {
            this.iyQ.clear();
            this.iyR = 0;
            this.iyS = cey;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iyZ;
        private final String iza;
        private final Runnable izb;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.iyZ = atomicReference;
            this.iza = str;
            this.izb = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.iyZ.get() == null) {
                synchronized (a.class) {
                    if (this.iyZ.get() == null) {
                        this.iyZ.set(com.baidu.tbadk.core.c.a.afD().mB(this.iza));
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
            if (this.izb != null) {
                this.izb.run();
            }
        }
    }
}
