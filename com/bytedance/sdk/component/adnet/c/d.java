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
    public boolean f63854a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63855b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f63856c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f63857d;

    /* renamed from: e  reason: collision with root package name */
    public int f63858e;

    /* renamed from: f  reason: collision with root package name */
    public int f63859f;

    /* renamed from: g  reason: collision with root package name */
    public int f63860g;

    /* renamed from: h  reason: collision with root package name */
    public int f63861h;

    /* renamed from: i  reason: collision with root package name */
    public int f63862i;

    /* renamed from: j  reason: collision with root package name */
    public int f63863j;
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
        this.f63854a = false;
        this.f63855b = true;
        this.f63856c = null;
        this.f63857d = null;
        this.f63858e = 10;
        this.f63859f = 1;
        this.f63860g = 1;
        this.f63861h = 10;
        this.f63862i = 1;
        this.f63863j = 1;
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
            sb.append(this.f63854a);
            sb.append(" probeEnable: ");
            sb.append(this.f63855b);
            sb.append(" hostFilter: ");
            Map<String, Integer> map = this.f63856c;
            sb.append(map != null ? map.size() : 0);
            sb.append(" hostMap: ");
            Map<String, String> map2 = this.f63857d;
            sb.append(map2 != null ? map2.size() : 0);
            sb.append(" reqTo: ");
            sb.append(this.f63858e);
            sb.append("#");
            sb.append(this.f63859f);
            sb.append("#");
            sb.append(this.f63860g);
            sb.append(" reqErr: ");
            sb.append(this.f63861h);
            sb.append("#");
            sb.append(this.f63862i);
            sb.append("#");
            sb.append(this.f63863j);
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
