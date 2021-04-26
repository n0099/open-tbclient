package com.baidu.webkit.internal.resource;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
/* loaded from: classes5.dex */
public interface IResouceNetTaskListener extends INoProGuard {
    void onNetDownloadComplete(BdNet bdNet);

    void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2);

    void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2);

    void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask);

    boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2);

    void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2);

    void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2);

    void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask);

    void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask);

    void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask);

    void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3);
}
