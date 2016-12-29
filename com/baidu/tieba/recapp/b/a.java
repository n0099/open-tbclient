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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.m;
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
    private final int aty = 5;
    private C0071a eOj = null;
    private HashMap<String, d> eOl = new HashMap<>();
    private static a eOi = null;
    private static DownloadData atA = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> eOk = new HashMap<>();

    private a() {
    }

    public static a aYh() {
        synchronized (a.class) {
            if (eOi == null) {
                eOi = new a();
            }
        }
        return eOi;
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
        e(downloadData);
    }

    public void e(DownloadData downloadData) {
        if (downloadData != null) {
            List<DownloadData> iV = com.baidu.tieba.recapp.b.b.aYj().iV();
            if (iV != null && iV.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail_over_max));
                f(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), r.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Cr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr() {
        if (atA == null && !mTaskList.isEmpty()) {
            atA = mTaskList.get(0);
            if (atA != null) {
                this.eOj = new C0071a(this, null);
                this.eOj.setPriority(3);
                this.eOj.execute(atA);
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

    public void f(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void w(List<DownloadData> list) {
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
        ArrayList<com.baidu.tbadk.core.data.c> atC;

        private b() {
            this.atC = null;
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
            this.atC = arrayList;
            Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.c next = it.next();
                String str = next.Pp;
                if (m.cZ(a.this.getFileOfUrl(next.Pn)) != null) {
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
        /* renamed from: x */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.aYj().iV()) {
                Iterator<com.baidu.tbadk.core.data.c> it = this.atC.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Pp, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.w(list);
            this.atC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aC(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.uf());
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
                if (!av.isEmpty(id) && !av.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String aC = a.this.aC(str);
                    File cZ = m.cZ(str);
                    if (isForceDownload || cZ == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aC);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aC);
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
        /* renamed from: i */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            a.this.eOj = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.f(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.b.b.aYj().a(downloadData, 5);
                    if (a.this.al(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.download_will_begin);
                            d dVar = new d(downloadData, 0);
                            a.this.eOl.put(downloadData.getUrl(), dVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + string, 0, string, downloadData.getUser_name(), a.this.fh(downloadData.getAction()), false, dVar.aYk(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        a.this.g(downloadData);
                    }
                }
                a.atA = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Cr();
                }
            }
        }
    }

    public void g(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str = String.valueOf(al) + "%";
            d dVar = this.eOl.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, al) : dVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                dVar2.aYl();
            } else if (status == 4 || status == 2 || status == 7) {
                dVar2.aYm();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            dVar2.qi(al);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), fh(downloadData.getAction()), false, dVar2.aYk(), false);
        }
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.eOl.get(downloadData.getUrl());
            d dVar2 = dVar == null ? new d(downloadData, al(downloadData.getId(), downloadData.getName())) : dVar;
            dVar2.aYl();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(al(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fh(downloadData.getAction()), false, dVar2.aYk(), false);
        }
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            d dVar = this.eOl.get(downloadData.getUrl());
            int al = al(downloadData.getId(), downloadData.getName());
            if (dVar == null) {
                dVar = new d(downloadData, al);
            }
            dVar.aYm();
        }
    }

    public void r(DownloadData downloadData) {
        if (downloadData != null) {
            q(downloadData);
            d dVar = this.eOl.get(downloadData.getUrl());
            if (dVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, String.valueOf(al(downloadData.getId(), downloadData.getName())) + "%", downloadData.getUser_name(), fh(downloadData.getAction()), false, dVar.aYk(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public void o(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getUser_name()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.download_fail_tip), process, String.valueOf(process) + "%", string, fh(downloadData.getAction()), false);
            }
        }
    }

    public boolean fi(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.aYj().iV()) {
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

    public boolean fn(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.aYj().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void h(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.b.b.aYj().iV()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                com.baidu.tieba.recapp.b.b.aYj().t(str, true);
            } else {
                com.baidu.tieba.recapp.b.b.aYj().fl(str);
            }
            if (downloadData != null) {
                int al = al(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(al) + "%";
                if (downloadData != null && al >= 0) {
                    d dVar = this.eOl.get(downloadData.getUrl());
                    d dVar2 = dVar == null ? new d(downloadData, al) : dVar;
                    dVar2.aYm();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), fh(downloadData.getAction()), false, dVar2.aYk(), false);
                }
            }
        }
    }

    public void s(DownloadData downloadData) {
        com.baidu.tieba.recapp.b.b.aYj().u(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
        f(downloadData);
    }

    public boolean an(String str, String str2) {
        File cZ;
        return TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cZ = m.cZ(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cZ.exists() && cZ.isFile();
    }

    public long am(String str, String str2) {
        File cZ = m.cZ(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cZ != null && cZ.exists() && cZ.isFile()) {
            return cZ.length();
        }
        return -1L;
    }

    public boolean fk(String str) {
        return (TextUtils.isEmpty(str) || m.cZ(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        if (aYh().fk(downloadData.getId())) {
            return 3;
        }
        if (aYh().fn(downloadData.getId())) {
            return 5;
        }
        if (aYh().fi(downloadData.getId())) {
            return 1;
        }
        if (!aYh().an(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    public static Integer py(String str) {
        if (eOk.containsKey(str)) {
            return eOk.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        eOk.put(str, valueOf);
        return valueOf;
    }
}
