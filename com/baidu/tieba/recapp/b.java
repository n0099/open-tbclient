package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
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
/* loaded from: classes3.dex */
public class b implements j, l {
    private static volatile b gCB;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gCC = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gCD = new AtomicReference<>(null);
    private boolean gCH = false;
    private boolean gCI = false;
    private CustomMessageListener gCJ = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.UR().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gCE = new HashMap<>();
    private int gCF = 0;
    private String gCG = bsZ();

    public static b bsU() {
        if (gCB == null) {
            synchronized (b.class) {
                if (gCB == null) {
                    gCB = new b();
                }
            }
        }
        return gCB;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gCJ);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bsV() {
        if (!this.gCH) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gCC.get();
                    if (lVar != null) {
                        lVar.a(b.this.gCG, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cr */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.oj(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gCE.put(gVar.forumName, gVar);
                                            b.this.gCH = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gCC.get() == null) {
                synchronized (b.class) {
                    new a(this.gCC, "frs.refresh.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            h(str, true, z);
        } else if (i == 2) {
            h(str, false, z);
        }
    }

    private void h(String str, boolean z, boolean z2) {
        bta();
        g gVar = this.gCE.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gCE.put(gVar.forumName, gVar);
        }
        gVar.S(z, z2);
        t(this.gCE);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gCC.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject btd = entry.getValue().btd();
                if (btd != null) {
                    jSONArray.put(btd);
                }
            }
            lVar.b(this.gCG, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int Y(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int Z(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gCE.get(str);
        if (gVar == null || !tQ(bsZ())) {
            return 0;
        }
        return gVar.R(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> oj(String str) {
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

    @Override // com.baidu.tieba.recapp.l
    public void bsW() {
        if (!this.gCI) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gCD.get()).a(b.this.gCG, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cr */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gCF = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gCF = 0;
                                }
                                b.this.gCI = true;
                            }
                        }
                    });
                }
            };
            if (this.gCD.get() == null) {
                synchronized (b.class) {
                    new a(this.gCD, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bsX() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gCD.get();
        if (lVar != null) {
            bta();
            this.gCF++;
            lVar.b(this.gCG, Integer.toString(this.gCF), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bsY() {
        if (tQ(bsZ())) {
            return this.gCF;
        }
        return 0;
    }

    private String bsZ() {
        return new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date());
    }

    private boolean tQ(String str) {
        if (TextUtils.isEmpty(this.gCG)) {
            return false;
        }
        return this.gCG.equals(str);
    }

    private void bta() {
        String bsZ = bsZ();
        if (!tQ(bsZ)) {
            this.gCE.clear();
            this.gCF = 0;
            this.gCG = bsZ;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gCN;
        private final String gCO;
        private final Runnable gCP;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gCN = atomicReference;
            this.gCO = str;
            this.gCP = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gCN.get() == null) {
                synchronized (b.class) {
                    if (this.gCN.get() == null) {
                        this.gCN.set(com.baidu.tbadk.core.c.a.Aq().eg(this.gCO));
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
            if (this.gCP != null) {
                this.gCP.run();
            }
        }
    }
}
