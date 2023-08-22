package com.baidu.tieba;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes8.dex */
public interface xo5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* loaded from: classes8.dex */
    public interface b {
        void C1(boolean z);

        void F1();

        boolean I1(String str);

        void J(ChatRoomEntranceData chatRoomEntranceData);

        void P0(boolean z);

        void P1(long j, String str, boolean z, boolean z2);

        boolean Z();

        void b1();

        void d1(MotionEvent motionEvent);

        void destroy();

        void g();

        int getState();

        boolean h1();

        Fragment i();

        void onActivityResult(int i, int i2, Intent intent);

        boolean w0();
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, ap5 ap5Var);

    void onChangeSkinType(int i);
}
