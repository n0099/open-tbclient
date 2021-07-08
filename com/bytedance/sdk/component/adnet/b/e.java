package com.bytedance.sdk.component.adnet.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.b.d;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.i;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.core.o;
/* loaded from: classes5.dex */
public class e extends Request<Bitmap> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Object f27906f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Object f27907c;

    /* renamed from: d  reason: collision with root package name */
    public final d.InterfaceC0314d f27908d;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    public m.a<Bitmap> f27909e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1398251747, "Lcom/bytedance/sdk/component/adnet/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1398251747, "Lcom/bytedance/sdk/component/adnet/b/e;");
                return;
            }
        }
        f27906f = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, m.a<Bitmap> aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar, Integer.valueOf(i2), Integer.valueOf(i3), scaleType, config};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (m.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27907c = new Object();
        setRetryPolicy(new com.bytedance.sdk.component.adnet.core.e(1000, 2, 2.0f));
        this.f27909e = aVar;
        this.f27908d = new com.bytedance.sdk.component.adnet.d.a(i2, i3, scaleType, config);
        setShouldCache(false);
    }

    private m<Bitmap> b(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, iVar)) == null) {
            Bitmap a2 = a(iVar.f28015b);
            if (a2 == null) {
                return m.a(new com.bytedance.sdk.component.adnet.err.e(iVar));
            }
            return m.a(a2, com.bytedance.sdk.component.adnet.d.c.a(iVar));
        }
        return (m) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public m<Bitmap> a(i iVar) {
        InterceptResult invokeL;
        m<Bitmap> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar)) == null) {
            synchronized (f27906f) {
                try {
                    try {
                        b2 = b(iVar);
                    } catch (OutOfMemoryError e2) {
                        o.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(iVar.f28015b.length), getUrl());
                        return m.a(new com.bytedance.sdk.component.adnet.err.e(e2, 612));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return b2;
        }
        return (m) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.cancel();
            synchronized (this.f27907c) {
                this.f27909e = null;
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public Request.b getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Request.b.f27958a : (Request.b) invokeV.objValue;
    }

    public Bitmap a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) ? this.f27908d.a(bArr) : (Bitmap) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void a(m<Bitmap> mVar) {
        m.a<Bitmap> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            synchronized (this.f27907c) {
                aVar = this.f27909e;
            }
            if (aVar != null) {
                aVar.a(mVar);
            }
        }
    }
}
