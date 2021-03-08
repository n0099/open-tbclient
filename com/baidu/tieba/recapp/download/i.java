package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.t;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    private static i mUT = null;
    private static DownloadData fCq = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> mUM = new HashMap<>();
    private final int fCo = 5;
    private a mUU = null;
    private HashMap<String, k> mUN = new HashMap<>();

    private i() {
    }

    public static i dDN() {
        synchronized (i.class) {
            if (mUT == null) {
                mUT = new i();
            }
        }
        return mUT;
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
            List<DownloadData> downloadList = com.baidu.tieba.recapp.download.a.dDH().getDownloadList();
            if (downloadList != null && downloadList.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
                return;
            }
            com.baidu.tieba.lego.card.c.a.a(mTaskList, downloadData);
            bBe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBe() {
        if (fCq == null && !com.baidu.tieba.lego.card.c.a.isEmpty(mTaskList)) {
            fCq = (DownloadData) com.baidu.tieba.lego.card.c.a.l(mTaskList, 0);
            if (fCq != null) {
                this.mUU = new a();
                this.mUU.setPriority(3);
                this.mUU.execute(fCq);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
                    String Rs = com.baidu.tieba.recapp.b.Rs(id);
                    String Rr = com.baidu.tieba.recapp.b.Rr(id);
                    File Rq = com.baidu.tieba.recapp.b.Rq(Rs);
                    if (isForceDownload || Rq == null) {
                        downloadData.setCallback(new j());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(Rr);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(Rs);
                    downloadData2.setPath(Rr);
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
            i.this.mUU = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String aJ = com.baidu.tieba.ad.download.a.aJ(TbadkCoreApplication.getInst(), downloadData.getPath());
                    com.baidu.tieba.ad.download.b.a.gjj.get().bLL().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk() && !com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aJ) && !t.RD(com.baidu.tieba.recapp.b.Rr(downloadData.getId()))) {
                        com.baidu.tieba.recapp.b.deleteFileOrDir(new File(com.baidu.tieba.recapp.b.Rr(downloadData.getId())));
                    }
                } else {
                    com.baidu.tieba.ad.download.b.a.gjj.get().bLL().ES(downloadData.getId());
                    com.baidu.tieba.recapp.download.a.dDH().a(downloadData, 5);
                    if (i.this.dX(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.mUN.put(downloadData.getUrl(), kVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), i.this.CO(downloadData.getAction()), false, kVar.dDK(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        i.this.c(downloadData);
                    }
                }
                DownloadData unused = i.fCq = null;
                if (!com.baidu.tieba.lego.card.c.a.isEmpty(i.mTaskList)) {
                    com.baidu.tieba.lego.card.c.a.m(i.mTaskList, 0);
                    i.this.bBe();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int dX = dX(downloadData.getId(), downloadData.getName());
            b.gjj.get().bLL().aD(downloadData.getId(), dX);
            String str = dX + "%";
            k kVar = this.mUN.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, dX) : kVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                kVar2.dDL();
            } else if (status == 4 || status == 2 || status == 7) {
                kVar2.dDM();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            kVar2.HQ(dX);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), CO(downloadData.getAction()), false, kVar2.dDK(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.mUN.get(downloadData.getUrl());
            k kVar2 = kVar == null ? new k(downloadData, dX(downloadData.getId(), downloadData.getName())) : kVar;
            kVar2.dDL();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, dX(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), CO(downloadData.getAction()), false, kVar2.dDK(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.mUN.get(downloadData.getUrl());
            int dX = dX(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, dX);
            }
            kVar.dDM();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            com.baidu.tieba.ad.download.b.a.gjj.get().bLL().a(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.mUN.get(downloadData.getUrl());
            if (kVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, dX(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), CO(downloadData.getAction()), false, kVar.dDK(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent CO(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, CO(downloadData.getAction()), false);
            }
        }
    }

    public boolean RF(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.dDH().getDownloadList()) {
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

    public boolean RG(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.dDH().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void F(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.dDH().getDownloadList()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.dDH().cancelDownLoadByUrl(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.dDH().cancelDownLoadByUrl(str);
            }
            if (downloadData != null) {
                int dX = dX(downloadData.getId(), downloadData.getName());
                com.baidu.tieba.ad.download.b.a.gjj.get().bLL().aC(str2, dX);
                String str3 = dX + "%";
                if (downloadData != null && dX >= 0) {
                    k kVar = this.mUN.get(downloadData.getUrl());
                    k kVar2 = kVar == null ? new k(downloadData, dX) : kVar;
                    kVar2.dDM();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), CO(downloadData.getAction()), false, kVar2.dDK(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.dDH().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        com.baidu.tieba.ad.download.b.a.gjj.get().bLL().a(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
        b(downloadData);
    }

    public long dY(String str, String str2) {
        File Rq = com.baidu.tieba.recapp.b.Rq(com.baidu.tieba.recapp.b.gh(str, str2));
        if (Rq != null && Rq.exists() && Rq.isFile()) {
            return Rq.length();
        }
        return -1L;
    }

    public static int getStatus(DownloadData downloadData) {
        String id;
        int i = 6;
        if (com.baidu.tieba.recapp.b.Rt(downloadData.getId())) {
            i = 3;
        } else if (dDN().RG(downloadData.getId())) {
            i = 5;
        } else if (dDN().RF(downloadData.getId())) {
            i = 1;
        } else if (com.baidu.tieba.recapp.b.gi(downloadData.getId(), downloadData.getName())) {
            i = 7;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && com.baidu.tieba.a.bJk().bJl() && t.RA(id)) {
            return 8;
        }
        return i;
    }

    public static Integer RJ(String str) {
        if (mUM.containsKey(str)) {
            return mUM.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        mUM.put(str, valueOf);
        return valueOf;
    }
}
