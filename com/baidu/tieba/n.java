package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ LogoActivity aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aQB = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQB.getPageContext();
        o oVar = new o(this);
        relativeLayout = this.aQB.mRootView;
        s.a(pageContext, oVar, relativeLayout);
    }
}
