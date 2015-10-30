package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ac dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar) {
        this.dlo = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        l lVar;
        l lVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.dlo.dlm;
        lVar = this.dlo.djP;
        List<a> aBr = lVar.aBr();
        lVar2 = this.dlo.djP;
        aVar.c(aBr, lVar2.aBp());
        aVar2 = this.dlo.dlm;
        navigationBar = this.dlo.mNavigationBar;
        aVar2.P(navigationBar);
    }
}
