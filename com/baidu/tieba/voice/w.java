package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f2648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f2648a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2648a.c.f2607a.b(4, this.f2648a.c.d.getString(R.string.voice_error_file_md5));
        this.f2648a.c.H = 1;
    }
}
