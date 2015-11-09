package com.baidu.tieba.themeCenter;

import android.view.View;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
class e implements SkinItemView.a {
    final /* synthetic */ d dgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dgm = dVar;
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(SkinItemView skinItemView, b bVar) {
        if (skinItemView != null && bVar != null && bVar.getId() > 0) {
            this.dgm.b(bVar);
        }
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(SkinProgressView skinProgressView, b bVar) {
        this.dgm.b(skinProgressView, bVar);
    }

    @Override // com.baidu.tieba.themeCenter.SkinItemView.a
    public void a(View view, b bVar) {
        this.dgm.c(bVar);
    }
}
