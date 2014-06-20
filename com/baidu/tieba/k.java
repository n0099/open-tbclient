package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
            this.a.b(com.baidu.adp.lib.f.b.a(String.valueOf(obj), 0));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ap(this.a, com.baidu.tbadk.core.atomData.ap.c)));
        this.a.finish();
    }
}
