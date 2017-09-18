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
    private final int aAD = 5;
    private C0120a fFM = null;
    private HashMap<String, c> fFO = new HashMap<>();
    private static a fFL = null;
    private static DownloadData aAF = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> fFN = new HashMap<>();

    private a() {
    }

    public static a bht() {
        synchronized (a.class) {
            if (fFL == null) {
                fFL = new a();
            }
        }
        return fFL;
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
            List<DownloadData> jP = com.baidu.tieba.recapp.c.b.bhv().jP();
            if (jP != null && jP.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            CL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL() {
        if (aAF == null && !mTaskList.isEmpty()) {
            aAF = mTaskList.get(0);
            if (aAF != null) {
                this.fFM = new C0120a();
                this.fFM.setPriority(3);
                this.fFM.execute(aAF);
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
        ArrayList<AdvertAppInfo> aAH;

        private b() {
            this.aAH = null;
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
            this.aAH = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.TR;
                if (k.m9do(a.this.getFileOfUrl(next.TQ)) != null) {
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
            for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bhv().jP()) {
                Iterator<AdvertAppInfo> it = this.aAH.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().TR, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.z(list);
            this.aAH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String az(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.uG());
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
    public class C0120a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0120a() {
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
                    File m9do = k.m9do(str);
                    if (isForceDownload || m9do == null) {
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
            a.this.fFM = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.c.b.bhv().a(downloadData, 5);
                    if (a.this.am(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_will_begin);
                            c cVar = new c(downloadData, 0);
                            a.this.fFO.put(downloadData.getUrl(), cVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), a.this.fx(downloadData.getAction()), false, cVar.bhw(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                DownloadData unused = a.aAF = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.CL();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int am = am(downloadData.getId(), downloadData.getName());
            String str = am + "%";
            c cVar = this.fFO.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, am) : cVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                cVar2.bhx();
            } else if (status == 4 || status == 2 || status == 7) {
                cVar2.bhy();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            cVar2.sa(am);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fx(downloadData.getAction()), false, cVar2.bhw(), false);
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fFO.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, am(downloadData.getId(), downloadData.getName())) : cVar;
            cVar2.bhx();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, am(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fx(downloadData.getAction()), false, cVar2.bhw(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fFO.get(downloadData.getUrl());
            int am = am(downloadData.getId(), downloadData.getName());
            if (cVar == null) {
                cVar = new c(downloadData, am);
            }
            cVar.bhy();
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            m(downloadData);
            c cVar = this.fFO.get(downloadData.getUrl());
            if (cVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, am(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fx(downloadData.getAction()), false, cVar.bhw(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fx(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_fail_tip), process, process + "%", string, fx(downloadData.getAction()), false);
            }
        }
    }

    public boolean fy(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bhv().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int am(String str, String str2) {
        long an = an(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (an <= j) {
            return (int) ((100 * an) / j);
        }
        return 0;
    }

    public boolean fD(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bhv().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.c.b.bhv().jP()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.c.b.bhv().r(str, true);
            } else {
                com.baidu.tieba.recapp.c.b.bhv().fB(str);
            }
            if (downloadData != null) {
                int am = am(downloadData.getId(), downloadData.getName());
                String str3 = am + "%";
                if (downloadData != null && am >= 0) {
                    c cVar = this.fFO.get(downloadData.getUrl());
                    c cVar2 = cVar == null ? new c(downloadData, am) : cVar;
                    cVar2.bhy();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fx(downloadData.getAction()), false, cVar2.bhw(), false);
                }
            }
        }
    }

    public void o(DownloadData downloadData) {
        com.baidu.tieba.recapp.c.b.bhv().q(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean ao(String str, String str2) {
        File m9do;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (m9do = k.m9do(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && m9do.exists() && m9do.isFile();
    }

    public long an(String str, String str2) {
        File m9do = k.m9do(str + "_" + str2 + ".tmp");
        if (m9do != null && m9do.exists() && m9do.isFile()) {
            return m9do.length();
        }
        return -1L;
    }

    public boolean fA(String str) {
        return (TextUtils.isEmpty(str) || k.m9do(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bht().fA(downloadData.getId())) {
            return 3;
        }
        if (bht().fD(downloadData.getId())) {
            return 5;
        }
        if (bht().fy(downloadData.getId())) {
            return 1;
        }
        if (!bht().ao(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer qV(String str) {
        if (fFN.containsKey(str)) {
            return fFN.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        fFN.put(str, valueOf);
        return valueOf;
    }
}
