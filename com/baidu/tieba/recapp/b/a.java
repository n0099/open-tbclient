package com.baidu.tieba.recapp.b;

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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final int asD = 5;
    private C0073a eXM = null;
    private HashMap<String, d> eXO = new HashMap<>();
    private static a eXL = null;
    private static DownloadData asF = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> eXN = new HashMap<>();

    private a() {
    }

    public static a aZX() {
        synchronized (a.class) {
            if (eXL == null) {
                eXL = new a();
            }
        }
        return eXL;
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
            List<DownloadData> iT = com.baidu.tieba.recapp.b.b.aZZ().iT();
            if (iT != null && iT.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(r.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), r.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Cm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cm() {
        if (asF == null && !mTaskList.isEmpty()) {
            asF = mTaskList.get(0);
            if (asF != null) {
                this.eXM = new C0073a(this, null);
                this.eXM.setPriority(3);
                this.eXM.execute(asF);
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

    public void v(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void p(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        try {
            new b(this, null).execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.c>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.c> asH;

        private b() {
            this.asH = null;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.c>... arrayListArr) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.asH = arrayList;
            Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.c next = it.next();
                String str = next.Oz;
                if (l.cX(a.this.getFileOfUrl(next.Oy)) != null) {
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
            for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.aZZ().iT()) {
                Iterator<com.baidu.tbadk.core.data.c> it = this.asH.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Oz, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.v(list);
            this.asH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aB(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.tZ());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0073a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private C0073a() {
        }

        /* synthetic */ C0073a(a aVar, C0073a c0073a) {
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
                if (!at.isEmpty(id) && !at.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String aB = a.this.aB(str);
                    File cX = l.cX(str);
                    if (isForceDownload || cX == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aB);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aB);
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
            a.this.eXM = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.b.b.aZZ().a(downloadData, 5);
                    if (a.this.al(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.download_will_begin);
                            d dVar = new d(downloadData, 0);
                            a.this.eXO.put(downloadData.getUrl(), dVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + string, 0, string, downloadData.getUser_name(), a.this.fe(downloadData.getAction()), false, dVar.baa(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.c(downloadData);
                    }
                }
                a.asF = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Cm();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str = String.valueOf(al) + "%";
            d dVar = this.eXO.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, al) : dVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                dVar2.bab();
            } else if (status == 4 || status == 2 || status == 7) {
                dVar2.bac();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            dVar2.qS(al);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fe(downloadData.getAction()), false, dVar2.baa(), false);
        }
    }

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.eXO.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, al(downloadData.getId(), downloadData.getName())) : dVar;
            dVar2.bab();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(al(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fe(downloadData.getAction()), false, dVar2.baa(), false);
        }
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.eXO.get(downloadData.getUrl());
            int al = al(downloadData.getId(), downloadData.getName());
            if (dVar == null) {
                dVar = new d(downloadData, al);
            }
            dVar.bac();
        }
    }

    public void n(DownloadData downloadData) {
        if (downloadData != null) {
            m(downloadData);
            d dVar = this.eXO.get(downloadData.getUrl());
            if (dVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(al(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fe(downloadData.getAction()), false, dVar.baa(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fe(String str) {
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
                    string = TbadkCoreApplication.m9getInst().getString(r.l.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(r.l.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(r.l.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.download_fail_tip), process, String.valueOf(process) + "%", string, fe(downloadData.getAction()), false);
            }
        }
    }

    public boolean ff(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.aZZ().iT()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int al(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((am * 100) / j);
        }
        return 0;
    }

    public boolean fk(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.aZZ().iT()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void i(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.b.b.aZZ().iT()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                com.baidu.tieba.recapp.b.b.aZZ().t(str, true);
            } else {
                com.baidu.tieba.recapp.b.b.aZZ().fi(str);
            }
            if (downloadData != null) {
                int al = al(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(al) + "%";
                if (downloadData != null && al >= 0) {
                    d dVar = this.eXO.get(downloadData.getUrl());
                    d dVar2 = dVar == null ? new d(downloadData, al) : dVar;
                    dVar2.bac();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fe(downloadData.getAction()), false, dVar2.baa(), false);
                }
            }
        }
    }

    public void o(DownloadData downloadData) {
        com.baidu.tieba.recapp.b.b.aZZ().q(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean an(String str, String str2) {
        File cX;
        return TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cX = l.cX(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cX.exists() && cX.isFile();
    }

    public long am(String str, String str2) {
        File cX = l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cX != null && cX.exists() && cX.isFile()) {
            return cX.length();
        }
        return -1L;
    }

    public boolean fh(String str) {
        return (TextUtils.isEmpty(str) || l.cX(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (aZX().fh(downloadData.getId())) {
            return 3;
        }
        if (aZX().fk(downloadData.getId())) {
            return 5;
        }
        if (aZX().ff(downloadData.getId())) {
            return 1;
        }
        if (!aZX().an(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer pS(String str) {
        if (eXN.containsKey(str)) {
            return eXN.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        eXN.put(str, valueOf);
        return valueOf;
    }
}
