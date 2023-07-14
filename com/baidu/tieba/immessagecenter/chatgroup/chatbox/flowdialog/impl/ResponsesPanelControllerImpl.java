package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ak8;
import com.baidu.tieba.bk8;
import com.baidu.tieba.ck8;
import com.baidu.tieba.dk8;
import com.baidu.tieba.ek8;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.ml8;
import com.baidu.tieba.zj8;
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
    public final ck8 a;
    public final bk8 b;
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
        this.b = new dk8(groupChatFragment.getPageContext());
        this.a = new ek8(groupChatFragment.getPageContext(), this);
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
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.a();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.h();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.k();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.p();
        }
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.b.o(obj);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void c(@NonNull ak8 ak8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ak8Var) == null) {
            this.a.c(ak8Var);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void f(@NonNull ml8 ml8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ml8Var) == null) {
            this.a.f(ml8Var);
        }
    }

    public void i(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b.g(list);
        }
    }

    public void q(@NonNull zj8 zj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zj8Var) == null) {
            this.b.n(zj8Var);
        }
    }

    public void r(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.b.l(str);
        }
    }

    public void s(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.b.c(str);
        }
    }

    public void d(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.b.r(str, str2);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController
    public void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, baseMsg, chatRoomDetail) == null) {
            this.a.e(baseMsg, chatRoomDetail);
        }
    }

    public void j(@NonNull String str, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, charSequence) == null) {
            this.b.m(str, charSequence);
        }
    }

    public void l(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), map, Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b.q(z, i, i2, map, z2, j, j2);
        }
    }

    public void o(int i, int i2, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, str) == null) {
            this.b.s(i, i2, str);
        }
    }
}
