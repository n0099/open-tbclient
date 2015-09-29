package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ b cfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cfb = bVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        PbChosenActivity pbChosenActivity;
        com.baidu.tieba.tbadkCore.w wVar;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        com.baidu.tieba.tbadkCore.w wVar2;
        pbChosenActivity = this.cfb.cfa;
        wVar = pbChosenActivity.ceL;
        if (AntiHelper.la(wVar.getErrorCode())) {
            pbChosenActivity2 = this.cfb.cfa;
            Activity activity = pbChosenActivity2.getActivity();
            pbChosenActivity3 = this.cfb.cfa;
            wVar2 = pbChosenActivity3.ceL;
            AntiHelper.P(activity, wVar2.getErrorString());
        }
    }
}
