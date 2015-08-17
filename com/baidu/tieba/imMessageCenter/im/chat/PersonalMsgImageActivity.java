package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.c.ad;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
/* loaded from: classes.dex */
public class PersonalMsgImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, ad adVar) {
        com.baidu.tieba.im.c.a.Ws().c(str, adVar);
    }
}
