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
    private static volatile b gCA;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gCB = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gCC = new AtomicReference<>(null);
    private boolean gCG = false;
    private boolean gCH = false;
    private CustomMessageListener gCI = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.UR().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gCD = new HashMap<>();
    private int gCE = 0;
    private String gCF = bsZ();

    public static b bsU() {
        if (gCA == null) {
            synchronized (b.class) {
                if (gCA == null) {
                    gCA = new b();
                }
            }
        }
        return gCA;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gCI);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bsV() {
        if (!this.gCG) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gCB.get();
                    if (lVar != null) {
                        lVar.a(b.this.gCF, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cr */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.oj(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gCD.put(gVar.forumName, gVar);
                                            b.this.gCG = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gCB.get() == null) {
                synchronized (b.class) {
                    new a(this.gCB, "frs.refresh.count", runnable).execute(new Void[0]);
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
        g gVar = this.gCD.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gCD.put(gVar.forumName, gVar);
        }
        gVar.S(z, z2);
        t(this.gCD);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gCB.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject btd = entry.getValue().btd();
                if (btd != null) {
                    jSONArray.put(btd);
                }
            }
            lVar.b(this.gCF, jSONArray.toString(), 86400000L);
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
        g gVar = this.gCD.get(str);
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
        if (!this.gCH) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gCC.get()).a(b.this.gCF, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cr */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gCE = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gCE = 0;
                                }
                                b.this.gCH = true;
                            }
                        }
                    });
                }
            };
            if (this.gCC.get() == null) {
                synchronized (b.class) {
                    new a(this.gCC, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bsX() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gCC.get();
        if (lVar != null) {
            bta();
            this.gCE++;
            lVar.b(this.gCF, Integer.toString(this.gCE), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bsY() {
        if (tQ(bsZ())) {
            return this.gCE;
        }
        return 0;
    }

    private String bsZ() {
        return new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date());
    }

    private boolean tQ(String str) {
        if (TextUtils.isEmpty(this.gCF)) {
            return false;
        }
        return this.gCF.equals(str);
    }

    private void bta() {
        String bsZ = bsZ();
        if (!tQ(bsZ)) {
            this.gCD.clear();
            this.gCE = 0;
            this.gCF = bsZ;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gCM;
        private final String gCN;
        private final Runnable gCO;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gCM = atomicReference;
            this.gCN = str;
            this.gCO = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gCM.get() == null) {
                synchronized (b.class) {
                    if (this.gCM.get() == null) {
                        this.gCM.set(com.baidu.tbadk.core.c.a.Aq().eg(this.gCN));
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
            if (this.gCO != null) {
                this.gCO.run();
            }
        }
    }
}
