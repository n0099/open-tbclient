package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ LogoActivity aQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aQi = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQi.getPageContext();
        o oVar = new o(this);
        relativeLayout = this.aQi.mRootView;
        s.a(pageContext, oVar, relativeLayout);
    }
}
