package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ LogoActivity aQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.aQD = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aQD.getPageContext();
        l lVar = new l(this);
        relativeLayout = this.aQD.mRootView;
        s.a(pageContext, lVar, relativeLayout);
    }
}
