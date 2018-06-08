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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
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
    private static h gkd = null;
    private static DownloadData aKE = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> gjV = new HashMap<>();
    private final int aKC = 5;
    private a gke = null;
    private HashMap<String, j> gjW = new HashMap<>();

    private h() {
    }

    public static h bov() {
        synchronized (h.class) {
            if (gkd == null) {
                gkd = new h();
            }
        }
        return gkd;
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
            List<DownloadData> me = com.baidu.tieba.recapp.download.a.boo().me();
            if (me != null && me.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.k.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            GX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GX() {
        if (aKE == null && !mTaskList.isEmpty()) {
            aKE = mTaskList.get(0);
            if (aKE != null) {
                this.gke = new a();
                this.gke.setPriority(3);
                this.gke.execute(aKE);
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQ(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.ye());
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
                    String str = id.replace(".", "_") + ".apk";
                    String aQ = h.this.aQ(str);
                    File dU = l.dU(str);
                    if (isForceDownload || dU == null) {
                        downloadData.setCallback(new i());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aQ);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aQ);
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
            h.this.gke = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    h.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.download.a.boo().a(downloadData, 5);
                    if (h.this.aq(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_will_begin);
                            j jVar = new j(downloadData, 0);
                            h.this.gjW.put(downloadData.getUrl(), jVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), h.this.gq(downloadData.getAction()), false, jVar.bos(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        h.this.c(downloadData);
                    }
                }
                DownloadData unused = h.aKE = null;
                if (!h.mTaskList.isEmpty()) {
                    h.mTaskList.remove(0);
                    h.this.GX();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aq = aq(downloadData.getId(), downloadData.getName());
            String str = aq + "%";
            j jVar = this.gjW.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, aq) : jVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                jVar2.bot();
            } else if (status == 4 || status == 2 || status == 7) {
                jVar2.bou();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            jVar2.rX(aq);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), gq(downloadData.getAction()), false, jVar2.bos(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gjW.get(downloadData.getUrl());
            j jVar2 = jVar == null ? new j(downloadData, aq(downloadData.getId(), downloadData.getName())) : jVar;
            jVar2.bot();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aq(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gq(downloadData.getAction()), false, jVar2.bos(), false);
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            j jVar = this.gjW.get(downloadData.getUrl());
            int aq = aq(downloadData.getId(), downloadData.getName());
            if (jVar == null) {
                jVar = new j(downloadData, aq);
            }
            jVar.bou();
        }
    }

    public void o(DownloadData downloadData) {
        if (downloadData != null) {
            n(downloadData);
            j jVar = this.gjW.get(downloadData.getUrl());
            if (jVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aq(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gq(downloadData.getAction()), false, jVar.bos(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent gq(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(d.k.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.k.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.k.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_fail_tip), process, process + "%", string, gq(downloadData.getAction()), false);
            }
        }
    }

    public boolean gr(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.boo().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int aq(String str, String str2) {
        long ar = ar(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ar <= j) {
            return (int) ((100 * ar) / j);
        }
        return 0;
    }

    public boolean gx(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.download.a.boo().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.download.a.boo().me()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.download.a.boo().l(str, true);
            } else {
                com.baidu.tieba.recapp.download.a.boo().gv(str);
            }
            if (downloadData != null) {
                int aq = aq(downloadData.getId(), downloadData.getName());
                String str3 = aq + "%";
                if (downloadData != null && aq >= 0) {
                    j jVar = this.gjW.get(downloadData.getUrl());
                    j jVar2 = jVar == null ? new j(downloadData, aq) : jVar;
                    jVar2.bou();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), gq(downloadData.getAction()), false, jVar2.bos(), false);
                }
            }
        }
    }

    public void p(DownloadData downloadData) {
        com.baidu.tieba.recapp.download.a.boo().l(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean as(String str, String str2) {
        File dU;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dU = l.dU(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && dU.exists() && dU.isFile();
    }

    public long ar(String str, String str2) {
        File dU = l.dU(str + "_" + str2 + ".tmp");
        if (dU != null && dU.exists() && dU.isFile()) {
            return dU.length();
        }
        return -1L;
    }

    public boolean gu(String str) {
        return (TextUtils.isEmpty(str) || l.dU(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bov().gu(downloadData.getId())) {
            return 3;
        }
        if (bov().gx(downloadData.getId())) {
            return 5;
        }
        if (bov().gr(downloadData.getId())) {
            return 1;
        }
        if (!bov().as(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer sM(String str) {
        if (gjV.containsKey(str)) {
            return gjV.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        gjV.put(str, valueOf);
        return valueOf;
    }
}
