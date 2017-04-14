package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ LogoActivity aQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.aQg = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQg.getPageContext();
        m mVar = new m(this);
        relativeLayout = this.aQg.mRootView;
        s.a(pageContext, mVar, relativeLayout);
    }
}
