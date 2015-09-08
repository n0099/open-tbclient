package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ ad cZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ad adVar) {
        this.cZQ = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        m mVar;
        m mVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.cZQ.cZO;
        mVar = this.cZQ.cYt;
        List<b> ayh = mVar.ayh();
        mVar2 = this.cZQ.cYt;
        aVar.c(ayh, mVar2.ayf());
        aVar2 = this.cZQ.cZO;
        navigationBar = this.cZQ.mNavigationBar;
        aVar2.N(navigationBar);
    }
}
