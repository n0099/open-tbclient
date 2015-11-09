package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cMT;
    private final /* synthetic */ boolean cMU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cMT = cVar;
        this.cMU = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.cMT.cMS;
        iVar = secretSettingActivity.cMF;
        iVar.fW(!this.cMU);
    }
}
