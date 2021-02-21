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
public class c implements m, o {
    private static volatile c mRj;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mRk = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mRl = new AtomicReference<>(null);
    private boolean mRp = false;
    private boolean mRq = false;
    private CustomMessageListener mRr = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bLn().a(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    };
    private HashMap<String, h> mRm = new HashMap<>();
    private int mRn = 0;
    private String mRo = dDj();

    public static c dDe() {
        if (mRj == null) {
            synchronized (c.class) {
                if (mRj == null) {
                    mRj = new c();
                }
            }
        }
        return mRj;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.mRr);
    }

    @Override // com.baidu.tieba.recapp.m
    public void dDf() {
        if (!this.mRp) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) c.this.mRk.get();
                    if (lVar != null) {
                        lVar.a(c.this.mRo, new l.a<String>() { // from class: com.baidu.tieba.recapp.c.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fd */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = c.this.Rq(str2).iterator();
                                    while (it.hasNext()) {
                                        h hVar = (h) it.next();
                                        if (hVar != null) {
                                            c.this.mRm.put(hVar.forumName, hVar);
                                            c.this.mRp = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mRk.get() == null) {
                new a(this.mRk, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        dDk();
        h hVar = this.mRm.get(str);
        if (hVar == null) {
            hVar = new h();
            hVar.forumName = str;
            this.mRm.put(hVar.forumName, hVar);
        }
        hVar.az(z, z2);
        I(this.mRm);
    }

    private synchronized void I(HashMap<String, h> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mRk.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, h> entry : hashMap.entrySet()) {
                JSONObject ajv = entry.getValue().ajv();
                if (ajv != null) {
                    jSONArray.put(ajv);
                }
            }
            lVar.asyncSet(this.mRo, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public int ba(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.m
    public int bb(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        h hVar = this.mRm.get(str);
        if (hVar == null || !Rr(dDj())) {
            return 0;
        }
        return hVar.ay(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> Rq(String str) {
        ArrayList<h> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new h(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.recapp.o
    public void dDg() {
        if (!this.mRq) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.c.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) c.this.mRl.get()).a(c.this.mRo, new l.a<String>() { // from class: com.baidu.tieba.recapp.c.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fd */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    c.this.mRn = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    c.this.mRn = 0;
                                }
                                c.this.mRq = true;
                            }
                        }
                    });
                }
            };
            if (this.mRl.get() == null) {
                new a(this.mRl, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public void dDh() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mRl.get();
        if (lVar != null) {
            dDk();
            this.mRn++;
            lVar.asyncSet(this.mRo, Integer.toString(this.mRn), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public int dDi() {
        if (Rr(dDj())) {
            return this.mRn;
        }
        return 0;
    }

    private String dDj() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Rr(String str) {
        if (TextUtils.isEmpty(this.mRo)) {
            return false;
        }
        return this.mRo.equals(str);
    }

    private void dDk() {
        String dDj = dDj();
        if (!Rr(dDj)) {
            this.mRm.clear();
            this.mRn = 0;
            this.mRo = dDj;
        }
    }

    /* loaded from: classes8.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mRv;
        private final String mRw;
        private final Runnable mRx;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mRv = atomicReference;
            this.mRw = str;
            this.mRx = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mRv.get() == null) {
                synchronized (a.class) {
                    if (this.mRv.get() == null) {
                        this.mRv.set(com.baidu.tbadk.core.c.a.bqr().As(this.mRw));
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
            if (this.mRx != null) {
                this.mRx.run();
            }
        }
    }
}
