package com.baidu.tieba.recapp.b;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b faP = new b();
    private static DownloadData atF = null;
    private static List<DownloadData> atx = new LinkedList();
    private a faQ = null;
    private int max = 20;
    private Handler atH = new c(this, Looper.getMainLooper());

    private b() {
    }

    public static b bbs() {
        return faP;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : atx) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().b(downloadData);
                return;
            }
            return;
        }
        k(downloadData);
    }

    public void k(DownloadData downloadData) {
        if (downloadData != null) {
            if (!m.cA()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().b(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < atx.size()) {
                    DownloadData downloadData2 = atx.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    atx.add(downloadData);
                    Cz();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        if (atF == null && !atx.isEmpty()) {
            atF = atx.get(0);
            if (atF != null) {
                this.faQ = new a();
                this.faQ.execute(atF);
            }
        }
    }

    public void fk(String str) {
        s(str, false);
    }

    public void s(String str, boolean z) {
        if (atF != null && atF.getUrl().equals(str)) {
            if (z) {
                this.faQ.CC();
                return;
            } else {
                this.faQ.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = atx.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().b(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            atx.remove(downloadData);
        }
    }

    public List<DownloadData> iV() {
        return atx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private ab NX = new ab();

        a() {
        }

        public void CC() {
            if (this.NX != null) {
                this.NX.ej();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.NX.ej();
            b.atF.setStatus(4);
            b.atF.setStatusMsg(null);
            if (b.atF.getCallback() != null) {
                b.atF.getCallback().b(b.atF);
            }
            if (!b.atx.isEmpty()) {
                b.atx.remove(0);
            }
            b.atF = null;
            b.this.Cz();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [379=4, 381=4, 382=4, 383=4] */
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
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().a(downloadDataArr[0])) {
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.NX.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.NX.a(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp", b.this.atH, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                        return 3;
                    }
                    File cU = m.cU(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (cU == null) {
                        return 1;
                    }
                    try {
                        String parent = cU.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            cU.renameTo(new File(parent2, file.getName()));
                        } else {
                            e.b(cU, file);
                            e.f(cU);
                        }
                    } catch (IOException e) {
                        try {
                            e.f(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!ba.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!com.baidu.adp.lib.util.t.k(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                e.f(new File(downloadDataArr[0].getPath()));
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
                return (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().c(downloadDataArr[0])) ? 0 : 2;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((a) num);
            if (num.intValue() == 0) {
                b.atF.setStatus(0);
                if (b.atF.getCallback() != null) {
                    b.atF.getCallback().b(b.atF);
                }
                if (b.atF.getCallback() != null) {
                    b.atF.getCallback().d(b.atF);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 5:
                    default:
                        string = null;
                        break;
                    case 6:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(t.j.download_fail);
                        break;
                }
                b.atF.setStatusMsg(string);
                b.atF.setErrorCode(num.intValue());
                b.atF.setStatus(2);
                if (b.atF.getCallback() != null) {
                    b.atF.getCallback().b(b.atF);
                }
                if (b.atF.getCallback() != null) {
                    b.atF.getCallback().a(b.atF, num.intValue(), string);
                }
            }
            b.atF = null;
            if (!b.atx.isEmpty()) {
                b.atx.remove(0);
                b.this.Cz();
            }
        }
    }
}
