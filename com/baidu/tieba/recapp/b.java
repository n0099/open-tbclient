package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
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
    private static volatile b gnE;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gnF = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gnG = new AtomicReference<>(null);
    private boolean gnK = false;
    private boolean gnL = false;
    private CustomMessageListener gnM = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Rc().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gnH = new HashMap<>();
    private int gnI = 0;
    private String gnJ = bnc();

    public static b bmX() {
        if (gnE == null) {
            synchronized (b.class) {
                if (gnE == null) {
                    gnE = new b();
                }
            }
        }
        return gnE;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gnM);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bmY() {
        if (!this.gnK) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gnF.get();
                    if (lVar != null) {
                        lVar.a(b.this.gnJ, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: bW */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.mZ(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gnH.put(gVar.forumName, gVar);
                                            b.this.gnK = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gnF.get() == null) {
                synchronized (b.class) {
                    new a(this.gnF, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bnd();
        g gVar = this.gnH.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gnH.put(gVar.forumName, gVar);
        }
        gVar.P(z, z2);
        p(this.gnH);
    }

    private synchronized void p(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gnF.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bng = entry.getValue().bng();
                if (bng != null) {
                    jSONArray.put(bng);
                }
            }
            lVar.b(this.gnJ, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int Q(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int R(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gnH.get(str);
        if (gVar == null || !sD(bnc())) {
            return 0;
        }
        return gVar.O(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> mZ(String str) {
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
    public void bmZ() {
        if (!this.gnL) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gnG.get()).a(b.this.gnJ, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: bW */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gnI = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gnI = 0;
                                }
                                b.this.gnL = true;
                            }
                        }
                    });
                }
            };
            if (this.gnG.get() == null) {
                synchronized (b.class) {
                    new a(this.gnG, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bna() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gnG.get();
        if (lVar != null) {
            bnd();
            this.gnI++;
            lVar.b(this.gnJ, Integer.toString(this.gnI), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bnb() {
        if (sD(bnc())) {
            return this.gnI;
        }
        return 0;
    }

    private String bnc() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean sD(String str) {
        if (TextUtils.isEmpty(this.gnJ)) {
            return false;
        }
        return this.gnJ.equals(str);
    }

    private void bnd() {
        String bnc = bnc();
        if (!sD(bnc)) {
            this.gnH.clear();
            this.gnI = 0;
            this.gnJ = bnc;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gnQ;
        private final String gnR;
        private final Runnable gnS;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gnQ = atomicReference;
            this.gnR = str;
            this.gnS = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gnQ.get() == null) {
                synchronized (b.class) {
                    if (this.gnQ.get() == null) {
                        this.gnQ.set(com.baidu.tbadk.core.c.a.xb().dy(this.gnR));
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
            if (this.gnS != null) {
                this.gnS.run();
            }
        }
    }
}
