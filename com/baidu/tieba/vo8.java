package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.base.core.inputtool.GroupInputTool;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vo8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int f = 2131167477;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final GroupInputTool a;
    public GroupChatUserReplyView b;
    public e c;
    public RelativeLayout d;
    public boolean e;

    /* loaded from: classes8.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);

        void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948247626, "Lcom/baidu/tieba/vo8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948247626, "Lcom/baidu/tieba/vo8;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements GroupChatUserReplyView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo8 a;

        public a(vo8 vo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo8Var;
        }

        @Override // com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView.b
        public void onCloseEvent() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(vo8 vo8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ vo8 b;

        public c(vo8 vo8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vo8Var;
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.b.j(false);
                if (this.b.a != null && this.b.a.I() != null) {
                    this.b.a.I().d(true);
                }
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
                if (this.b.a != null && this.b.a.I() != null) {
                    this.b.a.I().c(ViewState.VISIBLE);
                }
            }
        }
    }

    public vo8(GroupChatUserReplyView groupChatUserReplyView, @Nullable GroupInputTool groupInputTool, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatUserReplyView, groupInputTool, relativeLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = true;
        this.a = groupInputTool;
        this.b = groupChatUserReplyView;
        this.d = relativeLayout;
        f();
    }

    public final boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                this.b.setData(str);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.e = z;
        }
    }

    public void i(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.c = eVar;
        }
    }

    public void j(boolean z) {
        GroupChatUserReplyView groupChatUserReplyView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048583, this, z) != null) || (groupChatUserReplyView = this.b) == null) {
            return;
        }
        if (z) {
            groupChatUserReplyView.setVisibility(0);
        } else {
            groupChatUserReplyView.setVisibility(8);
        }
    }

    public void k(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) && e() && this.c != null) {
            h(true);
            this.c.b(d(), 0, 200L, new c(this, dVar), false);
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return UtilHelper.getDimenPixelSize(f);
        }
        return invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GroupChatUserReplyView groupChatUserReplyView = this.b;
            if (groupChatUserReplyView != null && groupChatUserReplyView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        GroupChatUserReplyView groupChatUserReplyView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (groupChatUserReplyView = this.b) == null) {
            return;
        }
        groupChatUserReplyView.setEventCallback(new a(this));
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void l(@Nullable d dVar, @NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, dVar, str) == null) && this.c != null && this.a != null && c(str) && !e()) {
            if (this.d != null) {
                this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            j(true);
            if (this.a.I() != null) {
                this.a.I().d(false);
            }
            h(false);
            this.c.a(0, d(), 200L, new b(this, dVar), false);
        }
    }
}
