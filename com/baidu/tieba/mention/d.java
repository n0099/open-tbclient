package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.ax;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.write.AtListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        com.baidu.tieba.k kVar;
        com.baidu.tieba.k kVar2;
        imageView = this.a.l;
        if (view == imageView && TiebaApplication.B()) {
            kVar = this.a.s;
            cb.a(kVar, "msg_newchat_tab_c", "click", 1, new Object[0]);
            new ax("pchat", "2").start();
            kVar2 = this.a.s;
            AtListActivity.a(kVar2, 12011, false);
        }
    }
}
