package com.baidu.wallet.base.iddetect;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f24066a;

    /* renamed from: b  reason: collision with root package name */
    public int f24067b;

    /* renamed from: c  reason: collision with root package name */
    public float f24068c;

    /* renamed from: d  reason: collision with root package name */
    public float f24069d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24070e;

    public a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24070e = false;
        this.f24066a = i2;
        this.f24067b = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f24070e) {
                return this.f24069d < aVar.f24069d ? -1 : 1;
            }
            int i2 = this.f24067b;
            int i3 = aVar.f24067b;
            if (i2 < i3) {
                return -1;
            }
            return (i2 <= i3 && this.f24066a < aVar.f24066a) ? -1 : 1;
        }
        return invokeL.intValue;
    }
}
