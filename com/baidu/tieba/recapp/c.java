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
public class c implements m, o {
    private static volatile c mTp;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mTq = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mTr = new AtomicReference<>(null);
    private boolean mTv = false;
    private boolean mTw = false;
    private CustomMessageListener mTx = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bLr().a(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    };
    private HashMap<String, h> mTs = new HashMap<>();
    private int mTt = 0;
    private String mTu = dDr();

    public static c dDm() {
        if (mTp == null) {
            synchronized (c.class) {
                if (mTp == null) {
                    mTp = new c();
                }
            }
        }
        return mTp;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.mTx);
    }

    @Override // com.baidu.tieba.recapp.m
    public void dDn() {
        if (!this.mTv) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) c.this.mTq.get();
                    if (lVar != null) {
                        lVar.a(c.this.mTu, new l.a<String>() { // from class: com.baidu.tieba.recapp.c.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: fd */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = c.this.Rw(str2).iterator();
                                    while (it.hasNext()) {
                                        h hVar = (h) it.next();
                                        if (hVar != null) {
                                            c.this.mTs.put(hVar.forumName, hVar);
                                            c.this.mTv = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mTq.get() == null) {
                new a(this.mTq, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dDs();
        h hVar = this.mTs.get(str);
        if (hVar == null) {
            hVar = new h();
            hVar.forumName = str;
            this.mTs.put(hVar.forumName, hVar);
        }
        hVar.az(z, z2);
        I(this.mTs);
    }

    private synchronized void I(HashMap<String, h> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mTq.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, h> entry : hashMap.entrySet()) {
                JSONObject ajy = entry.getValue().ajy();
                if (ajy != null) {
                    jSONArray.put(ajy);
                }
            }
            lVar.asyncSet(this.mTu, jSONArray.toString(), 86400000L);
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
        h hVar = this.mTs.get(str);
        if (hVar == null || !Rx(dDr())) {
            return 0;
        }
        return hVar.ay(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<h> Rw(String str) {
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
    public void dDo() {
        if (!this.mTw) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.c.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) c.this.mTr.get()).a(c.this.mTu, new l.a<String>() { // from class: com.baidu.tieba.recapp.c.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: fd */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    c.this.mTt = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    c.this.mTt = 0;
                                }
                                c.this.mTw = true;
                            }
                        }
                    });
                }
            };
            if (this.mTr.get() == null) {
                new a(this.mTr, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public void dDp() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mTr.get();
        if (lVar != null) {
            dDs();
            this.mTt++;
            lVar.asyncSet(this.mTu, Integer.toString(this.mTt), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public int dDq() {
        if (Rx(dDr())) {
            return this.mTt;
        }
        return 0;
    }

    private String dDr() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Rx(String str) {
        if (TextUtils.isEmpty(this.mTu)) {
            return false;
        }
        return this.mTu.equals(str);
    }

    private void dDs() {
        String dDr = dDr();
        if (!Rx(dDr)) {
            this.mTs.clear();
            this.mTt = 0;
            this.mTu = dDr;
        }
    }

    /* loaded from: classes7.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mTB;
        private final String mTC;
        private final Runnable mTD;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mTB = atomicReference;
            this.mTC = str;
            this.mTD = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mTB.get() == null) {
                synchronized (a.class) {
                    if (this.mTB.get() == null) {
                        this.mTB.set(com.baidu.tbadk.core.c.a.bqt().Az(this.mTC));
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
            if (this.mTD != null) {
                this.mTD.run();
            }
        }
    }
}
