package com.bun.miitmdid;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.interfaces.IIdProvider;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.pojo.IdSupplierImpl;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes12.dex */
public abstract class n implements IIdProvider {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f54428b;
    public transient /* synthetic */ FieldHolder $fh;
    public IIdentifierListener a;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.doStart();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.doStart();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2134063051, "Lcom/bun/miitmdid/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2134063051, "Lcom/bun/miitmdid/n;");
                return;
            }
        }
        f54428b = new char[]{'0', SignatureImpl.SEP};
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public Context a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? context == null ? com.bun.miitmdid.a.c() : context.getApplicationContext() : (Context) invokeL.objValue;
    }

    public void a(String str, String str2, String str3, boolean z, boolean z2) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.a == null) {
                e0.d("BaseProvider", "onSupport: callback Listener is null");
                return;
            }
            if (z) {
                str4 = str;
                str5 = str2;
                str6 = str3;
            } else {
                str4 = "";
                str5 = str4;
                str6 = str5;
            }
            boolean z3 = (z && (str4 == null || str4.isEmpty() || f0.a(str4, f54428b))) ? true : z2;
            e0.c("BaseProvider", "mcallback onSupport");
            this.a.onSupport(new IdSupplierImpl(str4, str5, str6, z, z3));
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStartInThreadPool(IIdentifierListener iIdentifierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iIdentifierListener) == null) {
            this.a = iIdentifierListener;
            g0.a(new a(this));
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStartSync(IIdentifierListener iIdentifierListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iIdentifierListener) == null) {
            this.a = iIdentifierListener;
            g0.a(new b(this));
            if (this.a == null) {
                e0.d("BaseProvider", "doStart: callback Listener is null");
            }
        }
    }
}
