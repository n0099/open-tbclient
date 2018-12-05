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
    private static volatile b gKS;
    private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gKT = new AtomicReference<>(null);
    private AtomicReference<com.baidu.adp.lib.cache.l<String>> gKU = new AtomicReference<>(null);
    private boolean gKY = false;
    private boolean gKZ = false;
    private CustomMessageListener gLa = new CustomMessageListener(2921022) { // from class: com.baidu.tieba.recapp.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.ad.a.Wg().d(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()});
            }
        }
    };
    private HashMap<String, g> gKV = new HashMap<>();
    private int gKW = 0;
    private String gKX = buo();

    public static b buj() {
        if (gKS == null) {
            synchronized (b.class) {
                if (gKS == null) {
                    gKS = new b();
                }
            }
        }
        return gKS;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gLa);
    }

    @Override // com.baidu.tieba.recapp.j
    public void buk() {
        if (!this.gKY) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.cache.l lVar = (com.baidu.adp.lib.cache.l) b.this.gKT.get();
                    if (lVar != null) {
                        lVar.a(b.this.gKX, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.cache.l.a
                            /* renamed from: cw */
                            public void g(String str, String str2) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Iterator it = b.this.oK(str2).iterator();
                                    while (it.hasNext()) {
                                        g gVar = (g) it.next();
                                        if (gVar != null) {
                                            b.this.gKV.put(gVar.forumName, gVar);
                                            b.this.gKY = true;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
            if (this.gKT.get() == null) {
                synchronized (b.class) {
                    new a(this.gKT, "frs.refresh.count", runnable).execute(new Void[0]);
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
        bup();
        g gVar = this.gKV.get(str);
        if (gVar == null) {
            gVar = new g();
            gVar.forumName = str;
            this.gKV.put(gVar.forumName, gVar);
        }
        gVar.U(z, z2);
        s(this.gKV);
    }

    private synchronized void s(HashMap<String, g> hashMap) {
        com.baidu.adp.lib.cache.l<String> lVar = this.gKT.get();
        if (lVar != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, g> entry : hashMap.entrySet()) {
                JSONObject bus = entry.getValue().bus();
                if (bus != null) {
                    jSONArray.put(bus);
                }
            }
            lVar.b(this.gKX, jSONArray.toString(), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public int aa(String str, boolean z) {
        return i(str, true, z);
    }

    @Override // com.baidu.tieba.recapp.j
    public int ab(String str, boolean z) {
        return i(str, false, z);
    }

    private int i(String str, boolean z, boolean z2) {
        g gVar = this.gKV.get(str);
        if (gVar == null || !uv(buo())) {
            return 0;
        }
        return gVar.T(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<g> oK(String str) {
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
    public void bul() {
        if (!this.gKZ) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.recapp.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.baidu.adp.lib.cache.l) b.this.gKU.get()).a(b.this.gKX, new l.a<String>() { // from class: com.baidu.tieba.recapp.b.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.cache.l.a
                        /* renamed from: cw */
                        public void g(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    b.this.gKW = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    b.this.gKW = 0;
                                }
                                b.this.gKZ = true;
                            }
                        }
                    });
                }
            };
            if (this.gKU.get() == null) {
                synchronized (b.class) {
                    new a(this.gKU, "hot.splash.count", runnable).execute(new Void[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void bum() {
        com.baidu.adp.lib.cache.l<String> lVar = this.gKU.get();
        if (lVar != null) {
            bup();
            this.gKW++;
            lVar.b(this.gKX, Integer.toString(this.gKW), 86400000L);
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public int bun() {
        if (uv(buo())) {
            return this.gKW;
        }
        return 0;
    }

    private String buo() {
        return new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date());
    }

    private boolean uv(String str) {
        if (TextUtils.isEmpty(this.gKX)) {
            return false;
        }
        return this.gKX.equals(str);
    }

    private void bup() {
        String buo = buo();
        if (!uv(buo)) {
            this.gKV.clear();
            this.gKW = 0;
            this.gKX = buo;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a extends BdAsyncTask<Void, Void, Void> {
        private final AtomicReference<com.baidu.adp.lib.cache.l<String>> gLe;
        private final String gLf;
        private final Runnable gLg;

        private a(AtomicReference<com.baidu.adp.lib.cache.l<String>> atomicReference, String str, Runnable runnable) {
            this.gLe = atomicReference;
            this.gLf = str;
            this.gLg = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.gLe.get() == null) {
                synchronized (b.class) {
                    if (this.gLe.get() == null) {
                        this.gLe.set(com.baidu.tbadk.core.c.a.BB().ey(this.gLf));
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
            if (this.gLg != null) {
                this.gLg.run();
            }
        }
    }
}
