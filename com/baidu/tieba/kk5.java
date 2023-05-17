package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes6.dex */
public interface kk5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface b {
        void B1(long j, String str, boolean z, boolean z2);

        void D(ChatRoomEntranceData chatRoomEntranceData);

        void F0(boolean z);

        boolean Q();

        void R0();

        void T0(MotionEvent motionEvent);

        boolean X0();

        void c();

        Fragment d();

        void destroy();

        int getState();

        boolean n0();

        void o1(boolean z);

        void r1();

        boolean u1(String str);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, nk5 nk5Var);

    void onChangeSkinType(int i);
}
