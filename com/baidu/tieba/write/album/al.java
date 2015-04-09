package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ah cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar) {
        this.cuX = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        n nVar;
        n nVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.cuX.cuV;
        nVar = this.cuX.ctF;
        List<a> aqa = nVar.aqa();
        nVar2 = this.cuX.ctF;
        aVar.c(aqa, nVar2.apY());
        aVar2 = this.cuX.cuV;
        navigationBar = this.cuX.mNavigationBar;
        aVar2.F(navigationBar);
    }
}
