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
    private static volatile b gNJ;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gNK = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gNL = new AtomicReference<>(null);
    private boolean gNP = false;
    private boolean gNQ = false;
    private CustomMessageListener gNR = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Wi().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gNM = new HashMap<>();
    private int gNN = 0;
    private String gNO = buZ();

    public static b buU() {
        if (gNJ == null) {
            synchronized (b.class) {
                if (gNJ == null) {
                    gNJ = new b();
                }
            }
        }
        return gNJ;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gNR);
    }

    @Override // com.baidu.tieba.recapp.j
    public void buV() {
        if (!this.gNP) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gNK.get();
                    if (lVar != null) {
                        lVar.a(b.this.gNO, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cw */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.oN(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gNM.put(gVar.forumName, gVar);
                                            b.this.gNP = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gNK.get() == null) {
                synchronized (b.class) {
                    new a(this.gNK, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bva();
        g gVar = this.gNM.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gNM.put(gVar.forumName, gVar);
        }
        gVar.U(z, z2);
        s(this.gNM);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gNK.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bvd = entry.getValue().bvd();
                if (bvd != null) {
                    jSONArray.put(bvd);
                }
            }
            lVar.b(this.gNO, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aa(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ab(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gNM.get(str);
        if (gVar == null || !uy(buZ())) {
            return 0;
        }
        return gVar.T(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> oN(String str) {
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
    public void buW() {
        if (!this.gNQ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gNL.get()).a(b.this.gNO, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cw */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gNN = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gNN = 0;
                                }
                                b.this.gNQ = true;
                            }
                        }
                    });
                }
            };
            if (this.gNL.get() == null) {
                synchronized (b.class) {
                    new a(this.gNL, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void buX() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gNL.get();
        if (lVar != null) {
            bva();
            this.gNN++;
            lVar.b(this.gNO, Integer.toString(this.gNN), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int buY() {
        if (uy(buZ())) {
            return this.gNN;
        }
        return 0;
    }

    private String buZ() {
        return new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date());
    }

    private boolean uy(String str) {
        if (TextUtils.isEmpty(this.gNO)) {
            return false;
        }
        return this.gNO.equals(str);
    }

    private void bva() {
        String buZ = buZ();
        if (!uy(buZ)) {
            this.gNM.clear();
            this.gNN = 0;
            this.gNO = buZ;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gNV;
        private final String gNW;
        private final Runnable gNX;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gNV = atomicReference;
            this.gNW = str;
            this.gNX = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gNV.get() == null) {
                synchronized (b.class) {
                    if (this.gNV.get() == null) {
                        this.gNV.set(com.baidu.tbadk.core.c.a.BB().ey(this.gNW));
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
            if (this.gNX != null) {
                this.gNX.run();
            }
        }
    }
}
