package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity, int i) {
        super(i);
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        r rVar;
        r rVar2;
        if (customResponsedMessage instanceof PushMessage) {
            GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
            ValidateActivity validateActivity = this.a;
            i = validateActivity.j;
            validateActivity.j = i + 1;
            ValidateActivity validateActivity2 = this.a;
            i2 = validateActivity2.h;
            validateActivity2.h = i2 + 1;
            ValidateItemData a = l.a(p);
            rVar = this.a.b;
            rVar.c().b().add(0, a);
            rVar2 = this.a.b;
            rVar2.c().notifyDataSetChanged();
        }
    }
}
