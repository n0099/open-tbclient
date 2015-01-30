package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ValidateActivity bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.bpQ = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        boolean z;
        m mVar;
        z = this.bpQ.bpN;
        if (!z) {
            mVar = this.bpQ.bpK;
            mVar.setLoadProgressBarVisable(false);
        }
    }
}
