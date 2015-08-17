package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ ad cRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ad adVar) {
        this.cRf = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        m mVar;
        m mVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.cRf.cRd;
        mVar = this.cRf.cPJ;
        List<b> atO = mVar.atO();
        mVar2 = this.cRf.cPJ;
        aVar.c(atO, mVar2.atM());
        aVar2 = this.cRf.cRd;
        navigationBar = this.cRf.mNavigationBar;
        aVar2.N(navigationBar);
    }
}
