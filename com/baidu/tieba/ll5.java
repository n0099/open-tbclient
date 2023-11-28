package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface ll5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaSquare", "SecondFloorService");

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, boolean z2);

        void b(boolean z);
    }

    void hide();

    void j();

    void k(@Nullable a aVar);

    void l();

    @NonNull
    Fragment m(@NonNull String str);

    void show();
}
