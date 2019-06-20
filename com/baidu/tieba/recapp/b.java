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
    private static volatile b iyQ;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iyR = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iyS = new AtomicReference<>(null);
    private boolean iyW = false;
    private boolean iyX = false;
    private CustomMessageListener iyY = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aBK().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iyT = new HashMap<>();
    private int iyU = 0;
    private String iyV = ceB();

    public static b cew() {
        if (iyQ == null) {
            synchronized (b.class) {
                if (iyQ == null) {
                    iyQ = new b();
                }
            }
        }
        return iyQ;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iyY);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cex() {
        if (!this.iyW) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iyR.get();
                    if (lVar != null) {
                        lVar.a(b.this.iyV, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: db */
                            public void h(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.CO(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iyT.put(gVar.forumName, gVar);
                                            b.this.iyW = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iyR.get() == null) {
                new a(this.iyR, "frs.refresh.count", runnable).execute(new Void[0]);
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
        ceC();
        g gVar = this.iyT.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iyT.put(gVar.forumName, gVar);
        }
        gVar.ag(z, z2);
        t(this.iyT);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iyR.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject ceF = entry.getValue().ceF();
                if (ceF != null) {
                    jSONArray.put(ceF);
                }
            }
            lVar.b(this.iyV, jSONArray.toString(), 86400000L);
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
        g gVar = this.iyT.get(str);
        if (gVar == null || !CP(ceB())) {
            return 0;
        }
        return gVar.af(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> CO(String str) {
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
    public void cey() {
        if (!this.iyX) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iyS.get()).a(b.this.iyV, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: db */
                        public void h(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iyU = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iyU = 0;
                                }
                                b.this.iyX = true;
                            }
                        }
                    });
                }
            };
            if (this.iyS.get() == null) {
                new a(this.iyS, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cez() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iyS.get();
        if (lVar != null) {
            ceC();
            this.iyU++;
            lVar.b(this.iyV, Integer.toString(this.iyU), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int ceA() {
        if (CP(ceB())) {
            return this.iyU;
        }
        return 0;
    }

    private String ceB() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean CP(String str) {
        if (TextUtils.isEmpty(this.iyV)) {
            return false;
        }
        return this.iyV.equals(str);
    }

    private void ceC() {
        String ceB = ceB();
        if (!CP(ceB)) {
            this.iyT.clear();
            this.iyU = 0;
            this.iyV = ceB;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> izc;
        private final String izd;
        private final Runnable ize;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.izc = atomicReference;
            this.izd = str;
            this.ize = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.izc.get() == null) {
                synchronized (a.class) {
                    if (this.izc.get() == null) {
                        this.izc.set(com.baidu.tbadk.core.c.a.afD().mA(this.izd));
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
            if (this.ize != null) {
                this.ize.run();
            }
        }
    }
}
