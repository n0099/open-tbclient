package com.baidu.tieba.recapp.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f ksp = new f();
    private static DownloadData dWo = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private a ksq = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler dWq = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.download.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && f.dWo != null) {
                f.dWo.setLength(message.arg1);
                f.dWo.setSize(message.arg2);
                f.dWo.setStatus(1);
                if (f.dWo.getCallback() != null) {
                    f.dWo.getCallback().onFileUpdateProgress(f.dWo);
                }
            }
        }
    };

    private f() {
    }

    public static f cNw() {
        return ksp;
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
            if (!m.checkSD()) {
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
                    startQueue();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startQueue() {
        if (dWo == null && !mTaskList.isEmpty()) {
            dWo = mTaskList.get(0);
            if (dWo != null) {
                this.ksq = new a();
                this.ksq.execute(dWo);
            }
        }
    }

    public void cancelDownLoadByUrl(String str) {
        cancelDownLoadByUrl(str, false);
    }

    public void cancelDownLoadByUrl(String str, boolean z) {
        if (dWo != null && dWo.getUrl().equals(str)) {
            if (z) {
                this.ksq.cancelImmediately();
                return;
            } else {
                this.ksq.cancel(true);
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

    public void h(DownloadData downloadData) {
        if (downloadData != null) {
            cancelDownLoadByUrl(downloadData.getUrl(), true);
            File GetFile = m.GetFile(downloadData.getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadData.getName() + ".tmp");
            if (GetFile != null) {
                GetFile.delete();
            }
        }
    }

    public List<DownloadData> getDownloadList() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private x blF = new x();

        a() {
        }

        public void cancelImmediately() {
            if (this.blF != null) {
                this.blF.setCancel();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.blF.setCancel();
            f.dWo.setStatus(4);
            f.dWo.setStatusMsg(null);
            if (f.dWo.getCallback() != null) {
                f.dWo.getCallback().onFileUpdateProgress(f.dWo);
            }
            if (!f.mTaskList.isEmpty()) {
                f.mTaskList.remove(0);
            }
            DownloadData unused = f.dWo = null;
            f.this.startQueue();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=5, 393=4, 394=4, 395=4] */
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
                    this.blF.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.blF.a(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp", f.this.dWq, 900002, 3, 3000)).booleanValue()) {
                        return 3;
                    }
                    File GetFile = m.GetFile(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp");
                    if (GetFile == null) {
                        return 1;
                    }
                    try {
                        String parent = GetFile.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            GetFile.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.f.copyFile(GetFile, file);
                            com.baidu.adp.lib.util.f.deleteQuietly(GetFile);
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
                if (!aq.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!s.toMd5(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.f.deleteQuietly(new File(downloadDataArr[0].getPath()));
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
                    f.dWo.setStatus(0);
                    if (f.dWo.getCallback() != null) {
                        f.dWo.getCallback().onFileUpdateProgress(f.dWo);
                    }
                    if (f.dWo.getCallback() != null) {
                        f.dWo.getCallback().onFileDownloadSucceed(f.dWo);
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
                    f.dWo.setStatusMsg(string);
                    f.dWo.setErrorCode(num.intValue());
                    f.dWo.setStatus(2);
                    if (f.dWo.getCallback() != null) {
                        f.dWo.getCallback().onFileUpdateProgress(f.dWo);
                    }
                    if (f.dWo.getCallback() != null) {
                        f.dWo.getCallback().onFileDownloadFailed(f.dWo, num.intValue(), string);
                    }
                }
                DownloadData unused = f.dWo = null;
                if (!f.mTaskList.isEmpty()) {
                    f.mTaskList.remove(0);
                    f.this.startQueue();
                }
            }
        }
    }
}
