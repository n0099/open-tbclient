package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag fIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.fIk = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.fIk.fIi;
        oVar = this.fIk.fGE;
        List<d> bni = oVar.bni();
        oVar2 = this.fIk.fGE;
        aVar.b(bni, oVar2.bng());
        aVar2 = this.fIk.fIi;
        navigationBar = this.fIk.mNavigationBar;
        aVar2.aL(navigationBar);
    }
}
