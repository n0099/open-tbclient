package com.baidu.tieba;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes8.dex */
public interface up5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* loaded from: classes8.dex */
    public interface b {
        boolean F0();

        void H1(boolean z);

        void K1();

        boolean O1(String str);

        void T(ChatRoomEntranceData chatRoomEntranceData);

        void W0(boolean z);

        void X1(long j, String str, boolean z, boolean z2);

        void destroy();

        void g();

        int getState();

        Fragment i();

        boolean i0();

        void j1();

        void l1(MotionEvent motionEvent);

        void onActivityResult(int i, int i2, Intent intent);

        boolean p1();
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, xp5 xp5Var);

    void onChangeSkinType(int i);
}
