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
/* loaded from: classes20.dex */
public class a implements j, l {
    private static volatile a lBU;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lBV = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> lBW = new AtomicReference<>(null);
    private boolean lCa = false;
    private boolean lCb = false;
    private CustomMessageListener lCc = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bAU().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> lBX = new HashMap<>();
    private int lBY = 0;
    private String lBZ = dna();

    public static a dmV() {
        if (lBU == null) {
            synchronized (a.class) {
                if (lBU == null) {
                    lBU = new a();
                }
            }
        }
        return lBU;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.lCc);
    }

    @Override // com.baidu.tieba.recapp.j
    public void dmW() {
        if (!this.lCa) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.lBV.get();
                    if (lVar != null) {
                        lVar.a(a.this.lBZ, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eH */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Pi(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.lBX.put(fVar.forumName, fVar);
                                            a.this.lCa = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.lBV.get() == null) {
                new C0788a(this.lBV, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dnb();
        f fVar = this.lBX.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.lBX.put(fVar.forumName, fVar);
        }
        fVar.aw(z, z2);
        G(this.lBX);
    }

    private synchronized void G(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.lBV.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject abr = entry.getValue().abr();
                if (abr != null) {
                    jSONArray.put(abr);
                }
            }
            lVar.asyncSet(this.lBZ, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aT(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int aU(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.lBX.get(str);
        if (fVar == null || !Pj(dna())) {
            return 0;
        }
        return fVar.av(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Pi(String str) {
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

    @Override // com.baidu.tieba.recapp.l
    public void dmX() {
        if (!this.lCb) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.lBW.get()).a(a.this.lBZ, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eH */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.lBY = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.lBY = 0;
                                }
                                a.this.lCb = true;
                            }
                        }
                    });
                }
            };
            if (this.lBW.get() == null) {
                new C0788a(this.lBW, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void dmY() {
        com.baidu.adp.lib.cache.l<String> lVar = this.lBW.get();
        if (lVar != null) {
            dnb();
            this.lBY++;
            lVar.asyncSet(this.lBZ, Integer.toString(this.lBY), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int dmZ() {
        if (Pj(dna())) {
            return this.lBY;
        }
        return 0;
    }

    private String dna() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Pj(String str) {
        if (TextUtils.isEmpty(this.lBZ)) {
            return false;
        }
        return this.lBZ.equals(str);
    }

    private void dnb() {
        String dna = dna();
        if (!Pj(dna)) {
            this.lBX.clear();
            this.lBY = 0;
            this.lBZ = dna;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static final class C0788a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lCg;
        private final String lCh;
        private final Runnable lCi;

        private C0788a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.lCg = atomicReference;
            this.lCh = str;
            this.lCi = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.lCg.get() == null) {
                synchronized (C0788a.class) {
                    if (this.lCg.get() == null) {
                        this.lCg.set(com.baidu.tbadk.core.c.a.bhb().zy(this.lCh));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0788a) r2);
            if (this.lCi != null) {
                this.lCi.run();
            }
        }
    }
}
