package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cKY;
    private final /* synthetic */ boolean cKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cKY = cVar;
        this.cKZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.cKY.cKX;
        iVar = secretSettingActivity.cKK;
        iVar.fT(!this.cKZ);
    }
}
