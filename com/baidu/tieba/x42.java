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
/* loaded from: classes8.dex */
public class x42 extends s42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final String n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i != 2001 ? i != 2002 ? "error draw on canvas" : "width / height must > 0" : "data length invalid" : (String) invokeI.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w62 a;
        public final /* synthetic */ CanvasView b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ x42 d;

        public a(x42 x42Var, w62 w62Var, CanvasView canvasView, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var, w62Var, canvasView, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x42Var;
            this.a = w62Var;
            this.b = canvasView;
            this.c = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int h = this.a.h();
                if (h == 0) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                    this.b.c(this.a.i(), this.a.j());
                    this.b.postInvalidate();
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(h, this.d.n(h));
                }
                String str = this.a.e;
                if (!TextUtils.isEmpty(str)) {
                    this.c.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x42(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/canvas/putImageData");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sc3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        db2 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            w62 o = o(unitedSchemeEntity);
            if (o == null) {
                v82.c("SwanAppCanvas", "CanvasPutImageData action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(o.c) && (H = ix2.T().H()) != null) {
                o.c = H.v3();
            }
            if (!TextUtils.isEmpty(o.c) && !TextUtils.isEmpty(o.b)) {
                CanvasView a2 = w72.a(o);
                if (a2 == null) {
                    v82.c("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                po3.k(new a(this, o, a2, callbackHandler), "CanvasPutImageDataAction");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            v82.c("SwanAppCanvas", "CanvasPutImageData slave id = " + o.c + " ; canvas id = " + o.b);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public w62 o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str)) {
                return new w62(str);
            }
            return null;
        }
        return (w62) invokeL.objValue;
    }
}
