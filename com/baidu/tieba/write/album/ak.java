package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ag fzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.fzH = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.fzH.fzF;
        oVar = this.fzH.fxZ;
        List<d> blK = oVar.blK();
        oVar2 = this.fzH.fxZ;
        aVar.b(blK, oVar2.blI());
        aVar2 = this.fzH.fzF;
        navigationBar = this.fzH.mNavigationBar;
        aVar2.aH(navigationBar);
    }
}
