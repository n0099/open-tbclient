package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
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
public class a implements i, k {
    private static volatile a kJY;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kJZ = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> kKa = new AtomicReference<>(null);
    private boolean kKe = false;
    private boolean kKf = false;
    private CustomMessageListener kKg = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bmu().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> kKb = new HashMap<>();
    private int kKc = 0;
    private String kKd = cUs();

    public static a cUn() {
        if (kJY == null) {
            synchronized (a.class) {
                if (kJY == null) {
                    kJY = new a();
                }
            }
        }
        return kJY;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.kKg);
    }

    @Override // com.baidu.tieba.recapp.i
    public void cUo() {
        if (!this.kKe) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.kJZ.get();
                    if (lVar != null) {
                        lVar.a(a.this.kKd, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eh */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Lc(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.kKb.put(fVar.forumName, fVar);
                                            a.this.kKe = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.kJZ.get() == null) {
                new C0710a(this.kJZ, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        cUt();
        f fVar = this.kKb.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.kKb.put(fVar.forumName, fVar);
        }
        fVar.ap(z, z2);
        J(this.kKb);
    }

    private synchronized void J(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.kJZ.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject TA = entry.getValue().TA();
                if (TA != null) {
                    jSONArray.put(TA);
                }
            }
            lVar.asyncSet(this.kKd, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public int aQ(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.i
    public int aR(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.kKb.get(str);
        if (fVar == null || !Ld(cUs())) {
            return 0;
        }
        return fVar.ao(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Lc(String str) {
        ArrayList<f> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new f(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.recapp.k
    public void cUp() {
        if (!this.kKf) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.kKa.get()).a(a.this.kKd, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eh */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.kKc = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.kKc = 0;
                                }
                                a.this.kKf = true;
                            }
                        }
                    });
                }
            };
            if (this.kKa.get() == null) {
                new C0710a(this.kKa, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void cUq() {
        com.baidu.adp.lib.cache.l<String> lVar = this.kKa.get();
        if (lVar != null) {
            cUt();
            this.kKc++;
            lVar.asyncSet(this.kKd, Integer.toString(this.kKc), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public int cUr() {
        if (Ld(cUs())) {
            return this.kKc;
        }
        return 0;
    }

    private String cUs() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Ld(String str) {
        if (TextUtils.isEmpty(this.kKd)) {
            return false;
        }
        return this.kKd.equals(str);
    }

    private void cUt() {
        String cUs = cUs();
        if (!Ld(cUs)) {
            this.kKb.clear();
            this.kKc = 0;
            this.kKd = cUs;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0710a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kKk;
        private final String kKl;
        private final Runnable kKm;

        private C0710a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.kKk = atomicReference;
            this.kKl = str;
            this.kKm = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.kKk.get() == null) {
                synchronized (C0710a.class) {
                    if (this.kKk.get() == null) {
                        this.kKk.set(com.baidu.tbadk.core.c.a.aSS().vM(this.kKl));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0710a) r2);
            if (this.kKm != null) {
                this.kKm.run();
            }
        }
    }
}
