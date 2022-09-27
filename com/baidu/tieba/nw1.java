package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nw1 extends iw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my1 a;
        public final /* synthetic */ CanvasView b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ nw1 d;

        public a(nw1 nw1Var, my1 my1Var, CanvasView canvasView, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw1Var, my1Var, canvasView, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nw1Var;
            this.a = my1Var;
            this.b = canvasView;
            this.c = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int h = this.a.h();
                if (h != 0) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(h, this.d.n(h));
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                    this.b.c(this.a.i(), this.a.j());
                    this.b.postInvalidate();
                }
                String str = this.a.e;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.c.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw1(i43 i43Var) {
        super(i43Var, "/swanAPI/canvas/putImageData");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i43) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        t22 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            my1 o = o(unitedSchemeEntity);
            if (o == null) {
                l02.c("SwanAppCanvas", "CanvasPutImageData action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(o.c) && (H = yo2.U().H()) != null) {
                o.c = H.t3();
            }
            if (!TextUtils.isEmpty(o.c) && !TextUtils.isEmpty(o.b)) {
                CanvasView a2 = mz1.a(o);
                if (a2 == null) {
                    l02.c("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                fg3.k(new a(this, o, a2, callbackHandler), "CanvasPutImageDataAction");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            l02.c("SwanAppCanvas", "CanvasPutImageData slave id = " + o.c + " ; canvas id = " + o.b);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i != 2001 ? i != 2002 ? "error draw on canvas" : "width / height must > 0" : "data length invalid" : (String) invokeI.objValue;
    }

    public my1 o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new my1(str);
        }
        return (my1) invokeL.objValue;
    }
}
