package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ b cfm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cfm = bVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        PbChosenActivity pbChosenActivity;
        com.baidu.tieba.tbadkCore.w wVar;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        com.baidu.tieba.tbadkCore.w wVar2;
        pbChosenActivity = this.cfm.cfl;
        wVar = pbChosenActivity.ceW;
        if (AntiHelper.lc(wVar.getErrorCode())) {
            pbChosenActivity2 = this.cfm.cfl;
            Activity activity = pbChosenActivity2.getActivity();
            pbChosenActivity3 = this.cfm.cfl;
            wVar2 = pbChosenActivity3.ceW;
            AntiHelper.P(activity, wVar2.getErrorString());
        }
    }
}
