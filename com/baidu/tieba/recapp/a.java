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
/* loaded from: classes25.dex */
public class a implements k, m {
    private static volatile a msT;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> msU = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> msV = new AtomicReference<>(null);
    private boolean msZ = false;
    private boolean mta = false;
    private CustomMessageListener mtb = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bIE().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> msW = new HashMap<>();
    private int msX = 0;
    private String msY = dzE();

    public static a dzz() {
        if (msT == null) {
            synchronized (a.class) {
                if (msT == null) {
                    msT = new a();
                }
            }
        }
        return msT;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.mtb);
    }

    @Override // com.baidu.tieba.recapp.k
    public void dzA() {
        if (!this.msZ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.msU.get();
                    if (lVar != null) {
                        lVar.a(a.this.msY, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eX */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.QH(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.msW.put(fVar.forumName, fVar);
                                            a.this.msZ = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.msU.get() == null) {
                new C0836a(this.msU, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        dzF();
        f fVar = this.msW.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.msW.put(fVar.forumName, fVar);
        }
        fVar.ax(z, z2);
        H(this.msW);
    }

    private synchronized void H(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.msU.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject aiy = entry.getValue().aiy();
                if (aiy != null) {
                    jSONArray.put(aiy);
                }
            }
            lVar.asyncSet(this.msY, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public int aZ(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.k
    public int ba(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.msW.get(str);
        if (fVar == null || !QI(dzE())) {
            return 0;
        }
        return fVar.aw(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> QH(String str) {
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

    @Override // com.baidu.tieba.recapp.m
    public void dzB() {
        if (!this.mta) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.msV.get()).a(a.this.msY, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eX */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.msX = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.msX = 0;
                                }
                                a.this.mta = true;
                            }
                        }
                    });
                }
            };
            if (this.msV.get() == null) {
                new C0836a(this.msV, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void dzC() {
        com.baidu.adp.lib.cache.l<String> lVar = this.msV.get();
        if (lVar != null) {
            dzF();
            this.msX++;
            lVar.asyncSet(this.msY, Integer.toString(this.msX), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public int dzD() {
        if (QI(dzE())) {
            return this.msX;
        }
        return 0;
    }

    private String dzE() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean QI(String str) {
        if (TextUtils.isEmpty(this.msY)) {
            return false;
        }
        return this.msY.equals(str);
    }

    private void dzF() {
        String dzE = dzE();
        if (!QI(dzE)) {
            this.msW.clear();
            this.msX = 0;
            this.msY = dzE;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static final class C0836a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mtf;
        private final String mtg;
        private final Runnable mth;

        private C0836a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mtf = atomicReference;
            this.mtg = str;
            this.mth = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mtf.get() == null) {
                synchronized (C0836a.class) {
                    if (this.mtf.get() == null) {
                        this.mtf.set(com.baidu.tbadk.core.c.a.bob().AH(this.mtg));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0836a) r2);
            if (this.mth != null) {
                this.mth.run();
            }
        }
    }
}
