package com.bytedance.sdk.component.adnet.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f27917a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27918b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f27919c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f27920d;

    /* renamed from: e  reason: collision with root package name */
    public int f27921e;

    /* renamed from: f  reason: collision with root package name */
    public int f27922f;

    /* renamed from: g  reason: collision with root package name */
    public int f27923g;

    /* renamed from: h  reason: collision with root package name */
    public int f27924h;

    /* renamed from: i  reason: collision with root package name */
    public int f27925i;
    public int j;
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
        this.f27917a = false;
        this.f27918b = true;
        this.f27919c = null;
        this.f27920d = null;
        this.f27921e = 10;
        this.f27922f = 1;
        this.f27923g = 1;
        this.f27924h = 10;
        this.f27925i = 1;
        this.j = 1;
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
            sb.append(this.f27917a);
            sb.append(" probeEnable: ");
            sb.append(this.f27918b);
            sb.append(" hostFilter: ");
            Map<String, Integer> map = this.f27919c;
            sb.append(map != null ? map.size() : 0);
            sb.append(" hostMap: ");
            Map<String, String> map2 = this.f27920d;
            sb.append(map2 != null ? map2.size() : 0);
            sb.append(" reqTo: ");
            sb.append(this.f27921e);
            sb.append("#");
            sb.append(this.f27922f);
            sb.append("#");
            sb.append(this.f27923g);
            sb.append(" reqErr: ");
            sb.append(this.f27924h);
            sb.append("#");
            sb.append(this.f27925i);
            sb.append("#");
            sb.append(this.j);
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
