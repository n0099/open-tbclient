package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class c implements SkinItemView.a {
    final /* synthetic */ DownloadedThemeListActivity dHa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dHa = downloadedThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(SkinItemView skinItemView, com.baidu.tieba.themeCenter.b bVar) {
        h hVar;
        com.baidu.tieba.themeCenter.d dVar;
        boolean z;
        com.baidu.tieba.themeCenter.d dVar2;
        DownloadedThemeListActivity downloadedThemeListActivity = this.dHa;
        hVar = this.dHa.dGV;
        downloadedThemeListActivity.dGX = hVar.isInEditMode();
        dVar = this.dHa.dGg;
        if (dVar != null) {
            z = this.dHa.dGX;
            if (!z && skinItemView != null && bVar != null && bVar.getId() > 0) {
                dVar2 = this.dHa.dGg;
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
        DownloadedThemeListActivity downloadedThemeListActivity = this.dHa;
        hVar = this.dHa.dGV;
        downloadedThemeListActivity.dGX = hVar.isInEditMode();
        dVar = this.dHa.dGg;
        if (dVar != null) {
            z = this.dHa.dGX;
            if (!z && skinProgressView != null && bVar != null) {
                dVar2 = this.dHa.dGg;
                dVar2.b(skinProgressView, bVar);
            }
        }
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(View view, com.baidu.tieba.themeCenter.b bVar) {
        com.baidu.tieba.themeCenter.d dVar;
        com.baidu.tieba.themeCenter.d dVar2;
        dVar = this.dHa.dGg;
        if (dVar != null && bVar != null && bVar.getId() > 0) {
            dVar2 = this.dHa.dGg;
            dVar2.c(bVar);
        }
    }
}
