package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.model.ValidateModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.g<Integer> {
    final /* synthetic */ ValidateActivity bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ValidateActivity validateActivity) {
        this.bpP = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.g gVar;
        this.bpP.totalCount = num.intValue();
        i = this.bpP.totalCount;
        if (i > 0) {
            this.bpP.aez = true;
            i2 = this.bpP.bpN;
            i3 = this.bpP.offset;
            gVar = this.bpP.getDataCallBack;
            ValidateModel.requestValidateDataFromDB(i2, i3, gVar);
        }
    }
}
