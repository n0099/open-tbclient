package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ba;
/* loaded from: classes.dex */
class k implements d {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // com.baidu.tieba.d
    public void a(Object obj) {
        if (obj != null) {
            this.a.b(com.baidu.adp.lib.e.c.a(String.valueOf(obj), 0));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ba(this.a, ba.c)));
        this.a.finish();
    }
}
