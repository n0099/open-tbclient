package com.baidu.tieba.recapp.b;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final int asY = 5;
    private C0076a fdA = null;
    private HashMap<String, d> fdC = new HashMap<>();
    private static a fdz = null;
    private static DownloadData ata = null;
    private static List<DownloadData> atb = new LinkedList();
    private static HashMap<String, Integer> fdB = new HashMap<>();

    private a() {
    }

    public static a bbX() {
        synchronized (a.class) {
            if (fdz == null) {
                fdz = new a();
            }
        }
        return fdz;
    }

    public void a(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setTag(strArr);
        downloadData.setPosition(i);
        downloadData.setNotifyId(i2);
        downloadData.setNeedInvokeApk(z);
        downloadData.setForceDownload(z2);
        downloadData.setNeedNotify(z3);
        downloadData.setApp_icon(str4);
        downloadData.setDownloadStaticsData(downloadStaticsData);
        downloadData.setUser_name(str5);
        e(downloadData);
    }

    public void e(DownloadData downloadData) {
        if (downloadData != null) {
            List<DownloadData> iV = com.baidu.tieba.recapp.b.b.bbZ().iV();
            if (iV != null && iV.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail_over_max));
                f(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), r.j.download_fail_over_max);
                return;
            }
            atb.add(downloadData);
            Cw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw() {
        if (ata == null && !atb.isEmpty()) {
            ata = atb.get(0);
            if (ata != null) {
                this.fdA = new C0076a(this, null);
                this.fdA.setPriority(3);
                this.fdA.execute(ata);
            }
        }
    }

    public String getFileOfUrl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public void f(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void w(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        try {
            new b(this, null).execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.b>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.b> atd;

        private b() {
            this.atd = null;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.b>... arrayListArr) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.atd = arrayList;
            Iterator<com.baidu.tbadk.core.data.b> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.b next = it.next();
                String str = next.Pg;
                if (m.cW(a.this.getFileOfUrl(next.Pe)) != null) {
                    DownloadData downloadData = new DownloadData(str);
                    downloadData.setStatus(3);
                    linkedList.add(downloadData);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.bbZ().iV()) {
                Iterator<com.baidu.tbadk.core.data.b> it = this.atd.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Pg, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.w(list);
            this.atd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aC(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.getCacheDir());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0076a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0076a() {
        }

        /* synthetic */ C0076a(a aVar, C0076a c0076a) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            DownloadData downloadData = downloadDataArr[0];
            if (downloadData != null) {
                String id = downloadData.getId();
                String name = downloadData.getName();
                if (!az.isEmpty(id) && !az.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String aC = a.this.aC(str);
                    File cW = m.cW(str);
                    if (isForceDownload || cW == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aC);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aC);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                return downloadData;
            }
            return downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            a.this.fdA = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.f(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.b.b.bbZ().a(downloadData, 5);
                    if (a.this.ak(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.download_will_begin);
                            d dVar = new d(downloadData, 0);
                            a.this.fdC.put(downloadData.getUrl(), dVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + string, 0, string, downloadData.getUser_name(), a.this.fi(downloadData.getAction()), false, dVar.bca(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.g(downloadData);
                    }
                }
                a.ata = null;
                if (!a.atb.isEmpty()) {
                    a.atb.remove(0);
                    a.this.Cw();
                }
            }
        }
    }

    public void g(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            String str = String.valueOf(ak) + "%";
            d dVar = this.fdC.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, ak) : dVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                dVar2.bcb();
            } else if (status == 4 || status == 2 || status == 7) {
                dVar2.bcc();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            dVar2.qQ(ak);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fi(downloadData.getAction()), false, dVar2.bca(), false);
        }
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.fdC.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, ak(downloadData.getId(), downloadData.getName())) : dVar;
            dVar2.bcb();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(ak(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fi(downloadData.getAction()), false, dVar2.bca(), false);
        }
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.fdC.get(downloadData.getUrl());
            int ak = ak(downloadData.getId(), downloadData.getName());
            if (dVar == null) {
                dVar = new d(downloadData, ak);
            }
            dVar.bcc();
        }
    }

    public void r(DownloadData downloadData) {
        if (downloadData != null) {
            q(downloadData);
            d dVar = this.fdC.get(downloadData.getUrl());
            if (dVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(ak(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fi(downloadData.getAction()), false, dVar.bca(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public void o(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.download_fail_tip), process, String.valueOf(process) + "%", string, fi(downloadData.getAction()), false);
            }
        }
    }

    public boolean fj(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.bbZ().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ak(String str, String str2) {
        long al = al(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (al <= j) {
            return (int) ((al * 100) / j);
        }
        return 0;
    }

    public boolean fo(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.bbZ().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void h(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.b.b.bbZ().iV()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                com.baidu.tieba.recapp.b.b.bbZ().t(str, true);
            } else {
                com.baidu.tieba.recapp.b.b.bbZ().fm(str);
            }
            if (downloadData != null) {
                int ak = ak(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(ak) + "%";
                if (downloadData != null && ak >= 0) {
                    d dVar = this.fdC.get(downloadData.getUrl());
                    d dVar2 = dVar == null ? new d(downloadData, ak) : dVar;
                    dVar2.bcc();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fi(downloadData.getAction()), false, dVar2.bca(), false);
                }
            }
        }
    }

    public void s(DownloadData downloadData) {
        com.baidu.tieba.recapp.b.b.bbZ().u(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
        f(downloadData);
    }

    public boolean am(String str, String str2) {
        File cW;
        return TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cW = m.cW(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cW.exists() && cW.isFile();
    }

    public long al(String str, String str2) {
        File cW = m.cW(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cW != null && cW.exists() && cW.isFile()) {
            return cW.length();
        }
        return -1L;
    }

    public boolean fl(String str) {
        return (TextUtils.isEmpty(str) || m.cW(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bbX().fl(downloadData.getId())) {
            return 3;
        }
        if (bbX().fo(downloadData.getId())) {
            return 5;
        }
        if (bbX().fj(downloadData.getId())) {
            return 1;
        }
        if (!bbX().am(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer qF(String str) {
        if (fdB.containsKey(str)) {
            return fdB.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        fdB.put(str, valueOf);
        return valueOf;
    }
}
