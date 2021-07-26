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
    public boolean f28015a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28016b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f28017c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f28018d;

    /* renamed from: e  reason: collision with root package name */
    public int f28019e;

    /* renamed from: f  reason: collision with root package name */
    public int f28020f;

    /* renamed from: g  reason: collision with root package name */
    public int f28021g;

    /* renamed from: h  reason: collision with root package name */
    public int f28022h;

    /* renamed from: i  reason: collision with root package name */
    public int f28023i;
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
        this.f28015a = false;
        this.f28016b = true;
        this.f28017c = null;
        this.f28018d = null;
        this.f28019e = 10;
        this.f28020f = 1;
        this.f28021g = 1;
        this.f28022h = 10;
        this.f28023i = 1;
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
            sb.append(this.f28015a);
            sb.append(" probeEnable: ");
            sb.append(this.f28016b);
            sb.append(" hostFilter: ");
            Map<String, Integer> map = this.f28017c;
            sb.append(map != null ? map.size() : 0);
            sb.append(" hostMap: ");
            Map<String, String> map2 = this.f28018d;
            sb.append(map2 != null ? map2.size() : 0);
            sb.append(" reqTo: ");
            sb.append(this.f28019e);
            sb.append("#");
            sb.append(this.f28020f);
            sb.append("#");
            sb.append(this.f28021g);
            sb.append(" reqErr: ");
            sb.append(this.f28022h);
            sb.append("#");
            sb.append(this.f28023i);
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
