package com.bytedance.sdk.component.adnet.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64580a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64581b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f64582c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f64583d;

    /* renamed from: e  reason: collision with root package name */
    public int f64584e;

    /* renamed from: f  reason: collision with root package name */
    public int f64585f;

    /* renamed from: g  reason: collision with root package name */
    public int f64586g;

    /* renamed from: h  reason: collision with root package name */
    public int f64587h;

    /* renamed from: i  reason: collision with root package name */
    public int f64588i;

    /* renamed from: j  reason: collision with root package name */
    public int f64589j;
    public int k;
    public int l;
    public String m;
    public int n;
    public long o;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64580a = false;
        this.f64581b = true;
        this.f64582c = null;
        this.f64583d = null;
        this.f64584e = 10;
        this.f64585f = 1;
        this.f64586g = 1;
        this.f64587h = 10;
        this.f64588i = 1;
        this.f64589j = 1;
        this.k = 900;
        this.l = 120;
        this.m = null;
        this.n = 0;
        this.o = 0L;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" localEnable: ");
            sb.append(this.f64580a);
            sb.append(" probeEnable: ");
            sb.append(this.f64581b);
            sb.append(" hostFilter: ");
            Map<String, Integer> map = this.f64582c;
            sb.append(map != null ? map.size() : 0);
            sb.append(" hostMap: ");
            Map<String, String> map2 = this.f64583d;
            sb.append(map2 != null ? map2.size() : 0);
            sb.append(" reqTo: ");
            sb.append(this.f64584e);
            sb.append("#");
            sb.append(this.f64585f);
            sb.append("#");
            sb.append(this.f64586g);
            sb.append(" reqErr: ");
            sb.append(this.f64587h);
            sb.append("#");
            sb.append(this.f64588i);
            sb.append("#");
            sb.append(this.f64589j);
            sb.append(" updateInterval: ");
            sb.append(this.k);
            sb.append(" updateRandom: ");
            sb.append(this.l);
            sb.append(" httpBlack: ");
            sb.append(this.m);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
