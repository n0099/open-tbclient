package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cLx;
    private final /* synthetic */ boolean cLy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cLx = cVar;
        this.cLy = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.cLx.cLw;
        iVar = secretSettingActivity.cLj;
        iVar.fT(!this.cLy);
    }
}
