package com.baidu.tieba;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ LogoActivity aIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.aIj = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        TbPageContext pageContext = this.aIj.getPageContext();
        k kVar = new k(this);
        relativeLayout = this.aIj.mRootView;
        q.a(pageContext, kVar, relativeLayout);
    }
}
