package com.baidu.tieba;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
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
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class lo0 {
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
    public List<oo0> d;
    @JvmField
    public ho0 e;
    @JvmField
    public ko0 f;
    @JvmField
    public String g;
    @JvmField
    public ap0 h;
    @JvmField
    public String i;

    /* loaded from: classes4.dex */
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

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00bc, code lost:
            if (r0.equals("invoke") != false) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f3  */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final lo0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("convert");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = kz0.c(jSONObject.optString("convert"));
                    }
                    if (optJSONObject2 != null) {
                        lo0 lo0Var = new lo0();
                        lo0Var.b = optJSONObject2.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                        lo0Var.c = optJSONObject2.optString("button_icon");
                        String optString = optJSONObject2.optString("button_text_color");
                        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"button_text_color\")");
                        int i = 1;
                        if (optString.length() > 0) {
                            optJSONObject2.optString("button_text_color");
                        } else {
                            optJSONObject2.optString("textColor");
                        }
                        optJSONObject2.optInt("buttonShineType");
                        lo0Var.g = optJSONObject2.optString("background_color");
                        lo0Var.i = optJSONObject2.optString("button_scheme");
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = optJSONObject2.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                oo0 a = oo0.d.a(optJSONArray.optJSONObject(i2));
                                if (a != null) {
                                    arrayList.add(a);
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        lo0Var.d = arrayList;
                        String optString2 = optJSONObject2.optString("type");
                        if (optString2 != null) {
                            int hashCode = optString2.hashCode();
                            if (hashCode == -1335224239) {
                                optString2.equals("detail");
                            } else {
                                if (hashCode != -1183693704) {
                                    if (hashCode == 1427818632 && optString2.equals("download")) {
                                        i = 2;
                                    }
                                }
                                lo0Var.a = i;
                                lo0Var.e = ho0.c(optJSONObject2.optJSONObject("download"));
                                ko0 ko0Var = new ko0();
                                ko0Var.d = optJSONObject2.optString("ext");
                                ko0Var.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                                Unit unit2 = Unit.INSTANCE;
                                lo0Var.f = ko0Var;
                                optJSONObject = optJSONObject2.optJSONObject("app_info");
                                if (optJSONObject != null) {
                                    lo0Var.h = ap0.c(optJSONObject);
                                }
                                return lo0Var;
                            }
                        }
                        i = 0;
                        lo0Var.a = i;
                        lo0Var.e = ho0.c(optJSONObject2.optJSONObject("download"));
                        ko0 ko0Var2 = new ko0();
                        ko0Var2.d = optJSONObject2.optString("ext");
                        ko0Var2.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                        Unit unit22 = Unit.INSTANCE;
                        lo0Var.f = ko0Var2;
                        optJSONObject = optJSONObject2.optJSONObject("app_info");
                        if (optJSONObject != null) {
                        }
                        return lo0Var;
                    }
                    return null;
                }
                return null;
            }
            return (lo0) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947949468, "Lcom/baidu/tieba/lo0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947949468, "Lcom/baidu/tieba/lo0;");
                return;
            }
        }
        j = new a(null);
    }

    public lo0() {
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
    public static final lo0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? j.a(jSONObject) : (lo0) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a == 2 && this.e == null) ? false : true : invokeV.booleanValue;
    }
}
