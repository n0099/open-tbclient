package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.tieba.themeCenter.theme.download.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ DownloadedThemeListActivity dHa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dHa = downloadedThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.download.d.a
    public void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.dHa.dGV;
        if (hVar != null) {
            hVar2 = this.dHa.dGV;
            hVar2.hw(z);
            hVar3 = this.dHa.dGV;
            hVar3.bU(list);
        }
    }
}
