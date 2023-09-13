package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.io8;
import com.baidu.tieba.tm8;
import com.baidu.tieba.um8;
import com.baidu.tieba.vm8;
import com.baidu.tieba.wm8;
import com.baidu.tieba.xm8;
import com.baidu.tieba.ym8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ResponsesPanelControllerImpl implements ResponsesPanelController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wm8 a;
    public final vm8 b;
    @NonNull
    public GroupChatFragment c;

    public ResponsesPanelControllerImpl(@NonNull GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = groupChatFragment;
        this.b = new xm8(groupChatFragment.getPageContext());
        this.a = new ym8(groupChatFragment.getPageContext(), this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.a.onDestroy();
            this.b.onDestroy();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.f();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.i();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.p();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void a(@NonNull um8 um8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, um8Var) == null) {
            this.a.a(um8Var);
        }
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.b.o(obj);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void e(@NonNull io8 io8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, io8Var) == null) {
            this.a.e(io8Var);
        }
    }

    public void g(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b.c(list);
        }
    }

    public void p(@NonNull tm8 tm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tm8Var) == null) {
            this.b.n(tm8Var);
        }
    }

    public void q(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.b.l(str);
        }
    }

    public void r(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.b.a(str);
        }
    }

    public void c(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.b.r(str, str2);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void d(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, baseMsg, chatRoomDetail) == null) {
            this.a.d(baseMsg, chatRoomDetail);
        }
    }

    public void j(@NonNull String str, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, charSequence) == null) {
            this.b.m(str, charSequence);
        }
    }

    public void k(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), map, Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b.q(z, i, i2, map, z2, j, j2);
        }
    }

    public void n(int i, int i2, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, str) == null) {
            this.b.s(i, i2, str);
        }
    }
}
