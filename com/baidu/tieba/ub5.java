package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes6.dex */
public interface ub5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface b {
        void L0();

        void X0(long j, String str, boolean z);

        void c();

        Fragment d();

        void destroy();

        int getState();

        boolean m1(String str);

        void z(ChatRoomEntranceData chatRoomEntranceData);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, xb5 xb5Var);

    void onChangeSkinType(int i);
}
