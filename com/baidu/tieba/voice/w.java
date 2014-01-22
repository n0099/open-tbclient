package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c.a.a(4, this.a.c.d.getString(R.string.voice_error_file_md5));
        this.a.c.H = 1;
    }
}
