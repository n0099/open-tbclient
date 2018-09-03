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
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private static h gph = null;
    private static DownloadData aLD = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> goZ = new HashMap<>();
    private final int aLB = 5;
    private a gpi = null;
    private HashMap<String, j> gpa = new HashMap<>();

    private h() {
    }

    public static h bnB() {
        synchronized (h.class) {
            if (gph == null) {
                gph = new h();
            }
        }
        return gph;
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
            List<DownloadData> mg = com.baidu.tieba.recapp.download.a.bnu().mg();
            if (mg != null && mg.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(f.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), f.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Hl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        if (aLD == null && !mTaskList.isEmpty()) {
            aLD = mTaskList.get(0);
            if (aLD != null) {
                this.gpi = new a();
                this.gpi.setPriority(3);
                this.gpi.execute(aLD);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aT(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.yj());
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
                    String aT = h.this.aT(str);
                    File dU = l.dU(str);
                    if (isForceDownload || dU == null) {
                        downloadData.setCallback(new i());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aT);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aT);
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
            h.this.gpi = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    h.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.download.a.bnu().a(downloadData, 5);
                    if (h.this.an(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(f.j.download_will_begin);
                            j jVar = new j(downloadData, 0);
                            h.this.gpa.put(downloadData.getUrl(), jVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), h.this.gt(downloadData.getAction()), false, jVar.bny(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        h.this.c(downloadData);
                    }
                }
                DownloadData unused = h.aLD = null;
                if (!h.mTaskList.isEmpty()) {
                    h.mTaskList.remove(0);
                    h.this.Hl();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int an = an(downloadData.getId(), downloadData.getName());
            String str = an + "%";
            j jVar = this.gpa.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, an) : jVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                jVar2.bnz();
            } else if (status == 4 || status == 2 || status == 7) {
                jVar2.bnA();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            jVar2.sf(an);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), gt(downloadData.getAction()), false, jVar2.bny(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gpa.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, an(downloadData.getId(), downloadData.getName())) : jVar;
            jVar2.bnz();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, an(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gt(downloadData.getAction()), false, jVar2.bny(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gpa.get(downloadData.getUrl());
            int an = an(downloadData.getId(), downloadData.getName());
            if (jVar == null) {
                jVar = new j(downloadData, an);
            }
            jVar.bnA();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            j jVar = this.gpa.get(downloadData.getUrl());
            if (jVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, an(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gt(downloadData.getAction()), false, jVar.bny(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent gt(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(f.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(f.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(f.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(f.j.download_fail_tip), process, process + "%", string, gt(downloadData.getAction()), false);
            }
        }
    }

    public boolean gu(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.bnu().mg()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int an(String str, String str2) {
        long ao = ao(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ao <= j) {
            return (int) ((100 * ao) / j);
        }
        return 0;
    }

    public boolean sK(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.bnu().mg()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void i(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.bnu().mg()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.bnu().k(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.bnu().gx(str);
            }
            if (downloadData != null) {
                int an = an(downloadData.getId(), downloadData.getName());
                String str3 = an + "%";
                if (downloadData != null && an >= 0) {
                    j jVar = this.gpa.get(downloadData.getUrl());
                    j jVar2 = jVar == null ? new j(downloadData, an) : jVar;
                    jVar2.bnA();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), gt(downloadData.getAction()), false, jVar2.bny(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.bnu().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean bY(String str, String str2) {
        File dU;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dU = l.dU(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && dU.exists() && dU.isFile();
    }

    public long ao(String str, String str2) {
        File dU = l.dU(str + "_" + str2 + ".tmp");
        if (dU != null && dU.exists() && dU.isFile()) {
            return dU.length();
        }
        return -1L;
    }

    public boolean gw(String str) {
        return (TextUtils.isEmpty(str) || l.dU(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bnB().gw(downloadData.getId())) {
            return 3;
        }
        if (bnB().sK(downloadData.getId())) {
            return 5;
        }
        if (bnB().gu(downloadData.getId())) {
            return 1;
        }
        if (!bnB().bY(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer sL(String str) {
        if (goZ.containsKey(str)) {
            return goZ.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        goZ.put(str, valueOf);
        return valueOf;
    }
}
