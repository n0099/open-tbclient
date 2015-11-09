package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ DownloadedThemeListActivity diQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.diQ = downloadedThemeListActivity;
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
            hVar = this.diQ.diK;
            if (hVar != null) {
                hVar2 = this.diQ.diK;
                if (view == hVar2.aAt()) {
                    DownloadedThemeListActivity downloadedThemeListActivity = this.diQ;
                    hVar3 = this.diQ.diK;
                    downloadedThemeListActivity.diM = hVar3.aAs();
                    dVar = this.diQ.diL;
                    if (dVar != null) {
                        dVar2 = this.diQ.diL;
                        z = this.diQ.diM;
                        dVar2.gN(z);
                    }
                }
            }
        }
    }
}
