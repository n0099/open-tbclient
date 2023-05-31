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
import com.baidu.tieba.g75;
import com.baidu.tieba.h75;
import com.baidu.tieba.k39;
import com.baidu.tieba.mx8;
import com.baidu.tieba.o65;
import com.baidu.tieba.oc5;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
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
            g75 g75Var = new g75();
            g75Var.b = R.raw.lottie_bubble_breath_tip;
            g75Var.a = BreatheTipWidget.PointType.LOTTIE;
            g75Var.c = ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            h75 h75Var = new h75();
            h75Var.a = this.a.getString(R.string.obfuscated_res_0x7f0f0f5f);
            h75Var.b = this.a.getString(R.string.obfuscated_res_0x7f0f0f5e);
            h75Var.e = R.drawable.god_post_guide_bg;
            h75Var.f = ri.g(this.a, R.dimen.tbds140);
            h75Var.g = ri.g(this.a, R.dimen.tbds460);
            h75Var.h = ri.g(this.a, R.dimen.tbds286);
            h75Var.i = ri.g(this.a, R.dimen.tbds100);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.i(this.b);
            breatheTipWidget.h(BreatheTipWidget.FromType.GOD);
            breatheTipWidget.g(h75Var, g75Var);
            this.e = breatheTipWidget;
            if (breatheTipWidget.j((Activity) this.a, 3000L)) {
                o65.m().z(k39.a, o65.m().n(k39.a, 0) + 1);
                oc5.b("c15280", this.c, this.d);
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
            sg.a().removeCallbacks(this.a);
            this.a.a();
        }
    }

    public boolean b(mx8 mx8Var, Context context, View view2, String str, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, mx8Var, context, view2, str, str2)) == null) {
            k39.a();
            if (!k39.c(mx8Var)) {
                return false;
            }
            this.a = new a(context, view2, str, str2);
            sg.a().postDelayed(this.a, 1000L);
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
