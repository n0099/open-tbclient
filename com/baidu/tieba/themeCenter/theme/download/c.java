package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class c implements SkinItemView.a {
    final /* synthetic */ DownloadedThemeListActivity dOB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dOB = downloadedThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(SkinItemView skinItemView, com.baidu.tieba.themeCenter.b bVar) {
        h hVar;
        com.baidu.tieba.themeCenter.d dVar;
        boolean z;
        com.baidu.tieba.themeCenter.d dVar2;
        DownloadedThemeListActivity downloadedThemeListActivity = this.dOB;
        hVar = this.dOB.dOw;
        downloadedThemeListActivity.dOy = hVar.isInEditMode();
        dVar = this.dOB.dNH;
        if (dVar != null) {
            z = this.dOB.dOy;
            if (!z && skinItemView != null && bVar != null && bVar.getId() > 0) {
                dVar2 = this.dOB.dNH;
                dVar2.b(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(SkinProgressView skinProgressView, com.baidu.tieba.themeCenter.b bVar) {
        h hVar;
        com.baidu.tieba.themeCenter.d dVar;
        boolean z;
        com.baidu.tieba.themeCenter.d dVar2;
        DownloadedThemeListActivity downloadedThemeListActivity = this.dOB;
        hVar = this.dOB.dOw;
        downloadedThemeListActivity.dOy = hVar.isInEditMode();
        dVar = this.dOB.dNH;
        if (dVar != null) {
            z = this.dOB.dOy;
            if (!z && skinProgressView != null && bVar != null) {
                dVar2 = this.dOB.dNH;
                dVar2.b(skinProgressView, bVar);
            }
        }
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(View view, com.baidu.tieba.themeCenter.b bVar) {
        com.baidu.tieba.themeCenter.d dVar;
        com.baidu.tieba.themeCenter.d dVar2;
        dVar = this.dOB.dNH;
        if (dVar != null && bVar != null && bVar.getId() > 0) {
            dVar2 = this.dOB.dNH;
            dVar2.c(bVar);
        }
    }
}
