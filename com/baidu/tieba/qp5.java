package com.baidu.tieba;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes7.dex */
public interface qp5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* loaded from: classes7.dex */
    public interface b {
        void E1(boolean z);

        void H1();

        boolean K1(String str);

        void L(ChatRoomEntranceData chatRoomEntranceData);

        void Q0(boolean z);

        void R1(long j, String str, boolean z, boolean z2);

        boolean a0();

        void c1();

        void destroy();

        void e1(MotionEvent motionEvent);

        void g();

        int getState();

        Fragment i();

        boolean i1();

        void onActivityResult(int i, int i2, Intent intent);

        boolean x0();
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, tp5 tp5Var);

    void onChangeSkinType(int i);
}
