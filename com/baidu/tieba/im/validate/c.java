package com.baidu.tieba.im.validate;
/* loaded from: classes.dex */
final class c implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        boolean z;
        t tVar;
        z = this.a.i;
        if (!z) {
            tVar = this.a.b;
            tVar.a(false);
        }
        com.baidu.tieba.im.pushNotify.a.a((com.baidu.tieba.im.a<Void>) null);
    }
}
