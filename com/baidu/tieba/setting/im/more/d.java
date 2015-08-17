package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cvB;
    private final /* synthetic */ boolean cvC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cvB = cVar;
        this.cvC = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.cvB.cvA;
        iVar = secretSettingActivity.cvn;
        iVar.eX(!this.cvC);
    }
}
