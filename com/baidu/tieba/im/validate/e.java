package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ ValidateActivity biR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.biR = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.a aVar;
        this.biR.totalCount = num.intValue();
        i = this.biR.totalCount;
        if (i > 0) {
            this.biR.isLoading = true;
            i2 = this.biR.biP;
            i3 = this.biR.offset;
            aVar = this.biR.bbO;
            l.a(i2, i3, aVar);
        }
    }
}
