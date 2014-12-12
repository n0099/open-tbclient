package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ValidateActivity bot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.bot = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        boolean z;
        m mVar;
        z = this.bot.boq;
        if (!z) {
            mVar = this.bot.bon;
            mVar.setLoadProgressBarVisable(false);
        }
    }
}
