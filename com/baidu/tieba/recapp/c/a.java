package com.baidu.tieba.recapp.c;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final int aAw = 5;
    private C0123a fKK = null;
    private HashMap<String, c> fKM = new HashMap<>();
    private static a fKJ = null;
    private static DownloadData aAy = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> fKL = new HashMap<>();

    private a() {
    }

    public static a bjf() {
        synchronized (a.class) {
            if (fKJ == null) {
                fKJ = new a();
            }
        }
        return fKJ;
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
        a(downloadData);
    }

    public void a(DownloadData downloadData) {
        if (downloadData != null) {
            List<DownloadData> jL = com.baidu.tieba.recapp.c.b.bjh().jL();
            if (jL != null && jL.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Cy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy() {
        if (aAy == null && !mTaskList.isEmpty()) {
            aAy = mTaskList.get(0);
            if (aAy != null) {
                this.fKK = new C0123a();
                this.fKK.setPriority(3);
                this.fKK.execute(aAy);
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

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void z(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> aAA;

        private b() {
            this.aAA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<AdvertAppInfo>... arrayListArr) {
            ArrayList<AdvertAppInfo> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.aAA = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.Ul;
                if (k.dk(a.this.getFileOfUrl(next.Uk)) != null) {
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
        /* renamed from: l */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bjh().jL()) {
                Iterator<AdvertAppInfo> it = this.aAA.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Ul, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.z(list);
            this.aAA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String az(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.uj());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0123a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0123a() {
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
                if (!am.isEmpty(id) && !am.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + ".apk";
                    String az = a.this.az(str);
                    File dk = k.dk(str);
                    if (isForceDownload || dk == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(az);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(az);
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
        /* renamed from: e */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            a.this.fKK = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.c.b.bjh().a(downloadData, 5);
                    if (a.this.al(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_will_begin);
                            c cVar = new c(downloadData, 0);
                            a.this.fKM.put(downloadData.getUrl(), cVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), a.this.fw(downloadData.getAction()), false, cVar.bji(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                DownloadData unused = a.aAy = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Cy();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str = al + "%";
            c cVar = this.fKM.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, al) : cVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                cVar2.bjj();
            } else if (status == 4 || status == 2 || status == 7) {
                cVar2.bjk();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            cVar2.sr(al);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fw(downloadData.getAction()), false, cVar2.bji(), false);
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fKM.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, al(downloadData.getId(), downloadData.getName())) : cVar;
            cVar2.bjj();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, al(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fw(downloadData.getAction()), false, cVar2.bji(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fKM.get(downloadData.getUrl());
            int al = al(downloadData.getId(), downloadData.getName());
            if (cVar == null) {
                cVar = new c(downloadData, al);
            }
            cVar.bjk();
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            m(downloadData);
            c cVar = this.fKM.get(downloadData.getUrl());
            if (cVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, al(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fw(downloadData.getAction()), false, cVar.bji(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public void k(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_fail_tip), process, process + "%", string, fw(downloadData.getAction()), false);
            }
        }
    }

    public boolean fx(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bjh().jL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int al(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((100 * am) / j);
        }
        return 0;
    }

    public boolean fC(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bjh().jL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.c.b.bjh().jL()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.c.b.bjh().o(str, true);
            } else {
                com.baidu.tieba.recapp.c.b.bjh().fA(str);
            }
            if (downloadData != null) {
                int al = al(downloadData.getId(), downloadData.getName());
                String str3 = al + "%";
                if (downloadData != null && al >= 0) {
                    c cVar = this.fKM.get(downloadData.getUrl());
                    c cVar2 = cVar == null ? new c(downloadData, al) : cVar;
                    cVar2.bjk();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fw(downloadData.getAction()), false, cVar2.bji(), false);
                }
            }
        }
    }

    public void o(DownloadData downloadData) {
        com.baidu.tieba.recapp.c.b.bjh().q(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean an(String str, String str2) {
        File dk;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dk = k.dk(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && dk.exists() && dk.isFile();
    }

    public long am(String str, String str2) {
        File dk = k.dk(str + "_" + str2 + ".tmp");
        if (dk != null && dk.exists() && dk.isFile()) {
            return dk.length();
        }
        return -1L;
    }

    public boolean fz(String str) {
        return (TextUtils.isEmpty(str) || k.dk(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bjf().fz(downloadData.getId())) {
            return 3;
        }
        if (bjf().fC(downloadData.getId())) {
            return 5;
        }
        if (bjf().fx(downloadData.getId())) {
            return 1;
        }
        if (!bjf().an(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer rl(String str) {
        if (fKL.containsKey(str)) {
            return fKL.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        fKL.put(str, valueOf);
        return valueOf;
    }
}
