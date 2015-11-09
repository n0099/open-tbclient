package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ SecretSettingActivity cMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SecretSettingActivity secretSettingActivity) {
        this.cMS = secretSettingActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        iVar = this.cMS.cMF;
        iVar.fY(false);
    }
}
