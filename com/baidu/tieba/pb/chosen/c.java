package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ b cIB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cIB = bVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        PbChosenActivity pbChosenActivity;
        com.baidu.tieba.tbadkCore.w wVar;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        com.baidu.tieba.tbadkCore.w wVar2;
        pbChosenActivity = this.cIB.cIA;
        wVar = pbChosenActivity.cIk;
        if (AntiHelper.or(wVar.getErrorCode())) {
            pbChosenActivity2 = this.cIB.cIA;
            Activity activity = pbChosenActivity2.getActivity();
            pbChosenActivity3 = this.cIB.cIA;
            wVar2 = pbChosenActivity3.cIk;
            AntiHelper.X(activity, wVar2.getErrorString());
        }
    }
}
