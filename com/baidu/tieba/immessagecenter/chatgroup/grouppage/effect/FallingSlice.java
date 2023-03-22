package com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.FallingData;
import com.baidu.tbadk.widget.falling.FallingEventType;
import com.baidu.tbadk.widget.falling.FallingView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.nx7;
import com.baidu.tieba.sr5;
import com.baidu.tieba.sv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FallingSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final TbPageContext<?> j;
    public c k;
    @Nullable
    public sv7 l;
    public long m;
    public boolean n;
    public final sr5 o;

    /* loaded from: classes4.dex */
    public class a implements sr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingSlice a;

        public a(FallingSlice fallingSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingSlice;
        }

        @Override // com.baidu.tieba.sr5
        public void a(FallingEventType fallingEventType, @Nullable Object obj) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, fallingEventType, obj) == null) {
                if (obj instanceof FallingData) {
                    str = ((FallingData) obj).getAffect();
                } else {
                    str = "";
                }
                if (fallingEventType == FallingEventType.CLICK) {
                    nx7.f("c15184", str, this.a.m, this.a.n);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingSlice a;

        public b(FallingSlice fallingSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingSlice;
        }

        @Override // com.baidu.tbadk.widget.falling.FallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.a();
            }
        }

        @Override // com.baidu.tbadk.widget.falling.FallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.k.b.setTag(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ChatFallingView b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static c a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                c cVar = new c();
                cVar.a = view2;
                cVar.b = (ChatFallingView) view2.findViewById(R.id.obfuscated_res_0x7f091ceb);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public FallingSlice(@NonNull TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.j = tbPageContext;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void E(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, bundle) == null) {
            super.E(view2, bundle);
            if (view2 != null) {
                this.k = c.a(view2);
            }
            this.k.b.setEventCallback(this.o);
            P();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.b.setAnimationListener(new b(this));
        }
    }

    public void R() {
        ChatFallingView chatFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (chatFallingView = this.k.b) != null) {
            chatFallingView.z();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            R();
        }
    }

    public void Q(@NonNull FallingData fallingData, long j, boolean z, @Nullable sv7 sv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{fallingData, Long.valueOf(j), Boolean.valueOf(z), sv7Var}) == null) {
            this.m = j;
            this.n = z;
            this.l = sv7Var;
            ChatFallingView chatFallingView = this.k.b;
            if (chatFallingView != null) {
                chatFallingView.x(fallingData, this.j, false);
                nx7.f("c15183", fallingData.getAffect(), this.m, z);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @Nullable
    public View u(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d083c, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }
}
