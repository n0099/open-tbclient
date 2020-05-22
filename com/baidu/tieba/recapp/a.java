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
    private static volatile a kIQ;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kIR = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> kIS = new AtomicReference<>(null);
    private boolean kIW = false;
    private boolean kIX = false;
    private CustomMessageListener kIY = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bms().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> kIT = new HashMap<>();
    private int kIU = 0;
    private String kIV = cUc();

    public static a cTX() {
        if (kIQ == null) {
            synchronized (a.class) {
                if (kIQ == null) {
                    kIQ = new a();
                }
            }
        }
        return kIQ;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.kIY);
    }

    @Override // com.baidu.tieba.recapp.i
    public void cTY() {
        if (!this.kIW) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.kIR.get();
                    if (lVar != null) {
                        lVar.a(a.this.kIV, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eh */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Lb(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.kIT.put(fVar.forumName, fVar);
                                            a.this.kIW = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.kIR.get() == null) {
                new C0709a(this.kIR, "frs.refresh.count", runnable).execute(new Void[0]);
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
        cUd();
        f fVar = this.kIT.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.kIT.put(fVar.forumName, fVar);
        }
        fVar.ap(z, z2);
        J(this.kIT);
    }

    private synchronized void J(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.kIR.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject TA = entry.getValue().TA();
                if (TA != null) {
                    jSONArray.put(TA);
                }
            }
            lVar.asyncSet(this.kIV, jSONArray.toString(), 86400000L);
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
        f fVar = this.kIT.get(str);
        if (fVar == null || !Lc(cUc())) {
            return 0;
        }
        return fVar.ao(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Lb(String str) {
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
    public void cTZ() {
        if (!this.kIX) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.kIS.get()).a(a.this.kIV, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eh */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.kIU = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.kIU = 0;
                                }
                                a.this.kIX = true;
                            }
                        }
                    });
                }
            };
            if (this.kIS.get() == null) {
                new C0709a(this.kIS, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void cUa() {
        com.baidu.adp.lib.cache.l<String> lVar = this.kIS.get();
        if (lVar != null) {
            cUd();
            this.kIU++;
            lVar.asyncSet(this.kIV, Integer.toString(this.kIU), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public int cUb() {
        if (Lc(cUc())) {
            return this.kIU;
        }
        return 0;
    }

    private String cUc() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Lc(String str) {
        if (TextUtils.isEmpty(this.kIV)) {
            return false;
        }
        return this.kIV.equals(str);
    }

    private void cUd() {
        String cUc = cUc();
        if (!Lc(cUc)) {
            this.kIT.clear();
            this.kIU = 0;
            this.kIV = cUc;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0709a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> kJc;
        private final String kJd;
        private final Runnable kJe;

        private C0709a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.kJc = atomicReference;
            this.kJd = str;
            this.kJe = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.kJc.get() == null) {
                synchronized (C0709a.class) {
                    if (this.kJc.get() == null) {
                        this.kJc.set(com.baidu.tbadk.core.c.a.aSS().vM(this.kJd));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0709a) r2);
            if (this.kJe != null) {
                this.kJe.run();
            }
        }
    }
}
