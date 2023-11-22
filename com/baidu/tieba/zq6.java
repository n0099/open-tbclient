package com.baidu.tieba;

import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
/* loaded from: classes9.dex */
public interface zq6 {

    /* loaded from: classes9.dex */
    public interface a {
        void onProgress(long j);
    }

    /* loaded from: classes9.dex */
    public interface b {
        boolean a(String str);

        boolean b();
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(boolean z, String str);
    }

    boolean a(QmFilterItem qmFilterItem);

    boolean b(QmStickerItem qmStickerItem);

    boolean c();

    boolean d();

    if6 e();

    ff6 f();

    void g(c cVar);

    boolean onDestroy();

    boolean onPause();

    boolean onResume();

    boolean startRecord();

    boolean stopRecord();
}
