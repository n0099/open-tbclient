package com.baidu.tieba;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class zm0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public int a;
    @JvmField
    public String b;
    @JvmField
    public String c;
    @JvmField
    public List<cn0> d;
    @JvmField
    public vm0 e;
    @JvmField
    public ym0 f;
    @JvmField
    public String g;
    @JvmField
    public on0 h;
    @JvmField
    public String i;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @JvmStatic
        public final zm0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("convert");
                    if (optJSONObject == null) {
                        optJSONObject = yx0.c(jSONObject.optString("convert"));
                    }
                    if (optJSONObject != null) {
                        zm0 zm0Var = new zm0();
                        zm0Var.b = optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                        zm0Var.c = optJSONObject.optString("button_icon");
                        optJSONObject.optString("textColor");
                        optJSONObject.optInt("buttonShineType");
                        zm0Var.g = optJSONObject.optString("background_color");
                        zm0Var.i = optJSONObject.optString("button_scheme");
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = optJSONObject.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                cn0 a = cn0.d.a(optJSONArray.optJSONObject(i));
                                if (a != null) {
                                    arrayList.add(a);
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        zm0Var.d = arrayList;
                        return zm0Var;
                    }
                    return null;
                }
                return null;
            }
            return (zm0) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948364620, "Lcom/baidu/tieba/zm0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948364620, "Lcom/baidu/tieba/zm0;");
                return;
            }
        }
        j = new a(null);
    }

    public zm0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
    }

    @JvmStatic
    public static final zm0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? j.a(jSONObject) : (zm0) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a == 2 && this.e == null) ? false : true : invokeV.booleanValue;
    }
}
