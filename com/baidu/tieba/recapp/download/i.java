package com.baidu.tieba.recapp.download;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private static i iKg = null;
    private static DownloadData csu = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> iJY = new HashMap<>();
    private final int css = 5;
    private a iKh = null;
    private HashMap<String, k> iJZ = new HashMap<>();

    private i() {
    }

    public static i ciW() {
        synchronized (i.class) {
            if (iKg == null) {
                iKg = new i();
            }
        }
        return iKg;
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
            List<DownloadData> mN = com.baidu.tieba.recapp.download.a.ciP().mN();
            if (mN != null && mN.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            asf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asf() {
        if (csu == null && !mTaskList.isEmpty()) {
            csu = mTaskList.get(0);
            if (csu != null) {
                this.iKh = new a();
                this.iKh.setPriority(3);
                this.iKh.execute(csu);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aV(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.aij());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public String Eh(String str) {
        return aV(str.replace(".", "_") + ".apk");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private a() {
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
                if (!aq.isEmpty(id) && !aq.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + ".apk";
                    String aV = i.this.aV(str);
                    File nm = m.nm(str);
                    if (isForceDownload || nm == null) {
                        downloadData.setCallback(new j());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aV);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aV);
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
            i.this.iKh = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String at = com.baidu.tieba.ad.download.a.at(TbadkCoreApplication.getInst(), downloadData.getPath());
                    com.baidu.tieba.ad.download.b.a.cYZ.get().aDI().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk() && !com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), at)) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.ad.download.b.a.cYZ.get().aDI().sM(downloadData.getId());
                    com.baidu.tieba.recapp.download.a.ciP().a(downloadData, 5);
                    if (i.this.cd(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.iJZ.put(downloadData.getUrl(), kVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), i.this.qj(downloadData.getAction()), false, kVar.ciT(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        i.this.c(downloadData);
                    }
                }
                DownloadData unused = i.csu = null;
                if (!i.mTaskList.isEmpty()) {
                    i.mTaskList.remove(0);
                    i.this.asf();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int cd = cd(downloadData.getId(), downloadData.getName());
            b.cYZ.get().aDI().ai(downloadData.getId(), cd);
            String str = cd + "%";
            k kVar = this.iJZ.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, cd) : kVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                kVar2.ciU();
            } else if (status == 4 || status == 2 || status == 7) {
                kVar2.ciV();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            kVar2.zD(cd);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), qj(downloadData.getAction()), false, kVar2.ciT(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.iJZ.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, cd(downloadData.getId(), downloadData.getName())) : kVar;
            kVar2.ciU();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, cd(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), qj(downloadData.getAction()), false, kVar2.ciT(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.iJZ.get(downloadData.getUrl());
            int cd = cd(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, cd);
            }
            kVar.ciV();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            com.baidu.tieba.ad.download.b.a.cYZ.get().aDI().a(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.iJZ.get(downloadData.getUrl());
            if (kVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, cd(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), qj(downloadData.getAction()), false, kVar.ciT(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent qj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public void l(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, qj(downloadData.getAction()), false);
            }
        }
    }

    public boolean qk(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.ciP().mN()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int cd(String str, String str2) {
        long ce = ce(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ce <= j) {
            return (int) ((100 * ce) / j);
        }
        return 0;
    }

    public boolean Ef(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.ciP().mN()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void z(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.ciP().mN()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.ciP().S(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.ciP().qn(str);
            }
            if (downloadData != null) {
                int cd = cd(downloadData.getId(), downloadData.getName());
                com.baidu.tieba.ad.download.b.a.cYZ.get().aDI().ah(str2, cd);
                String str3 = cd + "%";
                if (downloadData != null && cd >= 0) {
                    k kVar = this.iJZ.get(downloadData.getUrl());
                    k kVar2 = kVar == null ? new k(downloadData, cd) : kVar;
                    kVar2.ciV();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), qj(downloadData.getAction()), false, kVar2.ciT(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.ciP().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        com.baidu.tieba.ad.download.b.a.cYZ.get().aDI().a(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
        b(downloadData);
    }

    public boolean dZ(String str, String str2) {
        File nm;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (nm = m.nm(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && nm.exists() && nm.isFile();
    }

    public long ce(String str, String str2) {
        File nm = m.nm(str + "_" + str2 + ".tmp");
        if (nm != null && nm.exists() && nm.isFile()) {
            return nm.length();
        }
        return -1L;
    }

    public boolean qm(String str) {
        return (TextUtils.isEmpty(str) || m.nm(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (ciW().qm(downloadData.getId())) {
            return 3;
        }
        if (ciW().Ef(downloadData.getId())) {
            return 5;
        }
        if (ciW().qk(downloadData.getId())) {
            return 1;
        }
        if (!ciW().dZ(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer Eg(String str) {
        if (iJY.containsKey(str)) {
            return iJY.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        iJY.put(str, valueOf);
        return valueOf;
    }
}
