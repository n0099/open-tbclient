package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1717a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ValidateActivity validateActivity) {
        this.f1717a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        boolean z;
        m mVar;
        z = this.f1717a.k;
        if (!z) {
            mVar = this.f1717a.b;
            mVar.a(false);
        }
        com.baidu.tieba.im.pushNotify.a.a((com.baidu.tieba.im.a<Void>) null);
    }
}
