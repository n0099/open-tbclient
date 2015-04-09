package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ValidateActivity bnW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ValidateActivity validateActivity) {
        this.bnW = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        boolean z;
        p pVar;
        z = this.bnW.bnT;
        if (!z) {
            pVar = this.bnW.bnQ;
            pVar.setLoadProgressBarVisable(false);
        }
    }
}
