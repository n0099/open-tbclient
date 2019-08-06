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
    private static volatile b iGm;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iGn = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iGo = new AtomicReference<>(null);
    private boolean iGs = false;
    private boolean iGt = false;
    private CustomMessageListener iGu = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aDb().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iGp = new HashMap<>();
    private int iGq = 0;
    private String iGr = chK();

    public static b chF() {
        if (iGm == null) {
            synchronized (b.class) {
                if (iGm == null) {
                    iGm = new b();
                }
            }
        }
        return iGm;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iGu);
    }

    @Override // com.baidu.tieba.recapp.j
    public void chG() {
        if (!this.iGs) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iGn.get();
                    if (lVar != null) {
                        lVar.a(b.this.iGr, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dc */
                            public void h(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.DC(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iGp.put(gVar.forumName, gVar);
                                            b.this.iGs = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iGn.get() == null) {
                new a(this.iGn, "frs.refresh.count", runnable).execute(new Void[0]);
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
        chL();
        g gVar = this.iGp.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iGp.put(gVar.forumName, gVar);
        }
        gVar.aj(z, z2);
        t(this.iGp);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iGn.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject chO = entry.getValue().chO();
                if (chO != null) {
                    jSONArray.put(chO);
                }
            }
            lVar.b(this.iGr, jSONArray.toString(), 86400000L);
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
        g gVar = this.iGp.get(str);
        if (gVar == null || !DD(chK())) {
            return 0;
        }
        return gVar.ai(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> DC(String str) {
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
    public void chH() {
        if (!this.iGt) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iGo.get()).a(b.this.iGr, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dc */
                        public void h(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iGq = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iGq = 0;
                                }
                                b.this.iGt = true;
                            }
                        }
                    });
                }
            };
            if (this.iGo.get() == null) {
                new a(this.iGo, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void chI() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iGo.get();
        if (lVar != null) {
            chL();
            this.iGq++;
            lVar.b(this.iGr, Integer.toString(this.iGq), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int chJ() {
        if (DD(chK())) {
            return this.iGq;
        }
        return 0;
    }

    private String chK() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean DD(String str) {
        if (TextUtils.isEmpty(this.iGr)) {
            return false;
        }
        return this.iGr.equals(str);
    }

    private void chL() {
        String chK = chK();
        if (!DD(chK)) {
            this.iGp.clear();
            this.iGq = 0;
            this.iGr = chK;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final Runnable iGA;
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iGy;
        private final String iGz;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.iGy = atomicReference;
            this.iGz = str;
            this.iGA = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.iGy.get() == null) {
                synchronized (a.class) {
                    if (this.iGy.get() == null) {
                        this.iGy.set(com.baidu.tbadk.core.d.a.agH().mL(this.iGz));
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
            if (this.iGA != null) {
                this.iGA.run();
            }
        }
    }
}
