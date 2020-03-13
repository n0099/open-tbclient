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
    private static volatile b jFG;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jFH = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> jFI = new AtomicReference<>(null);
    private boolean jFM = false;
    private boolean jFN = false;
    private CustomMessageListener jFO = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aYa().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> jFJ = new HashMap<>();
    private int jFK = 0;
    private String jFL = cCm();

    public static b cCh() {
        if (jFG == null) {
            synchronized (b.class) {
                if (jFG == null) {
                    jFG = new b();
                }
            }
        }
        return jFG;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.jFO);
    }

    @Override // com.baidu.tieba.recapp.j
    public void cCi() {
        if (!this.jFM) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.jFH.get();
                    if (lVar != null) {
                        lVar.a(b.this.jFL, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: dt */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.HI(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.jFJ.put(gVar.forumName, gVar);
                                            b.this.jFM = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.jFH.get() == null) {
                new a(this.jFH, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cCn();
        g gVar = this.jFJ.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.jFJ.put(gVar.forumName, gVar);
        }
        gVar.am(z, z2);
        s(this.jFJ);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.jFH.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject Jh = entry.getValue().Jh();
                if (Jh != null) {
                    jSONArray.put(Jh);
                }
            }
            lVar.asyncSet(this.jFL, jSONArray.toString(), 86400000L);
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
        g gVar = this.jFJ.get(str);
        if (gVar == null || !HJ(cCm())) {
            return 0;
        }
        return gVar.al(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> HI(String str) {
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
    public void cCj() {
        if (!this.jFN) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.jFI.get()).a(b.this.jFL, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: dt */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.jFK = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.jFK = 0;
                                }
                                b.this.jFN = true;
                            }
                        }
                    });
                }
            };
            if (this.jFI.get() == null) {
                new a(this.jFI, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void cCk() {
        com.baidu.adp.lib.cache.l<String> lVar = this.jFI.get();
        if (lVar != null) {
            cCn();
            this.jFK++;
            lVar.asyncSet(this.jFL, Integer.toString(this.jFK), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cCl() {
        if (HJ(cCm())) {
            return this.jFK;
        }
        return 0;
    }

    private String cCm() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean HJ(String str) {
        if (TextUtils.isEmpty(this.jFL)) {
            return false;
        }
        return this.jFL.equals(str);
    }

    private void cCn() {
        String cCm = cCm();
        if (!HJ(cCm)) {
            this.jFJ.clear();
            this.jFK = 0;
            this.jFL = cCm;
        }
    }

    /* loaded from: classes13.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> jFS;
        private final String jFT;
        private final Runnable jFU;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.jFS = atomicReference;
            this.jFT = str;
            this.jFU = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.jFS.get() == null) {
                synchronized (a.class) {
                    if (this.jFS.get() == null) {
                        this.jFS.set(com.baidu.tbadk.core.c.a.aEB().sQ(this.jFT));
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
            if (this.jFU != null) {
                this.jFU.run();
            }
        }
    }
}
