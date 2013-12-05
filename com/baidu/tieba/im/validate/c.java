package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ValidateActivity validateActivity) {
        this.f1896a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Integer num) {
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.a aVar;
        this.f1896a.j = num.intValue();
        i = this.f1896a.j;
        if (i > 0) {
            this.f1896a.m = true;
            i2 = this.f1896a.k;
            i3 = this.f1896a.l;
            aVar = this.f1896a.c;
            l.a(i2, i3, aVar);
        }
    }
}
