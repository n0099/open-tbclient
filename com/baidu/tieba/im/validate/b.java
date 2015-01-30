package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.model.ValidateModel;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ ValidateActivity bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity, int i) {
        super(i);
        this.bpQ = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        m mVar;
        m mVar2;
        if (customResponsedMessage instanceof PushMessage) {
            GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
            ValidateActivity validateActivity = this.bpQ;
            i = validateActivity.offset;
            validateActivity.offset = i + 1;
            ValidateActivity validateActivity2 = this.bpQ;
            i2 = validateActivity2.totalCount;
            validateActivity2.totalCount = i2 + 1;
            ValidateItemData convertToValidateItemData = ValidateModel.convertToValidateItemData(p);
            mVar = this.bpQ.bpK;
            mVar.TJ().getDatas().add(0, convertToValidateItemData);
            mVar2 = this.bpQ.bpK;
            mVar2.TJ().notifyDataSetChanged();
        }
    }
}
