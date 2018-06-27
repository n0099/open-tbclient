package com.baidu.tieba.recapp.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a gnE = new a();
    private static DownloadData aLI = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private C0226a gnF = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler aLK = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.download.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && a.aLI != null) {
                a.aLI.setLength(message.arg1);
                a.aLI.setSize(message.arg2);
                a.aLI.setStatus(1);
                if (a.aLI.getCallback() != null) {
                    a.aLI.getCallback().onFileUpdateProgress(a.aLI);
                }
            }
        }
    };

    private a() {
    }

    public static a boP() {
        return gnE;
    }

    public void a(DownloadData downloadData, int i) {
        int i2;
        int type = downloadData.getType();
        int i3 = 0;
        Iterator<DownloadData> it = mTaskList.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            i3 = it.next().getType() == type ? i2 + 1 : i2;
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_over_max));
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
            if (!l.ge()) {
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_no_sd));
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
                    Hs();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hs() {
        if (aLI == null && !mTaskList.isEmpty()) {
            aLI = mTaskList.get(0);
            if (aLI != null) {
                this.gnF = new C0226a();
                this.gnF.execute(aLI);
            }
        }
    }

    public void gz(String str) {
        l(str, false);
    }

    public void l(String str, boolean z) {
        if (aLI != null && aLI.getUrl().equals(str)) {
            if (z) {
                this.gnF.Hu();
                return;
            } else {
                this.gnF.cancel(true);
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

    public void l(DownloadData downloadData) {
        if (downloadData != null) {
            l(downloadData.getUrl(), true);
            File dX = l.dX(downloadData.getId() + "_" + downloadData.getName() + ".tmp");
            if (dX != null) {
                dX.delete();
            }
        }
    }

    public List<DownloadData> me() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.baidu.tieba.recapp.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0226a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private b gnH = new b();

        C0226a() {
        }

        public void Hu() {
            if (this.gnH != null) {
                this.gnH.hP();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.gnH.hP();
            a.aLI.setStatus(4);
            a.aLI.setStatusMsg(null);
            if (a.aLI.getCallback() != null) {
                a.aLI.getCallback().onFileUpdateProgress(a.aLI);
            }
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
            }
            DownloadData unused = a.aLI = null;
            a.this.Hs();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [389=5, 391=4, 392=4, 393=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:84:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    this.gnH.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.gnH.a(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", a.this.aLK, TbConfig.NET_MSG_GETLENTH, 1, 3000)).booleanValue()) {
                        return 3;
                    }
                    File dX = l.dX(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (dX == null) {
                        return 1;
                    }
                    try {
                        String parent = dX.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            dX.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.f.b(dX, file);
                            com.baidu.adp.lib.util.f.i(dX);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.f.i(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!ap.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!s.g(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.f.i(new File(downloadDataArr[0].getPath()));
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
            super.onPostExecute((C0226a) num);
            if (num != null) {
                if (num.intValue() == 0) {
                    a.aLI.setStatus(0);
                    if (a.aLI.getCallback() != null) {
                        a.aLI.getCallback().onFileUpdateProgress(a.aLI);
                    }
                    if (a.aLI.getCallback() != null) {
                        a.aLI.getCallback().onFileDownloadSucceed(a.aLI);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_net);
                            break;
                        case 4:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                            break;
                    }
                    a.aLI.setStatusMsg(string);
                    a.aLI.setErrorCode(num.intValue());
                    a.aLI.setStatus(2);
                    if (a.aLI.getCallback() != null) {
                        a.aLI.getCallback().onFileUpdateProgress(a.aLI);
                    }
                    if (a.aLI.getCallback() != null) {
                        a.aLI.getCallback().onFileDownloadFailed(a.aLI, num.intValue(), string);
                    }
                }
                DownloadData unused = a.aLI = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.Hs();
                }
            }
        }
    }
}
