package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ac dkO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar) {
        this.dkO = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        l lVar;
        l lVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.dkO.dkM;
        lVar = this.dkO.djp;
        List<a> aBl = lVar.aBl();
        lVar2 = this.dkO.djp;
        aVar.c(aBl, lVar2.aBj());
        aVar2 = this.dkO.dkM;
        navigationBar = this.dkO.mNavigationBar;
        aVar2.P(navigationBar);
    }
}
