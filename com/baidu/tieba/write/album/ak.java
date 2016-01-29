package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag eog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.eog = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.eog.eod;
        oVar = this.eog.emG;
        List<d> aPn = oVar.aPn();
        oVar2 = this.eog.emG;
        aVar.d(aPn, oVar2.aSJ());
        aVar2 = this.eog.eod;
        navigationBar = this.eog.mNavigationBar;
        aVar2.ao(navigationBar);
    }
}
