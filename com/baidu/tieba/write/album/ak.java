package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag gle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.gle = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.gle.glc;
        oVar = this.gle.gjE;
        List<d> bpH = oVar.bpH();
        oVar2 = this.gle.gjE;
        aVar.b(bpH, oVar2.buO());
        aVar2 = this.gle.glc;
        navigationBar = this.gle.mNavigationBar;
        aVar2.aH(navigationBar);
    }
}
