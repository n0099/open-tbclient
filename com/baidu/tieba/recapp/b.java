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
    private static volatile b jFu;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jFv = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> jFw = new AtomicReference<>(null);
    private boolean jFA = false;
    private boolean jFB = false;
    private CustomMessageListener jFC = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aXZ().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> jFx = new HashMap<>();
    private int jFy = 0;
    private String jFz = cCl();

    public static b cCg() {
        if (jFu == null) {
            synchronized (b.class) {
                if (jFu == null) {
                    jFu = new b();
                }
            }
        }
        return jFu;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.jFC);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cCh() {
        if (!this.jFA) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.jFv.get();
                    if (lVar != null) {
                        lVar.a(b.this.jFz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dt */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.HH(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.jFx.put(gVar.forumName, gVar);
                                            b.this.jFA = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.jFv.get() == null) {
                new a(this.jFv, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cCm();
        g gVar = this.jFx.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.jFx.put(gVar.forumName, gVar);
        }
        gVar.am(z, z2);
        s(this.jFx);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.jFv.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject Jh = entry.getValue().Jh();
                if (Jh != null) {
                    jSONArray.put(Jh);
                }
            }
            lVar.asyncSet(this.jFz, jSONArray.toString(), 86400000L);
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
        g gVar = this.jFx.get(str);
        if (gVar == null || !HI(cCl())) {
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
    public void cCi() {
        if (!this.jFB) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.jFw.get()).a(b.this.jFz, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dt */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.jFy = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.jFy = 0;
                                }
                                b.this.jFB = true;
                            }
                        }
                    });
                }
            };
            if (this.jFw.get() == null) {
                new a(this.jFw, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cCj() {
        com.baidu.adp.lib.cache.l<String> lVar = this.jFw.get();
        if (lVar != null) {
            cCm();
            this.jFy++;
            lVar.asyncSet(this.jFz, Integer.toString(this.jFy), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cCk() {
        if (HI(cCl())) {
            return this.jFy;
        }
        return 0;
    }

    private String cCl() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean HI(String str) {
        if (TextUtils.isEmpty(this.jFz)) {
            return false;
        }
        return this.jFz.equals(str);
    }

    private void cCm() {
        String cCl = cCl();
        if (!HI(cCl)) {
            this.jFx.clear();
            this.jFy = 0;
            this.jFz = cCl;
        }
    }

    /* loaded from: classes13.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jFG;
        private final String jFH;
        private final Runnable jFI;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.jFG = atomicReference;
            this.jFH = str;
            this.jFI = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.jFG.get() == null) {
                synchronized (a.class) {
                    if (this.jFG.get() == null) {
                        this.jFG.set(com.baidu.tbadk.core.c.a.aEB().sQ(this.jFH));
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
            if (this.jFI != null) {
                this.jFI.run();
            }
        }
    }
}
