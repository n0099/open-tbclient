package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class i {
    private static i mue = null;
    private static DownloadData fmS = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> mtW = new HashMap<>();
    private final int MAX = 5;
    private a muf = null;
    private HashMap<String, k> mtX = new HashMap<>();

    private i() {
    }

    public static i dAA() {
        synchronized (i.class) {
            if (mue == null) {
                mue = new i();
            }
        }
        return mue;
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
            List<DownloadData> downloadList = com.baidu.tieba.recapp.download.a.dAt().getDownloadList();
            if (downloadList != null && downloadList.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
                return;
            }
            com.baidu.tieba.lego.card.d.a.a(mTaskList, downloadData);
            bzr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzr() {
        if (fmS == null && !com.baidu.tieba.lego.card.d.a.isEmpty(mTaskList)) {
            fmS = (DownloadData) com.baidu.tieba.lego.card.d.a.l(mTaskList, 0);
            if (fmS != null) {
                this.muf = new a();
                this.muf.setPriority(3);
                this.muf.execute(fmS);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(n.getCacheDir());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public String Rv(String str) {
        return getFilePath(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
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
                if (!at.isEmpty(id) && !at.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk";
                    String filePath = i.this.getFilePath(str);
                    File GetFile = n.GetFile(str);
                    if (isForceDownload || GetFile == null) {
                        downloadData.setCallback(new j());
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
            i.this.muf = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String aC = com.baidu.tieba.ad.download.a.aC(TbadkCoreApplication.getInst(), downloadData.getPath());
                    com.baidu.tieba.ad.download.b.a.che.get().bJF().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk() && !com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aC)) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
                    }
                } else {
                    com.baidu.tieba.ad.download.b.a.che.get().bJF().Fn(downloadData.getId());
                    com.baidu.tieba.recapp.download.a.dAt().a(downloadData, 5);
                    if (i.this.dX(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.mtX.put(downloadData.getUrl(), kVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), i.this.Dx(downloadData.getAction()), false, kVar.dAx(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        i.this.c(downloadData);
                    }
                }
                DownloadData unused = i.fmS = null;
                if (!com.baidu.tieba.lego.card.d.a.isEmpty(i.mTaskList)) {
                    com.baidu.tieba.lego.card.d.a.m(i.mTaskList, 0);
                    i.this.bzr();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int dX = dX(downloadData.getId(), downloadData.getName());
            b.che.get().bJF().az(downloadData.getId(), dX);
            String str = dX + "%";
            k kVar = this.mtX.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, dX) : kVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                kVar2.dAy();
            } else if (status == 4 || status == 2 || status == 7) {
                kVar2.dAz();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            kVar2.HS(dX);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), Dx(downloadData.getAction()), false, kVar2.dAx(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.mtX.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, dX(downloadData.getId(), downloadData.getName())) : kVar;
            kVar2.dAy();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, dX(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), Dx(downloadData.getAction()), false, kVar2.dAx(), false);
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.mtX.get(downloadData.getUrl());
            int dX = dX(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, dX);
            }
            kVar.dAz();
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            k(downloadData);
            com.baidu.tieba.ad.download.b.a.che.get().bJF().a(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.mtX.get(downloadData.getUrl());
            if (kVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, dX(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), Dx(downloadData.getAction()), false, kVar.dAx(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent Dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public void m(DownloadData downloadData) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, Dx(downloadData.getAction()), false);
            }
        }
    }

    public boolean Dy(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.dAt().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int dX(String str, String str2) {
        long dY = dY(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (dY <= j) {
            return (int) ((100 * dY) / j);
        }
        return 0;
    }

    public boolean Rs(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.dAt().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void C(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.dAt().getDownloadList()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.dAt().cancelDownLoadByUrl(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.dAt().cancelDownLoadByUrl(str);
            }
            if (downloadData != null) {
                int dX = dX(downloadData.getId(), downloadData.getName());
                com.baidu.tieba.ad.download.b.a.che.get().bJF().ay(str2, dX);
                String str3 = dX + "%";
                if (downloadData != null && dX >= 0) {
                    k kVar = this.mtX.get(downloadData.getUrl());
                    k kVar2 = kVar == null ? new k(downloadData, dX) : kVar;
                    kVar2.dAz();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), Dx(downloadData.getAction()), false, kVar2.dAx(), false);
                }
            }
        }
    }

    public void n(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.dAt().i(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        com.baidu.tieba.ad.download.b.a.che.get().bJF().a(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
        b(downloadData);
    }

    public boolean gc(String str, String str2) {
        File GetFile;
        return TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L) != 0 && (GetFile = n.GetFile(new StringBuilder().append(str).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(str2).append(".tmp").toString())) != null && GetFile.exists() && GetFile.isFile();
    }

    public long dY(String str, String str2) {
        File GetFile = n.GetFile(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public boolean DA(String str) {
        return (TextUtils.isEmpty(str) || n.GetFile(new StringBuilder().append(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        String id;
        int i = 6;
        if (dAA().DA(downloadData.getId())) {
            i = 3;
        } else if (dAA().Rs(downloadData.getId())) {
            i = 5;
        } else if (dAA().Dy(downloadData.getId())) {
            i = 1;
        } else if (dAA().gc(downloadData.getId(), downloadData.getName())) {
            i = 7;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && com.baidu.tieba.a.bHt().bHv() && dAA().Rt(id)) {
            return 8;
        }
        return i;
    }

    private boolean Rt(String str) {
        TbadkApplication inst = TbadkApplication.getInst();
        if (inst != null) {
            try {
                if (inst.getPackageManager() != null) {
                    inst.getPackageManager().getPackageInfo(str, 64);
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static Integer Ru(String str) {
        if (mtW.containsKey(str)) {
            return mtW.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        mtW.put(str, valueOf);
        return valueOf;
    }
}
