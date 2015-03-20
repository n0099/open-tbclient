package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.model.ValidateModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<Integer> {
    final /* synthetic */ ValidateActivity bnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.bnG = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: c */
    public void onReturnDataInUI(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.g gVar;
        this.bnG.totalCount = num.intValue();
        i = this.bnG.totalCount;
        if (i > 0) {
            this.bnG.amT = true;
            i2 = this.bnG.bnE;
            i3 = this.bnG.offset;
            gVar = this.bnG.getDataCallBack;
            ValidateModel.requestValidateDataFromDB(i2, i3, gVar);
        }
    }
}
