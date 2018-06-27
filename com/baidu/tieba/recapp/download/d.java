package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
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
    private final int aLy = 5;
    private a gnL = null;
    private HashMap<String, f> gnN = new HashMap<>();
    private static d gnK = null;
    private static DownloadData aLA = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> gnM = new HashMap<>();

    private d() {
    }

    public static d boQ() {
        synchronized (d.class) {
            if (gnK == null) {
                gnK = new d();
            }
        }
        return gnK;
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
            List<DownloadData> me = e.boS().me();
            if (me != null && me.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.k.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Hp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp() {
        if (aLA == null && !mTaskList.isEmpty()) {
            aLA = mTaskList.get(0);
            if (aLA != null) {
                this.gnL = new a();
                this.gnL.setPriority(3);
                this.gnL.execute(aLA);
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

    public void F(List<DownloadData> list) {
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
        ArrayList<AdvertAppInfo> aLC;

        private b() {
            this.aLC = null;
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
            this.aLC = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.aef;
                if (l.dX(d.this.getFileOfUrl(next.aee)) != null) {
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
        /* renamed from: q */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.boS().me()) {
                Iterator<AdvertAppInfo> it = this.aLC.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().aef, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            d.this.F(list);
            this.aLC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aS(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.ys());
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
                if (!ap.isEmpty(id) && !ap.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + ".apk";
                    String aS = d.this.aS(str);
                    File dX = l.dX(str);
                    if (isForceDownload || dX == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aS);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aS);
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
            d.this.gnL = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    d.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    e.boS().a(downloadData, 5);
                    if (d.this.aq(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_will_begin);
                            f fVar = new f(downloadData, 0);
                            d.this.gnN.put(downloadData.getUrl(), fVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), d.this.gv(downloadData.getAction()), false, fVar.boT(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        d.this.c(downloadData);
                    }
                }
                DownloadData unused = d.aLA = null;
                if (!d.mTaskList.isEmpty()) {
                    d.mTaskList.remove(0);
                    d.this.Hp();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aq = aq(downloadData.getId(), downloadData.getName());
            String str = aq + "%";
            f fVar = this.gnN.get(downloadData.getUrl());
            f fVar2 = fVar == null ? new f(downloadData, aq) : fVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                fVar2.boU();
            } else if (status == 4 || status == 2 || status == 7) {
                fVar2.boV();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            fVar2.sh(aq);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), gv(downloadData.getAction()), false, fVar2.boT(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            f fVar = this.gnN.get(downloadData.getUrl());
            f fVar2 = fVar == null ? new f(downloadData, aq(downloadData.getId(), downloadData.getName())) : fVar;
            fVar2.boU();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aq(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gv(downloadData.getAction()), false, fVar2.boT(), false);
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            f fVar = this.gnN.get(downloadData.getUrl());
            int aq = aq(downloadData.getId(), downloadData.getName());
            if (fVar == null) {
                fVar = new f(downloadData, aq);
            }
            fVar.boV();
        }
    }

    public void o(DownloadData downloadData) {
        if (downloadData != null) {
            n(downloadData);
            f fVar = this.gnN.get(downloadData.getUrl());
            if (fVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, aq(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), gv(downloadData.getAction()), false, fVar.boT(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent gv(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_fail_tip), process, process + "%", string, gv(downloadData.getAction()), false);
            }
        }
    }

    public boolean gw(String str) {
        for (DownloadData downloadData : e.boS().me()) {
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

    public boolean gB(String str) {
        for (DownloadData downloadData : e.boS().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : e.boS().me()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                e.boS().l(str, true);
            } else {
                e.boS().gz(str);
            }
            if (downloadData != null) {
                int aq = aq(downloadData.getId(), downloadData.getName());
                String str3 = aq + "%";
                if (downloadData != null && aq >= 0) {
                    f fVar = this.gnN.get(downloadData.getUrl());
                    f fVar2 = fVar == null ? new f(downloadData, aq) : fVar;
                    fVar2.boV();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), gv(downloadData.getAction()), false, fVar2.boT(), false);
                }
            }
        }
    }

    public void p(DownloadData downloadData) {
        e.boS().l(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean as(String str, String str2) {
        File dX;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dX = l.dX(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && dX.exists() && dX.isFile();
    }

    public long ar(String str, String str2) {
        File dX = l.dX(str + "_" + str2 + ".tmp");
        if (dX != null && dX.exists() && dX.isFile()) {
            return dX.length();
        }
        return -1L;
    }

    public boolean gy(String str) {
        return (TextUtils.isEmpty(str) || l.dX(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (boQ().gy(downloadData.getId())) {
            return 3;
        }
        if (boQ().gB(downloadData.getId())) {
            return 5;
        }
        if (boQ().gw(downloadData.getId())) {
            return 1;
        }
        if (!boQ().as(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer sL(String str) {
        if (gnM.containsKey(str)) {
            return gnM.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        gnM.put(str, valueOf);
        return valueOf;
    }
}
