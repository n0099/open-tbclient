package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ValidateActivity bnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ValidateActivity validateActivity) {
        this.bnG = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        boolean z;
        p pVar;
        z = this.bnG.bnD;
        if (!z) {
            pVar = this.bnG.bnA;
            pVar.setLoadProgressBarVisable(false);
        }
    }
}
