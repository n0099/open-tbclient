package com.bytedance.sdk.component.image.c.a.b;

import android.os.Build;
import android.util.LruCache;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IRawCache;
/* loaded from: classes9.dex */
public class c implements IRawCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65541a;

    /* renamed from: b  reason: collision with root package name */
    public int f65542b;

    /* renamed from: c  reason: collision with root package name */
    public int f65543c;

    /* renamed from: d  reason: collision with root package name */
    public LruCache<String, byte[]> f65544d;

    public c(int i2, int i3) {
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
        this.f65543c = i2;
        this.f65541a = i3;
        this.f65544d = new LruCache<String, byte[]>(this, i2) { // from class: com.bytedance.sdk.component.image.c.a.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65545a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(i2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65545a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str, byte[] bArr) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, bArr)) == null) ? bArr.length : invokeLL.intValue;
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    @Nullable
    public boolean a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bArr)) == null) {
            if (str == null || bArr == null) {
                return false;
            }
            this.f65544d.put(str, bArr);
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    @Nullable
    public byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f65544d.get(str) : (byte[]) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.image.c.a.a
    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.f65544d.trimToSize((int) (this.f65543c * d2));
            } else {
                this.f65544d.evictAll();
            }
        }
    }
}
