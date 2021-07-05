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
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f29916a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f29917b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f29918c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f29919d;

    /* renamed from: e  reason: collision with root package name */
    public final int f29920e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29921f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29922g;

    /* renamed from: h  reason: collision with root package name */
    public final int f29923h;

    /* renamed from: i  reason: collision with root package name */
    public final long f29924i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final String o;
    public SparseArray<c.a> p;

    /* renamed from: com.bytedance.sdk.openadsdk.core.e.f$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f29925a;

        /* renamed from: b  reason: collision with root package name */
        public long f29926b;

        /* renamed from: c  reason: collision with root package name */
        public int f29927c;

        /* renamed from: d  reason: collision with root package name */
        public int f29928d;

        /* renamed from: e  reason: collision with root package name */
        public int f29929e;

        /* renamed from: f  reason: collision with root package name */
        public int f29930f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f29931g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f29932h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f29933i;
        public int[] j;
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

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f29926b = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.f29928d = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f29929e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                this.f29930f = i2;
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
                this.f29927c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iArr)) == null) {
                this.f29933i = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iArr)) == null) {
                this.j = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.f29925a = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
                this.f29932h = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) {
                this.f29931g = iArr;
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
        this.f29916a = aVar.f29932h;
        this.f29917b = aVar.f29933i;
        this.f29919d = aVar.j;
        this.f29918c = aVar.f29931g;
        this.f29920e = aVar.f29930f;
        this.f29921f = aVar.f29929e;
        this.f29922g = aVar.f29928d;
        this.f29923h = aVar.f29927c;
        this.f29924i = aVar.f29926b;
        this.j = aVar.f29925a;
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
                if (this.f29916a != null && this.f29916a.length == 2) {
                    jSONObject.putOpt("ad_x", Integer.valueOf(this.f29916a[0])).putOpt("ad_y", Integer.valueOf(this.f29916a[1]));
                }
                if (this.f29917b != null && this.f29917b.length == 2) {
                    jSONObject.putOpt("width", Integer.valueOf(this.f29917b[0])).putOpt("height", Integer.valueOf(this.f29917b[1]));
                }
                if (this.f29918c != null && this.f29918c.length == 2) {
                    jSONObject.putOpt("button_x", Integer.valueOf(this.f29918c[0])).putOpt("button_y", Integer.valueOf(this.f29918c[1]));
                }
                if (this.f29919d != null && this.f29919d.length == 2) {
                    jSONObject.putOpt("button_width", Integer.valueOf(this.f29919d[0])).putOpt("button_height", Integer.valueOf(this.f29919d[1]));
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (this.p != null) {
                    for (int i2 = 0; i2 < this.p.size(); i2++) {
                        c.a valueAt = this.p.valueAt(i2);
                        if (valueAt != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.putOpt("force", Double.valueOf(valueAt.f29747c)).putOpt("mr", Double.valueOf(valueAt.f29746b)).putOpt("phase", Integer.valueOf(valueAt.f29745a)).putOpt("ts", Long.valueOf(valueAt.f29748d));
                            jSONArray.put(jSONObject3);
                        }
                    }
                }
                jSONObject2.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
                jSONObject.putOpt("down_x", Integer.valueOf(this.f29920e)).putOpt("down_y", Integer.valueOf(this.f29921f)).putOpt("up_x", Integer.valueOf(this.f29922g)).putOpt("up_y", Integer.valueOf(this.f29923h)).putOpt("down_time", Long.valueOf(this.f29924i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.o);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
