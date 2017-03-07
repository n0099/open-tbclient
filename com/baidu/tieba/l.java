package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ LogoActivity aPQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.aPQ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aPQ.getPageContext();
        m mVar = new m(this);
        relativeLayout = this.aPQ.mRootView;
        s.a(pageContext, mVar, relativeLayout);
    }
}
