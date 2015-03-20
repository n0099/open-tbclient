package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.model.ValidateModel;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ ValidateActivity bnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity, int i) {
        super(i);
        this.bnG = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        p pVar;
        p pVar2;
        if (customResponsedMessage instanceof PushMessage) {
            GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
            ValidateActivity validateActivity = this.bnG;
            i = validateActivity.offset;
            validateActivity.offset = i + 1;
            ValidateActivity validateActivity2 = this.bnG;
            i2 = validateActivity2.totalCount;
            validateActivity2.totalCount = i2 + 1;
            ValidateItemData convertToValidateItemData = ValidateModel.convertToValidateItemData(p);
            pVar = this.bnG.bnA;
            pVar.TE().getDatas().add(0, convertToValidateItemData);
            pVar2 = this.bnG.bnA;
            pVar2.TE().notifyDataSetChanged();
        }
    }
}
