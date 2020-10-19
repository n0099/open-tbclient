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
    private static volatile a mad;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> mae = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> maf = new AtomicReference<>(null);
    private boolean maj = false;
    private boolean mak = false;
    private CustomMessageListener mal = new CustomMessageListener(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL) { // from class: com.baidu.tieba.recapp.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.bES().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, f> mag = new HashMap<>();
    private int mah = 0;
    private String mai = duv();

    public static a duq() {
        if (mad == null) {
            synchronized (a.class) {
                if (mad == null) {
                    mad = new a();
                }
            }
        }
        return mad;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.mal);
    }

    @Override // com.baidu.tieba.recapp.j
    public void dur() {
        if (!this.maj) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) a.this.mae.get();
                    if (lVar != null) {
                        lVar.a(a.this.mai, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: eS */
                            public void onItemGet(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = a.this.Qx(str2).iterator();
                                    while (it.hasNext()) {
                                        f fVar = (f) it.next();
                                        if (fVar != null) {
                                            a.this.mag.put(fVar.forumName, fVar);
                                            a.this.maj = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.mae.get() == null) {
                new C0803a(this.mae, "frs.refresh.count", runnable).execute(new Void[0]);
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
        duw();
        f fVar = this.mag.get(str);
        if (fVar == null) {
            fVar = new f();
            fVar.forumName = str;
            this.mag.put(fVar.forumName, fVar);
        }
        fVar.ax(z, z2);
        I(this.mag);
    }

    private synchronized void I(HashMap<String, f> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.mae.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, f> entry : hashMap.entrySet()) {
                JSONObject aeM = entry.getValue().aeM();
                if (aeM != null) {
                    jSONArray.put(aeM);
                }
            }
            lVar.asyncSet(this.mai, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aX(String str, boolean z) {
        return m(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int aY(String str, boolean z) {
        return m(str, false, z);
    }

    private int m(String str, boolean z, boolean z2) {
        f fVar = this.mag.get(str);
        if (fVar == null || !Qy(duv())) {
            return 0;
        }
        return fVar.aw(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<f> Qx(String str) {
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
    public void dus() {
        if (!this.mak) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.a.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) a.this.maf.get()).a(a.this.mai, new l.a<String>() { // from class: com.baidu.tieba.recapp.a.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: eS */
                        public void onItemGet(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    a.this.mah = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    a.this.mah = 0;
                                }
                                a.this.mak = true;
                            }
                        }
                    });
                }
            };
            if (this.maf.get() == null) {
                new C0803a(this.maf, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void dut() {
        com.baidu.adp.lib.cache.l<String> lVar = this.maf.get();
        if (lVar != null) {
            duw();
            this.mah++;
            lVar.asyncSet(this.mai, Integer.toString(this.mah), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int duu() {
        if (Qy(duv())) {
            return this.mah;
        }
        return 0;
    }

    private String duv() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private boolean Qy(String str) {
        if (TextUtils.isEmpty(this.mai)) {
            return false;
        }
        return this.mai.equals(str);
    }

    private void duw() {
        String duv = duv();
        if (!Qy(duv)) {
            this.mag.clear();
            this.mah = 0;
            this.mai = duv;
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private static final class C0803a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> maq;
        private final String mar;
        private final Runnable mas;

        private C0803a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.maq = atomicReference;
            this.mar = str;
            this.mas = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.maq.get() == null) {
                synchronized (C0803a.class) {
                    if (this.maq.get() == null) {
                        this.maq.set(com.baidu.tbadk.core.c.a.bkE().AF(this.mar));
                    }
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute((C0803a) r2);
            if (this.mas != null) {
                this.mas.run();
            }
        }
    }
}
