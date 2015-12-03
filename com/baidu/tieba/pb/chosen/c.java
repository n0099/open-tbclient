package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ b cyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cyp = bVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        PbChosenActivity pbChosenActivity;
        com.baidu.tieba.tbadkCore.x xVar;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        com.baidu.tieba.tbadkCore.x xVar2;
        pbChosenActivity = this.cyp.cyo;
        xVar = pbChosenActivity.cxX;
        if (AntiHelper.mC(xVar.getErrorCode())) {
            pbChosenActivity2 = this.cyp.cyo;
            Activity activity = pbChosenActivity2.getActivity();
            pbChosenActivity3 = this.cyp.cyo;
            xVar2 = pbChosenActivity3.cxX;
            AntiHelper.Q(activity, xVar2.getErrorString());
        }
    }
}
