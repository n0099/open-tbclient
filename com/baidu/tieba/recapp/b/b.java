package com.baidu.tieba.recapp.b;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b fbU = new b();
    private static DownloadData ayi = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private a fbV = null;
    private int max = 20;
    private Handler ayk = new c(this, Looper.getMainLooper());

    private b() {
    }

    public static b aZH() {
        return fbU;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : mTaskList) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        f(downloadData);
    }

    public void f(DownloadData downloadData) {
        if (downloadData != null) {
            if (!l.dH()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < mTaskList.size()) {
                    DownloadData downloadData2 = mTaskList.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    mTaskList.add(downloadData);
                    CI();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CI() {
        if (ayi == null && !mTaskList.isEmpty()) {
            ayi = mTaskList.get(0);
            if (ayi != null) {
                this.fbV = new a();
                this.fbV.execute(ayi);
            }
        }
    }

    public void eX(String str) {
        t(str, false);
    }

    public void t(String str, boolean z) {
        if (ayi != null && ayi.getUrl().equals(str)) {
            if (z) {
                this.fbV.CL();
                return;
            } else {
                this.fbV.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = mTaskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            mTaskList.remove(downloadData);
        }
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            t(downloadData.getUrl(), true);
            File cQ = l.cQ(String.valueOf(downloadData.getId()) + "_" + downloadData.getName() + ".tmp");
            if (cQ != null) {
                cQ.delete();
            }
        }
    }

    public List<DownloadData> jN() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private z mNetWork = new z();

        a() {
        }

        public void CL() {
            if (this.mNetWork != null) {
                this.mNetWork.fp();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mNetWork.fp();
            b.ayi.setStatus(4);
            b.ayi.setStatusMsg(null);
            if (b.ayi.getCallback() != null) {
                b.ayi.getCallback().onFileUpdateProgress(b.ayi);
            }
            if (!b.mTaskList.isEmpty()) {
                b.mTaskList.remove(0);
            }
            b.ayi = null;
            b.this.CI();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=4, 393=4, 394=4, 395=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:75:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            Boolean.valueOf(false);
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.mNetWork.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.mNetWork.a(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp", b.this.ayk, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                        return 3;
                    }
                    File cQ = l.cQ(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (cQ == null) {
                        return 1;
                    }
                    try {
                        String parent = cQ.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            cQ.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.e.b(cQ, file);
                            com.baidu.adp.lib.util.e.f(cQ);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.e.f(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!au.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!t.k(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.e.f(new File(downloadDataArr[0].getPath()));
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        return 4;
                                    } catch (IOException e3) {
                                        BdLog.d(e3.getMessage());
                                        return 4;
                                    }
                                }
                                return 4;
                            } else if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    BdLog.d(e4.getMessage());
                                }
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream2 = fileInputStream;
                            try {
                                BdLog.d(e.getMessage());
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                        return 6;
                                    } catch (IOException e6) {
                                        BdLog.d(e6.getMessage());
                                        return 6;
                                    }
                                }
                                return 6;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e7) {
                                        BdLog.d(e7.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
                return (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) ? 0 : 2;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((a) num);
            if (num != null) {
                if (num.intValue() == 0) {
                    b.ayi.setStatus(0);
                    if (b.ayi.getCallback() != null) {
                        b.ayi.getCallback().onFileUpdateProgress(b.ayi);
                    }
                    if (b.ayi.getCallback() != null) {
                        b.ayi.getCallback().onFileDownloadSucceed(b.ayi);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_net);
                            break;
                        case 4:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                    }
                    b.ayi.setStatusMsg(string);
                    b.ayi.setErrorCode(num.intValue());
                    b.ayi.setStatus(2);
                    if (b.ayi.getCallback() != null) {
                        b.ayi.getCallback().onFileUpdateProgress(b.ayi);
                    }
                    if (b.ayi.getCallback() != null) {
                        b.ayi.getCallback().onFileDownloadFailed(b.ayi, num.intValue(), string);
                    }
                }
                b.ayi = null;
                if (!b.mTaskList.isEmpty()) {
                    b.mTaskList.remove(0);
                    b.this.CI();
                }
            }
        }
    }
}
