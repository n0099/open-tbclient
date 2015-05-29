package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ aj czp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar) {
        this.czp = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        p pVar;
        p pVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.czp.czn;
        pVar = this.czp.cxU;
        List<a> arQ = pVar.arQ();
        pVar2 = this.czp.cxU;
        aVar.b(arQ, pVar2.arO());
        aVar2 = this.czp.czn;
        navigationBar = this.czp.mNavigationBar;
        aVar2.I(navigationBar);
    }
}
