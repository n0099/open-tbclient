package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
final class b extends com.baidu.adp.framework.c.a {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity, int i) {
        super(2001129);
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        t tVar;
        t tVar2;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof PushMessage) {
            GroupNewsPojo b = ((PushMessage) customResponsedMessage2).b();
            ValidateActivity validateActivity = this.a;
            i = validateActivity.l;
            validateActivity.l = i + 1;
            ValidateActivity validateActivity2 = this.a;
            i2 = validateActivity2.j;
            validateActivity2.j = i2 + 1;
            ValidateItemData a = n.a(b);
            tVar = this.a.b;
            tVar.e().b().add(0, a);
            tVar2 = this.a.b;
            tVar2.e().notifyDataSetChanged();
        }
    }
}
