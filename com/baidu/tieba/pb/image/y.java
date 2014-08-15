package com.baidu.tieba.pb.image;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bg;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, String str, String str2) {
        this.a = xVar;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.c;
        messageManager.sendMessage(new CustomMessage(2002003, new bg(context, String.valueOf(this.b), this.c)));
    }
}
