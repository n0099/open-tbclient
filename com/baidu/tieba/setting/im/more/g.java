package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ SecretSettingActivity dlj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SecretSettingActivity secretSettingActivity) {
        this.dlj = secretSettingActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        iVar = this.dlj.dkW;
        iVar.gO(false);
    }
}
