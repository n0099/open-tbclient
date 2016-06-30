package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag fDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.fDY = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.fDY.fDW;
        oVar = this.fDY.fCA;
        List<d> bfE = oVar.bfE();
        oVar2 = this.fDY.fCA;
        aVar.b(bfE, oVar2.bkb());
        aVar2 = this.fDY.fDW;
        navigationBar = this.fDY.mNavigationBar;
        aVar2.aL(navigationBar);
    }
}
