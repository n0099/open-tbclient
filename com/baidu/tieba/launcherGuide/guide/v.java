package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tieba.tbadkCore.ay;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ay {
    final /* synthetic */ t bxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bxg = tVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void d(String str, long j) {
        a aVar;
        int i = com.baidu.adp.lib.g.c.toInt(String.valueOf(j), 0);
        aVar = this.bxg.bxe;
        aVar.gG(i);
        this.bxg.o(i, false);
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void e(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.bxg.bxd;
        newUserGuideActivity.showToast(y.error);
    }
}
