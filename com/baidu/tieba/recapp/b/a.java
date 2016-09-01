package com.baidu.tieba.recapp.b;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final int atu = 5;
    private C0073a faN = null;
    private static a faM = null;
    private static DownloadData atw = null;
    private static List<DownloadData> atx = new LinkedList();

    private a() {
    }

    public static a bbr() {
        synchronized (a.class) {
            if (faM == null) {
                faM = new a();
            }
        }
        return faM;
    }

    public void a(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, null, true, false, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3) {
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
        e(downloadData);
    }

    public void e(DownloadData downloadData) {
        if (downloadData != null) {
            List<DownloadData> iV = com.baidu.tieba.recapp.b.b.bbs().iV();
            if (iV != null && iV.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail_over_max));
                f(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), t.j.download_fail_over_max);
                return;
            }
            atx.add(downloadData);
            Cw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw() {
        if (atw == null && !atx.isEmpty()) {
            atw = atx.get(0);
            if (atw != null) {
                this.faN = new C0073a(this, null);
                this.faN.setPriority(3);
                this.faN.execute(atw);
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

    public void o(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        try {
            new b(this, null).execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.b>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.b> atz;

        private b() {
            this.atz = null;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.b>... arrayListArr) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.atz = arrayList;
            Iterator<com.baidu.tbadk.core.data.b> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.b next = it.next();
                String str = next.Pe;
                if (m.cU(a.this.getFileOfUrl(next.Pc)) != null) {
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
            for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.bbs().iV()) {
                Iterator<com.baidu.tbadk.core.data.b> it = this.atz.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Pe, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            a.this.w(list);
            this.atz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aC(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.getCacheDir());
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
                if (!ba.isEmpty(id) && !ba.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String aC = a.this.aC(str);
                    File cU = m.cU(str);
                    if (isForceDownload || cU == null) {
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
        /* renamed from: j */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            a.this.faN = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    a.this.f(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    com.baidu.tieba.recapp.b.b.bbs().a(downloadData, 5);
                    int ak = a.this.ak(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && ak <= 0) {
                        String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + string, 0, string, downloadData.getName(), a.this.fg(downloadData.getAction()), false);
                    } else {
                        a.this.g(downloadData);
                    }
                }
                a.atw = null;
                if (!a.atx.isEmpty()) {
                    a.atx.remove(0);
                    a.this.Cw();
                }
            }
        }
    }

    public void g(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, ak, String.valueOf(ak) + "%", downloadData.getName(), fg(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public boolean fh(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.bbs().iV()) {
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

    public boolean fm(String str) {
        for (DownloadData downloadData : com.baidu.tieba.recapp.b.b.bbs().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void h(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : com.baidu.tieba.recapp.b.b.bbs().iV()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                com.baidu.tieba.recapp.b.b.bbs().s(str, true);
            } else {
                com.baidu.tieba.recapp.b.b.bbs().fk(str);
            }
            if (downloadData != null) {
                int ak = ak(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(ak) + "%";
                if (downloadData != null && ak >= 0) {
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.download_cancel), ak, str3, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.download_cancel), fg(downloadData.getAction()), false);
                }
            }
        }
    }

    public boolean am(String str, String str2) {
        File cU;
        return TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cU = m.cU(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cU.exists() && cU.isFile();
    }

    public long al(String str, String str2) {
        File cU = m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cU != null && cU.exists() && cU.isFile()) {
            return cU.length();
        }
        return -1L;
    }

    public boolean fj(String str) {
        return (TextUtils.isEmpty(str) || m.cU(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
