package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.tieba.themeCenter.theme.download.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ DownloadedThemeListActivity dOB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dOB = downloadedThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.download.d.a
    public void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.dOB.dOw;
        if (hVar != null) {
            hVar2 = this.dOB.dOw;
            hVar2.hF(z);
            hVar3 = this.dOB.dOw;
            hVar3.bX(list);
        }
    }
}
