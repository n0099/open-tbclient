package com.baidu.tieba.setting.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c dIv;
    private final /* synthetic */ boolean dIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.dIv = cVar;
        this.dIw = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        i iVar;
        secretSettingActivity = this.dIv.dIu;
        iVar = secretSettingActivity.dIi;
        iVar.hu(!this.dIw);
    }
}
