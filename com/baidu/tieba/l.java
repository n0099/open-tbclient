package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ LogoActivity aQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.aQi = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQi.getPageContext();
        m mVar = new m(this);
        relativeLayout = this.aQi.mRootView;
        s.a(pageContext, mVar, relativeLayout);
    }
}
