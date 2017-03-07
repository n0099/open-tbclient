package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag fME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.fME = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.fME.fMC;
        oVar = this.fME.fKY;
        List<d> bmV = oVar.bmV();
        oVar2 = this.fME.fKY;
        aVar.b(bmV, oVar2.bmT());
        aVar2 = this.fME.fMC;
        navigationBar = this.fME.mNavigationBar;
        aVar2.aJ(navigationBar);
    }
}
