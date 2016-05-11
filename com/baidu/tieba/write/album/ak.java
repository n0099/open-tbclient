package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag eYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.eYV = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.eYV.eYT;
        oVar = this.eYV.eXx;
        List<d> aXo = oVar.aXo();
        oVar2 = this.eYV.eXx;
        aVar.b(aXo, oVar2.bby());
        aVar2 = this.eYV.eYT;
        navigationBar = this.eYV.mNavigationBar;
        aVar2.aD(navigationBar);
    }
}
