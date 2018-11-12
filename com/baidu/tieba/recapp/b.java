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
    private static volatile b gEc;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gEd = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gEe = new AtomicReference<>(null);
    private boolean gEi = false;
    private boolean gEj = false;
    private CustomMessageListener gEk = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Va().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gEf = new HashMap<>();
    private int gEg = 0;
    private String gEh = bsv();

    public static b bsq() {
        if (gEc == null) {
            synchronized (b.class) {
                if (gEc == null) {
                    gEc = new b();
                }
            }
        }
        return gEc;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gEk);
    }

    @Override // com.baidu.tieba.recapp.j
    public void bsr() {
        if (!this.gEi) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gEd.get();
                    if (lVar != null) {
                        lVar.a(b.this.gEh, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cr */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.ok(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gEf.put(gVar.forumName, gVar);
                                            b.this.gEi = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gEd.get() == null) {
                synchronized (b.class) {
                    new a(this.gEd, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bsw();
        g gVar = this.gEf.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gEf.put(gVar.forumName, gVar);
        }
        gVar.U(z, z2);
        r(this.gEf);
    }

    private synchronized void r(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gEd.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bsz = entry.getValue().bsz();
                if (bsz != null) {
                    jSONArray.put(bsz);
                }
            }
            lVar.b(this.gEh, jSONArray.toString(), 86400000L);
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
        g gVar = this.gEf.get(str);
        if (gVar == null || !tU(bsv())) {
            return 0;
        }
        return gVar.T(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> ok(String str) {
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
    public void bss() {
        if (!this.gEj) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gEe.get()).a(b.this.gEh, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cr */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gEg = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gEg = 0;
                                }
                                b.this.gEj = true;
                            }
                        }
                    });
                }
            };
            if (this.gEe.get() == null) {
                synchronized (b.class) {
                    new a(this.gEe, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bst() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gEe.get();
        if (lVar != null) {
            bsw();
            this.gEg++;
            lVar.b(this.gEh, Integer.toString(this.gEg), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bsu() {
        if (tU(bsv())) {
            return this.gEg;
        }
        return 0;
    }

    private String bsv() {
        return new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date());
    }

    private boolean tU(String str) {
        if (TextUtils.isEmpty(this.gEh)) {
            return false;
        }
        return this.gEh.equals(str);
    }

    private void bsw() {
        String bsv = bsv();
        if (!tU(bsv)) {
            this.gEf.clear();
            this.gEg = 0;
            this.gEh = bsv;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gEo;
        private final String gEp;
        private final Runnable gEq;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gEo = atomicReference;
            this.gEp = str;
            this.gEq = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gEo.get() == null) {
                synchronized (b.class) {
                    if (this.gEo.get() == null) {
                        this.gEo.set(com.baidu.tbadk.core.c.a.Ax().eg(this.gEp));
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
            if (this.gEq != null) {
                this.gEq.run();
            }
        }
    }
}
