package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
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
public class a implements i, k {
    private static volatile a kqW;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kqX = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> kqY = new AtomicReference<>(null);
    private boolean krc = false;
    private boolean krd = false;
    private CustomMessageListener kre = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bgh().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> kqZ = new HashMap<>();
    private int kra = 0;
    private String krb = cNc();

    public static a cMX() {
        if (kqW == null) {
            synchronized (a.class) {
                if (kqW == null) {
                    kqW = new a();
                }
            }
        }
        return kqW;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.kre);
    }

    @Override // com.baidu.tieba.recapp.i
    public void cMY() {
        if (!this.krc) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.kqX.get();
                    if (lVar != null) {
                        lVar.a(a.this.krb, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dG */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Jp(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.kqZ.put(fVar.forumName, fVar);
                                            a.this.krc = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.kqX.get() == null) {
                new C0656a(this.kqX, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        cNd();
        f fVar = this.kqZ.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.kqZ.put(fVar.forumName, fVar);
        }
        fVar.am(z, z2);
        H(this.kqZ);
    }

    private synchronized void H(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.kqX.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject QV = entry.getValue().QV();
                if (QV != null) {
                    jSONArray.put(QV);
                }
            }
            lVar.asyncSet(this.krb, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int aD(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.i
    public int aE(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.kqZ.get(str);
        if (fVar == null || !Jq(cNc())) {
            return 0;
        }
        return fVar.al(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Jp(String str) {
        ArrayList<f> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new f(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.recapp.k
    public void cMZ() {
        if (!this.krd) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.kqY.get()).a(a.this.krb, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dG */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.kra = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.kra = 0;
                                }
                                a.this.krd = true;
                            }
                        }
                    });
                }
            };
            if (this.kqY.get() == null) {
                new C0656a(this.kqY, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void cNa() {
        com.baidu.adp.lib.cache.l<String> lVar = this.kqY.get();
        if (lVar != null) {
            cNd();
            this.kra++;
            lVar.asyncSet(this.krb, Integer.toString(this.kra), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public int cNb() {
        if (Jq(cNc())) {
            return this.kra;
        }
        return 0;
    }

    private String cNc() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Jq(String str) {
        if (TextUtils.isEmpty(this.krb)) {
            return false;
        }
        return this.krb.equals(str);
    }

    private void cNd() {
        String cNc = cNc();
        if (!Jq(cNc)) {
            this.kqZ.clear();
            this.kra = 0;
            this.krb = cNc;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0656a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kri;
        private final String krj;
        private final Runnable krk;

        private C0656a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.kri = atomicReference;
            this.krj = str;
            this.krk = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.kri.get() == null) {
                synchronized (C0656a.class) {
                    if (this.kri.get() == null) {
                        this.kri.set(com.baidu.tbadk.core.c.a.aMR().ug(this.krj));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0656a) r2);
            if (this.krk != null) {
                this.krk.run();
            }
        }
    }
}
