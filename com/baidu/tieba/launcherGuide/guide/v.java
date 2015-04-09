package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tieba.tbadkCore.ay;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ay {
    final /* synthetic */ t bxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bxw = tVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void d(String str, long j) {
        a aVar;
        int i = com.baidu.adp.lib.g.c.toInt(String.valueOf(j), 0);
        aVar = this.bxw.bxu;
        aVar.gI(i);
        this.bxw.o(i, false);
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void e(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.bxw.bxt;
        newUserGuideActivity.showToast(y.error);
    }
}
