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
/* loaded from: classes8.dex */
public class b implements l, n {
    private static volatile b mMs;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mMt = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mMu = new AtomicReference<>(null);
    private boolean mMy = false;
    private boolean mMz = false;
    private CustomMessageListener mMA = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bOF().a(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    };
    private HashMap<String, g> mMv = new HashMap<>();
    private int mMw = 0;
    private String mMx = dEL();

    public static b dEG() {
        if (mMs == null) {
            synchronized (b.class) {
                if (mMs == null) {
                    mMs = new b();
                }
            }
        }
        return mMs;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.mMA);
    }

    @Override // com.baidu.tieba.recapp.l
    public void dEH() {
        if (!this.mMy) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.mMt.get();
                    if (lVar != null) {
                        lVar.a(b.this.mMx, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fe */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Rw(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.mMv.put(gVar.forumName, gVar);
                                            b.this.mMy = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mMt.get() == null) {
                new a(this.mMt, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        dEM();
        g gVar = this.mMv.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.mMv.put(gVar.forumName, gVar);
        }
        gVar.az(z, z2);
        G(this.mMv);
    }

    private synchronized void G(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mMt.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject amQ = entry.getValue().amQ();
                if (amQ != null) {
                    jSONArray.put(amQ);
                }
            }
            lVar.asyncSet(this.mMx, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int ba(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.l
    public int bb(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        g gVar = this.mMv.get(str);
        if (gVar == null || !Rx(dEL())) {
            return 0;
        }
        return gVar.ay(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Rw(String str) {
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

    @Override // com.baidu.tieba.recapp.n
    public void dEI() {
        if (!this.mMz) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.mMu.get()).a(b.this.mMx, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fe */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.mMw = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.mMw = 0;
                                }
                                b.this.mMz = true;
                            }
                        }
                    });
                }
            };
            if (this.mMu.get() == null) {
                new a(this.mMu, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public void dEJ() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mMu.get();
        if (lVar != null) {
            dEM();
            this.mMw++;
            lVar.asyncSet(this.mMx, Integer.toString(this.mMw), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public int dEK() {
        if (Rx(dEL())) {
            return this.mMw;
        }
        return 0;
    }

    private String dEL() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Rx(String str) {
        if (TextUtils.isEmpty(this.mMx)) {
            return false;
        }
        return this.mMx.equals(str);
    }

    private void dEM() {
        String dEL = dEL();
        if (!Rx(dEL)) {
            this.mMv.clear();
            this.mMw = 0;
            this.mMx = dEL;
        }
    }

    /* loaded from: classes8.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mME;
        private final String mMF;
        private final Runnable mMG;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mME = atomicReference;
            this.mMF = str;
            this.mMG = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mME.get() == null) {
                synchronized (a.class) {
                    if (this.mME.get() == null) {
                        this.mME.set(com.baidu.tbadk.core.c.a.btS().Bn(this.mMF));
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
            if (this.mMG != null) {
                this.mMG.run();
            }
        }
    }
}
