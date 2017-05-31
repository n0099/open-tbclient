package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ LogoActivity aQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.aQD = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQD.getPageContext();
        n nVar = new n(this);
        relativeLayout = this.aQD.mRootView;
        s.a(pageContext, nVar, relativeLayout);
    }
}
