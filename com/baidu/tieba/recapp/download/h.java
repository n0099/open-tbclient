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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private static h iAo = null;
    private static DownloadData cqg = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> iAg = new HashMap<>();
    private final int cqe = 5;
    private a iAp = null;
    private HashMap<String, j> iAh = new HashMap<>();

    private h() {
    }

    public static h ceZ() {
        synchronized (h.class) {
            if (iAo == null) {
                iAo = new h();
            }
        }
        return iAo;
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
            List<DownloadData> mx = com.baidu.tieba.recapp.download.a.ceS().mx();
            if (mx != null && mx.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            aqL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqL() {
        if (cqg == null && !mTaskList.isEmpty()) {
            cqg = mTaskList.get(0);
            if (cqg != null) {
                this.iAp = new a();
                this.iAp.setPriority(3);
                this.iAp.execute(cqg);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aU(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.ahb());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
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
                if (!ap.isEmpty(id) && !ap.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + ".apk";
                    String aU = h.this.aU(str);
                    File mY = m.mY(str);
                    if (isForceDownload || mY == null) {
                        downloadData.setCallback(new i());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aU);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aU);
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
            h.this.iAp = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    h.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.download.a.ceS().a(downloadData, 5);
                    if (h.this.cc(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            j jVar = new j(downloadData, 0);
                            h.this.iAh.put(downloadData.getUrl(), jVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), h.this.pH(downloadData.getAction()), false, jVar.ceW(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        h.this.c(downloadData);
                    }
                }
                DownloadData unused = h.cqg = null;
                if (!h.mTaskList.isEmpty()) {
                    h.mTaskList.remove(0);
                    h.this.aqL();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int cc = cc(downloadData.getId(), downloadData.getName());
            String str = cc + "%";
            j jVar = this.iAh.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, cc) : jVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                jVar2.ceX();
            } else if (status == 4 || status == 2 || status == 7) {
                jVar2.ceY();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            jVar2.yT(cc);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), pH(downloadData.getAction()), false, jVar2.ceW(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.iAh.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, cc(downloadData.getId(), downloadData.getName())) : jVar;
            jVar2.ceX();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, cc(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), pH(downloadData.getAction()), false, jVar2.ceW(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.iAh.get(downloadData.getUrl());
            int cc = cc(downloadData.getId(), downloadData.getName());
            if (jVar == null) {
                jVar = new j(downloadData, cc);
            }
            jVar.ceY();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            j jVar = this.iAh.get(downloadData.getUrl());
            if (jVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, cc(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), pH(downloadData.getAction()), false, jVar.ceW(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent pH(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, pH(downloadData.getAction()), false);
            }
        }
    }

    public boolean pI(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.ceS().mx()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int cc(String str, String str2) {
        long cd = cd(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (cd <= j) {
            return (int) ((100 * cd) / j);
        }
        return 0;
    }

    public boolean CS(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.ceS().mx()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void x(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.ceS().mx()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.ceS().Q(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.ceS().pL(str);
            }
            if (downloadData != null) {
                int cc = cc(downloadData.getId(), downloadData.getName());
                String str3 = cc + "%";
                if (downloadData != null && cc >= 0) {
                    j jVar = this.iAh.get(downloadData.getUrl());
                    j jVar2 = jVar == null ? new j(downloadData, cc) : jVar;
                    jVar2.ceY();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), pH(downloadData.getAction()), false, jVar2.ceW(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.ceS().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean dX(String str, String str2) {
        File mY;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (mY = m.mY(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && mY.exists() && mY.isFile();
    }

    public long cd(String str, String str2) {
        File mY = m.mY(str + "_" + str2 + ".tmp");
        if (mY != null && mY.exists() && mY.isFile()) {
            return mY.length();
        }
        return -1L;
    }

    public boolean pK(String str) {
        return (TextUtils.isEmpty(str) || m.mY(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (ceZ().pK(downloadData.getId())) {
            return 3;
        }
        if (ceZ().CS(downloadData.getId())) {
            return 5;
        }
        if (ceZ().pI(downloadData.getId())) {
            return 1;
        }
        if (!ceZ().dX(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer CT(String str) {
        if (iAg.containsKey(str)) {
            return iAg.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        iAg.put(str, valueOf);
        return valueOf;
    }
}
