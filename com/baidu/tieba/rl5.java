package com.baidu.tieba;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes8.dex */
public interface rl5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* loaded from: classes8.dex */
    public interface b {
        boolean B1();

        void V1(boolean z);

        void Y(ChatRoomEntranceData chatRoomEntranceData);

        void b2();

        void destroy();

        void e1(boolean z);

        boolean f2(String str);

        void g();

        int getState();

        Fragment k();

        boolean m0();

        void onActivityResult(int i, int i2, Intent intent);

        boolean p();

        void p2(long j, String str, boolean z, boolean z2);

        void u1();

        void w1(MotionEvent motionEvent);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, ul5 ul5Var);

    void onChangeSkinType(int i);
}
