package com.baidu.tieba;

import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes8.dex */
public interface ui5 {
    void onFileDownloadFailed(DownloadData downloadData, int i, String str);

    void onFileDownloadSucceed(DownloadData downloadData);

    boolean onFileDownloaded(DownloadData downloadData);

    void onFileUpdateProgress(DownloadData downloadData);

    boolean onPreDownload(DownloadData downloadData);
}
