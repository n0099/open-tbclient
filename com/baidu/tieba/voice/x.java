package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f2597a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2597a.c.f2553a.b(4, this.f2597a.c.d.getString(R.string.voice_error_file_md5));
        this.f2597a.c.H = 1;
    }
}
