package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ValidateActivity validateActivity) {
        this.f1894a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        boolean z;
        n nVar;
        z = this.f1894a.i;
        if (!z) {
            nVar = this.f1894a.b;
            nVar.a(false);
        }
        com.baidu.tieba.im.pushNotify.a.a((com.baidu.tieba.im.a<Void>) null);
    }
}
