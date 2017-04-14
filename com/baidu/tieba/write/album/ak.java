package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag fOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.fOn = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.fOn.fOl;
        oVar = this.fOn.fMH;
        List<d> bnF = oVar.bnF();
        oVar2 = this.fOn.fMH;
        aVar.b(bnF, oVar2.bnD());
        aVar2 = this.fOn.fOl;
        navigationBar = this.fOn.mNavigationBar;
        aVar2.aH(navigationBar);
    }
}
