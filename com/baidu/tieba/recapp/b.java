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
    private static volatile b mHc;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mHd = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mHe = new AtomicReference<>(null);
    private boolean mHi = false;
    private boolean mHj = false;
    private CustomMessageListener mHk = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bMn().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> mHf = new HashMap<>();
    private int mHg = 0;
    private String mHh = dEW();

    public static b dER() {
        if (mHc == null) {
            synchronized (b.class) {
                if (mHc == null) {
                    mHc = new b();
                }
            }
        }
        return mHc;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.mHk);
    }

    @Override // com.baidu.tieba.recapp.l
    public void dES() {
        if (!this.mHi) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.mHd.get();
                    if (lVar != null) {
                        lVar.a(b.this.mHh, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fd */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.RQ(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.mHf.put(gVar.forumName, gVar);
                                            b.this.mHi = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mHd.get() == null) {
                new a(this.mHd, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dEX();
        g gVar = this.mHf.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.mHf.put(gVar.forumName, gVar);
        }
        gVar.ax(z, z2);
        H(this.mHf);
    }

    private synchronized void H(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mHd.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject alG = entry.getValue().alG();
                if (alG != null) {
                    jSONArray.put(alG);
                }
            }
            lVar.asyncSet(this.mHh, jSONArray.toString(), 86400000L);
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
        g gVar = this.mHf.get(str);
        if (gVar == null || !RR(dEW())) {
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
    public void dET() {
        if (!this.mHj) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.mHe.get()).a(b.this.mHh, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fd */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.mHg = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.mHg = 0;
                                }
                                b.this.mHj = true;
                            }
                        }
                    });
                }
            };
            if (this.mHe.get() == null) {
                new a(this.mHe, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public void dEU() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mHe.get();
        if (lVar != null) {
            dEX();
            this.mHg++;
            lVar.asyncSet(this.mHh, Integer.toString(this.mHg), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public int dEV() {
        if (RR(dEW())) {
            return this.mHg;
        }
        return 0;
    }

    private String dEW() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean RR(String str) {
        if (TextUtils.isEmpty(this.mHh)) {
            return false;
        }
        return this.mHh.equals(str);
    }

    private void dEX() {
        String dEW = dEW();
        if (!RR(dEW)) {
            this.mHf.clear();
            this.mHg = 0;
            this.mHh = dEW;
        }
    }

    /* loaded from: classes26.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mHo;
        private final String mHp;
        private final Runnable mHq;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mHo = atomicReference;
            this.mHp = str;
            this.mHq = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mHo.get() == null) {
                synchronized (a.class) {
                    if (this.mHo.get() == null) {
                        this.mHo.set(com.baidu.tbadk.core.c.a.brq().Bo(this.mHp));
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
            if (this.mHq != null) {
                this.mHq.run();
            }
        }
    }
}
