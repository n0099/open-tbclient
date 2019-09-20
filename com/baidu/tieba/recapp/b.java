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
    private static volatile b iID;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iIE = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> iIF = new AtomicReference<>(null);
    private boolean iIJ = false;
    private boolean iIK = false;
    private CustomMessageListener iIL = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.aDp().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> iIG = new HashMap<>();
    private int iIH = 0;
    private String iII = ciy();

    public static b cit() {
        if (iID == null) {
            synchronized (b.class) {
                if (iID == null) {
                    iID = new b();
                }
            }
        }
        return iID;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.iIL);
    }

    @Override // com.baidu.tieba.recapp.j
    public void ciu() {
        if (!this.iIJ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.iIE.get();
                    if (lVar != null) {
                        lVar.a(b.this.iII, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: de */
                            public void h(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.Eb(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.iIG.put(gVar.forumName, gVar);
                                            b.this.iIJ = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.iIE.get() == null) {
                new a(this.iIE, "frs.refresh.count", runnable).execute(new Void[0]);
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
        ciz();
        g gVar = this.iIG.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.iIG.put(gVar.forumName, gVar);
        }
        gVar.ah(z, z2);
        t(this.iIG);
    }

    private synchronized void t(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.iIE.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject ciC = entry.getValue().ciC();
                if (ciC != null) {
                    jSONArray.put(ciC);
                }
            }
            lVar.b(this.iII, jSONArray.toString(), 86400000L);
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
        g gVar = this.iIG.get(str);
        if (gVar == null || !Ec(ciy())) {
            return 0;
        }
        return gVar.ag(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> Eb(String str) {
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
    public void civ() {
        if (!this.iIK) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.iIF.get()).a(b.this.iII, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: de */
                        public void h(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.iIH = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.iIH = 0;
                                }
                                b.this.iIK = true;
                            }
                        }
                    });
                }
            };
            if (this.iIF.get() == null) {
                new a(this.iIF, "hot.splash.count", runnable).execute(new Void[0]);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void ciw() {
        com.baidu.adp.lib.cache.l<String> lVar = this.iIF.get();
        if (lVar != null) {
            ciz();
            this.iIH++;
            lVar.b(this.iII, Integer.toString(this.iIH), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int cix() {
        if (Ec(ciy())) {
            return this.iIH;
        }
        return 0;
    }

    private String ciy() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean Ec(String str) {
        if (TextUtils.isEmpty(this.iII)) {
            return false;
        }
        return this.iII.equals(str);
    }

    private void ciz() {
        String ciy = ciy();
        if (!Ec(ciy)) {
            this.iIG.clear();
            this.iIH = 0;
            this.iII = ciy;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> iIP;
        private final String iIQ;
        private final Runnable iIR;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.iIP = atomicReference;
            this.iIQ = str;
            this.iIR = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.iIP.get() == null) {
                synchronized (a.class) {
                    if (this.iIP.get() == null) {
                        this.iIP.set(com.baidu.tbadk.core.d.a.agL().mN(this.iIQ));
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
            if (this.iIR != null) {
                this.iIR.run();
            }
        }
    }
}
