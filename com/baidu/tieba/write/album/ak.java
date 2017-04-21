package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag fQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.fQJ = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.fQJ.fQH;
        oVar = this.fQJ.fPd;
        List<d> boG = oVar.boG();
        oVar2 = this.fQJ.fPd;
        aVar.b(boG, oVar2.boE());
        aVar2 = this.fQJ.fQH;
        navigationBar = this.fQJ.mNavigationBar;
        aVar2.aH(navigationBar);
    }
}
