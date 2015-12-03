package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ DownloadedThemeListActivity dHa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dHa = downloadedThemeListActivity;
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
            hVar = this.dHa.dGV;
            if (hVar != null) {
                hVar2 = this.dHa.dGV;
                if (view == hVar2.aFE()) {
                    DownloadedThemeListActivity downloadedThemeListActivity = this.dHa;
                    hVar3 = this.dHa.dGV;
                    downloadedThemeListActivity.dGX = hVar3.aFD();
                    dVar = this.dHa.dGW;
                    if (dVar != null) {
                        dVar2 = this.dHa.dGW;
                        z = this.dHa.dGX;
                        dVar2.hv(z);
                    }
                }
            }
        }
    }
}
