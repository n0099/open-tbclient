package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.a = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        aa aaVar;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
            aaVar = this.a.a;
            aaVar.c().setHasPrivilege(true);
        }
    }
}
