package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.tieba.themeCenter.theme.download.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ DownloadedThemeListActivity dgK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dgK = downloadedThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.download.d.a
    public void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.dgK.dgE;
        if (hVar != null) {
            hVar2 = this.dgK.dgE;
            hVar2.gL(z);
            hVar3 = this.dgK.dgE;
            hVar3.bB(list);
        }
    }
}
