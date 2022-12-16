package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface mb5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaSquare", "SecondFloorService");

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, boolean z2);

        void b(boolean z);
    }

    void c();

    void d(@Nullable a aVar);

    void e();

    @NonNull
    Fragment f(@NonNull String str);

    void hide();

    void show();
}
