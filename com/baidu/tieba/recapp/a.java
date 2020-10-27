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
/* loaded from: classes26.dex */
public class a implements j, l {
    private static volatile a mmD;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mmE = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> mmF = new AtomicReference<>(null);
    private boolean mmJ = false;
    private boolean mmK = false;
    private CustomMessageListener mmL = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bGL().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> mmG = new HashMap<>();
    private int mmH = 0;
    private String mmI = dxC();

    public static a dxx() {
        if (mmD == null) {
            synchronized (a.class) {
                if (mmD == null) {
                    mmD = new a();
                }
            }
        }
        return mmD;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.mmL);
    }

    @Override // com.baidu.tieba.recapp.j
    public void dxy() {
        if (!this.mmJ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.mmE.get();
                    if (lVar != null) {
                        lVar.a(a.this.mmI, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eX */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.QV(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.mmG.put(fVar.forumName, fVar);
                                            a.this.mmJ = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mmE.get() == null) {
                new C0818a(this.mmE, "frs.refresh.count", runnable).execute(new Void[0]);
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
        dxD();
        f fVar = this.mmG.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.mmG.put(fVar.forumName, fVar);
        }
        fVar.aA(z, z2);
        I(this.mmG);
    }

    private synchronized void I(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mmE.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject agG = entry.getValue().agG();
                if (agG != null) {
                    jSONArray.put(agG);
                }
            }
            lVar.asyncSet(this.mmI, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aZ(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ba(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.mmG.get(str);
        if (fVar == null || !QW(dxC())) {
            return 0;
        }
        return fVar.az(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> QV(String str) {
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
    public void dxz() {
        if (!this.mmK) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.mmF.get()).a(a.this.mmI, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eX */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.mmH = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.mmH = 0;
                                }
                                a.this.mmK = true;
                            }
                        }
                    });
                }
            };
            if (this.mmF.get() == null) {
                new C0818a(this.mmF, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void dxA() {
        com.baidu.adp.lib.cache.l<String> lVar = this.mmF.get();
        if (lVar != null) {
            dxD();
            this.mmH++;
            lVar.asyncSet(this.mmI, Integer.toString(this.mmH), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int dxB() {
        if (QW(dxC())) {
            return this.mmH;
        }
        return 0;
    }

    private String dxC() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean QW(String str) {
        if (TextUtils.isEmpty(this.mmI)) {
            return false;
        }
        return this.mmI.equals(str);
    }

    private void dxD() {
        String dxC = dxC();
        if (!QW(dxC)) {
            this.mmG.clear();
            this.mmH = 0;
            this.mmI = dxC;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private static final class C0818a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mmP;
        private final String mmQ;
        private final Runnable mmR;

        private C0818a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.mmP = atomicReference;
            this.mmQ = str;
            this.mmR = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mmP.get() == null) {
                synchronized (C0818a.class) {
                    if (this.mmP.get() == null) {
                        this.mmP.set(com.baidu.tbadk.core.c.a.bmx().AY(this.mmQ));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0818a) r2);
            if (this.mmR != null) {
                this.mmR.run();
            }
        }
    }
}
