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
    private static volatile b gnH;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gnI = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gnJ = new AtomicReference<>(null);
    private boolean gnN = false;
    private boolean gnO = false;
    private CustomMessageListener gnP = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Rh().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gnK = new HashMap<>();
    private int gnL = 0;
    private String gnM = bnd();

    public static b bmY() {
        if (gnH == null) {
            synchronized (b.class) {
                if (gnH == null) {
                    gnH = new b();
                }
            }
        }
        return gnH;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gnP);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bmZ() {
        if (!this.gnN) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gnI.get();
                    if (lVar != null) {
                        lVar.a(b.this.gnM, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: bW */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.nb(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gnK.put(gVar.forumName, gVar);
                                            b.this.gnN = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gnI.get() == null) {
                synchronized (b.class) {
                    new a(this.gnI, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bne();
        g gVar = this.gnK.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gnK.put(gVar.forumName, gVar);
        }
        gVar.P(z, z2);
        p(this.gnK);
    }

    private synchronized void p(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gnI.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bnh = entry.getValue().bnh();
                if (bnh != null) {
                    jSONArray.put(bnh);
                }
            }
            lVar.b(this.gnM, jSONArray.toString(), 86400000L);
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
        g gVar = this.gnK.get(str);
        if (gVar == null || !sH(bnd())) {
            return 0;
        }
        return gVar.O(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> nb(String str) {
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
    public void bna() {
        if (!this.gnO) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gnJ.get()).a(b.this.gnM, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: bW */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gnL = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gnL = 0;
                                }
                                b.this.gnO = true;
                            }
                        }
                    });
                }
            };
            if (this.gnJ.get() == null) {
                synchronized (b.class) {
                    new a(this.gnJ, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bnb() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gnJ.get();
        if (lVar != null) {
            bne();
            this.gnL++;
            lVar.b(this.gnM, Integer.toString(this.gnL), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bnc() {
        if (sH(bnd())) {
            return this.gnL;
        }
        return 0;
    }

    private String bnd() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean sH(String str) {
        if (TextUtils.isEmpty(this.gnM)) {
            return false;
        }
        return this.gnM.equals(str);
    }

    private void bne() {
        String bnd = bnd();
        if (!sH(bnd)) {
            this.gnK.clear();
            this.gnL = 0;
            this.gnM = bnd;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gnT;
        private final String gnU;
        private final Runnable gnV;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gnT = atomicReference;
            this.gnU = str;
            this.gnV = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gnT.get() == null) {
                synchronized (b.class) {
                    if (this.gnT.get() == null) {
                        this.gnT.set(com.baidu.tbadk.core.c.a.xa().dy(this.gnU));
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
            if (this.gnV != null) {
                this.gnV.run();
            }
        }
    }
}
