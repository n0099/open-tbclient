package com.baidu.tieba.pb.pb.main.controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tieba.R;
import com.baidu.tieba.ds9;
import com.baidu.tieba.lb5;
import com.baidu.tieba.lz9;
import com.baidu.tieba.n55;
import com.baidu.tieba.o55;
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
            n55 n55Var = new n55();
            n55Var.b = R.raw.lottie_bubble_breath_tip;
            n55Var.a = BreatheTipWidget.PointType.LOTTIE;
            n55Var.c = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            o55 o55Var = new o55();
            o55Var.a = this.a.getString(R.string.obfuscated_res_0x7f0f1016);
            o55Var.b = this.a.getString(R.string.obfuscated_res_0x7f0f1015);
            o55Var.e = R.drawable.god_post_guide_bg;
            o55Var.f = BdUtilHelper.getDimens(this.a, R.dimen.tbds140);
            o55Var.g = BdUtilHelper.getDimens(this.a, R.dimen.tbds460);
            o55Var.h = BdUtilHelper.getDimens(this.a, R.dimen.tbds286);
            o55Var.i = BdUtilHelper.getDimens(this.a, R.dimen.tbds100);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.i(BreatheTipWidget.FromType.GOD);
            breatheTipWidget.h(o55Var, n55Var);
            breatheTipWidget.g(false);
            this.e = breatheTipWidget;
            if (breatheTipWidget.k((Activity) this.a, 3000L)) {
                SharedPrefHelper.getInstance().putInt(lz9.a, SharedPrefHelper.getInstance().getInt(lz9.a, 0) + 1);
                lb5.b("c15280", this.c, this.d);
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
            SafeHandler.getInst().removeCallbacks(this.a);
            this.a.a();
        }
    }

    public boolean b(ds9 ds9Var, Context context, View view2, String str, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, ds9Var, context, view2, str, str2)) == null) {
            lz9.a();
            if (!lz9.c(ds9Var)) {
                return false;
            }
            this.a = new a(context, view2, str, str2);
            SafeHandler.getInst().postDelayed(this.a, 1000L);
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
