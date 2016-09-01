package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag gbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.gbq = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.gbq.gbo;
        oVar = this.gbq.fZQ;
        List<d> bmF = oVar.bmF();
        oVar2 = this.gbq.fZQ;
        aVar.b(bmF, oVar2.brN());
        aVar2 = this.gbq.gbo;
        navigationBar = this.gbq.mNavigationBar;
        aVar2.aJ(navigationBar);
    }
}
