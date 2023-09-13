package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wc3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox1 a;

        public a(wc3 wc3Var, ox1 ox1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc3Var, ox1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ox1Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wc3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/pageScrollTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var != null && context != null) {
                JSONObject a2 = ed3.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    h82.i("PageScrollToAction", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                    return false;
                }
                int optInt = a2.optInt("scrollTop", -1);
                int optInt2 = a2.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    ox1 i = uw2.T().i();
                    if (i != null) {
                        if (i instanceof NgWebView) {
                            f = e02.z(i, yo3.f(context, optInt));
                        } else {
                            f = yo3.f(context, optInt);
                        }
                        ValueAnimator ofInt = ValueAnimator.ofInt(i.getWebViewScrollY(), f);
                        ofInt.setDuration(optInt2);
                        ofInt.addUpdateListener(new a(this, i));
                        ofInt.start();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                h82.c("PageScrollToAction", "illegal scrollTop or duration");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            h82.c("PageScrollToAction", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
