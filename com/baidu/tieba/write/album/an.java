package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ aj czq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar) {
        this.czq = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        p pVar;
        p pVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.czq.czo;
        pVar = this.czq.cxV;
        List<a> arR = pVar.arR();
        pVar2 = this.czq.cxV;
        aVar.b(arR, pVar2.arP());
        aVar2 = this.czq.czo;
        navigationBar = this.czq.mNavigationBar;
        aVar2.I(navigationBar);
    }
}
