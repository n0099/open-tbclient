package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ LogoActivity aHs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.aHs = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aHs.getPageContext();
        k kVar = new k(this);
        relativeLayout = this.aHs.mRootView;
        q.a(pageContext, kVar, relativeLayout);
    }
}
