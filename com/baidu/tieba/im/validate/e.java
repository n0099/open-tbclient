package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.model.ValidateModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<Integer> {
    final /* synthetic */ ValidateActivity bnW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.bnW = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: c */
    public void onReturnDataInUI(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.g gVar;
        this.bnW.totalCount = num.intValue();
        i = this.bnW.totalCount;
        if (i > 0) {
            this.bnW.anb = true;
            i2 = this.bnW.bnU;
            i3 = this.bnW.offset;
            gVar = this.bnW.getDataCallBack;
            ValidateModel.requestValidateDataFromDB(i2, i3, gVar);
        }
    }
}
