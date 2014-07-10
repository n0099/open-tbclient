package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bb;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c a;
    private String b;
    private String c;

    public d(c cVar) {
        this.a = cVar;
        b(null);
        a(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (this.b != null && this.b.length() > 0) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.a.a;
            messageManager.sendMessage(new CustomMessage(2002003, new bb(context, this.b, this.c)));
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.b = str;
    }
}
