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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a iGq = new a();
    private static DownloadData cry = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private C0401a iGr = null;
    private int crA = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler crB = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.download.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && a.cry != null) {
                a.cry.setLength(message.arg1);
                a.cry.setSize(message.arg2);
                a.cry.setStatus(1);
                if (a.cry.getCallback() != null) {
                    a.cry.getCallback().onFileUpdateProgress(a.cry);
                }
            }
        }
    };

    private a() {
    }

    public static a chJ() {
        return iGq;
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
            if (!m.gB()) {
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
                    arT();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arT() {
        if (cry == null && !mTaskList.isEmpty()) {
            cry = mTaskList.get(0);
            if (cry != null) {
                this.iGr = new C0401a();
                this.iGr.execute(cry);
            }
        }
    }

    public void qc(String str) {
        S(str, false);
    }

    public void S(String str, boolean z) {
        if (cry != null && cry.getUrl().equals(str)) {
            if (z) {
                this.iGr.arW();
                return;
            } else {
                this.iGr.cancel(true);
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
            S(downloadData.getUrl(), true);
            File nk = m.nk(downloadData.getId() + "_" + downloadData.getName() + ".tmp");
            if (nk != null) {
                nk.delete();
            }
        }
    }

    public List<DownloadData> mN() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.baidu.tieba.recapp.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0401a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private b iGt = new b();

        C0401a() {
        }

        public void arW() {
            if (this.iGt != null) {
                this.iGt.in();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.iGt.in();
            a.cry.setStatus(4);
            a.cry.setStatusMsg(null);
            if (a.cry.getCallback() != null) {
                a.cry.getCallback().onFileUpdateProgress(a.cry);
            }
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
            }
            DownloadData unused = a.cry = null;
            a.this.arT();
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
                    this.iGt.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.iGt.a(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", a.this.crB, TbConfig.NET_MSG_GETLENTH, 1, 3000)).booleanValue()) {
                        return 3;
                    }
                    File nk = m.nk(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (nk == null) {
                        return 1;
                    }
                    try {
                        String parent = nk.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            nk.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.f.c(nk, file);
                            com.baidu.adp.lib.util.f.j(nk);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.f.j(file);
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
                            if (!s.h(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.f.j(new File(downloadDataArr[0].getPath()));
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
            super.onPostExecute((C0401a) num);
            if (num != null) {
                if (num.intValue() == 0) {
                    a.cry.setStatus(0);
                    if (a.cry.getCallback() != null) {
                        a.cry.getCallback().onFileUpdateProgress(a.cry);
                    }
                    if (a.cry.getCallback() != null) {
                        a.cry.getCallback().onFileDownloadSucceed(a.cry);
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
                    a.cry.setStatusMsg(string);
                    a.cry.setErrorCode(num.intValue());
                    a.cry.setStatus(2);
                    if (a.cry.getCallback() != null) {
                        a.cry.getCallback().onFileUpdateProgress(a.cry);
                    }
                    if (a.cry.getCallback() != null) {
                        a.cry.getCallback().onFileDownloadFailed(a.cry, num.intValue(), string);
                    }
                }
                DownloadData unused = a.cry = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.arT();
                }
            }
        }
    }
}
