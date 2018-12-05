package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private static h gMr = null;
    private static DownloadData aXK = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> gMj = new HashMap<>();
    private final int aXI = 5;
    private a gMs = null;
    private HashMap<String, j> gMk = new HashMap<>();

    private h() {
    }

    public static h buM() {
        synchronized (h.class) {
            if (gMr == null) {
                gMr = new h();
            }
        }
        return gMr;
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
            List<DownloadData> nt = com.baidu.tieba.recapp.download.a.buF().nt();
            if (nt != null && nt.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(e.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), e.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            LQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LQ() {
        if (aXK == null && !mTaskList.isEmpty()) {
            aXK = mTaskList.get(0);
            if (aXK != null) {
                this.gMs = new a();
                this.gMs.setPriority(3);
                this.gMs.execute(aXK);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bj(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.getCacheDir());
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
                if (!ao.isEmpty(id) && !ao.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", BaseRequestAction.SPLITE) + ".apk";
                    String bj = h.this.bj(str);
                    File eU = l.eU(str);
                    if (isForceDownload || eU == null) {
                        downloadData.setCallback(new i());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(bj);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(bj);
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
            h.this.gMs = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    h.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", BaseRequestAction.SPLITE) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.download.a.buF().a(downloadData, 5);
                    if (h.this.aJ(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.download_will_begin);
                            j jVar = new j(downloadData, 0);
                            h.this.gMk.put(downloadData.getUrl(), jVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), h.this.hw(downloadData.getAction()), false, jVar.buJ(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        h.this.c(downloadData);
                    }
                }
                DownloadData unused = h.aXK = null;
                if (!h.mTaskList.isEmpty()) {
                    h.mTaskList.remove(0);
                    h.this.LQ();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aJ = aJ(downloadData.getId(), downloadData.getName());
            String str = aJ + "%";
            j jVar = this.gMk.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, aJ) : jVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                jVar2.buK();
            } else if (status == 4 || status == 2 || status == 7) {
                jVar2.buL();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            jVar2.tM(aJ);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), hw(downloadData.getAction()), false, jVar2.buJ(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gMk.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, aJ(downloadData.getId(), downloadData.getName())) : jVar;
            jVar2.buK();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aJ(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), hw(downloadData.getAction()), false, jVar2.buJ(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gMk.get(downloadData.getUrl());
            int aJ = aJ(downloadData.getId(), downloadData.getName());
            if (jVar == null) {
                jVar = new j(downloadData, aJ);
            }
            jVar.buL();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            j jVar = this.gMk.get(downloadData.getUrl());
            if (jVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aJ(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), hw(downloadData.getAction()), false, jVar.buJ(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent hw(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(e.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(e.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(e.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.download_fail_tip), process, process + "%", string, hw(downloadData.getAction()), false);
            }
        }
    }

    public boolean hx(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.buF().nt()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int aJ(String str, String str2) {
        long aK = aK(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (aK <= j) {
            return (int) ((100 * aK) / j);
        }
        return 0;
    }

    public boolean uy(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.buF().nt()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.buF().nt()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.buF().u(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.buF().hA(str);
            }
            if (downloadData != null) {
                int aJ = aJ(downloadData.getId(), downloadData.getName());
                String str3 = aJ + "%";
                if (downloadData != null && aJ >= 0) {
                    j jVar = this.gMk.get(downloadData.getUrl());
                    j jVar2 = jVar == null ? new j(downloadData, aJ) : jVar;
                    jVar2.buL();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), hw(downloadData.getAction()), false, jVar2.buJ(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.buF().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean cy(String str, String str2) {
        File eU;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (eU = l.eU(new StringBuilder().append(str).append(BaseRequestAction.SPLITE).append(str2).append(".tmp").toString())) != null && eU.exists() && eU.isFile();
    }

    public long aK(String str, String str2) {
        File eU = l.eU(str + BaseRequestAction.SPLITE + str2 + ".tmp");
        if (eU != null && eU.exists() && eU.isFile()) {
            return eU.length();
        }
        return -1L;
    }

    public boolean hz(String str) {
        return (TextUtils.isEmpty(str) || l.eU(new StringBuilder().append(str.replace(".", BaseRequestAction.SPLITE)).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (buM().hz(downloadData.getId())) {
            return 3;
        }
        if (buM().uy(downloadData.getId())) {
            return 5;
        }
        if (buM().hx(downloadData.getId())) {
            return 1;
        }
        if (!buM().cy(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer uz(String str) {
        if (gMj.containsKey(str)) {
            return gMj.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        gMj.put(str, valueOf);
        return valueOf;
    }
}
