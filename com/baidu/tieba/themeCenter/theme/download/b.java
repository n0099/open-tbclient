package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ DownloadedThemeListActivity dgK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dgK = downloadedThemeListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        h hVar3;
        d dVar;
        d dVar2;
        boolean z;
        if (view != null) {
            hVar = this.dgK.dgE;
            if (hVar != null) {
                hVar2 = this.dgK.dgE;
                if (view == hVar2.azx()) {
                    DownloadedThemeListActivity downloadedThemeListActivity = this.dgK;
                    hVar3 = this.dgK.dgE;
                    downloadedThemeListActivity.dgG = hVar3.azw();
                    dVar = this.dgK.dgF;
                    if (dVar != null) {
                        dVar2 = this.dgK.dgF;
                        z = this.dgK.dgG;
                        dVar2.gK(z);
                    }
                }
            }
        }
    }
}
