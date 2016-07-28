package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ LogoActivity aIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.aIj = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aIj.getPageContext();
        m mVar = new m(this);
        relativeLayout = this.aIj.mRootView;
        q.a(pageContext, mVar, relativeLayout);
    }
}
