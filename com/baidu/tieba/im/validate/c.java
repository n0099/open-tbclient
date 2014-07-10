package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        boolean z;
        t tVar;
        z = this.a.i;
        if (!z) {
            tVar = this.a.b;
            tVar.a(false);
        }
        com.baidu.tieba.im.pushNotify.a.b((com.baidu.tieba.im.a<Void>) null);
    }
}
