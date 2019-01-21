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
    private static volatile b gOO;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gOP = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gOQ = new AtomicReference<>(null);
    private boolean gOU = false;
    private boolean gOV = false;
    private CustomMessageListener gOW = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.WE().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gOR = new HashMap<>();
    private int gOS = 0;
    private String gOT = bvI();

    public static b bvD() {
        if (gOO == null) {
            synchronized (b.class) {
                if (gOO == null) {
                    gOO = new b();
                }
            }
        }
        return gOO;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gOW);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bvE() {
        if (!this.gOU) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gOP.get();
                    if (lVar != null) {
                        lVar.a(b.this.gOT, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cx */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.pd(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gOR.put(gVar.forumName, gVar);
                                            b.this.gOU = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gOP.get() == null) {
                synchronized (b.class) {
                    new a(this.gOP, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bvJ();
        g gVar = this.gOR.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gOR.put(gVar.forumName, gVar);
        }
        gVar.U(z, z2);
        s(this.gOR);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gOP.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bvM = entry.getValue().bvM();
                if (bvM != null) {
                    jSONArray.put(bvM);
                }
            }
            lVar.b(this.gOT, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int Z(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int aa(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gOR.get(str);
        if (gVar == null || !uO(bvI())) {
            return 0;
        }
        return gVar.T(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> pd(String str) {
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
    public void bvF() {
        if (!this.gOV) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gOQ.get()).a(b.this.gOT, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cx */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gOS = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gOS = 0;
                                }
                                b.this.gOV = true;
                            }
                        }
                    });
                }
            };
            if (this.gOQ.get() == null) {
                synchronized (b.class) {
                    new a(this.gOQ, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bvG() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gOQ.get();
        if (lVar != null) {
            bvJ();
            this.gOS++;
            lVar.b(this.gOT, Integer.toString(this.gOS), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bvH() {
        if (uO(bvI())) {
            return this.gOS;
        }
        return 0;
    }

    private String bvI() {
        return new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date());
    }

    private boolean uO(String str) {
        if (TextUtils.isEmpty(this.gOT)) {
            return false;
        }
        return this.gOT.equals(str);
    }

    private void bvJ() {
        String bvI = bvI();
        if (!uO(bvI)) {
            this.gOR.clear();
            this.gOS = 0;
            this.gOT = bvI;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gPa;
        private final String gPb;
        private final Runnable gPc;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gPa = atomicReference;
            this.gPb = str;
            this.gPc = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gPa.get() == null) {
                synchronized (b.class) {
                    if (this.gPa.get() == null) {
                        this.gPa.set(com.baidu.tbadk.core.c.a.BO().eH(this.gPb));
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
            if (this.gPc != null) {
                this.gPc.run();
            }
        }
    }
}
