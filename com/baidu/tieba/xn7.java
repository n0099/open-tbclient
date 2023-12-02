package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class xn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdRecyclerView a;
    public Function0<Unit> b;
    public boolean c;
    public boolean d;
    public final PbListView e;
    public final BdListView.p f;

    public xn7(BdRecyclerView recyclerView, Function0<Unit> function0) {
        RecyclerView.LayoutParams generateLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView, function0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.a = recyclerView;
        this.b = function0;
        PbListView pbListView = new PbListView(this.a.getContext());
        pbListView.c();
        pbListView.s(R.color.transparent);
        pbListView.w(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds182));
        pbListView.B();
        pbListView.L(R.dimen.tbfontsize33);
        pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
        pbListView.F(R.color.CAM_X0110);
        pbListView.v();
        this.e = pbListView;
        ViewGroup.LayoutParams layoutParams = pbListView.c().getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-1, -2) : layoutParams;
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (layoutManager != null && (generateLayoutParams = layoutManager.generateLayoutParams(layoutParams)) != null) {
            Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "generateLayoutParams(oldLayoutParams)");
            this.e.c().setLayoutParams(generateLayoutParams);
        }
        this.f = new BdListView.p() { // from class: com.baidu.tieba.sn7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.adp.widget.ListView.BdListView.p
            public final void onScrollToBottom() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    xn7.e(xn7.this);
                }
            }
        };
    }

    public static final void e(xn7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function0<Unit> function0 = this$0.b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void g(xn7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean canScrollVertically = this$0.a.canScrollVertically(1);
            boolean canScrollVertically2 = this$0.a.canScrollVertically(-1);
            if (!canScrollVertically && canScrollVertically2) {
                this$0.f.onScrollToBottom();
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = null;
        }
    }

    public final void c() {
        Function0<Unit> function0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (function0 = this.b) != null) {
            function0.invoke();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.post(new Runnable() { // from class: com.baidu.tieba.qn7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        xn7.g(xn7.this);
                    }
                }
            });
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.e.H(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0c2e));
                this.e.c().setPadding(0, 0, 0, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds125));
                this.e.g();
                this.e.G(null);
                this.a.setOnSrollToBottomListener(null);
                return;
            }
            this.e.c().setPadding(0, 0, 0, 0);
            d(this.c, this.d);
        }
    }

    public final void d(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.c = z;
            this.d = z2;
            if (!z2) {
                this.a.setNextPage(null);
                this.a.setOnSrollToBottomListener(null);
                return;
            }
            this.a.setNextPage(this.e);
            if (z) {
                this.e.R();
                this.e.G(null);
                this.a.setOnSrollToBottomListener(this.f);
                f();
                return;
            }
            this.e.H(this.a.getContext().getString(R.string.list_has_no_more));
            this.e.g();
            this.e.G(null);
            this.a.setOnSrollToBottomListener(null);
        }
    }
}
