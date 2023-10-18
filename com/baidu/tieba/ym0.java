package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class ym0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a v;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final String j;
    public final int k;
    public final boolean l;
    public boolean m;
    public final boolean n;
    public final String o;
    public final int p;
    public final boolean q;
    public final String r;
    public final int s;
    public final int t;
    public final boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948334829, "Lcom/baidu/tieba/ym0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948334829, "Lcom/baidu/tieba/ym0;");
                return;
            }
        }
        v = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ym0) {
                    ym0 ym0Var = (ym0) obj;
                    return this.a == ym0Var.a && this.b == ym0Var.b && this.c == ym0Var.c && this.d == ym0Var.d && this.e == ym0Var.e && this.f == ym0Var.f && this.g == ym0Var.g && this.h == ym0Var.h && this.i == ym0Var.i && Intrinsics.areEqual(this.j, ym0Var.j) && this.k == ym0Var.k && this.l == ym0Var.l && this.m == ym0Var.m && this.n == ym0Var.n && Intrinsics.areEqual(this.o, ym0Var.o) && this.p == ym0Var.p && this.q == ym0Var.q && Intrinsics.areEqual(this.r, ym0Var.r) && this.s == ym0Var.s && this.t == ym0Var.t && this.u == ym0Var.u;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v9, types: [boolean] */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            boolean z = this.a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.b;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (((((((((((((i + i2) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
            ?? r22 = this.i;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            String str = this.j;
            int hashCode = (((i5 + (str != null ? str.hashCode() : 0)) * 31) + this.k) * 31;
            ?? r23 = this.l;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (hashCode + i6) * 31;
            ?? r24 = this.m;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            ?? r25 = this.n;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            String str2 = this.o;
            int hashCode2 = (((i11 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.p) * 31;
            ?? r26 = this.q;
            int i12 = r26;
            if (r26 != 0) {
                i12 = 1;
            }
            int i13 = (hashCode2 + i12) * 31;
            String str3 = this.r;
            int hashCode3 = (((((i13 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.s) * 31) + this.t) * 31;
            boolean z2 = this.u;
            return hashCode3 + (z2 ? 1 : z2 ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "CmdPolicy(showTailFrame=" + this.a + ", unmountLandingUrl=" + this.b + ", guideArrowShowTime=" + this.c + ", guideArrowType=" + this.d + ", autoScrollLoopCount=" + this.e + ", downloadTaskDuration=" + this.f + ", invokeTaskDuration=" + this.g + ", invokeTaskShowTime=" + this.h + ", tailNineSplitScreen=" + this.i + ", tailNineChargeModify=" + this.j + ", tailNineSplitChargeDuration=" + this.k + ", btnIconShowSwitch=" + this.l + ", bottomArrowShow=" + this.m + ", bigCardAutoInvoke=" + this.n + ", bigCardAutoInvokeChargeMode=" + this.o + ", bigCardAutoInvokeChargeTime=" + this.p + ", imageNineSplitScreen=" + this.q + ", imageNineChargeModify=" + this.r + ", imageNineSplitChargeDuration=" + this.s + ", formChargeDelayTime=" + this.t + ", formAutoInvoke=" + this.u + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ym0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            boolean z;
            boolean z2;
            int i;
            int i2;
            int i3;
            boolean z3;
            int i4;
            int i5;
            int i6;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    if (jSONObject.optInt("show_tail_frame", 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (jSONObject.optInt("unmount_lp_url") == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int optInt = jSONObject.optInt("ad_immersive_video_tip_delay", -1);
                    int optInt2 = jSONObject.optInt("ad_immersive_video_tip_type", 0);
                    int optInt3 = jSONObject.optInt("auto_scroll_loop", 0);
                    int optInt4 = jSONObject.optInt("download_exp_duration");
                    String optString = jSONObject.optString("invoke_exp_duration");
                    Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"invoke_exp_duration\")");
                    Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString);
                    if (intOrNull != null) {
                        i = intOrNull.intValue();
                    } else {
                        i = 0;
                    }
                    String optString2 = jSONObject.optString("invoke_exp_show_time");
                    Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"invoke_exp_show_time\")");
                    Integer intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(optString2);
                    if (intOrNull2 != null) {
                        i2 = intOrNull2.intValue();
                    } else {
                        i2 = 10;
                    }
                    boolean areEqual = Intrinsics.areEqual(jSONObject.optString("tail_nine_split_screen", "0"), "1");
                    String optString3 = jSONObject.optString("tail_nine_charge_modify", "0");
                    Intrinsics.checkNotNullExpressionValue(optString3, "it.optString(\"tail_nine_charge_modify\", \"0\")");
                    String optString4 = jSONObject.optString("tail_nine_split_screen_charge_duration");
                    Intrinsics.checkNotNullExpressionValue(optString4, "it.optString(\"tail_nine_…_screen_charge_duration\")");
                    Integer intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull(optString4);
                    if (intOrNull3 != null) {
                        i3 = intOrNull3.intValue();
                    } else {
                        i3 = 0;
                    }
                    if (jSONObject.optInt("btn_icon_show_switch", 1) == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean areEqual2 = Intrinsics.areEqual(jSONObject.optString("bottom_arrow_show_switch", "0"), "1");
                    boolean areEqual3 = Intrinsics.areEqual(jSONObject.optString("big_card_nine_split_screen", "0"), "1");
                    String optString5 = jSONObject.optString("big_card_nine_charge_modify", "0");
                    Intrinsics.checkNotNullExpressionValue(optString5, "it.optString(\"big_card_nine_charge_modify\", \"0\")");
                    String optString6 = jSONObject.optString("big_card_nine_split_screen_charge_duration");
                    Intrinsics.checkNotNullExpressionValue(optString6, "it.optString(\"big_card_n…_screen_charge_duration\")");
                    Integer intOrNull4 = StringsKt__StringNumberConversionsKt.toIntOrNull(optString6);
                    if (intOrNull4 != null) {
                        i4 = intOrNull4.intValue();
                    } else {
                        i4 = 0;
                    }
                    boolean areEqual4 = Intrinsics.areEqual(jSONObject.optString("image_info_nine_split_screen", "0"), "1");
                    String optString7 = jSONObject.optString("image_info_nine_charge_modify", "0");
                    Intrinsics.checkNotNullExpressionValue(optString7, "it.optString(\"image_info_nine_charge_modify\", \"0\")");
                    String optString8 = jSONObject.optString("image_info_nine_split_screen_charge_duration");
                    Intrinsics.checkNotNullExpressionValue(optString8, "it.optString(\"image_info…_screen_charge_duration\")");
                    Integer intOrNull5 = StringsKt__StringNumberConversionsKt.toIntOrNull(optString8);
                    if (intOrNull5 != null) {
                        i5 = intOrNull5.intValue();
                    } else {
                        i5 = 0;
                    }
                    String optString9 = jSONObject.optString("form_charge_delay_time");
                    Intrinsics.checkNotNullExpressionValue(optString9, "it.optString(\"form_charge_delay_time\")");
                    Integer intOrNull6 = StringsKt__StringNumberConversionsKt.toIntOrNull(optString9);
                    if (intOrNull6 != null) {
                        i6 = intOrNull6.intValue();
                    } else {
                        i6 = 0;
                    }
                    return new ym0(z, z2, optInt, optInt2, optInt3, optInt4, i, i2, areEqual, optString3, i3, z3, areEqual2, areEqual3, optString5, i4, areEqual4, optString7, i5, i6, Intrinsics.areEqual(jSONObject.optString("form_auto_invoke", "0"), "1"));
                }
                return null;
            }
            return (ym0) invokeL.objValue;
        }
    }

    public ym0(boolean z, boolean z2, int i, int i2, int i3, int i4, int i5, int i6, boolean z3, String tailNineChargeModify, int i7, boolean z4, boolean z5, boolean z6, String bigCardAutoInvokeChargeMode, int i8, boolean z7, String imageNineChargeModify, int i9, int i10, boolean z8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z3), tailNineChargeModify, Integer.valueOf(i7), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), bigCardAutoInvokeChargeMode, Integer.valueOf(i8), Boolean.valueOf(z7), imageNineChargeModify, Integer.valueOf(i9), Integer.valueOf(i10), Boolean.valueOf(z8)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i11 = newInitContext.flag;
            if ((i11 & 1) != 0) {
                int i12 = i11 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tailNineChargeModify, "tailNineChargeModify");
        Intrinsics.checkNotNullParameter(bigCardAutoInvokeChargeMode, "bigCardAutoInvokeChargeMode");
        Intrinsics.checkNotNullParameter(imageNineChargeModify, "imageNineChargeModify");
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = i6;
        this.i = z3;
        this.j = tailNineChargeModify;
        this.k = i7;
        this.l = z4;
        this.m = z5;
        this.n = z6;
        this.o = bigCardAutoInvokeChargeMode;
        this.p = i8;
        this.q = z7;
        this.r = imageNineChargeModify;
        this.s = i9;
        this.t = i10;
        this.u = z8;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.p;
            if (i <= 0) {
                return 0L;
            }
            return TimeUnit.SECONDS.toMillis(i);
        }
        return invokeV.longValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public final Long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.f;
            if (i <= 0) {
                return null;
            }
            return Long.valueOf(TimeUnit.SECONDS.toMillis(i));
        }
        return (Long) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.t;
            if (i <= 0) {
                return 0L;
            }
            return TimeUnit.SECONDS.toMillis(i);
        }
        return invokeV.longValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public final long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i = this.s;
            if (i <= 0) {
                return 0L;
            }
            return TimeUnit.SECONDS.toMillis(i);
        }
        return invokeV.longValue;
    }

    public final Long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i = this.g;
            if (i <= 0) {
                return null;
            }
            return Long.valueOf(TimeUnit.SECONDS.toMillis(i));
        }
        return (Long) invokeV.objValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i = this.k;
            if (i <= 0) {
                return 0L;
            }
            return TimeUnit.SECONDS.toMillis(i);
        }
        return invokeV.longValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }
}
