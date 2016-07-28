package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag fRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.fRl = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.fRl.fRj;
        oVar = this.fRl.fPM;
        List<d> biV = oVar.biV();
        oVar2 = this.fRl.fPM;
        aVar.b(biV, oVar2.bnx());
        aVar2 = this.fRl.fRj;
        navigationBar = this.fRl.mNavigationBar;
        aVar2.aJ(navigationBar);
    }
}
