package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
/* loaded from: classes7.dex */
public interface or6 {

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    boolean a(QmFilterItem qmFilterItem);

    void b(a aVar);

    void c(TbMultiMediaData tbMultiMediaData);

    long d();

    void e();

    void f(int i, int i2);

    void g(float f);

    long getCurrentPlayTime();

    long getFrom();

    TbMediaTrackConfig getMediaTrackConfig();

    float getRatio();

    void h();

    boolean i();

    boolean isPlaying();

    void j(boolean z);

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void start();
}
