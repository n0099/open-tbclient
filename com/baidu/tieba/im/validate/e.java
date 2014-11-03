package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ ValidateActivity bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.bjf = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.a aVar;
        this.bjf.totalCount = num.intValue();
        i = this.bjf.totalCount;
        if (i > 0) {
            this.bjf.isLoading = true;
            i2 = this.bjf.bjd;
            i3 = this.bjf.offset;
            aVar = this.bjf.bcc;
            l.a(i2, i3, aVar);
        }
    }
}
