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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final int azb = 5;
    private C0082a frb = null;
    private HashMap<String, d> frd = new HashMap<>();
    private static a fra = null;
    private static DownloadData azd = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> frc = new HashMap<>();

    private a() {
    }

    public static a bdX() {
        synchronized (a.class) {
            if (fra == null) {
                fra = new a();
            }
        }
        return fra;
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
            List<DownloadData> jP = com.baidu.tieba.recapp.c.b.bdZ().jP();
            if (jP != null && jP.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), w.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Cw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw() {
        if (azd == null && !mTaskList.isEmpty()) {
            azd = mTaskList.get(0);
            if (azd != null) {
                this.frb = new C0082a(this, null);
                this.frb.setPriority(3);
                this.frb.execute(azd);
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

    public void w(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new b(this, null).execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> azf;

        private b() {
            this.azf = null;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
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
            this.azf = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.SY;
                if (n.dm(a.this.getFileOfUrl(next.SX)) != null) {
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
            for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bdZ().jP()) {
                Iterator<AdvertAppInfo> it = this.azf.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().SY, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.w(list);
            this.azf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(n.uu());
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
    public class C0082a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0082a() {
        }

        /* synthetic */ C0082a(a aVar, C0082a c0082a) {
            this();
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
                if (!aw.isEmpty(id) && !aw.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String filePath = a.this.getFilePath(str);
                    File dm = n.dm(str);
                    if (isForceDownload || dm == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(filePath);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(filePath);
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
            a.this.frb = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.c.b.bdZ().a(downloadData, 5);
                    if (a.this.aj(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_will_begin);
                            d dVar = new d(downloadData, 0);
                            a.this.frd.put(downloadData.getUrl(), dVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + string, 0, string, downloadData.getUser_name(), a.this.fo(downloadData.getAction()), false, dVar.bea(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                a.azd = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Cw();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aj = aj(downloadData.getId(), downloadData.getName());
            String str = String.valueOf(aj) + "%";
            d dVar = this.frd.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, aj) : dVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                dVar2.beb();
            } else if (status == 4 || status == 2 || status == 7) {
                dVar2.bec();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            dVar2.rB(aj);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fo(downloadData.getAction()), false, dVar2.bea(), false);
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.frd.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, aj(downloadData.getId(), downloadData.getName())) : dVar;
            dVar2.beb();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(aj(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fo(downloadData.getAction()), false, dVar2.bea(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.frd.get(downloadData.getUrl());
            int aj = aj(downloadData.getId(), downloadData.getName());
            if (dVar == null) {
                dVar = new d(downloadData, aj);
            }
            dVar.bec();
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            m(downloadData);
            d dVar = this.frd.get(downloadData.getUrl());
            if (dVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(aj(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fo(downloadData.getAction()), false, dVar.bea(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public void k(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m9getInst().getString(w.l.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(w.l.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(w.l.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_fail_tip), process, String.valueOf(process) + "%", string, fo(downloadData.getAction()), false);
            }
        }
    }

    public boolean fp(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bdZ().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int aj(String str, String str2) {
        long ak = ak(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ak <= j) {
            return (int) ((ak * 100) / j);
        }
        return 0;
    }

    public boolean fu(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.bdZ().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.c.b.bdZ().jP()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                com.baidu.tieba.recapp.c.b.bdZ().r(str, true);
            } else {
                com.baidu.tieba.recapp.c.b.bdZ().fs(str);
            }
            if (downloadData != null) {
                int aj = aj(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(aj) + "%";
                if (downloadData != null && aj >= 0) {
                    d dVar = this.frd.get(downloadData.getUrl());
                    d dVar2 = dVar == null ? new d(downloadData, aj) : dVar;
                    dVar2.bec();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fo(downloadData.getAction()), false, dVar2.bea(), false);
                }
            }
        }
    }

    public void o(DownloadData downloadData) {
        com.baidu.tieba.recapp.c.b.bdZ().q(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean al(String str, String str2) {
        File dm;
        return TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (dm = n.dm(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && dm.exists() && dm.isFile();
    }

    public long ak(String str, String str2) {
        File dm = n.dm(String.valueOf(str) + "_" + str2 + ".tmp");
        if (dm != null && dm.exists() && dm.isFile()) {
            return dm.length();
        }
        return -1L;
    }

    public boolean fr(String str) {
        return (TextUtils.isEmpty(str) || n.dm(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (bdX().fr(downloadData.getId())) {
            return 3;
        }
        if (bdX().fu(downloadData.getId())) {
            return 5;
        }
        if (bdX().fp(downloadData.getId())) {
            return 1;
        }
        if (!bdX().al(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer qu(String str) {
        if (frc.containsKey(str)) {
            return frc.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        frc.put(str, valueOf);
        return valueOf;
    }
}
