package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ SignAllForumAdvertActivity ejS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SignAllForumAdvertActivity signAllForumAdvertActivity) {
        this.ejS = signAllForumAdvertActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.signall.SignAllForumAdvertActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bg ut = bg.ut();
        TbPageContext<?> pageContext = this.ejS.getPageContext();
        str = this.ejS.ejP;
        ut.c(pageContext, new String[]{str});
    }
}
