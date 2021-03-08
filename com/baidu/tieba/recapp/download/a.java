package com.baidu.tieba.recapp.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private static a mUA = new a();
    private static DownloadData fCu = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private C0864a mUB = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler fCw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.download.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && a.fCu != null) {
                a.fCu.setLength(message.arg1);
                a.fCu.setSize(message.arg2);
                a.fCu.setStatus(1);
                if (a.fCu.getCallback() != null) {
                    a.fCu.getCallback().onFileUpdateProgress(a.fCu);
                }
            }
        }
    };

    private a() {
    }

    public static a dDH() {
        return mUA;
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
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
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
            if (!com.baidu.tieba.a.bJk().bJs() && !o.checkSD()) {
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
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
                if (i2 < com.baidu.tieba.lego.card.c.a.eL(mTaskList)) {
                    DownloadData downloadData2 = (DownloadData) com.baidu.tieba.lego.card.c.a.l(mTaskList, i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    com.baidu.tieba.lego.card.c.a.a(mTaskList, downloadData);
                    startQueue();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startQueue() {
        if (fCu == null && !com.baidu.tieba.lego.card.c.a.isEmpty(mTaskList)) {
            fCu = (DownloadData) com.baidu.tieba.lego.card.c.a.l(mTaskList, 0);
            if (fCu != null) {
                this.mUB = new C0864a();
                this.mUB.execute(fCu);
            }
        }
    }

    public void cancelDownLoadByUrl(String str) {
        cancelDownLoadByUrl(str, false);
    }

    public void cancelDownLoadByUrl(String str, boolean z) {
        if (fCu != null && fCu.getUrl().equals(str)) {
            if (z) {
                this.mUB.cancelImmediately();
                return;
            } else {
                this.mUB.cancel(true);
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
                com.baidu.tieba.lego.card.c.a.a(linkedList, next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            com.baidu.tieba.lego.card.c.a.b(mTaskList, downloadData);
        }
    }

    public void h(DownloadData downloadData) {
        if (downloadData != null) {
            cancelDownLoadByUrl(downloadData.getUrl(), true);
            File Rq = com.baidu.tieba.recapp.b.Rq(com.baidu.tieba.recapp.b.gh(downloadData.getId(), downloadData.getName()));
            if (Rq != null) {
                Rq.delete();
            }
        }
    }

    public List<DownloadData> getDownloadList() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.baidu.tieba.recapp.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0864a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private c mUD = new c();

        C0864a() {
        }

        public void cancelImmediately() {
            if (this.mUD != null) {
                this.mUD.setCancel();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mUD.setCancel();
            a.fCu.setStatus(4);
            a.fCu.setStatusMsg(null);
            if (a.fCu.getCallback() != null) {
                a.fCu.getCallback().onFileUpdateProgress(a.fCu);
            }
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(a.mTaskList)) {
                com.baidu.tieba.lego.card.c.a.m(a.mTaskList, 0);
            }
            DownloadData unused = a.fCu = null;
            a.this.startQueue();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [389=5, 391=4, 392=4, 393=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.mUD.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.mUD.a(com.baidu.tieba.recapp.b.gh(downloadDataArr[0].getId(), downloadDataArr[0].getName()), a.this.fCw, 900002, 1, 3000)).booleanValue()) {
                        return 3;
                    }
                    File Rq = com.baidu.tieba.recapp.b.Rq(com.baidu.tieba.recapp.b.gh(downloadDataArr[0].getId(), downloadDataArr[0].getName()));
                    if (Rq == null) {
                        return 1;
                    }
                    try {
                        String parent = Rq.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            Rq.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.f.copyFile(Rq, file);
                            com.baidu.adp.lib.util.f.deleteQuietly(Rq);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.f.deleteQuietly(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!au.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = null;
                    }
                    try {
                        if (!s.toMd5(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            com.baidu.adp.lib.util.f.deleteQuietly(new File(downloadDataArr[0].getPath()));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return 4;
                                } catch (IOException e4) {
                                    BdLog.d(e4.getMessage());
                                    return 4;
                                }
                            }
                            return 4;
                        } else if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                BdLog.d(e5.getMessage());
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.d(e.getMessage());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    return 6;
                                } catch (IOException e7) {
                                    BdLog.d(e7.getMessage());
                                    return 6;
                                }
                            }
                            return 6;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                    BdLog.d(e8.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                        }
                        throw th;
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
            super.onPostExecute((C0864a) num);
            if (num != null) {
                if (num.intValue() == 0) {
                    a.fCu.setStatus(0);
                    if (a.fCu.getCallback() != null) {
                        a.fCu.getCallback().onFileUpdateProgress(a.fCu);
                    }
                    if (a.fCu.getCallback() != null) {
                        a.fCu.getCallback().onFileDownloadSucceed(a.fCu);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                            break;
                        case 4:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                    }
                    a.fCu.setStatusMsg(string);
                    a.fCu.setErrorCode(num.intValue());
                    a.fCu.setStatus(2);
                    if (a.fCu.getCallback() != null) {
                        a.fCu.getCallback().onFileUpdateProgress(a.fCu);
                    }
                    if (a.fCu.getCallback() != null) {
                        a.fCu.getCallback().onFileDownloadFailed(a.fCu, num.intValue(), string);
                    }
                }
                DownloadData unused = a.fCu = null;
                if (!com.baidu.tieba.lego.card.c.a.isEmpty(a.mTaskList)) {
                    com.baidu.tieba.lego.card.c.a.m(a.mTaskList, 0);
                    a.this.startQueue();
                }
            }
        }
    }
}
