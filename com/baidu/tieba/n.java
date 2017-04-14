package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ LogoActivity aQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aQg = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQg.getPageContext();
        o oVar = new o(this);
        relativeLayout = this.aQg.mRootView;
        s.a(pageContext, oVar, relativeLayout);
    }
}
