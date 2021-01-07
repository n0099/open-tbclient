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
    private static volatile b mMr;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mMs = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mMt = new AtomicReference<>(null);
    private boolean mMx = false;
    private boolean mMy = false;
    private CustomMessageListener mMz = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bOG().a(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    };
    private HashMap<String, g> mMu = new HashMap<>();
    private int mMv = 0;
    private String mMw = dEM();

    public static b dEH() {
        if (mMr == null) {
            synchronized (b.class) {
                if (mMr == null) {
                    mMr = new b();
                }
            }
        }
        return mMr;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.mMz);
    }

    @Override // com.baidu.tieba.recapp.l
    public void dEI() {
        if (!this.mMx) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.mMs.get();
                    if (lVar != null) {
                        lVar.a(b.this.mMw, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fe */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Rv(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.mMu.put(gVar.forumName, gVar);
                                            b.this.mMx = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mMs.get() == null) {
                new a(this.mMs, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dEN();
        g gVar = this.mMu.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.mMu.put(gVar.forumName, gVar);
        }
        gVar.az(z, z2);
        G(this.mMu);
    }

    private synchronized void G(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mMs.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject amR = entry.getValue().amR();
                if (amR != null) {
                    jSONArray.put(amR);
                }
            }
            lVar.asyncSet(this.mMw, jSONArray.toString(), 86400000L);
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
        g gVar = this.mMu.get(str);
        if (gVar == null || !Rw(dEM())) {
            return 0;
        }
        return gVar.ay(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Rv(String str) {
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
    public void dEJ() {
        if (!this.mMy) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.mMt.get()).a(b.this.mMw, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fe */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.mMv = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.mMv = 0;
                                }
                                b.this.mMy = true;
                            }
                        }
                    });
                }
            };
            if (this.mMt.get() == null) {
                new a(this.mMt, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public void dEK() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mMt.get();
        if (lVar != null) {
            dEN();
            this.mMv++;
            lVar.asyncSet(this.mMw, Integer.toString(this.mMv), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public int dEL() {
        if (Rw(dEM())) {
            return this.mMv;
        }
        return 0;
    }

    private String dEM() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Rw(String str) {
        if (TextUtils.isEmpty(this.mMw)) {
            return false;
        }
        return this.mMw.equals(str);
    }

    private void dEN() {
        String dEM = dEM();
        if (!Rw(dEM)) {
            this.mMu.clear();
            this.mMv = 0;
            this.mMw = dEM;
        }
    }

    /* loaded from: classes8.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mMD;
        private final String mME;
        private final Runnable mMF;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mMD = atomicReference;
            this.mME = str;
            this.mMF = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mMD.get() == null) {
                synchronized (a.class) {
                    if (this.mMD.get() == null) {
                        this.mMD.set(com.baidu.tbadk.core.c.a.btT().Bm(this.mME));
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
            if (this.mMF != null) {
                this.mMF.run();
            }
        }
    }
}
