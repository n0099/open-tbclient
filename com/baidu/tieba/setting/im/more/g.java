package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ SecretSettingActivity dsq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SecretSettingActivity secretSettingActivity) {
        this.dsq = secretSettingActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        iVar = this.dsq.dse;
        iVar.gW(false);
    }
}
