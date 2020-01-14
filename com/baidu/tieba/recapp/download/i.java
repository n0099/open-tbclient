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
/* loaded from: classes11.dex */
public class i {
    private static i jGe = null;
    private static DownloadData drV = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> jFX = new HashMap<>();
    private final int MAX = 5;
    private a jGf = null;
    private HashMap<String, k> jFY = new HashMap<>();

    private i() {
    }

    public static i cBj() {
        synchronized (i.class) {
            if (jGe == null) {
                jGe = new i();
            }
        }
        return jGe;
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
            List<DownloadData> downloadList = com.baidu.tieba.recapp.download.a.cBc().getDownloadList();
            if (downloadList != null && downloadList.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            aLQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLQ() {
        if (drV == null && !mTaskList.isEmpty()) {
            drV = mTaskList.get(0);
            if (drV != null) {
                this.jGf = new a();
                this.jGf.setPriority(3);
                this.jGf.execute(drV);
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
        sb.append(m.getCacheDir());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public String HA(String str) {
        return getFilePath(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
                    String str = id.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk";
                    String filePath = i.this.getFilePath(str);
                    File GetFile = m.GetFile(str);
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
            i.this.jGf = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String aJ = com.baidu.tieba.ad.download.a.aJ(TbadkCoreApplication.getInst(), downloadData.getPath());
                    com.baidu.tieba.ad.download.b.a.dVC.get().aWc().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk() && !com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aJ)) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
                    }
                } else {
                    com.baidu.tieba.ad.download.b.a.dVC.get().aWc().wI(downloadData.getId());
                    com.baidu.tieba.recapp.download.a.cBc().a(downloadData, 5);
                    if (i.this.cx(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.jFY.put(downloadData.getUrl(), kVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), i.this.uE(downloadData.getAction()), false, kVar.cBg(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        i.this.c(downloadData);
                    }
                }
                DownloadData unused = i.drV = null;
                if (!i.mTaskList.isEmpty()) {
                    i.mTaskList.remove(0);
                    i.this.aLQ();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int cx = cx(downloadData.getId(), downloadData.getName());
            b.dVC.get().aWc().am(downloadData.getId(), cx);
            String str = cx + "%";
            k kVar = this.jFY.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, cx) : kVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                kVar2.cBh();
            } else if (status == 4 || status == 2 || status == 7) {
                kVar2.cBi();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            kVar2.AJ(cx);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), uE(downloadData.getAction()), false, kVar2.cBg(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.jFY.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, cx(downloadData.getId(), downloadData.getName())) : kVar;
            kVar2.cBh();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, cx(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), uE(downloadData.getAction()), false, kVar2.cBg(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.jFY.get(downloadData.getUrl());
            int cx = cx(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, cx);
            }
            kVar.cBi();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            com.baidu.tieba.ad.download.b.a.dVC.get().aWc().a(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.jFY.get(downloadData.getUrl());
            if (kVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, cx(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), uE(downloadData.getAction()), false, kVar.cBg(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent uE(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, uE(downloadData.getAction()), false);
            }
        }
    }

    public boolean uF(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.cBc().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int cx(String str, String str2) {
        long cy = cy(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (cy <= j) {
            return (int) ((100 * cy) / j);
        }
        return 0;
    }

    public boolean Hx(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.cBc().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void z(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.cBc().getDownloadList()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.cBc().cancelDownLoadByUrl(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.cBc().cancelDownLoadByUrl(str);
            }
            if (downloadData != null) {
                int cx = cx(downloadData.getId(), downloadData.getName());
                com.baidu.tieba.ad.download.b.a.dVC.get().aWc().al(str2, cx);
                String str3 = cx + "%";
                if (downloadData != null && cx >= 0) {
                    k kVar = this.jFY.get(downloadData.getUrl());
                    k kVar2 = kVar == null ? new k(downloadData, cx) : kVar;
                    kVar2.cBi();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), uE(downloadData.getAction()), false, kVar2.cBg(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.cBc().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        com.baidu.tieba.ad.download.b.a.dVC.get().aWc().a(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
        b(downloadData);
    }

    public boolean eg(String str, String str2) {
        File GetFile;
        return TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L) != 0 && (GetFile = m.GetFile(new StringBuilder().append(str).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(str2).append(".tmp").toString())) != null && GetFile.exists() && GetFile.isFile();
    }

    public long cy(String str, String str2) {
        File GetFile = m.GetFile(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public boolean uH(String str) {
        return (TextUtils.isEmpty(str) || m.GetFile(new StringBuilder().append(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        String id;
        int i = 6;
        if (cBj().uH(downloadData.getId())) {
            i = 3;
        } else if (cBj().Hx(downloadData.getId())) {
            i = 5;
        } else if (cBj().uF(downloadData.getId())) {
            i = 1;
        } else if (cBj().eg(downloadData.getId(), downloadData.getName())) {
            i = 7;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && com.baidu.tieba.a.aSU().aSW() && cBj().Hy(id)) {
            return 8;
        }
        return i;
    }

    private boolean Hy(String str) {
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

    public static Integer Hz(String str) {
        if (jFX.containsKey(str)) {
            return jFX.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        jFX.put(str, valueOf);
        return valueOf;
    }
}
