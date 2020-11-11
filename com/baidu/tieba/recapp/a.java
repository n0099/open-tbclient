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
/* loaded from: classes26.dex */
public class a implements j, l {
    private static volatile a msB;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> msC = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> msD = new AtomicReference<>(null);
    private boolean msH = false;
    private boolean msI = false;
    private CustomMessageListener msJ = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bJk().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> msE = new HashMap<>();
    private int msF = 0;
    private String msG = dAe();

    public static a dzZ() {
        if (msB == null) {
            synchronized (a.class) {
                if (msB == null) {
                    msB = new a();
                }
            }
        }
        return msB;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.msJ);
    }

    @Override // com.baidu.tieba.recapp.j
    public void dAa() {
        if (!this.msH) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.msC.get();
                    if (lVar != null) {
                        lVar.a(a.this.msG, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eX */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Rm(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.msE.put(fVar.forumName, fVar);
                                            a.this.msH = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.msC.get() == null) {
                new C0833a(this.msC, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dAf();
        f fVar = this.msE.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.msE.put(fVar.forumName, fVar);
        }
        fVar.aA(z, z2);
        I(this.msE);
    }

    private synchronized void I(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.msC.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject ajg = entry.getValue().ajg();
                if (ajg != null) {
                    jSONArray.put(ajg);
                }
            }
            lVar.asyncSet(this.msG, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aZ(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ba(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.msE.get(str);
        if (fVar == null || !Rn(dAe())) {
            return 0;
        }
        return fVar.az(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Rm(String str) {
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
    public void dAb() {
        if (!this.msI) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.msD.get()).a(a.this.msG, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eX */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.msF = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.msF = 0;
                                }
                                a.this.msI = true;
                            }
                        }
                    });
                }
            };
            if (this.msD.get() == null) {
                new C0833a(this.msD, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void dAc() {
        com.baidu.adp.lib.cache.l<String> lVar = this.msD.get();
        if (lVar != null) {
            dAf();
            this.msF++;
            lVar.asyncSet(this.msG, Integer.toString(this.msF), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int dAd() {
        if (Rn(dAe())) {
            return this.msF;
        }
        return 0;
    }

    private String dAe() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Rn(String str) {
        if (TextUtils.isEmpty(this.msG)) {
            return false;
        }
        return this.msG.equals(str);
    }

    private void dAf() {
        String dAe = dAe();
        if (!Rn(dAe)) {
            this.msE.clear();
            this.msF = 0;
            this.msG = dAe;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private static final class C0833a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> msN;
        private final String msO;
        private final Runnable msP;

        private C0833a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.msN = atomicReference;
            this.msO = str;
            this.msP = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.msN.get() == null) {
                synchronized (C0833a.class) {
                    if (this.msN.get() == null) {
                        this.msN.set(com.baidu.tbadk.core.c.a.boX().Bm(this.msO));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0833a) r2);
            if (this.msP != null) {
                this.msP.run();
            }
        }
    }
}
