package com.bytedance.sdk.component.adnet.b;

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
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.i;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.core.o;
import java.io.UnsupportedEncodingException;
/* loaded from: classes9.dex */
public abstract class c<T> extends Request<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f64227c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final Object f64228d;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    public m.a<T> f64229e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f64230f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1398251809, "Lcom/bytedance/sdk/component/adnet/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1398251809, "Lcom/bytedance/sdk/component/adnet/b/c;");
                return;
            }
        }
        f64227c = String.format("application/json; charset=%s", "utf-8");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str, @Nullable String str2, @Nullable m.a<T> aVar) {
        super(i2, str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (m.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64228d = new Object();
        this.f64229e = aVar;
        this.f64230f = str2;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public abstract m<T> a(i iVar);

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void a(m<T> mVar) {
        m.a<T> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
            synchronized (this.f64228d) {
                aVar = this.f64229e;
            }
            if (aVar != null) {
                aVar.a(mVar);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cancel();
            synchronized (this.f64228d) {
                this.f64229e = null;
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public byte[] getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.f64230f == null) {
                    return null;
                }
                return this.f64230f.getBytes("utf-8");
            } catch (UnsupportedEncodingException unused) {
                o.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f64230f, "utf-8");
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public String getBodyContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f64227c : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getBody() : (byte[]) invokeV.objValue;
    }
}
