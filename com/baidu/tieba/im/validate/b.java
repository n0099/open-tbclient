package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ ValidateActivity biR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity, int i) {
        super(i);
        this.biR = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        r rVar;
        r rVar2;
        if (customResponsedMessage instanceof PushMessage) {
            GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
            ValidateActivity validateActivity = this.biR;
            i = validateActivity.offset;
            validateActivity.offset = i + 1;
            ValidateActivity validateActivity2 = this.biR;
            i2 = validateActivity2.totalCount;
            validateActivity2.totalCount = i2 + 1;
            ValidateItemData g = l.g(p);
            rVar = this.biR.biL;
            rVar.RS().getDatas().add(0, g);
            rVar2 = this.biR.biL;
            rVar2.RS().notifyDataSetChanged();
        }
    }
}
