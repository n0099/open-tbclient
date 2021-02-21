package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private final int fAP = 5;
    private a mSD = null;
    private HashMap<String, g> mSF = new HashMap<>();
    private static e mSC = null;
    private static DownloadData fAR = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private static HashMap<String, Integer> mSE = new HashMap<>();

    private e() {
    }

    public static e dDA() {
        synchronized (e.class) {
            if (mSC == null) {
                mSC = new e();
            }
        }
        return mSC;
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
            List<DownloadData> downloadList = f.dDB().getDownloadList();
            if (downloadList != null && downloadList.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            bBb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBb() {
        if (fAR == null && !mTaskList.isEmpty()) {
            fAR = mTaskList.get(0);
            if (fAR != null) {
                this.mSD = new a();
                this.mSD.setPriority(3);
                this.mSD.execute(fAR);
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

    public void bF(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void G(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> fAT;

        private b() {
            this.fAT = null;
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
            this.fAT = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.eLw;
                if (o.GetFile(e.this.getFileOfUrl(next.apkUrl)) != null) {
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
        /* renamed from: B */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : f.dDB().getDownloadList()) {
                Iterator<AdvertAppInfo> it = this.fAT.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().eLw, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            e.this.bF(list);
            this.fAT = null;
        }
    }

    public static String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.getCacheDir());
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
                if (!au.isEmpty(id) && !au.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk";
                    String filePath = e.getFilePath(str);
                    File GetFile = o.GetFile(str);
                    if (isForceDownload || GetFile == null) {
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
            e.this.mSD = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    e.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
                    }
                } else {
                    f.dDB().a(downloadData, 5);
                    if (e.this.dX(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            g gVar = new g(downloadData, 0);
                            e.this.mSF.put(downloadData.getUrl(), gVar);
                            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), e.this.CH(downloadData.getAction()), false, gVar.dDC(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        e.this.c(downloadData);
                    }
                }
                DownloadData unused = e.fAR = null;
                if (!e.mTaskList.isEmpty()) {
                    e.mTaskList.remove(0);
                    e.this.bBb();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int dX = dX(downloadData.getId(), downloadData.getName());
            String str = dX + "%";
            g gVar = this.mSF.get(downloadData.getUrl());
            g gVar2 = gVar == null ? new g(downloadData, dX) : gVar;
            int status = getStatus(downloadData);
            if (status == 1) {
                gVar2.dDD();
            } else if (status == 4 || status == 2 || status == 7) {
                gVar2.dDE();
            } else if (status == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            gVar2.HN(dX);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), CH(downloadData.getAction()), false, gVar2.dDC(), false);
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            g gVar = this.mSF.get(downloadData.getUrl());
            g gVar2 = gVar == null ? new g(downloadData, dX(downloadData.getId(), downloadData.getName())) : gVar;
            gVar2.dDD();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, dX(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), CH(downloadData.getAction()), false, gVar2.dDC(), false);
        }
    }

    public void j(DownloadData downloadData) {
        if (downloadData != null) {
            g gVar = this.mSF.get(downloadData.getUrl());
            int dX = dX(downloadData.getId(), downloadData.getName());
            if (gVar == null) {
                gVar = new g(downloadData, dX);
            }
            gVar.dDE();
        }
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            j(downloadData);
            g gVar = this.mSF.get(downloadData.getUrl());
            if (gVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, dX(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), CH(downloadData.getAction()), false, gVar.dDC(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent CH(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", string, CH(downloadData.getAction()), false);
            }
        }
    }

    public boolean Rz(String str) {
        for (DownloadData downloadData : f.dDB().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int dX(String str, String str2) {
        long dY = dY(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (dY <= j) {
            return (int) ((100 * dY) / j);
        }
        return 0;
    }

    public boolean RA(String str) {
        for (DownloadData downloadData : f.dDB().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void F(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : f.dDB().getDownloadList()) {
                if (downloadData2.getId() == null || !downloadData2.getId().equals(str2)) {
                    downloadData2 = downloadData;
                }
                downloadData = downloadData2;
            }
            if (z) {
                f.dDB().cancelDownLoadByUrl(str, true);
            } else {
                f.dDB().cancelDownLoadByUrl(str);
            }
            if (downloadData != null) {
                int dX = dX(downloadData.getId(), downloadData.getName());
                String str3 = dX + "%";
                if (downloadData != null && dX >= 0) {
                    g gVar = this.mSF.get(downloadData.getUrl());
                    g gVar2 = gVar == null ? new g(downloadData, dX) : gVar;
                    gVar2.dDE();
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), CH(downloadData.getAction()), false, gVar2.dDC(), false);
                }
            }
        }
    }

    public void m(DownloadData downloadData) {
        f.dDB().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b(downloadData);
    }

    public boolean gk(String str, String str2) {
        File GetFile;
        return TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L) != 0 && (GetFile = o.GetFile(new StringBuilder().append(str).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(str2).append(".tmp").toString())) != null && GetFile.exists() && GetFile.isFile();
    }

    public long dY(String str, String str2) {
        File GetFile = o.GetFile(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public boolean RB(String str) {
        return (TextUtils.isEmpty(str) || o.GetFile(new StringBuilder().append(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)).append(".apk").toString()) == null) ? false : true;
    }

    public static int getStatus(DownloadData downloadData) {
        String id;
        int i = 6;
        if (dDA().RB(downloadData.getId())) {
            i = 3;
        } else if (dDA().RA(downloadData.getId())) {
            i = 5;
        } else if (dDA().Rz(downloadData.getId())) {
            i = 1;
        } else if (dDA().gk(downloadData.getId(), downloadData.getName())) {
            i = 7;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && com.baidu.tieba.a.bJg().bJh() && dDA().RC(id)) {
            return 8;
        }
        return i;
    }

    private boolean RC(String str) {
        TbadkApplication inst = TbadkApplication.getInst();
        if (inst != null) {
            try {
                if (inst.getPackageManager() != null) {
                    inst.getPackageManager().getPackageInfo(str, 64);
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static Integer RD(String str) {
        if (mSE.containsKey(str)) {
            return mSE.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        mSE.put(str, valueOf);
        return valueOf;
    }
}
