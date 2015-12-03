package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag dMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.dMc = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.dMc.dMa;
        oVar = this.dMc.dKx;
        List<d> aHE = oVar.aHE();
        oVar2 = this.dMc.dKx;
        aVar.d(aHE, oVar2.aHC());
        aVar2 = this.dMc.dMa;
        navigationBar = this.dMc.mNavigationBar;
        aVar2.V(navigationBar);
    }
}
