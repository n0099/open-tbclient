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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private static h ihM = null;
    private static DownloadData chU = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> ihE = new HashMap<>();
    private final int chS = 5;
    private a ihN = null;
    private HashMap<String, j> ihF = new HashMap<>();

    private h() {
    }

    public static h bWW() {
        synchronized (h.class) {
            if (ihM == null) {
                ihM = new h();
            }
        }
        return ihM;
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
            List<DownloadData> nC = com.baidu.tieba.recapp.download.a.bWP().nC();
            if (nC != null && nC.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            alL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alL() {
        if (chU == null && !mTaskList.isEmpty()) {
            chU = mTaskList.get(0);
            if (chU != null) {
                this.ihN = new a();
                this.ihN.setPriority(3);
                this.ihN.execute(chU);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bk(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.acg());
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
                    String bk = h.this.bk(str);
                    File lQ = m.lQ(str);
                    if (isForceDownload || lQ == null) {
                        downloadData.setCallback(new i());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(bk);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(bk);
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
            h.this.ihN = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    h.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.download.a.bWP().a(downloadData, 5);
                    if (h.this.bS(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_will_begin);
                            j jVar = new j(downloadData, 0);
                            h.this.ihF.put(downloadData.getUrl(), jVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), h.this.oz(downloadData.getAction()), false, jVar.bWT(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        h.this.c(downloadData);
                    }
                }
                DownloadData unused = h.chU = null;
                if (!h.mTaskList.isEmpty()) {
                    h.mTaskList.remove(0);
                    h.this.alL();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int bS = bS(downloadData.getId(), downloadData.getName());
            String str = bS + "%";
            j jVar = this.ihF.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, bS) : jVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                jVar2.bWU();
            } else if (status == 4 || status == 2 || status == 7) {
                jVar2.bWV();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            jVar2.xQ(bS);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), oz(downloadData.getAction()), false, jVar2.bWT(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.ihF.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, bS(downloadData.getId(), downloadData.getName())) : jVar;
            jVar2.bWU();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, bS(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), oz(downloadData.getAction()), false, jVar2.bWT(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.ihF.get(downloadData.getUrl());
            int bS = bS(downloadData.getId(), downloadData.getName());
            if (jVar == null) {
                jVar = new j(downloadData, bS);
            }
            jVar.bWV();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            j jVar = this.ihF.get(downloadData.getUrl());
            if (jVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, bS(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), oz(downloadData.getAction()), false, jVar.bWT(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent oz(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_fail_tip), process, process + "%", string, oz(downloadData.getAction()), false);
            }
        }
    }

    public boolean oA(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.bWP().nC()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int bS(String str, String str2) {
        long bT = bT(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (bT <= j) {
            return (int) ((100 * bT) / j);
        }
        return 0;
    }

    public boolean Bv(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.bWP().nC()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void u(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.bWP().nC()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.bWP().O(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.bWP().oD(str);
            }
            if (downloadData != null) {
                int bS = bS(downloadData.getId(), downloadData.getName());
                String str3 = bS + "%";
                if (downloadData != null && bS >= 0) {
                    j jVar = this.ihF.get(downloadData.getUrl());
                    j jVar2 = jVar == null ? new j(downloadData, bS) : jVar;
                    jVar2.bWV();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), oz(downloadData.getAction()), false, jVar2.bWT(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.bWP().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean dI(String str, String str2) {
        File lQ;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (lQ = m.lQ(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && lQ.exists() && lQ.isFile();
    }

    public long bT(String str, String str2) {
        File lQ = m.lQ(str + "_" + str2 + ".tmp");
        if (lQ != null && lQ.exists() && lQ.isFile()) {
            return lQ.length();
        }
        return -1L;
    }

    public boolean oC(String str) {
        return (TextUtils.isEmpty(str) || m.lQ(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bWW().oC(downloadData.getId())) {
            return 3;
        }
        if (bWW().Bv(downloadData.getId())) {
            return 5;
        }
        if (bWW().oA(downloadData.getId())) {
            return 1;
        }
        if (!bWW().dI(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer Bw(String str) {
        if (ihE.containsKey(str)) {
            return ihE.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        ihE.put(str, valueOf);
        return valueOf;
    }
}
