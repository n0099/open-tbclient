package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.impersonal.components.LoadingMsgView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j29 extends i29<m09, LoadingMsgView, g09> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements LoadingMsgView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g09 a;

        public a(g09 g09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g09Var;
        }

        @Override // com.baidu.tieba.impersonal.components.LoadingMsgView.a
        public void onShow() {
            m09 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (f = this.a.c().f()) != null) {
                f.d(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j29(String name) {
        super(name);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {name};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i29
    /* renamed from: l */
    public LoadingMsgView g(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            LoadingMsgView loadingMsgView = new LoadingMsgView(context, null, 2, null);
            loadingMsgView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return loadingMsgView;
        }
        return (LoadingMsgView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i29
    /* renamed from: k */
    public void d(LoadingMsgView loadingMsgView, g09 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, loadingMsgView, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (loadingMsgView != null) {
                loadingMsgView.setShowEmotionTextStatusListener(new a(data));
            }
            m09 f = data.c().f();
            if (f != null) {
                if (loadingMsgView != null) {
                    loadingMsgView.setHasShowEmotionText(f.c());
                }
                if (loadingMsgView != null) {
                    loadingMsgView.setAnimationId(f.a());
                }
                if (loadingMsgView != null) {
                    loadingMsgView.setEmotionText(f.b());
                }
            }
        }
    }
}
