package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f2631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f2631a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2631a.c.f2590a.b(4, this.f2631a.c.d.getString(R.string.voice_error_file_md5));
        this.f2631a.c.H = 1;
    }
}
