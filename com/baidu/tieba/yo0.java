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
/* loaded from: classes6.dex */
public final class yo0 {
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
    public List<bp0> d;
    @JvmField
    public uo0 e;
    @JvmField
    public xo0 f;
    @JvmField
    public String g;
    @JvmField
    public np0 h;
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

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00bc, code lost:
            if (r0.equals("invoke") != false) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f3  */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final yo0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("convert");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = xz0.c(jSONObject.optString("convert"));
                    }
                    if (optJSONObject2 != null) {
                        yo0 yo0Var = new yo0();
                        yo0Var.b = optJSONObject2.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                        yo0Var.c = optJSONObject2.optString("button_icon");
                        String optString = optJSONObject2.optString("button_text_color");
                        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"button_text_color\")");
                        int i = 1;
                        if (optString.length() > 0) {
                            optJSONObject2.optString("button_text_color");
                        } else {
                            optJSONObject2.optString("textColor");
                        }
                        optJSONObject2.optInt("buttonShineType");
                        yo0Var.g = optJSONObject2.optString("background_color");
                        yo0Var.i = optJSONObject2.optString("button_scheme");
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = optJSONObject2.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                bp0 a = bp0.d.a(optJSONArray.optJSONObject(i2));
                                if (a != null) {
                                    arrayList.add(a);
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        yo0Var.d = arrayList;
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
                                yo0Var.a = i;
                                yo0Var.e = uo0.c(optJSONObject2.optJSONObject("download"));
                                xo0 xo0Var = new xo0();
                                xo0Var.d = optJSONObject2.optString("ext");
                                xo0Var.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                                Unit unit2 = Unit.INSTANCE;
                                yo0Var.f = xo0Var;
                                optJSONObject = optJSONObject2.optJSONObject("app_info");
                                if (optJSONObject != null) {
                                    yo0Var.h = np0.c(optJSONObject);
                                }
                                return yo0Var;
                            }
                        }
                        i = 0;
                        yo0Var.a = i;
                        yo0Var.e = uo0.c(optJSONObject2.optJSONObject("download"));
                        xo0 xo0Var2 = new xo0();
                        xo0Var2.d = optJSONObject2.optString("ext");
                        xo0Var2.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                        Unit unit22 = Unit.INSTANCE;
                        yo0Var.f = xo0Var2;
                        optJSONObject = optJSONObject2.optJSONObject("app_info");
                        if (optJSONObject != null) {
                        }
                        return yo0Var;
                    }
                    return null;
                }
                return null;
            }
            return (yo0) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948336751, "Lcom/baidu/tieba/yo0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948336751, "Lcom/baidu/tieba/yo0;");
                return;
            }
        }
        j = new a(null);
    }

    public yo0() {
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
    public static final yo0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? j.a(jSONObject) : (yo0) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a == 2 && this.e == null) ? false : true : invokeV.booleanValue;
    }
}
