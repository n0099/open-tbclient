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
/* loaded from: classes7.dex */
public class b implements l, n {
    private static volatile b mHI;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mHJ = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mHK = new AtomicReference<>(null);
    private boolean mHO = false;
    private boolean mHP = false;
    private CustomMessageListener mHQ = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bKO().a(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    };
    private HashMap<String, g> mHL = new HashMap<>();
    private int mHM = 0;
    private String mHN = dAU();

    public static b dAP() {
        if (mHI == null) {
            synchronized (b.class) {
                if (mHI == null) {
                    mHI = new b();
                }
            }
        }
        return mHI;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.mHQ);
    }

    @Override // com.baidu.tieba.recapp.l
    public void dAQ() {
        if (!this.mHO) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.mHJ.get();
                    if (lVar != null) {
                        lVar.a(b.this.mHN, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fd */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Qn(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.mHL.put(gVar.forumName, gVar);
                                            b.this.mHO = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mHJ.get() == null) {
                new a(this.mHJ, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dAV();
        g gVar = this.mHL.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.mHL.put(gVar.forumName, gVar);
        }
        gVar.az(z, z2);
        G(this.mHL);
    }

    private synchronized void G(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mHJ.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject aiX = entry.getValue().aiX();
                if (aiX != null) {
                    jSONArray.put(aiX);
                }
            }
            lVar.asyncSet(this.mHN, jSONArray.toString(), 86400000L);
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
        g gVar = this.mHL.get(str);
        if (gVar == null || !Qo(dAU())) {
            return 0;
        }
        return gVar.ay(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Qn(String str) {
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
    public void dAR() {
        if (!this.mHP) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.mHK.get()).a(b.this.mHN, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fd */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.mHM = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.mHM = 0;
                                }
                                b.this.mHP = true;
                            }
                        }
                    });
                }
            };
            if (this.mHK.get() == null) {
                new a(this.mHK, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public void dAS() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mHK.get();
        if (lVar != null) {
            dAV();
            this.mHM++;
            lVar.asyncSet(this.mHN, Integer.toString(this.mHM), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public int dAT() {
        if (Qo(dAU())) {
            return this.mHM;
        }
        return 0;
    }

    private String dAU() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Qo(String str) {
        if (TextUtils.isEmpty(this.mHN)) {
            return false;
        }
        return this.mHN.equals(str);
    }

    private void dAV() {
        String dAU = dAU();
        if (!Qo(dAU)) {
            this.mHL.clear();
            this.mHM = 0;
            this.mHN = dAU;
        }
    }

    /* loaded from: classes7.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mHU;
        private final String mHV;
        private final Runnable mHW;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mHU = atomicReference;
            this.mHV = str;
            this.mHW = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mHU.get() == null) {
                synchronized (a.class) {
                    if (this.mHU.get() == null) {
                        this.mHU.set(com.baidu.tbadk.core.c.a.bpZ().Ab(this.mHV));
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
            if (this.mHW != null) {
                this.mHW.run();
            }
        }
    }
}
