package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ DownloadedThemeListActivity dOB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dOB = downloadedThemeListActivity;
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
            hVar = this.dOB.dOw;
            if (hVar != null) {
                hVar2 = this.dOB.dOw;
                if (view == hVar2.aHT()) {
                    DownloadedThemeListActivity downloadedThemeListActivity = this.dOB;
                    hVar3 = this.dOB.dOw;
                    downloadedThemeListActivity.dOy = hVar3.aHS();
                    dVar = this.dOB.dOx;
                    if (dVar != null) {
                        dVar2 = this.dOB.dOx;
                        z = this.dOB.dOy;
                        dVar2.hE(z);
                    }
                }
            }
        }
    }
}
