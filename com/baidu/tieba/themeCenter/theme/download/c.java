package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class c implements SkinItemView.a {
    final /* synthetic */ DownloadedThemeListActivity dhk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dhk = downloadedThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(SkinItemView skinItemView, com.baidu.tieba.themeCenter.b bVar) {
        h hVar;
        com.baidu.tieba.themeCenter.d dVar;
        boolean z;
        com.baidu.tieba.themeCenter.d dVar2;
        DownloadedThemeListActivity downloadedThemeListActivity = this.dhk;
        hVar = this.dhk.dhe;
        downloadedThemeListActivity.dhg = hVar.isInEditMode();
        dVar = this.dhk.dgr;
        if (dVar != null) {
            z = this.dhk.dhg;
            if (!z && skinItemView != null && bVar != null && bVar.getId() > 0) {
                dVar2 = this.dhk.dgr;
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
        DownloadedThemeListActivity downloadedThemeListActivity = this.dhk;
        hVar = this.dhk.dhe;
        downloadedThemeListActivity.dhg = hVar.isInEditMode();
        dVar = this.dhk.dgr;
        if (dVar != null) {
            z = this.dhk.dhg;
            if (!z && skinProgressView != null && bVar != null) {
                dVar2 = this.dhk.dgr;
                dVar2.b(skinProgressView, bVar);
            }
        }
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(View view, com.baidu.tieba.themeCenter.b bVar) {
        com.baidu.tieba.themeCenter.d dVar;
        com.baidu.tieba.themeCenter.d dVar2;
        dVar = this.dhk.dgr;
        if (dVar != null && bVar != null && bVar.getId() > 0) {
            dVar2 = this.dhk.dgr;
            dVar2.c(bVar);
        }
    }
}
