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
    private final int ayn = 5;
    private C0077a eYi = null;
    private HashMap<String, d> eYk = new HashMap<>();
    private static a eYh = null;
    private static DownloadData ayp = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> eYj = new HashMap<>();

    private a() {
    }

    public static a aYt() {
        synchronized (a.class) {
            if (eYh == null) {
                eYh = new a();
            }
        }
        return eYh;
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
            List<DownloadData> jR = com.baidu.tieba.recapp.c.b.aYv().jR();
            if (jR != null && jR.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), w.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Ci();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        if (ayp == null && !mTaskList.isEmpty()) {
            ayp = mTaskList.get(0);
            if (ayp != null) {
                this.eYi = new C0077a(this, null);
                this.eYi.setPriority(3);
                this.eYi.execute(ayp);
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

    public void u(List<DownloadData> list) {
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
        ArrayList<AdvertAppInfo> ayr;

        private b() {
            this.ayr = null;
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
            this.ayr = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.Tq;
                if (l.cV(a.this.getFileOfUrl(next.Tp)) != null) {
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
            for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.aYv().jR()) {
                Iterator<AdvertAppInfo> it = this.ayr.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Tq, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.u(list);
            this.ayr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.ug());
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
    public class C0077a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0077a() {
        }

        /* synthetic */ C0077a(a aVar, C0077a c0077a) {
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
                    File cV = l.cV(str);
                    if (isForceDownload || cV == null) {
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
            a.this.eYi = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.c.b.aYv().a(downloadData, 5);
                    if (a.this.ak(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_will_begin);
                            d dVar = new d(downloadData, 0);
                            a.this.eYk.put(downloadData.getUrl(), dVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + string, 0, string, downloadData.getUser_name(), a.this.eW(downloadData.getAction()), false, dVar.aYw(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                a.ayp = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Ci();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            String str = String.valueOf(ak) + "%";
            d dVar = this.eYk.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, ak) : dVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                dVar2.aYx();
            } else if (status == 4 || status == 2 || status == 7) {
                dVar2.aYy();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            dVar2.qL(ak);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), eW(downloadData.getAction()), false, dVar2.aYw(), false);
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.eYk.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, ak(downloadData.getId(), downloadData.getName())) : dVar;
            dVar2.aYx();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(ak(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), eW(downloadData.getAction()), false, dVar2.aYw(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.eYk.get(downloadData.getUrl());
            int ak = ak(downloadData.getId(), downloadData.getName());
            if (dVar == null) {
                dVar = new d(downloadData, ak);
            }
            dVar.aYy();
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            m(downloadData);
            d dVar = this.eYk.get(downloadData.getUrl());
            if (dVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(ak(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), eW(downloadData.getAction()), false, dVar.aYw(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent eW(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_fail_tip), process, String.valueOf(process) + "%", string, eW(downloadData.getAction()), false);
            }
        }
    }

    public boolean eX(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.aYv().jR()) {
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

    public boolean fc(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.c.b.aYv().jR()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void i(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.c.b.aYv().jR()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                com.baidu.tieba.recapp.c.b.aYv().t(str, true);
            } else {
                com.baidu.tieba.recapp.c.b.aYv().fa(str);
            }
            if (downloadData != null) {
                int ak = ak(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(ak) + "%";
                if (downloadData != null && ak >= 0) {
                    d dVar = this.eYk.get(downloadData.getUrl());
                    d dVar2 = dVar == null ? new d(downloadData, ak) : dVar;
                    dVar2.aYy();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), eW(downloadData.getAction()), false, dVar2.aYw(), false);
                }
            }
        }
    }

    public void o(DownloadData downloadData) {
        com.baidu.tieba.recapp.c.b.aYv().q(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean am(String str, String str2) {
        File cV;
        return TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cV = l.cV(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cV.exists() && cV.isFile();
    }

    public long al(String str, String str2) {
        File cV = l.cV(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cV != null && cV.exists() && cV.isFile()) {
            return cV.length();
        }
        return -1L;
    }

    public boolean eZ(String str) {
        return (TextUtils.isEmpty(str) || l.cV(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (aYt().eZ(downloadData.getId())) {
            return 3;
        }
        if (aYt().fc(downloadData.getId())) {
            return 5;
        }
        if (aYt().eX(downloadData.getId())) {
            return 1;
        }
        if (!aYt().am(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer pj(String str) {
        if (eYj.containsKey(str)) {
            return eYj.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        eYj.put(str, valueOf);
        return valueOf;
    }
}
