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
/* loaded from: classes20.dex */
public class a implements j, l {
    private static volatile a llg;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> llh = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> lli = new AtomicReference<>(null);
    private boolean llm = false;
    private boolean lln = false;
    private CustomMessageListener llo = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.brW().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> llj = new HashMap<>();
    private int llk = 0;
    private String lll = dbQ();

    public static a dbL() {
        if (llg == null) {
            synchronized (a.class) {
                if (llg == null) {
                    llg = new a();
                }
            }
        }
        return llg;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.llo);
    }

    @Override // com.baidu.tieba.recapp.j
    public void dbM() {
        if (!this.llm) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.llh.get();
                    if (lVar != null) {
                        lVar.a(a.this.lll, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: ep */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Ml(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.llj.put(fVar.forumName, fVar);
                                            a.this.llm = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.llh.get() == null) {
                new C0736a(this.llh, "frs.refresh.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void f(String str, int i, boolean z) {
        if (i == 1) {
            l(str, true, z);
        } else if (i == 2) {
            l(str, false, z);
        }
    }

    private void l(String str, boolean z, boolean z2) {
        dbR();
        f fVar = this.llj.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.llj.put(fVar.forumName, fVar);
        }
        fVar.ar(z, z2);
        I(this.llj);
    }

    private synchronized void I(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.llh.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject Vl = entry.getValue().Vl();
                if (Vl != null) {
                    jSONArray.put(Vl);
                }
            }
            lVar.asyncSet(this.lll, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aP(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int aQ(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.llj.get(str);
        if (fVar == null || !Mm(dbQ())) {
            return 0;
        }
        return fVar.aq(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Ml(String str) {
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

    @Override // com.baidu.tieba.recapp.l
    public void dbN() {
        if (!this.lln) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.lli.get()).a(a.this.lll, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: ep */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.llk = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.llk = 0;
                                }
                                a.this.lln = true;
                            }
                        }
                    });
                }
            };
            if (this.lli.get() == null) {
                new C0736a(this.lli, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void dbO() {
        com.baidu.adp.lib.cache.l<String> lVar = this.lli.get();
        if (lVar != null) {
            dbR();
            this.llk++;
            lVar.asyncSet(this.lll, Integer.toString(this.llk), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int dbP() {
        if (Mm(dbQ())) {
            return this.llk;
        }
        return 0;
    }

    private String dbQ() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Mm(String str) {
        if (TextUtils.isEmpty(this.lll)) {
            return false;
        }
        return this.lll.equals(str);
    }

    private void dbR() {
        String dbQ = dbQ();
        if (!Mm(dbQ)) {
            this.llj.clear();
            this.llk = 0;
            this.lll = dbQ;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static final class C0736a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> lls;
        private final String llt;
        private final Runnable llu;

        private C0736a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.lls = atomicReference;
            this.llt = str;
            this.llu = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.lls.get() == null) {
                synchronized (C0736a.class) {
                    if (this.lls.get() == null) {
                        this.lls.set(com.baidu.tbadk.core.c.a.aYG().xj(this.llt));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0736a) r2);
            if (this.llu != null) {
                this.llu.run();
            }
        }
    }
}
