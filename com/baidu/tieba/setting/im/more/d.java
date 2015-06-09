package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cdY;
    private final /* synthetic */ boolean cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cdY = cVar;
        this.cdZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.cdY.cdX;
        iVar = secretSettingActivity.cdL;
        iVar.eF(!this.cdZ);
    }
}
