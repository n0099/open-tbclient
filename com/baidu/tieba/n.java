package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ LogoActivity aPQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aPQ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aPQ.getPageContext();
        o oVar = new o(this);
        relativeLayout = this.aPQ.mRootView;
        s.a(pageContext, oVar, relativeLayout);
    }
}
