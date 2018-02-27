package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private final int brB = 5;
    private a gCG = null;
    private HashMap<String, j> gCy = new HashMap<>();
    private static h gCF = null;
    private static DownloadData brD = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> gCx = new HashMap<>();

    private h() {
    }

    public static h boq() {
        synchronized (h.class) {
            if (gCF == null) {
                gCF = new h();
            }
        }
        return gCF;
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
            List<DownloadData> rl = com.baidu.tieba.recapp.download.a.boj().rl();
            if (rl != null && rl.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            KR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KR() {
        if (brD == null && !mTaskList.isEmpty()) {
            brD = mTaskList.get(0);
            if (brD != null) {
                this.gCG = new a();
                this.gCG.setPriority(3);
                this.gCG.execute(brD);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aH(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.BU());
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
                if (!am.isEmpty(id) && !am.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(Constants.DOT, "_") + ".apk";
                    String aH = h.this.aH(str);
                    File dC = k.dC(str);
                    if (isForceDownload || dC == null) {
                        downloadData.setCallback(new i());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aH);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aH);
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
            h.this.gCG = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    h.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(Constants.DOT, "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.download.a.boj().a(downloadData, 5);
                    if (h.this.al(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_will_begin);
                            j jVar = new j(downloadData, 0);
                            h.this.gCy.put(downloadData.getUrl(), jVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), h.this.gb(downloadData.getAction()), false, jVar.bon(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        h.this.c(downloadData);
                    }
                }
                DownloadData unused = h.brD = null;
                if (!h.mTaskList.isEmpty()) {
                    h.mTaskList.remove(0);
                    h.this.KR();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str = al + "%";
            j jVar = this.gCy.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, al) : jVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                jVar2.boo();
            } else if (status == 4 || status == 2 || status == 7) {
                jVar2.bop();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            jVar2.up(al);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), gb(downloadData.getAction()), false, jVar2.bon(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gCy.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, al(downloadData.getId(), downloadData.getName())) : jVar;
            jVar2.boo();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, al(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gb(downloadData.getAction()), false, jVar2.bon(), false);
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gCy.get(downloadData.getUrl());
            int al = al(downloadData.getId(), downloadData.getName());
            if (jVar == null) {
                jVar = new j(downloadData, al);
            }
            jVar.bop();
        }
    }

    public void o(DownloadData downloadData) {
        if (downloadData != null) {
            n(downloadData);
            j jVar = this.gCy.get(downloadData.getUrl());
            if (jVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, al(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gb(downloadData.getAction()), false, jVar.bon(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent gb(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_fail_tip), process, process + "%", string, gb(downloadData.getAction()), false);
            }
        }
    }

    public boolean gc(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.boj().rl()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int al(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((100 * am) / j);
        }
        return 0;
    }

    public boolean gh(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.boj().rl()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void i(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.boj().rl()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.boj().n(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.boj().gf(str);
            }
            if (downloadData != null) {
                int al = al(downloadData.getId(), downloadData.getName());
                String str3 = al + "%";
                if (downloadData != null && al >= 0) {
                    j jVar = this.gCy.get(downloadData.getUrl());
                    j jVar2 = jVar == null ? new j(downloadData, al) : jVar;
                    jVar2.bop();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), gb(downloadData.getAction()), false, jVar2.bon(), false);
                }
            }
        }
    }

    public void p(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.boj().l(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean an(String str, String str2) {
        File dC;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dC = k.dC(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && dC.exists() && dC.isFile();
    }

    public long am(String str, String str2) {
        File dC = k.dC(str + "_" + str2 + ".tmp");
        if (dC != null && dC.exists() && dC.isFile()) {
            return dC.length();
        }
        return -1L;
    }

    public boolean ge(String str) {
        return (TextUtils.isEmpty(str) || k.dC(new StringBuilder().append(str.replace(Constants.DOT, "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (boq().ge(downloadData.getId())) {
            return 3;
        }
        if (boq().gh(downloadData.getId())) {
            return 5;
        }
        if (boq().gc(downloadData.getId())) {
            return 1;
        }
        if (!boq().an(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer rL(String str) {
        if (gCx.containsKey(str)) {
            return gCx.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        gCx.put(str, valueOf);
        return valueOf;
    }
}
