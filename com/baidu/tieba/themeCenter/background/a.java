package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ BackgroundGroupActivity deY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BackgroundGroupActivity backgroundGroupActivity) {
        this.deY = backgroundGroupActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.d.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list) {
        g gVar;
        g gVar2;
        g gVar3;
        BackgroundGroupActivity backgroundGroupActivity = this.deY;
        gVar = this.deY.deV;
        backgroundGroupActivity.hideLoadingView(gVar.getRootView());
        if (i == 0) {
            gVar2 = this.deY.deV;
            gVar2.a(kVar, list);
            return;
        }
        this.deY.showToast(str);
        gVar3 = this.deY.deV;
        gVar3.Kr();
    }
}
