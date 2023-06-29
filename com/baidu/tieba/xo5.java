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
        void C1(long j, String str, boolean z, boolean z2);

        void F(ChatRoomEntranceData chatRoomEntranceData);

        void G0(boolean z);

        boolean R();

        void S0();

        void U0(MotionEvent motionEvent);

        boolean Y0();

        void d();

        void destroy();

        Fragment e();

        int getState();

        void onActivityResult(int i, int i2, Intent intent);

        boolean p0();

        void p1(boolean z);

        void s1();

        boolean v1(String str);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, ap5 ap5Var);

    void onChangeSkinType(int i);
}
