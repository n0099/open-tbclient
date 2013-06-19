package com.baidu.tieba.media;

import com.baidu.cyberplayer.sdk.BEngineManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements BEngineManager.OnEngineListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public boolean onPrepare() {
        m mVar;
        mVar = this.a.g;
        return mVar == m.DOWNLOADING;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public int onDownload(int i, int i2) {
        m mVar;
        if (i != 0) {
            this.a.a(i, i2);
        }
        mVar = this.a.g;
        return mVar == m.DOWNLOADING ? 0 : 1;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public int onPreInstall() {
        a aVar;
        m mVar;
        aVar = this.a.a;
        aVar.h();
        mVar = this.a.g;
        this.a.g = m.STOP;
        return mVar == m.DOWNLOADING ? 0 : 1;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager.OnEngineListener
    public void onInstalled(int i) {
        String[] strArr;
        this.a.g = m.STOP;
        this.a.a(i);
        strArr = e.l;
        com.baidu.adp.lib.e.b.a(strArr[i]);
    }
}
