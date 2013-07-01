package com.baidu.tieba.media;

import com.baidu.cyberplayer.sdk.BEngineManager;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BEngineManager.OnEngineListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaDownloadHelper f965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MediaDownloadHelper mediaDownloadHelper) {
        this.f965a = mediaDownloadHelper;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public boolean onPrepare() {
        MediaDownloadHelper.DOWNLOAD_STAT download_stat;
        download_stat = this.f965a.g;
        return download_stat == MediaDownloadHelper.DOWNLOAD_STAT.DOWNLOADING;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public int onDownload(int i, int i2) {
        MediaDownloadHelper.DOWNLOAD_STAT download_stat;
        if (i != 0) {
            this.f965a.a(i, i2);
        }
        download_stat = this.f965a.g;
        return download_stat == MediaDownloadHelper.DOWNLOAD_STAT.DOWNLOADING ? 0 : 1;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public int onPreInstall() {
        a aVar;
        MediaDownloadHelper.DOWNLOAD_STAT download_stat;
        aVar = this.f965a.f951a;
        aVar.h();
        download_stat = this.f965a.g;
        this.f965a.g = MediaDownloadHelper.DOWNLOAD_STAT.STOP;
        return download_stat == MediaDownloadHelper.DOWNLOAD_STAT.DOWNLOADING ? 0 : 1;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public void onInstalled(int i) {
        String[] strArr;
        this.f965a.g = MediaDownloadHelper.DOWNLOAD_STAT.STOP;
        this.f965a.a(i);
        strArr = MediaDownloadHelper.l;
        com.baidu.adp.lib.c.b.a(strArr[i]);
    }
}
