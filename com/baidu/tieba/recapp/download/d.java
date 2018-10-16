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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final int aTv = 5;
    private a gDQ = null;
    private HashMap<String, f> gDS = new HashMap<>();
    private static d gDP = null;
    private static DownloadData aTx = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> gDR = new HashMap<>();

    private d() {
    }

    public static d btr() {
        synchronized (d.class) {
            if (gDP == null) {
                gDP = new d();
            }
        }
        return gDP;
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
            List<DownloadData> nw = e.btt().nw();
            if (nw != null && nw.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(e.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), e.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            KA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KA() {
        if (aTx == null && !mTaskList.isEmpty()) {
            aTx = mTaskList.get(0);
            if (aTx != null) {
                this.gDQ = new a();
                this.gDQ.setPriority(3);
                this.gDQ.execute(aTx);
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

    public void P(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void s(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> aTz;

        private b() {
            this.aTz = null;
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
            this.aTz = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.alg;
                if (l.eC(d.this.getFileOfUrl(next.alf)) != null) {
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
        /* renamed from: z */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.btt().nw()) {
                Iterator<AdvertAppInfo> it = this.aTz.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().alg, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            d.this.P(list);
            this.aTz = null;
        }
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
                if (!ao.isEmpty(id) && !ao.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", BaseRequestAction.SPLITE) + ".apk";
                    String bj = d.this.bj(str);
                    File eC = l.eC(str);
                    if (isForceDownload || eC == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
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
            d.this.gDQ = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    d.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", BaseRequestAction.SPLITE) + ".apk");
                    }
                } else {
                    e.btt().a(downloadData, 5);
                    if (d.this.aG(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.download_will_begin);
                            f fVar = new f(downloadData, 0);
                            d.this.gDS.put(downloadData.getUrl(), fVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), d.this.hd(downloadData.getAction()), false, fVar.btu(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        d.this.c(downloadData);
                    }
                }
                DownloadData unused = d.aTx = null;
                if (!d.mTaskList.isEmpty()) {
                    d.mTaskList.remove(0);
                    d.this.KA();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aG = aG(downloadData.getId(), downloadData.getName());
            String str = aG + "%";
            f fVar = this.gDS.get(downloadData.getUrl());
            f fVar2 = fVar == null ? new f(downloadData, aG) : fVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                fVar2.btv();
            } else if (status == 4 || status == 2 || status == 7) {
                fVar2.btw();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            fVar2.sZ(aG);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), hd(downloadData.getAction()), false, fVar2.btu(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            f fVar = this.gDS.get(downloadData.getUrl());
            f fVar2 = fVar == null ? new f(downloadData, aG(downloadData.getId(), downloadData.getName())) : fVar;
            fVar2.btv();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aG(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), hd(downloadData.getAction()), false, fVar2.btu(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            f fVar = this.gDS.get(downloadData.getUrl());
            int aG = aG(downloadData.getId(), downloadData.getName());
            if (fVar == null) {
                fVar = new f(downloadData, aG);
            }
            fVar.btw();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            f fVar = this.gDS.get(downloadData.getUrl());
            if (fVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aG(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), hd(downloadData.getAction()), false, fVar.btu(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent hd(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.download_fail_tip), process, process + "%", string, hd(downloadData.getAction()), false);
            }
        }
    }

    public boolean he(String str) {
        for (DownloadData downloadData : e.btt().nw()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int aG(String str, String str2) {
        long aH = aH(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (aH <= j) {
            return (int) ((100 * aH) / j);
        }
        return 0;
    }

    public boolean tT(String str) {
        for (DownloadData downloadData : e.btt().nw()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : e.btt().nw()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                e.btt().t(str, true);
            } else {
                e.btt().hh(str);
            }
            if (downloadData != null) {
                int aG = aG(downloadData.getId(), downloadData.getName());
                String str3 = aG + "%";
                if (downloadData != null && aG >= 0) {
                    f fVar = this.gDS.get(downloadData.getUrl());
                    f fVar2 = fVar == null ? new f(downloadData, aG) : fVar;
                    fVar2.btw();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), hd(downloadData.getAction()), false, fVar2.btu(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        e.btt().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean ct(String str, String str2) {
        File eC;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (eC = l.eC(new StringBuilder().append(str).append(BaseRequestAction.SPLITE).append(str2).append(".tmp").toString())) != null && eC.exists() && eC.isFile();
    }

    public long aH(String str, String str2) {
        File eC = l.eC(str + BaseRequestAction.SPLITE + str2 + ".tmp");
        if (eC != null && eC.exists() && eC.isFile()) {
            return eC.length();
        }
        return -1L;
    }

    public boolean hg(String str) {
        return (TextUtils.isEmpty(str) || l.eC(new StringBuilder().append(str.replace(".", BaseRequestAction.SPLITE)).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (btr().hg(downloadData.getId())) {
            return 3;
        }
        if (btr().tT(downloadData.getId())) {
            return 5;
        }
        if (btr().he(downloadData.getId())) {
            return 1;
        }
        if (!btr().ct(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer tU(String str) {
        if (gDR.containsKey(str)) {
            return gDR.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        gDR.put(str, valueOf);
        return valueOf;
    }
}
