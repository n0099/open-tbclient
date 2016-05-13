package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity dEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonPostActivity personPostActivity) {
        this.dEo = personPostActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.person.post.PersonPostActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg.ut().c(this.dEo.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
    }
}
