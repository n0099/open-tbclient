package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.gdz = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.gdz.gdx;
        oVar = this.gdz.gbZ;
        List<d> bnn = oVar.bnn();
        oVar2 = this.gdz.gbZ;
        aVar.b(bnn, oVar2.bst());
        aVar2 = this.gdz.gdx;
        navigationBar = this.gdz.mNavigationBar;
        aVar2.aI(navigationBar);
    }
}
