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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final int brO = 5;
    private a gCL = null;
    private HashMap<String, f> gCN = new HashMap<>();
    private static d gCK = null;
    private static DownloadData brQ = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> gCM = new HashMap<>();

    private d() {
    }

    public static d bol() {
        synchronized (d.class) {
            if (gCK == null) {
                gCK = new d();
            }
        }
        return gCK;
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
            List<DownloadData> rl = e.bon().rl();
            if (rl != null && rl.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            KS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KS() {
        if (brQ == null && !mTaskList.isEmpty()) {
            brQ = mTaskList.get(0);
            if (brQ != null) {
                this.gCL = new a();
                this.gCL.setPriority(3);
                this.gCL.execute(brQ);
            }
        }
    }

    public String getFileOfUrl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void J(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void p(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> brS;

        private b() {
            this.brS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<AdvertAppInfo>... arrayListArr) {
            ArrayList<AdvertAppInfo> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.brS = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.aKK;
                if (k.dC(d.this.getFileOfUrl(next.aKJ)) != null) {
                    DownloadData downloadData = new DownloadData(str);
                    downloadData.setStatus(3);
                    linkedList.add(downloadData);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.bon().rl()) {
                Iterator<AdvertAppInfo> it = this.brS.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().aKK, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            d.this.J(list);
            this.brS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aH(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.BV());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
                    String aH = d.this.aH(str);
                    File dC = k.dC(str);
                    if (isForceDownload || dC == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
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
            d.this.gCL = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    d.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(Constants.DOT, "_") + ".apk");
                    }
                } else {
                    e.bon().a(downloadData, 5);
                    if (d.this.al(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_will_begin);
                            f fVar = new f(downloadData, 0);
                            d.this.gCN.put(downloadData.getUrl(), fVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), d.this.gb(downloadData.getAction()), false, fVar.boo(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        d.this.c(downloadData);
                    }
                }
                DownloadData unused = d.brQ = null;
                if (!d.mTaskList.isEmpty()) {
                    d.mTaskList.remove(0);
                    d.this.KS();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str = al + "%";
            f fVar = this.gCN.get(downloadData.getUrl());
            f fVar2 = fVar == null ? new f(downloadData, al) : fVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                fVar2.bop();
            } else if (status == 4 || status == 2 || status == 7) {
                fVar2.boq();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            fVar2.uo(al);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), gb(downloadData.getAction()), false, fVar2.boo(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            f fVar = this.gCN.get(downloadData.getUrl());
            f fVar2 = fVar == null ? new f(downloadData, al(downloadData.getId(), downloadData.getName())) : fVar;
            fVar2.bop();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, al(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gb(downloadData.getAction()), false, fVar2.boo(), false);
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            f fVar = this.gCN.get(downloadData.getUrl());
            int al = al(downloadData.getId(), downloadData.getName());
            if (fVar == null) {
                fVar = new f(downloadData, al);
            }
            fVar.boq();
        }
    }

    public void o(DownloadData downloadData) {
        if (downloadData != null) {
            n(downloadData);
            f fVar = this.gCN.get(downloadData.getUrl());
            if (fVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, al(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gb(downloadData.getAction()), false, fVar.boo(), false);
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
        for (DownloadData downloadData : e.bon().rl()) {
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
        for (DownloadData downloadData : e.bon().rl()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void i(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : e.bon().rl()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                e.bon().o(str, true);
            } else {
                e.bon().gf(str);
            }
            if (downloadData != null) {
                int al = al(downloadData.getId(), downloadData.getName());
                String str3 = al + "%";
                if (downloadData != null && al >= 0) {
                    f fVar = this.gCN.get(downloadData.getUrl());
                    f fVar2 = fVar == null ? new f(downloadData, al) : fVar;
                    fVar2.boq();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), gb(downloadData.getAction()), false, fVar2.boo(), false);
                }
            }
        }
    }

    public void p(DownloadData downloadData) {
        e.bon().l(downloadData);
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
        if (bol().ge(downloadData.getId())) {
            return 3;
        }
        if (bol().gh(downloadData.getId())) {
            return 5;
        }
        if (bol().gc(downloadData.getId())) {
            return 1;
        }
        if (!bol().an(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer rL(String str) {
        if (gCM.containsKey(str)) {
            return gCM.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        gCM.put(str, valueOf);
        return valueOf;
    }
}
