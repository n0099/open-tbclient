package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f2749a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f2749a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2749a.c.f2708a.b(4, this.f2749a.c.d.getString(R.string.voice_error_file_md5));
        this.f2749a.c.H = 1;
    }
}
