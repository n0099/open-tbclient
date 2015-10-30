package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ DownloadedThemeListActivity dhk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dhk = downloadedThemeListActivity;
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
            hVar = this.dhk.dhe;
            if (hVar != null) {
                hVar2 = this.dhk.dhe;
                if (view == hVar2.azD()) {
                    DownloadedThemeListActivity downloadedThemeListActivity = this.dhk;
                    hVar3 = this.dhk.dhe;
                    downloadedThemeListActivity.dhg = hVar3.azC();
                    dVar = this.dhk.dhf;
                    if (dVar != null) {
                        dVar2 = this.dhk.dhf;
                        z = this.dhk.dhg;
                        dVar2.gK(z);
                    }
                }
            }
        }
    }
}
