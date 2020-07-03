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
/* loaded from: classes13.dex */
public class a implements i, k {
    private static volatile a ldS;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> ldT = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> ldU = new AtomicReference<>(null);
    private boolean ldY = false;
    private boolean ldZ = false;
    private CustomMessageListener lea = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.boT().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> ldV = new HashMap<>();
    private int ldW = 0;
    private String ldX = cYI();

    public static a cYD() {
        if (ldS == null) {
            synchronized (a.class) {
                if (ldS == null) {
                    ldS = new a();
                }
            }
        }
        return ldS;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.lea);
    }

    @Override // com.baidu.tieba.recapp.i
    public void cYE() {
        if (!this.ldY) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.ldT.get();
                    if (lVar != null) {
                        lVar.a(a.this.ldX, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: en */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.LD(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.ldV.put(fVar.forumName, fVar);
                                            a.this.ldY = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.ldT.get() == null) {
                new C0726a(this.ldT, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        cYJ();
        f fVar = this.ldV.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.ldV.put(fVar.forumName, fVar);
        }
        fVar.aq(z, z2);
        J(this.ldV);
    }

    private synchronized void J(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.ldT.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject UG = entry.getValue().UG();
                if (UG != null) {
                    jSONArray.put(UG);
                }
            }
            lVar.asyncSet(this.ldX, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int aS(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.i
    public int aT(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.ldV.get(str);
        if (fVar == null || !LE(cYI())) {
            return 0;
        }
        return fVar.ap(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> LD(String str) {
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

    @Override // com.baidu.tieba.recapp.k
    public void cYF() {
        if (!this.ldZ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.ldU.get()).a(a.this.ldX, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: en */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.ldW = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.ldW = 0;
                                }
                                a.this.ldZ = true;
                            }
                        }
                    });
                }
            };
            if (this.ldU.get() == null) {
                new C0726a(this.ldU, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void cYG() {
        com.baidu.adp.lib.cache.l<String> lVar = this.ldU.get();
        if (lVar != null) {
            cYJ();
            this.ldW++;
            lVar.asyncSet(this.ldX, Integer.toString(this.ldW), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public int cYH() {
        if (LE(cYI())) {
            return this.ldW;
        }
        return 0;
    }

    private String cYI() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean LE(String str) {
        if (TextUtils.isEmpty(this.ldX)) {
            return false;
        }
        return this.ldX.equals(str);
    }

    private void cYJ() {
        String cYI = cYI();
        if (!LE(cYI)) {
            this.ldV.clear();
            this.ldW = 0;
            this.ldX = cYI;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0726a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lee;
        private final String lef;
        private final Runnable leg;

        private C0726a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.lee = atomicReference;
            this.lef = str;
            this.leg = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.lee.get() == null) {
                synchronized (C0726a.class) {
                    if (this.lee.get() == null) {
                        this.lee.set(com.baidu.tbadk.core.c.a.aUM().wc(this.lef));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0726a) r2);
            if (this.leg != null) {
                this.leg.run();
            }
        }
    }
}
