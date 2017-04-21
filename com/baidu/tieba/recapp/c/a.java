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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.l;
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
    private final int ayq = 5;
    private C0071a fcq = null;
    private HashMap<String, d> fcs = new HashMap<>();
    private static a fcp = null;
    private static DownloadData ays = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> fcr = new HashMap<>();

    private a() {
    }

    public static a baU() {
        synchronized (a.class) {
            if (fcp == null) {
                fcp = new a();
            }
        }
        return fcp;
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
            List<DownloadData> jS = com.baidu.tieba.recapp.c.b.baW().jS();
            if (jS != null && jS.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), w.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Dd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dd() {
        if (ays == null && !mTaskList.isEmpty()) {
            ays = mTaskList.get(0);
            if (ays != null) {
                this.fcq = new C0071a(this, null);
                this.fcq.setPriority(3);
                this.fcq.execute(ays);
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

    public void t(List<DownloadData> list) {
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
        ArrayList<AdvertAppInfo> ayu;

        private b() {
            this.ayu = null;
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
            this.ayu = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.TY;
                if (l.cX(a.this.getFileOfUrl(next.TX)) != null) {
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
            for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.baW().jS()) {
                Iterator<AdvertAppInfo> it = this.ayu.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().TY, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.t(list);
            this.ayu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.uU());
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
    public class C0071a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0071a() {
        }

        /* synthetic */ C0071a(a aVar, C0071a c0071a) {
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
                if (!au.isEmpty(id) && !au.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String filePath = a.this.getFilePath(str);
                    File cX = l.cX(str);
                    if (isForceDownload || cX == null) {
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
            a.this.fcq = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.c.b.baW().a(downloadData, 5);
                    if (a.this.ak(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_will_begin);
                            d dVar = new d(downloadData, 0);
                            a.this.fcs.put(downloadData.getUrl(), dVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + string, 0, string, downloadData.getUser_name(), a.this.eZ(downloadData.getAction()), false, dVar.baX(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                a.ays = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Dd();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            String str = String.valueOf(ak) + "%";
            d dVar = this.fcs.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, ak) : dVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                dVar2.baY();
            } else if (status == 4 || status == 2 || status == 7) {
                dVar2.baZ();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            dVar2.qT(ak);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), eZ(downloadData.getAction()), false, dVar2.baX(), false);
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.fcs.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, ak(downloadData.getId(), downloadData.getName())) : dVar;
            dVar2.baY();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(ak(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), eZ(downloadData.getAction()), false, dVar2.baX(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.fcs.get(downloadData.getUrl());
            int ak = ak(downloadData.getId(), downloadData.getName());
            if (dVar == null) {
                dVar = new d(downloadData, ak);
            }
            dVar.baZ();
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            m(downloadData);
            d dVar = this.fcs.get(downloadData.getUrl());
            if (dVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(ak(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), eZ(downloadData.getAction()), false, dVar.baX(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent eZ(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_fail_tip), process, String.valueOf(process) + "%", string, eZ(downloadData.getAction()), false);
            }
        }
    }

    public boolean fa(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.baW().jS()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ak(String str, String str2) {
        long al = al(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (al <= j) {
            return (int) ((al * 100) / j);
        }
        return 0;
    }

    public boolean ff(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.baW().jS()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void j(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.c.b.baW().jS()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                com.baidu.tieba.recapp.c.b.baW().t(str, true);
            } else {
                com.baidu.tieba.recapp.c.b.baW().fd(str);
            }
            if (downloadData != null) {
                int ak = ak(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(ak) + "%";
                if (downloadData != null && ak >= 0) {
                    d dVar = this.fcs.get(downloadData.getUrl());
                    d dVar2 = dVar == null ? new d(downloadData, ak) : dVar;
                    dVar2.baZ();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), eZ(downloadData.getAction()), false, dVar2.baX(), false);
                }
            }
        }
    }

    public void o(DownloadData downloadData) {
        com.baidu.tieba.recapp.c.b.baW().q(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean am(String str, String str2) {
        File cX;
        return TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cX = l.cX(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cX.exists() && cX.isFile();
    }

    public long al(String str, String str2) {
        File cX = l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cX != null && cX.exists() && cX.isFile()) {
            return cX.length();
        }
        return -1L;
    }

    public boolean fc(String str) {
        return (TextUtils.isEmpty(str) || l.cX(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (baU().fc(downloadData.getId())) {
            return 3;
        }
        if (baU().ff(downloadData.getId())) {
            return 5;
        }
        if (baU().fa(downloadData.getId())) {
            return 1;
        }
        if (!baU().am(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer pl(String str) {
        if (fcr.containsKey(str)) {
            return fcr.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        fcr.put(str, valueOf);
        return valueOf;
    }
}
