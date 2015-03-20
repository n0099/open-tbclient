package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bZq;
    private final /* synthetic */ boolean bZr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.bZq = cVar;
        this.bZr = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        g gVar;
        secretSettingActivity = this.bZq.bZp;
        gVar = secretSettingActivity.bZj;
        gVar.eq(!this.bZr);
    }
}
