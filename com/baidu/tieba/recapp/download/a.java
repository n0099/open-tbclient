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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a gCE = new a();
    private static DownloadData brY = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private C0224a gCF = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler bsa = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.download.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && a.brY != null) {
                a.brY.setLength(message.arg1);
                a.brY.setSize(message.arg2);
                a.brY.setStatus(1);
                if (a.brY.getCallback() != null) {
                    a.brY.getCallback().onFileUpdateProgress(a.brY);
                }
            }
        }
    };

    private a() {
    }

    public static a bok() {
        return gCE;
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
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_over_max));
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
            if (!k.lk()) {
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_no_sd));
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
                    KV();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        if (brY == null && !mTaskList.isEmpty()) {
            brY = mTaskList.get(0);
            if (brY != null) {
                this.gCF = new C0224a();
                this.gCF.execute(brY);
            }
        }
    }

    public void gf(String str) {
        o(str, false);
    }

    public void o(String str, boolean z) {
        if (brY != null && brY.getUrl().equals(str)) {
            if (z) {
                this.gCF.KY();
                return;
            } else {
                this.gCF.cancel(true);
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
            o(downloadData.getUrl(), true);
            File dC = k.dC(downloadData.getId() + "_" + downloadData.getName() + ".tmp");
            if (dC != null) {
                dC.delete();
            }
        }
    }

    public List<DownloadData> rl() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.baidu.tieba.recapp.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0224a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private b gCH = new b();

        C0224a() {
        }

        public void KY() {
            if (this.gCH != null) {
                this.gCH.mV();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.gCH.mV();
            a.brY.setStatus(4);
            a.brY.setStatusMsg(null);
            if (a.brY.getCallback() != null) {
                a.brY.getCallback().onFileUpdateProgress(a.brY);
            }
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
            }
            DownloadData unused = a.brY = null;
            a.this.KV();
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
                    this.gCH.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.gCH.a(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", a.this.bsa, TbConfig.NET_MSG_GETLENTH, 1, PushConstants.WORK_RECEIVER_EVENTCORE_ERROR)).booleanValue()) {
                        return 3;
                    }
                    File dC = k.dC(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (dC == null) {
                        return 1;
                    }
                    try {
                        String parent = dC.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            dC.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.f.b(dC, file);
                            com.baidu.adp.lib.util.f.j(dC);
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
                if (!am.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!s.e(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
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
            super.onPostExecute((C0224a) num);
            if (num != null) {
                if (num.intValue() == 0) {
                    a.brY.setStatus(0);
                    if (a.brY.getCallback() != null) {
                        a.brY.getCallback().onFileUpdateProgress(a.brY);
                    }
                    if (a.brY.getCallback() != null) {
                        a.brY.getCallback().onFileDownloadSucceed(a.brY);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_net);
                            break;
                        case 4:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                    }
                    a.brY.setStatusMsg(string);
                    a.brY.setErrorCode(num.intValue());
                    a.brY.setStatus(2);
                    if (a.brY.getCallback() != null) {
                        a.brY.getCallback().onFileUpdateProgress(a.brY);
                    }
                    if (a.brY.getCallback() != null) {
                        a.brY.getCallback().onFileDownloadFailed(a.brY, num.intValue(), string);
                    }
                }
                DownloadData unused = a.brY = null;
                if (!a.mTaskList.isEmpty()) {
                    a.mTaskList.remove(0);
                    a.this.KV();
                }
            }
        }
    }
}
