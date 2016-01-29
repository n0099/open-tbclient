package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ SecretSettingActivity dIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SecretSettingActivity secretSettingActivity) {
        this.dIu = secretSettingActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        iVar = this.dIu.dIi;
        iVar.hw(false);
    }
}
