package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ValidateActivity bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ValidateActivity validateActivity) {
        this.bjf = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        boolean z;
        r rVar;
        z = this.bjf.bjc;
        if (!z) {
            rVar = this.bjf.biZ;
            rVar.dg(false);
        }
    }
}
