package com;

import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
/* loaded from: classes.dex */
public class bi implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchButton b;

    public bi(SwitchButton switchButton, boolean z) {
        this.b = switchButton;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.setChecked(this.a);
    }
}
