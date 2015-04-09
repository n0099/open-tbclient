package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.i {
    final /* synthetic */ t bxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bxw = tVar;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        if (obj == null) {
            newUserGuideActivity3 = this.bxw.bxt;
            newUserGuideActivity3.showToast(y.neterror);
        } else if (obj instanceof ah) {
            int i = com.baidu.adp.lib.g.c.toInt(((ah) obj).getFid(), 0);
            aVar = this.bxw.bxu;
            aVar.gH(i);
            this.bxw.o(i, true);
            newUserGuideActivity = this.bxw.bxt;
            newUserGuideActivity.dm(true);
            newUserGuideActivity2 = this.bxw.bxt;
            newUserGuideActivity2.dl(true);
        }
    }
}
