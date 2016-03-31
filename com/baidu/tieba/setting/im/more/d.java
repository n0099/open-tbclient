package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c eaP;
    private final /* synthetic */ boolean eaQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.eaP = cVar;
        this.eaQ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.eaP.eaO;
        iVar = secretSettingActivity.eaC;
        iVar.ii(!this.eaQ);
    }
}
