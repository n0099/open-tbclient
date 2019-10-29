package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
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
/* loaded from: classes3.dex */
public class i {
    private static i iIX = null;
    private static DownloadData cEF = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> iIP = new HashMap<>();
    private final int cED = 5;
    private a iIY = null;
    private HashMap<String, k> iIQ = new HashMap<>();

    private i() {
    }

    public static i cfY() {
        synchronized (i.class) {
            if (iIX == null) {
                iIX = new i();
            }
        }
        return iIX;
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
            List<DownloadData> downloadList = com.baidu.tieba.recapp.download.a.cfR().getDownloadList();
            if (downloadList != null && downloadList.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            atU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atU() {
        if (cEF == null && !mTaskList.isEmpty()) {
            cEF = mTaskList.get(0);
            if (cEF != null) {
                this.iIY = new a();
                this.iIY.setPriority(3);
                this.iIY.execute(cEF);
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

    public String CC(String str) {
        return getFilePath(str.replace(DefaultConfig.TOKEN_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
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
                    String str = id.replace(DefaultConfig.TOKEN_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk";
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
            i.this.iIY = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String aq = com.baidu.tieba.ad.download.a.aq(TbadkCoreApplication.getInst(), downloadData.getPath());
                    com.baidu.tieba.ad.download.b.a.diy.get().aDR().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk() && !com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aq)) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(DefaultConfig.TOKEN_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
                    }
                } else {
                    com.baidu.tieba.ad.download.b.a.diy.get().aDR().rv(downloadData.getId());
                    com.baidu.tieba.recapp.download.a.cfR().a(downloadData, 5);
                    if (i.this.ca(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.iIQ.put(downloadData.getUrl(), kVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), i.this.pt(downloadData.getAction()), false, kVar.cfV(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        i.this.c(downloadData);
                    }
                }
                DownloadData unused = i.cEF = null;
                if (!i.mTaskList.isEmpty()) {
                    i.mTaskList.remove(0);
                    i.this.atU();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ca = ca(downloadData.getId(), downloadData.getName());
            b.diy.get().aDR().Z(downloadData.getId(), ca);
            String str = ca + "%";
            k kVar = this.iIQ.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, ca) : kVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                kVar2.cfW();
            } else if (status == 4 || status == 2 || status == 7) {
                kVar2.cfX();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            kVar2.yj(ca);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), pt(downloadData.getAction()), false, kVar2.cfV(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.iIQ.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, ca(downloadData.getId(), downloadData.getName())) : kVar;
            kVar2.cfW();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, ca(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), pt(downloadData.getAction()), false, kVar2.cfV(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.iIQ.get(downloadData.getUrl());
            int ca = ca(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, ca);
            }
            kVar.cfX();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            com.baidu.tieba.ad.download.b.a.diy.get().aDR().a(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.iIQ.get(downloadData.getUrl());
            if (kVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, ca(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), pt(downloadData.getAction()), false, kVar.cfV(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent pt(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, pt(downloadData.getAction()), false);
            }
        }
    }

    public boolean pu(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.cfR().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ca(String str, String str2) {
        long cb = cb(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (cb <= j) {
            return (int) ((100 * cb) / j);
        }
        return 0;
    }

    public boolean Cz(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.cfR().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void z(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.cfR().getDownloadList()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.cfR().cancelDownLoadByUrl(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.cfR().cancelDownLoadByUrl(str);
            }
            if (downloadData != null) {
                int ca = ca(downloadData.getId(), downloadData.getName());
                com.baidu.tieba.ad.download.b.a.diy.get().aDR().Y(str2, ca);
                String str3 = ca + "%";
                if (downloadData != null && ca >= 0) {
                    k kVar = this.iIQ.get(downloadData.getUrl());
                    k kVar2 = kVar == null ? new k(downloadData, ca) : kVar;
                    kVar2.cfX();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), pt(downloadData.getAction()), false, kVar2.cfV(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.cfR().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        com.baidu.tieba.ad.download.b.a.diy.get().aDR().a(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
        b(downloadData);
    }

    public boolean dL(String str, String str2) {
        File GetFile;
        return TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L) != 0 && (GetFile = m.GetFile(new StringBuilder().append(str).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(str2).append(".tmp").toString())) != null && GetFile.exists() && GetFile.isFile();
    }

    public long cb(String str, String str2) {
        File GetFile = m.GetFile(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public boolean pw(String str) {
        return (TextUtils.isEmpty(str) || m.GetFile(new StringBuilder().append(str.replace(DefaultConfig.TOKEN_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        String id;
        int i = 6;
        if (cfY().pw(downloadData.getId())) {
            i = 3;
        } else if (cfY().Cz(downloadData.getId())) {
            i = 5;
        } else if (cfY().pu(downloadData.getId())) {
            i = 1;
        } else if (cfY().dL(downloadData.getId(), downloadData.getName())) {
            i = 7;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && com.baidu.tieba.a.aAO().aAQ() && cfY().CA(id)) {
            return 8;
        }
        return i;
    }

    private boolean CA(String str) {
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

    public static Integer CB(String str) {
        if (iIP.containsKey(str)) {
            return iIP.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        iIP.put(str, valueOf);
        return valueOf;
    }
}
