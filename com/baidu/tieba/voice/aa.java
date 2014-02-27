package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class aa implements Runnable {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.a.a(4, this.a.a.d.getString(R.string.voice_error_file_md5));
        this.a.a.H = 1;
    }
}
