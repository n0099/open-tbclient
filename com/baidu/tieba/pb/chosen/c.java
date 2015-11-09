package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ b cfN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cfN = bVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        PbChosenActivity pbChosenActivity;
        com.baidu.tieba.tbadkCore.w wVar;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        com.baidu.tieba.tbadkCore.w wVar2;
        pbChosenActivity = this.cfN.cfM;
        wVar = pbChosenActivity.cfx;
        if (AntiHelper.lr(wVar.getErrorCode())) {
            pbChosenActivity2 = this.cfN.cfM;
            Activity activity = pbChosenActivity2.getActivity();
            pbChosenActivity3 = this.cfN.cfM;
            wVar2 = pbChosenActivity3.cfx;
            AntiHelper.Q(activity, wVar2.getErrorString());
        }
    }
}
