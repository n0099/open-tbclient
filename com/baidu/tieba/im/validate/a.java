package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        boolean z;
        n nVar;
        z = this.a.i;
        if (!z) {
            nVar = this.a.b;
            nVar.a(false);
        }
        com.baidu.tieba.im.c.a.a((com.baidu.tieba.im.a<Void>) null);
    }
}
