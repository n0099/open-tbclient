package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
public class b implements j, l {
    private static volatile b jFs;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jFt = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> jFu = new AtomicReference<>(null);
    private boolean jFy = false;
    private boolean jFz = false;
    private CustomMessageListener jFA = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aXX().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> jFv = new HashMap<>();
    private int jFw = 0;
    private String jFx = cCj();

    public static b cCe() {
        if (jFs == null) {
            synchronized (b.class) {
                if (jFs == null) {
                    jFs = new b();
                }
            }
        }
        return jFs;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.jFA);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cCf() {
        if (!this.jFy) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.jFt.get();
                    if (lVar != null) {
                        lVar.a(b.this.jFx, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dt */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.HH(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.jFv.put(gVar.forumName, gVar);
                                            b.this.jFy = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.jFt.get() == null) {
                new a(this.jFt, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void g(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        cCk();
        g gVar = this.jFv.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.jFv.put(gVar.forumName, gVar);
        }
        gVar.am(z, z2);
        s(this.jFv);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.jFt.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject Jf = entry.getValue().Jf();
                if (Jf != null) {
                    jSONArray.put(Jf);
                }
            }
            lVar.asyncSet(this.jFx, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int ax(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ay(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        g gVar = this.jFv.get(str);
        if (gVar == null || !HI(cCj())) {
            return 0;
        }
        return gVar.al(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> HH(String str) {
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
    public void cCg() {
        if (!this.jFz) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.jFu.get()).a(b.this.jFx, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dt */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.jFw = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.jFw = 0;
                                }
                                b.this.jFz = true;
                            }
                        }
                    });
                }
            };
            if (this.jFu.get() == null) {
                new a(this.jFu, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cCh() {
        com.baidu.adp.lib.cache.l<String> lVar = this.jFu.get();
        if (lVar != null) {
            cCk();
            this.jFw++;
            lVar.asyncSet(this.jFx, Integer.toString(this.jFw), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cCi() {
        if (HI(cCj())) {
            return this.jFw;
        }
        return 0;
    }

    private String cCj() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean HI(String str) {
        if (TextUtils.isEmpty(this.jFx)) {
            return false;
        }
        return this.jFx.equals(str);
    }

    private void cCk() {
        String cCj = cCj();
        if (!HI(cCj)) {
            this.jFv.clear();
            this.jFw = 0;
            this.jFx = cCj;
        }
    }

    /* loaded from: classes13.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jFE;
        private final String jFF;
        private final Runnable jFG;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.jFE = atomicReference;
            this.jFF = str;
            this.jFG = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.jFE.get() == null) {
                synchronized (a.class) {
                    if (this.jFE.get() == null) {
                        this.jFE.set(com.baidu.tbadk.core.c.a.aEz().sQ(this.jFF));
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
            if (this.jFG != null) {
                this.jFG.run();
            }
        }
    }
}
