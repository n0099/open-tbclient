package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ah cuH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar) {
        this.cuH = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        n nVar;
        n nVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.cuH.cuF;
        nVar = this.cuH.ctp;
        List<a> apL = nVar.apL();
        nVar2 = this.cuH.ctp;
        aVar.c(apL, nVar2.apJ());
        aVar2 = this.cuH.cuF;
        navigationBar = this.cuH.mNavigationBar;
        aVar2.F(navigationBar);
    }
}
