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
    private static volatile a kqS;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kqT = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> kqU = new AtomicReference<>(null);
    private boolean kqY = false;
    private boolean kqZ = false;
    private CustomMessageListener kra = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bgj().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> kqV = new HashMap<>();
    private int kqW = 0;
    private String kqX = cNe();

    public static a cMZ() {
        if (kqS == null) {
            synchronized (a.class) {
                if (kqS == null) {
                    kqS = new a();
                }
            }
        }
        return kqS;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.kra);
    }

    @Override // com.baidu.tieba.recapp.i
    public void cNa() {
        if (!this.kqY) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.kqT.get();
                    if (lVar != null) {
                        lVar.a(a.this.kqX, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dG */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Jm(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.kqV.put(fVar.forumName, fVar);
                                            a.this.kqY = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.kqT.get() == null) {
                new C0635a(this.kqT, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cNf();
        f fVar = this.kqV.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.kqV.put(fVar.forumName, fVar);
        }
        fVar.am(z, z2);
        H(this.kqV);
    }

    private synchronized void H(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.kqT.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject QW = entry.getValue().QW();
                if (QW != null) {
                    jSONArray.put(QW);
                }
            }
            lVar.asyncSet(this.kqX, jSONArray.toString(), 86400000L);
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
        f fVar = this.kqV.get(str);
        if (fVar == null || !Jn(cNe())) {
            return 0;
        }
        return fVar.al(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Jm(String str) {
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
    public void cNb() {
        if (!this.kqZ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.kqU.get()).a(a.this.kqX, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dG */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.kqW = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.kqW = 0;
                                }
                                a.this.kqZ = true;
                            }
                        }
                    });
                }
            };
            if (this.kqU.get() == null) {
                new C0635a(this.kqU, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void cNc() {
        com.baidu.adp.lib.cache.l<String> lVar = this.kqU.get();
        if (lVar != null) {
            cNf();
            this.kqW++;
            lVar.asyncSet(this.kqX, Integer.toString(this.kqW), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public int cNd() {
        if (Jn(cNe())) {
            return this.kqW;
        }
        return 0;
    }

    private String cNe() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Jn(String str) {
        if (TextUtils.isEmpty(this.kqX)) {
            return false;
        }
        return this.kqX.equals(str);
    }

    private void cNf() {
        String cNe = cNe();
        if (!Jn(cNe)) {
            this.kqV.clear();
            this.kqW = 0;
            this.kqX = cNe;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0635a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kre;
        private final String krf;
        private final Runnable krg;

        private C0635a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.kre = atomicReference;
            this.krf = str;
            this.krg = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.kre.get() == null) {
                synchronized (C0635a.class) {
                    if (this.kre.get() == null) {
                        this.kre.set(com.baidu.tbadk.core.c.a.aMT().ud(this.krf));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0635a) r2);
            if (this.krg != null) {
                this.krg.run();
            }
        }
    }
}
