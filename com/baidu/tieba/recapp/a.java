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
    private static volatile a lBJ;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lBK = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> lBL = new AtomicReference<>(null);
    private boolean lBP = false;
    private boolean lBQ = false;
    private CustomMessageListener lBR = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bAT().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> lBM = new HashMap<>();
    private int lBN = 0;
    private String lBO = dmX();

    public static a dmS() {
        if (lBJ == null) {
            synchronized (a.class) {
                if (lBJ == null) {
                    lBJ = new a();
                }
            }
        }
        return lBJ;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.lBR);
    }

    @Override // com.baidu.tieba.recapp.j
    public void dmT() {
        if (!this.lBP) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.lBK.get();
                    if (lVar != null) {
                        lVar.a(a.this.lBO, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eG */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Ph(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.lBM.put(fVar.forumName, fVar);
                                            a.this.lBP = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.lBK.get() == null) {
                new C0788a(this.lBK, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dmY();
        f fVar = this.lBM.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.lBM.put(fVar.forumName, fVar);
        }
        fVar.aw(z, z2);
        G(this.lBM);
    }

    private synchronized void G(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.lBK.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject abr = entry.getValue().abr();
                if (abr != null) {
                    jSONArray.put(abr);
                }
            }
            lVar.asyncSet(this.lBO, jSONArray.toString(), 86400000L);
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
        f fVar = this.lBM.get(str);
        if (fVar == null || !Pi(dmX())) {
            return 0;
        }
        return fVar.av(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Ph(String str) {
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
    public void dmU() {
        if (!this.lBQ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.lBL.get()).a(a.this.lBO, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eG */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.lBN = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.lBN = 0;
                                }
                                a.this.lBQ = true;
                            }
                        }
                    });
                }
            };
            if (this.lBL.get() == null) {
                new C0788a(this.lBL, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void dmV() {
        com.baidu.adp.lib.cache.l<String> lVar = this.lBL.get();
        if (lVar != null) {
            dmY();
            this.lBN++;
            lVar.asyncSet(this.lBO, Integer.toString(this.lBN), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int dmW() {
        if (Pi(dmX())) {
            return this.lBN;
        }
        return 0;
    }

    private String dmX() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Pi(String str) {
        if (TextUtils.isEmpty(this.lBO)) {
            return false;
        }
        return this.lBO.equals(str);
    }

    private void dmY() {
        String dmX = dmX();
        if (!Pi(dmX)) {
            this.lBM.clear();
            this.lBN = 0;
            this.lBO = dmX;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static final class C0788a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lBV;
        private final String lBW;
        private final Runnable lBX;

        private C0788a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.lBV = atomicReference;
            this.lBW = str;
            this.lBX = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.lBV.get() == null) {
                synchronized (C0788a.class) {
                    if (this.lBV.get() == null) {
                        this.lBV.set(com.baidu.tbadk.core.c.a.bhb().zx(this.lBW));
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
            if (this.lBX != null) {
                this.lBX.run();
            }
        }
    }
}
