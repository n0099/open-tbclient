package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        imageView = this.a.h;
        if (view == imageView && TbadkApplication.F()) {
            eVar = this.a.n;
            TiebaStatic.a(eVar, "msg_newchat_tab_c", "click", 1, new Object[0]);
            new ax("pchat", "2").start();
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            eVar2 = this.a.n;
            a.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.c(eVar2, 12011, false)));
        }
    }
}
