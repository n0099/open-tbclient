package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.interfaces.IIdProvider;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.huawei.hms.common.internal.TransactionIdCreater;
import org.aspectj.runtime.reflect.SignatureImpl;
@Keep
/* loaded from: classes7.dex */
public abstract class o implements IIdProvider {
    public static /* synthetic */ Interceptable $ic;
    @Keep
    public static final char[] e;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public IIdentifierListener a;
    @Keep
    public boolean b;
    @Keep
    public boolean c;
    @Keep
    public boolean d;

    @Keep
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final /* synthetic */ o a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        @Keep
        public native void run();
    }

    @Keep
    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final /* synthetic */ o a;

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        @Keep
        public native void run();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2134063020, "Lcom/bun/miitmdid/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2134063020, "Lcom/bun/miitmdid/o;");
                return;
            }
        }
        e = new char[]{TransactionIdCreater.FILL_BYTE, SignatureImpl.SEP};
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Keep
    public native Context a(Context context);

    @Keep
    public native void a(String str, String str2, String str3, boolean z, boolean z2);

    @Keep
    public native boolean a();

    @Keep
    public native boolean b();

    @Keep
    public native boolean c();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void doStartInThreadPool(IIdentifierListener iIdentifierListener);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void doStartSync(IIdentifierListener iIdentifierListener);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void setGetIdFlag(boolean z, boolean z2, boolean z3);
}
