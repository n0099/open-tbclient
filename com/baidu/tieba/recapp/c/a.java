package com.baidu.tieba.recapp.c;

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
public class a {
    private final int azL = 5;
    private C0123a fBX = null;
    private HashMap<String, c> fBZ = new HashMap<>();
    private static a fBW = null;
    private static DownloadData azN = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> fBY = new HashMap<>();

    private a() {
    }

    public static a bfT() {
        synchronized (a.class) {
            if (fBW == null) {
                fBW = new a();
            }
        }
        return fBW;
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
            List<DownloadData> jO = com.baidu.tieba.recapp.c.b.bfV().jO();
            if (jO != null && jO.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Cj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        if (azN == null && !mTaskList.isEmpty()) {
            azN = mTaskList.get(0);
            if (azN != null) {
                this.fBX = new C0123a();
                this.fBX.setPriority(3);
                this.fBX.execute(azN);
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

    public void y(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void n(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> azP;

        private b() {
            this.azP = null;
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
            this.azP = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.TT;
                if (k.dd(a.this.getFileOfUrl(next.TS)) != null) {
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
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute((b) list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bfV().jO()) {
                Iterator<AdvertAppInfo> it = this.azP.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().TT, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.y(list);
            this.azP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String az(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.uc());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0123a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0123a() {
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
                    String str = id.replace(".", "_") + ".apk";
                    String az = a.this.az(str);
                    File dd = k.dd(str);
                    if (isForceDownload || dd == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(az);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(az);
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
            a.this.fBX = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.c.b.bfV().a(downloadData, 5);
                    if (a.this.am(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_will_begin);
                            c cVar = new c(downloadData, 0);
                            a.this.fBZ.put(downloadData.getUrl(), cVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), a.this.fp(downloadData.getAction()), false, cVar.bfW(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                DownloadData unused = a.azN = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Cj();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int am = am(downloadData.getId(), downloadData.getName());
            String str = am + "%";
            c cVar = this.fBZ.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, am) : cVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                cVar2.bfX();
            } else if (status == 4 || status == 2 || status == 7) {
                cVar2.bfY();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            cVar2.sb(am);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fp(downloadData.getAction()), false, cVar2.bfW(), false);
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fBZ.get(downloadData.getUrl());
            c cVar2 = cVar == null ? new c(downloadData, am(downloadData.getId(), downloadData.getName())) : cVar;
            cVar2.bfX();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, am(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fp(downloadData.getAction()), false, cVar2.bfW(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            c cVar = this.fBZ.get(downloadData.getUrl());
            int am = am(downloadData.getId(), downloadData.getName());
            if (cVar == null) {
                cVar = new c(downloadData, am);
            }
            cVar.bfY();
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            m(downloadData);
            c cVar = this.fBZ.get(downloadData.getUrl());
            if (cVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, am(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), fp(downloadData.getAction()), false, cVar.bfW(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fp(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_fail_tip), process, process + "%", string, fp(downloadData.getAction()), false);
            }
        }
    }

    public boolean fq(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bfV().jO()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int am(String str, String str2) {
        long an = an(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (an <= j) {
            return (int) ((100 * an) / j);
        }
        return 0;
    }

    public boolean fv(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bfV().jO()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.c.b.bfV().jO()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                com.baidu.tieba.recapp.c.b.bfV().q(str, true);
            } else {
                com.baidu.tieba.recapp.c.b.bfV().ft(str);
            }
            if (downloadData != null) {
                int am = am(downloadData.getId(), downloadData.getName());
                String str3 = am + "%";
                if (downloadData != null && am >= 0) {
                    c cVar = this.fBZ.get(downloadData.getUrl());
                    c cVar2 = cVar == null ? new c(downloadData, am) : cVar;
                    cVar2.bfY();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fp(downloadData.getAction()), false, cVar2.bfW(), false);
                }
            }
        }
    }

    public void o(DownloadData downloadData) {
        com.baidu.tieba.recapp.c.b.bfV().q(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean ao(String str, String str2) {
        File dd;
        return TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dd = k.dd(new StringBuilder().append(str).append("_").append(str2).append(".tmp").toString())) != null && dd.exists() && dd.isFile();
    }

    public long an(String str, String str2) {
        File dd = k.dd(str + "_" + str2 + ".tmp");
        if (dd != null && dd.exists() && dd.isFile()) {
            return dd.length();
        }
        return -1L;
    }

    public boolean fs(String str) {
        return (TextUtils.isEmpty(str) || k.dd(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bfT().fs(downloadData.getId())) {
            return 3;
        }
        if (bfT().fv(downloadData.getId())) {
            return 5;
        }
        if (bfT().fq(downloadData.getId())) {
            return 1;
        }
        if (!bfT().ao(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer qE(String str) {
        if (fBY.containsKey(str)) {
            return fBY.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        fBY.put(str, valueOf);
        return valueOf;
    }
}
