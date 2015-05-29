package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cdX;
    private final /* synthetic */ boolean cdY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cdX = cVar;
        this.cdY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.cdX.cdW;
        iVar = secretSettingActivity.cdK;
        iVar.eF(!this.cdY);
    }
}
