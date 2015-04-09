package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bZF;
    private final /* synthetic */ boolean bZG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.bZF = cVar;
        this.bZG = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        g gVar;
        secretSettingActivity = this.bZF.bZE;
        gVar = secretSettingActivity.bZy;
        gVar.eo(!this.bZG);
    }
}
