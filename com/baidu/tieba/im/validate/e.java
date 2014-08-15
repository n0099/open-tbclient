package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.a aVar;
        this.a.h = num.intValue();
        i = this.a.h;
        if (i > 0) {
            this.a.k = true;
            i2 = this.a.i;
            i3 = this.a.j;
            aVar = this.a.c;
            l.a(i2, i3, aVar);
        }
    }
}
