package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag eIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.eIc = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.eIc.eIa;
        oVar = this.eIc.eGD;
        List<d> aWv = oVar.aWv();
        oVar2 = this.eIc.eGD;
        aVar.b(aWv, oVar2.aZj());
        aVar2 = this.eIc.eIa;
        navigationBar = this.eIc.mNavigationBar;
        aVar2.az(navigationBar);
    }
}
