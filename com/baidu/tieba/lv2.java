package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lv2 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hv2 c;
    public rv2 d;
    public jv2 e;
    public iv2 f;
    public ov2 g;
    public gv2 h;
    public pv2 i;
    public nv2 j;
    public qv2 k;
    public kv2 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lv2(h73 h73Var) {
        super(h73Var, "/swanAPI/video");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (h83.b) {
                Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.h83
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, k63 k63Var) {
        InterceptResult invokeLLLLL;
        char c;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, k63Var)) == null) {
            k32.i("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + h83.a(unitedSchemeEntity, "params"));
            switch (str.hashCode()) {
                case -1701478259:
                    if (str.equals("/swanAPI/video/pause")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440375597:
                    if (str.equals("/swanAPI/video/open")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440349763:
                    if (str.equals("/swanAPI/video/play")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440267007:
                    if (str.equals("/swanAPI/video/seek")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440252277:
                    if (str.equals("/swanAPI/video/stop")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1145507635:
                    if (str.equals("/swanAPI/video/remove")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1049743086:
                    if (str.equals("/swanAPI/video/update")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -274000988:
                    if (str.equals("/swanAPI/video/fullScreen")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 711122280:
                    if (str.equals("/swanAPI/video/sendDanmu")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1568993060:
                    if (str.equals("/swanAPI/video/playbackRate")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (this.c == null) {
                        this.c = new hv2("/swanAPI/video/open");
                    }
                    c2 = this.c.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case 1:
                    if (this.d == null) {
                        this.d = new rv2("/swanAPI/video/update");
                    }
                    c2 = this.d.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case 2:
                    if (this.j == null) {
                        this.j = new nv2("/swanAPI/video/remove");
                    }
                    c2 = this.j.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case 3:
                    if (this.e == null) {
                        this.e = new jv2("/swanAPI/video/play");
                    }
                    c2 = this.e.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case 4:
                    if (this.f == null) {
                        this.f = new iv2("/swanAPI/video/pause");
                    }
                    c2 = this.f.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case 5:
                    if (this.g == null) {
                        this.g = new ov2("/swanAPI/video/seek");
                    }
                    c2 = this.g.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case 6:
                    if (this.h == null) {
                        this.h = new gv2("/swanAPI/video/fullScreen");
                    }
                    c2 = this.h.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case 7:
                    if (this.i == null) {
                        this.i = new pv2("/swanAPI/video/sendDanmu");
                    }
                    c2 = this.i.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case '\b':
                    if (this.k == null) {
                        this.k = new qv2("/swanAPI/video/stop");
                    }
                    c2 = this.k.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                case '\t':
                    if (this.l == null) {
                        this.l = new kv2("/swanAPI/video/playbackRate");
                    }
                    c2 = this.l.c(context, unitedSchemeEntity, callbackHandler, k63Var);
                    break;
                default:
                    c2 = false;
                    break;
            }
            if (!c2 && !super.i(context, unitedSchemeEntity, callbackHandler, str, k63Var)) {
                return false;
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
