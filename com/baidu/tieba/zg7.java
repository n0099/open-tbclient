package com.baidu.tieba;

import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.forum.widget.ViewExtentionsKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes9.dex */
public final class zg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity a;
    public final ActivityForumBinding b;
    public zk7 c;
    public final a d;

    /* loaded from: classes9.dex */
    public static final class a implements qm7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ zg7 b;

        public a(zg7 zg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zg7Var;
        }

        @Override // com.baidu.tieba.qm7
        public Boolean a(MotionEvent e) {
            InterceptResult invokeL;
            yg7 yg7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                int action = e.getAction();
                xg7 xg7Var = null;
                if (action != 0) {
                    if (action == 2) {
                        if (e.getRawY() - this.a > 5.0f) {
                            return b();
                        }
                        if (e.getRawY() - this.a >= -5.0f) {
                            return null;
                        }
                        Boolean b = b();
                        if (Intrinsics.areEqual(b, Boolean.TRUE)) {
                            FragmentActivity fragmentActivity = this.b.a;
                            if (fragmentActivity instanceof xg7) {
                                xg7Var = (xg7) fragmentActivity;
                            }
                            if (xg7Var != null && (yg7Var = (yg7) xg7Var.X1(Reflection.getOrCreateKotlinClass(yg7.class))) != null) {
                                yg7Var.s();
                            }
                        }
                        return b;
                    }
                } else {
                    this.a = e.getRawY();
                }
                return null;
            }
            return (Boolean) invokeL.objValue;
        }

        public final Boolean b() {
            InterceptResult invokeV;
            zk7 zk7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                zk7 zk7Var2 = this.b.c;
                if (zk7Var2 != null) {
                    zk7Var2.G();
                }
                TbBottomSheetView tbBottomSheetView = this.b.b.t;
                Intrinsics.checkNotNullExpressionValue(tbBottomSheetView, "binding.topContentContainer");
                LinearLayout linearLayout = this.b.b.h;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
                if (!ViewExtentionsKt.f(tbBottomSheetView, linearLayout) || (zk7Var = this.b.c) == null) {
                    return null;
                }
                return Boolean.valueOf(zk7Var.c());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public zg7(FragmentActivity activity, ActivityForumBinding binding, zk7 zk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, binding, zk7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = activity;
        this.b = binding;
        this.c = zk7Var;
        this.d = new a(this);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.m.H(this.d);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.m.K(this.d);
        }
    }
}
