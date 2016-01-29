package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ SignAllForumAdvertActivity dOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SignAllForumAdvertActivity signAllForumAdvertActivity) {
        this.dOi = signAllForumAdvertActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.signall.SignAllForumAdvertActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        be wt = be.wt();
        TbPageContext<?> pageContext = this.dOi.getPageContext();
        str = this.dOi.dOf;
        wt.c(pageContext, new String[]{str});
    }
}
