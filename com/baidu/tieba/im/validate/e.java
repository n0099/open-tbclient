package com.baidu.tieba.im.validate;
/* loaded from: classes.dex */
final class e implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.a aVar;
        this.a.j = num.intValue();
        i = this.a.j;
        if (i > 0) {
            this.a.m = true;
            i2 = this.a.k;
            i3 = this.a.l;
            aVar = this.a.c;
            n.a(i2, i3, aVar);
        }
    }
}
