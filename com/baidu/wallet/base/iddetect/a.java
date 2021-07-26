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
    public int f24224a;

    /* renamed from: b  reason: collision with root package name */
    public int f24225b;

    /* renamed from: c  reason: collision with root package name */
    public float f24226c;

    /* renamed from: d  reason: collision with root package name */
    public float f24227d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24228e;

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
        this.f24228e = false;
        this.f24224a = i2;
        this.f24225b = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f24228e) {
                return this.f24227d < aVar.f24227d ? -1 : 1;
            }
            int i2 = this.f24225b;
            int i3 = aVar.f24225b;
            if (i2 < i3) {
                return -1;
            }
            return (i2 <= i3 && this.f24224a < aVar.f24224a) ? -1 : 1;
        }
        return invokeL.intValue;
    }
}
