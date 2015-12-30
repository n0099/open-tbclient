package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag dTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.dTB = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.dTB.dTz;
        oVar = this.dTB.dRW;
        List<d> aJZ = oVar.aJZ();
        oVar2 = this.dTB.dRW;
        aVar.d(aJZ, oVar2.aJX());
        aVar2 = this.dTB.dTz;
        navigationBar = this.dTB.mNavigationBar;
        aVar2.aa(navigationBar);
    }
}
