package com.baidu.tieba.pb.pb.main.controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tieba.R;
import com.baidu.tieba.fa5;
import com.baidu.tieba.ga5;
import com.baidu.tieba.j49;
import com.baidu.tieba.o95;
import com.baidu.tieba.pa9;
import com.baidu.tieba.wi;
import com.baidu.tieba.xf5;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbGodGuideController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public a a;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public final View b;
        public final String c;
        public final String d;
        public BreatheTipWidget e;

        public a(Context context, View view2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = view2;
            this.c = str;
            this.d = str2;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BreatheTipWidget breatheTipWidget = this.e;
                if (breatheTipWidget != null) {
                    breatheTipWidget.e();
                }
                this.a = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || BreatheTipWidget.f() || this.a == null) {
                return;
            }
            fa5 fa5Var = new fa5();
            fa5Var.b = R.raw.lottie_bubble_breath_tip;
            fa5Var.a = BreatheTipWidget.PointType.LOTTIE;
            fa5Var.c = wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            ga5 ga5Var = new ga5();
            ga5Var.a = this.a.getString(R.string.obfuscated_res_0x7f0f0fa2);
            ga5Var.b = this.a.getString(R.string.obfuscated_res_0x7f0f0fa1);
            ga5Var.e = R.drawable.god_post_guide_bg;
            ga5Var.f = wi.g(this.a, R.dimen.tbds140);
            ga5Var.g = wi.g(this.a, R.dimen.tbds460);
            ga5Var.h = wi.g(this.a, R.dimen.tbds286);
            ga5Var.i = wi.g(this.a, R.dimen.tbds100);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.i(BreatheTipWidget.FromType.GOD);
            breatheTipWidget.h(ga5Var, fa5Var);
            breatheTipWidget.g(false);
            this.e = breatheTipWidget;
            if (breatheTipWidget.k((Activity) this.a, 3000L)) {
                o95.p().F(pa9.a, o95.p().q(pa9.a, 0) + 1);
                xf5.b("c15280", this.c, this.d);
            }
        }
    }

    public PbGodGuideController() {
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

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a != null) {
            xg.a().removeCallbacks(this.a);
            this.a.a();
        }
    }

    public boolean b(j49 j49Var, Context context, View view2, String str, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, j49Var, context, view2, str, str2)) == null) {
            pa9.a();
            if (!pa9.c(j49Var)) {
                return false;
            }
            this.a = new a(context, view2, str, str2);
            xg.a().postDelayed(this.a, 1000L);
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
