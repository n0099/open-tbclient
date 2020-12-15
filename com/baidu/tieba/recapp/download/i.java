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
import com.baidu.tbadk.core.util.au;
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
    private static i mII = null;
    private static DownloadData ftE = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> mIz = new HashMap<>();
    private final int MAX = 5;
    private a mIJ = null;
    private HashMap<String, k> mIA = new HashMap<>();

    private i() {
    }

    public static i dFs() {
        synchronized (i.class) {
            if (mII == null) {
                mII = new i();
            }
        }
        return mII;
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
            List<DownloadData> downloadList = com.baidu.tieba.recapp.download.a.dFl().getDownloadList();
            if (downloadList != null && downloadList.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
                return;
            }
            com.baidu.tieba.lego.card.d.a.a(mTaskList, downloadData);
            bCh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCh() {
        if (ftE == null && !com.baidu.tieba.lego.card.d.a.isEmpty(mTaskList)) {
            ftE = (DownloadData) com.baidu.tieba.lego.card.d.a.l(mTaskList, 0);
            if (ftE != null) {
                this.mIJ = new a();
                this.mIJ.setPriority(3);
                this.mIJ.execute(ftE);
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

    public String RZ(String str) {
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
                if (!au.isEmpty(id) && !au.isEmpty(name)) {
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
            i.this.mIJ = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String aC = com.baidu.tieba.ad.download.a.aC(TbadkCoreApplication.getInst(), downloadData.getPath());
                    com.baidu.tieba.ad.download.b.a.clZ.get().bMH().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk() && !com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aC)) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
                    }
                } else {
                    com.baidu.tieba.ad.download.b.a.clZ.get().bMH().FC(downloadData.getId());
                    com.baidu.tieba.recapp.download.a.dFl().a(downloadData, 5);
                    if (i.this.ee(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.mIA.put(downloadData.getUrl(), kVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), i.this.DE(downloadData.getAction()), false, kVar.dFp(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        i.this.c(downloadData);
                    }
                }
                DownloadData unused = i.ftE = null;
                if (!com.baidu.tieba.lego.card.d.a.isEmpty(i.mTaskList)) {
                    com.baidu.tieba.lego.card.d.a.m(i.mTaskList, 0);
                    i.this.bCh();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ee = ee(downloadData.getId(), downloadData.getName());
            b.clZ.get().bMH().az(downloadData.getId(), ee);
            String str = ee + "%";
            k kVar = this.mIA.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, ee) : kVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                kVar2.dFq();
            } else if (status == 4 || status == 2 || status == 7) {
                kVar2.dFr();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            kVar2.Jh(ee);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), DE(downloadData.getAction()), false, kVar2.dFp(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.mIA.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, ee(downloadData.getId(), downloadData.getName())) : kVar;
            kVar2.dFq();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, ee(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), DE(downloadData.getAction()), false, kVar2.dFp(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.mIA.get(downloadData.getUrl());
            int ee = ee(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, ee);
            }
            kVar.dFr();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            com.baidu.tieba.ad.download.b.a.clZ.get().bMH().a(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.mIA.get(downloadData.getUrl());
            if (kVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, ee(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), DE(downloadData.getAction()), false, kVar.dFp(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent DE(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, DE(downloadData.getAction()), false);
            }
        }
    }

    public boolean DF(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.dFl().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ee(String str, String str2) {
        long ef = ef(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ef <= j) {
            return (int) ((100 * ef) / j);
        }
        return 0;
    }

    public boolean RW(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.dFl().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void D(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.dFl().getDownloadList()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.dFl().cancelDownLoadByUrl(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.dFl().cancelDownLoadByUrl(str);
            }
            if (downloadData != null) {
                int ee = ee(downloadData.getId(), downloadData.getName());
                com.baidu.tieba.ad.download.b.a.clZ.get().bMH().ay(str2, ee);
                String str3 = ee + "%";
                if (downloadData != null && ee >= 0) {
                    k kVar = this.mIA.get(downloadData.getUrl());
                    k kVar2 = kVar == null ? new k(downloadData, ee) : kVar;
                    kVar2.dFr();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), DE(downloadData.getAction()), false, kVar2.dFp(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.dFl().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        com.baidu.tieba.ad.download.b.a.clZ.get().bMH().a(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
        b(downloadData);
    }

    public boolean gh(String str, String str2) {
        File GetFile;
        return TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L) != 0 && (GetFile = n.GetFile(new StringBuilder().append(str).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(str2).append(".tmp").toString())) != null && GetFile.exists() && GetFile.isFile();
    }

    public long ef(String str, String str2) {
        File GetFile = n.GetFile(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public boolean DH(String str) {
        return (TextUtils.isEmpty(str) || n.GetFile(new StringBuilder().append(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        String id;
        int i = 6;
        if (dFs().DH(downloadData.getId())) {
            i = 3;
        } else if (dFs().RW(downloadData.getId())) {
            i = 5;
        } else if (dFs().DF(downloadData.getId())) {
            i = 1;
        } else if (dFs().gh(downloadData.getId(), downloadData.getName())) {
            i = 7;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && com.baidu.tieba.a.bKm().bKo() && dFs().RX(id)) {
            return 8;
        }
        return i;
    }

    private boolean RX(String str) {
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

    public static Integer RY(String str) {
        if (mIz.containsKey(str)) {
            return mIz.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        mIz.put(str, valueOf);
        return valueOf;
    }
}
