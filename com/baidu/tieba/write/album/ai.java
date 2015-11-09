package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ ae dmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ae aeVar) {
        this.dmW = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.view.a aVar;
        m mVar;
        m mVar2;
        com.baidu.tieba.write.view.a aVar2;
        NavigationBar navigationBar;
        aVar = this.dmW.dmU;
        mVar = this.dmW.dlv;
        List<b> aCh = mVar.aCh();
        mVar2 = this.dmW.dlv;
        aVar.c(aCh, mVar2.aCf());
        aVar2 = this.dmW.dmU;
        navigationBar = this.dmW.mNavigationBar;
        aVar2.O(navigationBar);
    }
}
