package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.model.ValidateModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.g<Integer> {
    final /* synthetic */ ValidateActivity bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ValidateActivity validateActivity) {
        this.bpQ = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.g gVar;
        this.bpQ.totalCount = num.intValue();
        i = this.bpQ.totalCount;
        if (i > 0) {
            this.bpQ.aeC = true;
            i2 = this.bpQ.bpO;
            i3 = this.bpQ.offset;
            gVar = this.bpQ.getDataCallBack;
            ValidateModel.requestValidateDataFromDB(i2, i3, gVar);
        }
    }
}
