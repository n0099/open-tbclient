package com.bytedance.sdk.openadsdk.core.e;

import android.util.SparseArray;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.core.b.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f66720a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f66721b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f66722c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f66723d;

    /* renamed from: e  reason: collision with root package name */
    public final int f66724e;

    /* renamed from: f  reason: collision with root package name */
    public final int f66725f;

    /* renamed from: g  reason: collision with root package name */
    public final int f66726g;

    /* renamed from: h  reason: collision with root package name */
    public final int f66727h;

    /* renamed from: i  reason: collision with root package name */
    public final long f66728i;

    /* renamed from: j  reason: collision with root package name */
    public final long f66729j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final String o;
    public SparseArray<c.a> p;

    /* renamed from: com.bytedance.sdk.openadsdk.core.e.f$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f66730a;

        /* renamed from: b  reason: collision with root package name */
        public long f66731b;

        /* renamed from: c  reason: collision with root package name */
        public int f66732c;

        /* renamed from: d  reason: collision with root package name */
        public int f66733d;

        /* renamed from: e  reason: collision with root package name */
        public int f66734e;

        /* renamed from: f  reason: collision with root package name */
        public int f66735f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f66736g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f66737h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f66738i;

        /* renamed from: j  reason: collision with root package name */
        public int[] f66739j;
        public int k;
        public int l;
        public int m;
        public SparseArray<c.a> n;
        public int o;
        public String p;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.o = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                this.f66731b = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.f66733d = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f66734e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                this.f66735f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                this.k = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                this.l = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.m = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(SparseArray<c.a> sparseArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArray)) == null) {
                this.n = sparseArray;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f66732c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iArr)) == null) {
                this.f66738i = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iArr)) == null) {
                this.f66739j = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f66730a = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
                this.f66737h = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) {
                this.f66736g = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.p = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public f a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new f(this, null) : (f) invokeV.objValue;
        }
    }

    public f(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66720a = aVar.f66737h;
        this.f66721b = aVar.f66738i;
        this.f66723d = aVar.f66739j;
        this.f66722c = aVar.f66736g;
        this.f66724e = aVar.f66735f;
        this.f66725f = aVar.f66734e;
        this.f66726g = aVar.f66733d;
        this.f66727h = aVar.f66732c;
        this.f66728i = aVar.f66731b;
        this.f66729j = aVar.f66730a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.o;
        this.p = aVar.n;
        this.o = aVar.p;
    }

    public /* synthetic */ f(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    @Keep
    @JProtect
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f66720a != null && this.f66720a.length == 2) {
                    jSONObject.putOpt("ad_x", Integer.valueOf(this.f66720a[0])).putOpt("ad_y", Integer.valueOf(this.f66720a[1]));
                }
                if (this.f66721b != null && this.f66721b.length == 2) {
                    jSONObject.putOpt("width", Integer.valueOf(this.f66721b[0])).putOpt("height", Integer.valueOf(this.f66721b[1]));
                }
                if (this.f66722c != null && this.f66722c.length == 2) {
                    jSONObject.putOpt("button_x", Integer.valueOf(this.f66722c[0])).putOpt("button_y", Integer.valueOf(this.f66722c[1]));
                }
                if (this.f66723d != null && this.f66723d.length == 2) {
                    jSONObject.putOpt("button_width", Integer.valueOf(this.f66723d[0])).putOpt("button_height", Integer.valueOf(this.f66723d[1]));
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (this.p != null) {
                    for (int i2 = 0; i2 < this.p.size(); i2++) {
                        c.a valueAt = this.p.valueAt(i2);
                        if (valueAt != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.putOpt("force", Double.valueOf(valueAt.f66540c)).putOpt("mr", Double.valueOf(valueAt.f66539b)).putOpt("phase", Integer.valueOf(valueAt.f66538a)).putOpt("ts", Long.valueOf(valueAt.f66541d));
                            jSONArray.put(jSONObject3);
                        }
                    }
                }
                jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
                jSONObject.putOpt("down_x", Integer.valueOf(this.f66724e)).putOpt("down_y", Integer.valueOf(this.f66725f)).putOpt("up_x", Integer.valueOf(this.f66726g)).putOpt("up_y", Integer.valueOf(this.f66727h)).putOpt("down_time", Long.valueOf(this.f66728i)).putOpt("up_time", Long.valueOf(this.f66729j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.o);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
