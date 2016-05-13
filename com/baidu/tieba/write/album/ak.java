package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag eYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.eYU = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.eYU.eYS;
        oVar = this.eYU.eXw;
        List<d> aXu = oVar.aXu();
        oVar2 = this.eYU.eXw;
        aVar.b(aXu, oVar2.bbF());
        aVar2 = this.eYU.eYS;
        navigationBar = this.eYU.mNavigationBar;
        aVar2.aD(navigationBar);
    }
}
