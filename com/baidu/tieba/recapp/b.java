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
    private static volatile b iFi;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iFj = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iFk = new AtomicReference<>(null);
    private boolean iFo = false;
    private boolean iFp = false;
    private CustomMessageListener iFq = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aCZ().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iFl = new HashMap<>();
    private int iFm = 0;
    private String iFn = chs();

    public static b chn() {
        if (iFi == null) {
            synchronized (b.class) {
                if (iFi == null) {
                    iFi = new b();
                }
            }
        }
        return iFi;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iFq);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cho() {
        if (!this.iFo) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iFj.get();
                    if (lVar != null) {
                        lVar.a(b.this.iFn, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dc */
                            public void h(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.DB(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iFl.put(gVar.forumName, gVar);
                                            b.this.iFo = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iFj.get() == null) {
                new a(this.iFj, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void g(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        cht();
        g gVar = this.iFl.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iFl.put(gVar.forumName, gVar);
        }
        gVar.aj(z, z2);
        t(this.iFl);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iFj.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject chw = entry.getValue().chw();
                if (chw != null) {
                    jSONArray.put(chw);
                }
            }
            lVar.b(this.iFn, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int ax(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ay(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        g gVar = this.iFl.get(str);
        if (gVar == null || !DC(chs())) {
            return 0;
        }
        return gVar.ai(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> DB(String str) {
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
    public void chp() {
        if (!this.iFp) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iFk.get()).a(b.this.iFn, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dc */
                        public void h(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iFm = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iFm = 0;
                                }
                                b.this.iFp = true;
                            }
                        }
                    });
                }
            };
            if (this.iFk.get() == null) {
                new a(this.iFk, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void chq() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iFk.get();
        if (lVar != null) {
            cht();
            this.iFm++;
            lVar.b(this.iFn, Integer.toString(this.iFm), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int chr() {
        if (DC(chs())) {
            return this.iFm;
        }
        return 0;
    }

    private String chs() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean DC(String str) {
        if (TextUtils.isEmpty(this.iFn)) {
            return false;
        }
        return this.iFn.equals(str);
    }

    private void cht() {
        String chs = chs();
        if (!DC(chs)) {
            this.iFl.clear();
            this.iFm = 0;
            this.iFn = chs;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iFu;
        private final String iFv;
        private final Runnable iFw;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.iFu = atomicReference;
            this.iFv = str;
            this.iFw = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.iFu.get() == null) {
                synchronized (a.class) {
                    if (this.iFu.get() == null) {
                        this.iFu.set(com.baidu.tbadk.core.d.a.agF().mL(this.iFv));
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
            if (this.iFw != null) {
                this.iFw.run();
            }
        }
    }
}
