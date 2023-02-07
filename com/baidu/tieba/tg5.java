package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes6.dex */
public interface tg5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface b {
        void O0();

        void S0();

        void c();

        Fragment d();

        void destroy();

        int getState();

        boolean j0();

        void l1(boolean z);

        void o1();

        boolean r1(String str);

        void x1(long j, String str, boolean z, boolean z2);

        void z(ChatRoomEntranceData chatRoomEntranceData);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, wg5 wg5Var);

    void onChangeSkinType(int i);
}
