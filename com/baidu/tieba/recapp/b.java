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
    private static volatile b mQT;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mQU = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mQV = new AtomicReference<>(null);
    private boolean mQZ = false;
    private boolean mRa = false;
    private CustomMessageListener mRb = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bLi().a(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    };
    private HashMap<String, g> mQW = new HashMap<>();
    private int mQX = 0;
    private String mQY = dDc();

    public static b dCX() {
        if (mQT == null) {
            synchronized (b.class) {
                if (mQT == null) {
                    mQT = new b();
                }
            }
        }
        return mQT;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.mRb);
    }

    @Override // com.baidu.tieba.recapp.l
    public void dCY() {
        if (!this.mQZ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.mQU.get();
                    if (lVar != null) {
                        lVar.a(b.this.mQY, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fd */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Rj(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.mQW.put(gVar.forumName, gVar);
                                            b.this.mQZ = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mQU.get() == null) {
                new a(this.mQU, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dDd();
        g gVar = this.mQW.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.mQW.put(gVar.forumName, gVar);
        }
        gVar.az(z, z2);
        I(this.mQW);
    }

    private synchronized void I(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mQU.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject ajv = entry.getValue().ajv();
                if (ajv != null) {
                    jSONArray.put(ajv);
                }
            }
            lVar.asyncSet(this.mQY, jSONArray.toString(), 86400000L);
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
        g gVar = this.mQW.get(str);
        if (gVar == null || !Rk(dDc())) {
            return 0;
        }
        return gVar.ay(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Rj(String str) {
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
    public void dCZ() {
        if (!this.mRa) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.mQV.get()).a(b.this.mQY, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fd */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.mQX = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.mQX = 0;
                                }
                                b.this.mRa = true;
                            }
                        }
                    });
                }
            };
            if (this.mQV.get() == null) {
                new a(this.mQV, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public void dDa() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mQV.get();
        if (lVar != null) {
            dDd();
            this.mQX++;
            lVar.asyncSet(this.mQY, Integer.toString(this.mQX), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public int dDb() {
        if (Rk(dDc())) {
            return this.mQX;
        }
        return 0;
    }

    private String dDc() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Rk(String str) {
        if (TextUtils.isEmpty(this.mQY)) {
            return false;
        }
        return this.mQY.equals(str);
    }

    private void dDd() {
        String dDc = dDc();
        if (!Rk(dDc)) {
            this.mQW.clear();
            this.mQX = 0;
            this.mQY = dDc;
        }
    }

    /* loaded from: classes8.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mRf;
        private final String mRg;
        private final Runnable mRh;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mRf = atomicReference;
            this.mRg = str;
            this.mRh = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mRf.get() == null) {
                synchronized (a.class) {
                    if (this.mRf.get() == null) {
                        this.mRf.set(com.baidu.tbadk.core.c.a.bqr().As(this.mRg));
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
            if (this.mRh != null) {
                this.mRh.run();
            }
        }
    }
}
