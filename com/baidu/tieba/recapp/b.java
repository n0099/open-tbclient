package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes13.dex */
public class b implements j, l {
    private static volatile b jHf;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jHg = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> jHh = new AtomicReference<>(null);
    private boolean jHl = false;
    private boolean jHm = false;
    private CustomMessageListener jHn = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aYe().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> jHi = new HashMap<>();
    private int jHj = 0;
    private String jHk = cCG();

    public static b cCB() {
        if (jHf == null) {
            synchronized (b.class) {
                if (jHf == null) {
                    jHf = new b();
                }
            }
        }
        return jHf;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.jHn);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cCC() {
        if (!this.jHl) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.jHg.get();
                    if (lVar != null) {
                        lVar.a(b.this.jHk, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dr */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.HI(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.jHi.put(gVar.forumName, gVar);
                                            b.this.jHl = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.jHg.get() == null) {
                new a(this.jHg, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        cCH();
        g gVar = this.jHi.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.jHi.put(gVar.forumName, gVar);
        }
        gVar.am(z, z2);
        s(this.jHi);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.jHg.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject Jk = entry.getValue().Jk();
                if (Jk != null) {
                    jSONArray.put(Jk);
                }
            }
            lVar.asyncSet(this.jHk, jSONArray.toString(), 86400000L);
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
        g gVar = this.jHi.get(str);
        if (gVar == null || !HJ(cCG())) {
            return 0;
        }
        return gVar.al(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> HI(String str) {
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
    public void cCD() {
        if (!this.jHm) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.jHh.get()).a(b.this.jHk, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dr */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.jHj = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.jHj = 0;
                                }
                                b.this.jHm = true;
                            }
                        }
                    });
                }
            };
            if (this.jHh.get() == null) {
                new a(this.jHh, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cCE() {
        com.baidu.adp.lib.cache.l<String> lVar = this.jHh.get();
        if (lVar != null) {
            cCH();
            this.jHj++;
            lVar.asyncSet(this.jHk, Integer.toString(this.jHj), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cCF() {
        if (HJ(cCG())) {
            return this.jHj;
        }
        return 0;
    }

    private String cCG() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean HJ(String str) {
        if (TextUtils.isEmpty(this.jHk)) {
            return false;
        }
        return this.jHk.equals(str);
    }

    private void cCH() {
        String cCG = cCG();
        if (!HJ(cCG)) {
            this.jHi.clear();
            this.jHj = 0;
            this.jHk = cCG;
        }
    }

    /* loaded from: classes13.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jHr;
        private final String jHs;
        private final Runnable jHt;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.jHr = atomicReference;
            this.jHs = str;
            this.jHt = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.jHr.get() == null) {
                synchronized (a.class) {
                    if (this.jHr.get() == null) {
                        this.jHr.set(com.baidu.tbadk.core.c.a.aEF().sQ(this.jHs));
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
            if (this.jHt != null) {
                this.jHt.run();
            }
        }
    }
}
