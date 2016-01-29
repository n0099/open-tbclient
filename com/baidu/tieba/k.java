package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ LogoActivity aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.aHJ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aHJ.getPageContext();
        l lVar = new l(this);
        relativeLayout = this.aHJ.mRootView;
        p.a(pageContext, lVar, relativeLayout);
    }
}
