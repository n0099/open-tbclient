package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f2023a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.f2023a = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar;
        r rVar2;
        r rVar3;
        rVar = this.f2023a.f2060a;
        ad adVar = rVar.f2041a;
        rVar2 = this.f2023a.f2060a;
        adVar.a(4, rVar2.d.getString(R.string.voice_error_file_md5));
        rVar3 = this.f2023a.f2060a;
        rVar3.H = 1;
    }
}
