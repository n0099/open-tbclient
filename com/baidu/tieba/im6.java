package com.baidu.tieba;

import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
/* loaded from: classes4.dex */
public interface im6 {

    /* loaded from: classes4.dex */
    public interface a {
        void onProgress(long j);
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(String str);

        boolean b();
    }

    boolean a(QmFilterItem qmFilterItem);

    boolean b(QmStickerItem qmStickerItem);

    boolean c();

    boolean d();

    mc6 e();

    jc6 f();

    boolean onDestroy();

    boolean onPause();

    boolean onResume();

    boolean startRecord();

    boolean stopRecord();
}
