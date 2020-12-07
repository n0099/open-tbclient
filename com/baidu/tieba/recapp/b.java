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
public class b implements l, n {
    private static volatile b mHa;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mHb = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mHc = new AtomicReference<>(null);
    private boolean mHg = false;
    private boolean mHh = false;
    private CustomMessageListener mHi = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bMm().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> mHd = new HashMap<>();
    private int mHe = 0;
    private String mHf = dEV();

    public static b dEQ() {
        if (mHa == null) {
            synchronized (b.class) {
                if (mHa == null) {
                    mHa = new b();
                }
            }
        }
        return mHa;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.mHi);
    }

    @Override // com.baidu.tieba.recapp.l
    public void dER() {
        if (!this.mHg) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.mHb.get();
                    if (lVar != null) {
                        lVar.a(b.this.mHf, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fd */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.RQ(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.mHd.put(gVar.forumName, gVar);
                                            b.this.mHg = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mHb.get() == null) {
                new a(this.mHb, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dEW();
        g gVar = this.mHd.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.mHd.put(gVar.forumName, gVar);
        }
        gVar.ax(z, z2);
        H(this.mHd);
    }

    private synchronized void H(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mHb.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject alG = entry.getValue().alG();
                if (alG != null) {
                    jSONArray.put(alG);
                }
            }
            lVar.asyncSet(this.mHf, jSONArray.toString(), 86400000L);
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
        g gVar = this.mHd.get(str);
        if (gVar == null || !RR(dEV())) {
            return 0;
        }
        return gVar.aw(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> RQ(String str) {
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
    public void dES() {
        if (!this.mHh) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.mHc.get()).a(b.this.mHf, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fd */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.mHe = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.mHe = 0;
                                }
                                b.this.mHh = true;
                            }
                        }
                    });
                }
            };
            if (this.mHc.get() == null) {
                new a(this.mHc, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public void dET() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mHc.get();
        if (lVar != null) {
            dEW();
            this.mHe++;
            lVar.asyncSet(this.mHf, Integer.toString(this.mHe), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public int dEU() {
        if (RR(dEV())) {
            return this.mHe;
        }
        return 0;
    }

    private String dEV() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean RR(String str) {
        if (TextUtils.isEmpty(this.mHf)) {
            return false;
        }
        return this.mHf.equals(str);
    }

    private void dEW() {
        String dEV = dEV();
        if (!RR(dEV)) {
            this.mHd.clear();
            this.mHe = 0;
            this.mHf = dEV;
        }
    }

    /* loaded from: classes26.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mHm;
        private final String mHn;
        private final Runnable mHo;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mHm = atomicReference;
            this.mHn = str;
            this.mHo = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mHm.get() == null) {
                synchronized (a.class) {
                    if (this.mHm.get() == null) {
                        this.mHm.set(com.baidu.tbadk.core.c.a.brq().Bo(this.mHn));
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
            if (this.mHo != null) {
                this.mHo.run();
            }
        }
    }
}
