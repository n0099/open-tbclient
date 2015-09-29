package com.baidu.tieba.themeCenter.theme.download;

import android.view.View;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class c implements SkinItemView.a {
    final /* synthetic */ DownloadedThemeListActivity dgK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DownloadedThemeListActivity downloadedThemeListActivity) {
        this.dgK = downloadedThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(SkinItemView skinItemView, com.baidu.tieba.themeCenter.b bVar) {
        h hVar;
        com.baidu.tieba.themeCenter.d dVar;
        boolean z;
        com.baidu.tieba.themeCenter.d dVar2;
        DownloadedThemeListActivity downloadedThemeListActivity = this.dgK;
        hVar = this.dgK.dgE;
        downloadedThemeListActivity.dgG = hVar.isInEditMode();
        dVar = this.dgK.dfR;
        if (dVar != null) {
            z = this.dgK.dgG;
            if (!z && skinItemView != null && bVar != null && bVar.getId() > 0) {
                dVar2 = this.dgK.dfR;
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
        DownloadedThemeListActivity downloadedThemeListActivity = this.dgK;
        hVar = this.dgK.dgE;
        downloadedThemeListActivity.dgG = hVar.isInEditMode();
        dVar = this.dgK.dfR;
        if (dVar != null) {
            z = this.dgK.dgG;
            if (!z && skinProgressView != null && bVar != null) {
                dVar2 = this.dgK.dfR;
                dVar2.b(skinProgressView, bVar);
            }
        }
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(View view, com.baidu.tieba.themeCenter.b bVar) {
        com.baidu.tieba.themeCenter.d dVar;
        com.baidu.tieba.themeCenter.d dVar2;
        dVar = this.dgK.dfR;
        if (dVar != null && bVar != null && bVar.getId() > 0) {
            dVar2 = this.dgK.dfR;
            dVar2.c(bVar);
        }
    }
}
