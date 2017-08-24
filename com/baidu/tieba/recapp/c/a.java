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
import com.baidu.tbadk.core.util.al;
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
    private final int aBu = 5;
    private C0118a fGV = null;
    private HashMap<String, c> fGX = new HashMap<>();
    private static a fGU = null;
    private static DownloadData aBw = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> fGW = new HashMap<>();

    private a() {
    }

    public static a bij() {
        synchronized (a.class) {
            if (fGU == null) {
                fGU = new a();
            }
        }
        return fGU;
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
            List<DownloadData> jX = com.baidu.tieba.recapp.c.b.bil().jX();
            if (jX != null && jX.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            CQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CQ() {
        if (aBw == null && !mTaskList.isEmpty()) {
            aBw = mTaskList.get(0);
            if (aBw != null) {
                this.fGV = new C0118a();
                this.fGV.setPriority(3);
                this.fGV.execute(aBw);
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
        ArrayList<AdvertAppInfo> aBy;

        private b() {
            this.aBy = null;
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
            this.aBy = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.UQ;
                if (k.dy(a.this.getFileOfUrl(next.UO)) != null) {
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
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute((b) list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bil().jX()) {
                Iterator<AdvertAppInfo> it = this.aBy.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().UQ, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.z(list);
            this.aBy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.uL());
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
    public class C0118a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0118a() {
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
                if (!al.isEmpty(id) && !al.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + ".apk";
                    String filePath = a.this.getFilePath(str);
                    File dy = k.dy(str);
                    if (isForceDownload || dy == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(filePath);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(filePath);
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
            a.this.fGV = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.c.b.bil().a(downloadData, 5);
                    if (a.this.aj(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_will_begin);
                            c cVar = new c(downloadData, 0);
                            a.this.fGX.put(downloadData.getUrl(), cVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), a.this.fC(downloadData.getAction()), false, cVar.bim(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                DownloadData unused = a.aBw = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.CQ();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aj = aj(downloadData.getId(), downloadData.getName());
            String str = aj + "%";
            c cVar = this.fGX.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, aj) : cVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                cVar2.bin();
            } else if (status == 4 || status == 2 || status == 7) {
                cVar2.bio();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            cVar2.sb(aj);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fC(downloadData.getAction()), false, cVar2.bim(), false);
        }
    }

    public void o(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fGX.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, aj(downloadData.getId(), downloadData.getName())) : cVar;
            cVar2.bin();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aj(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fC(downloadData.getAction()), false, cVar2.bim(), false);
        }
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fGX.get(downloadData.getUrl());
            int aj = aj(downloadData.getId(), downloadData.getName());
            if (cVar == null) {
                cVar = new c(downloadData, aj);
            }
            cVar.bio();
        }
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            p(downloadData);
            c cVar = this.fGX.get(downloadData.getUrl());
            if (cVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aj(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fC(downloadData.getAction()), false, cVar.bim(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fC(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_fail_tip), process, process + "%", string, fC(downloadData.getAction()), false);
            }
        }
    }

    public boolean fD(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bil().jX()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int aj(String str, String str2) {
        long ak = ak(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ak <= j) {
            return (int) ((100 * ak) / j);
        }
        return 0;
    }

    public boolean fI(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bil().jX()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void i(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.c.b.bil().jX()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.c.b.bil().r(str, true);
            } else {
                com.baidu.tieba.recapp.c.b.bil().fG(str);
            }
            if (downloadData != null) {
                int aj = aj(downloadData.getId(), downloadData.getName());
                String str3 = aj + "%";
                if (downloadData != null && aj >= 0) {
                    c cVar = this.fGX.get(downloadData.getUrl());
                    c cVar2 = cVar == null ? new c(downloadData, aj) : cVar;
                    cVar2.bio();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fC(downloadData.getAction()), false, cVar2.bim(), false);
                }
            }
        }
    }

    public void r(DownloadData downloadData) {
        com.baidu.tieba.recapp.c.b.bil().t(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean al(String str, String str2) {
        File dy;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dy = k.dy(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && dy.exists() && dy.isFile();
    }

    public long ak(String str, String str2) {
        File dy = k.dy(str + "_" + str2 + ".tmp");
        if (dy != null && dy.exists() && dy.isFile()) {
            return dy.length();
        }
        return -1L;
    }

    public boolean fF(String str) {
        return (TextUtils.isEmpty(str) || k.dy(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bij().fF(downloadData.getId())) {
            return 3;
        }
        if (bij().fI(downloadData.getId())) {
            return 5;
        }
        if (bij().fD(downloadData.getId())) {
            return 1;
        }
        if (!bij().al(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer rf(String str) {
        if (fGW.containsKey(str)) {
            return fGW.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        fGW.put(str, valueOf);
        return valueOf;
    }
}
