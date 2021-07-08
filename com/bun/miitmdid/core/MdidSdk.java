package com.bun.miitmdid.core;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.a.b;
import com.bun.miitmdid.b.c;
import com.bun.miitmdid.supplier.IdSupplier;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.supplier.b;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.a;
@Keep
/* loaded from: classes5.dex */
public class MdidSdk implements SupplierListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IIdentifierListener _InnerListener;
    public b _setting;

    /* renamed from: com.bun.miitmdid.core.MdidSdk$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27596a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(178248014, "Lcom/bun/miitmdid/core/MdidSdk$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(178248014, "Lcom/bun/miitmdid/core/MdidSdk$1;");
                    return;
                }
            }
            int[] iArr = new int[b.a.values().length];
            f27596a = iArr;
            try {
                iArr[b.a.f27614c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27596a[b.a.f27615d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27596a[b.a.f27613b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27596a[b.a.f27616e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27596a[b.a.f27617f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27596a[b.a.f27618g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27596a[b.a.f27619h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27596a[b.a.f27620i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f27596a[b.a.j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f27596a[b.a.k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f27596a[b.a.l.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Keep
    public MdidSdk() {
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
        try {
            a.a(true);
        } catch (Exception e2) {
            a.b("mdidsdk", "extractor exception!", e2);
        }
    }

    @Keep
    public MdidSdk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            a.a(z);
        } catch (Exception e2) {
            a.b("mdidsdk", "extractor exception!", e2);
        }
    }

    private int _InnerFailed(int i2, IdSupplier idSupplier) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i2, idSupplier)) == null) {
            OnSupport(idSupplier != null ? idSupplier.isSupported() : false, idSupplier);
            return i2;
        }
        return invokeIL.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.bun.miitmdid.supplier.h.a */
    /* JADX WARN: Multi-variable type inference failed */
    @Keep
    public int InitSdk(Context context, IIdentifierListener iIdentifierListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, iIdentifierListener)) == null) {
            this._InnerListener = iIdentifierListener;
            com.bun.miitmdid.utils.b.a(context);
            b.a a2 = b.a.a(Build.MANUFACTURER);
            if (a2 == b.a.f27612a) {
                return _InnerFailed(ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT, new com.bun.miitmdid.supplier.a());
            }
            com.bun.miitmdid.a.a a3 = com.bun.miitmdid.a.a.a(context);
            if (a3 == null) {
                return _InnerFailed(ErrorCode.INIT_ERROR_LOAD_CONFIGFILE, new com.bun.miitmdid.supplier.a());
            }
            this._setting = a3;
            com.bun.miitmdid.supplier.f.b bVar = null;
            switch (AnonymousClass1.f27596a[a2.ordinal()]) {
                case 1:
                    bVar = new com.bun.miitmdid.supplier.i.b(context);
                    break;
                case 2:
                    com.bun.miitmdid.supplier.h.a aVar = new com.bun.miitmdid.supplier.h.a(context);
                    aVar.a(this._setting.a());
                    bVar = aVar;
                    break;
                case 3:
                    bVar = new com.bun.miitmdid.supplier.b.a(context);
                    break;
                case 4:
                    bVar = new com.bun.miitmdid.supplier.g.a(context);
                    break;
                case 5:
                case 6:
                    bVar = new com.bun.miitmdid.supplier.e.b(context, this);
                    break;
                case 7:
                    bVar = new com.bun.miitmdid.supplier.a.a(context, this);
                    break;
                case 8:
                    bVar = new com.bun.miitmdid.supplier.sumsung.a(context, this);
                    break;
                case 9:
                case 10:
                    bVar = new com.bun.miitmdid.supplier.d.a(context);
                    break;
                case 11:
                    bVar = new com.bun.miitmdid.supplier.f.b(context);
                    break;
            }
            if (bVar == null) {
                return _InnerFailed(ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, new com.bun.miitmdid.supplier.a());
            }
            if (!bVar.b()) {
                bVar.a(this);
                return ErrorCode.INIT_ERROR_RESULT_DELAY;
            } else if (bVar.isSupported()) {
                OnSupport(true, bVar);
                return 0;
            } else {
                return _InnerFailed(ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, bVar);
            }
        }
        return invokeLL.intValue;
    }

    @Override // com.bun.miitmdid.utils.SupplierListener
    public void OnSupport(boolean z, IdSupplier idSupplier) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, idSupplier) == null) {
            IIdentifierListener iIdentifierListener = this._InnerListener;
            if (iIdentifierListener != null) {
                iIdentifierListener.OnSupport(z, idSupplier);
            }
            c cVar = new c();
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                String vaid = idSupplier.getVAID();
                String aaid = idSupplier.getAAID();
                if (idSupplier instanceof InnerIdSupplier) {
                    ((InnerIdSupplier) idSupplier).shutDown();
                }
                str = oaid;
                str2 = vaid;
                str3 = aaid;
            } else {
                str = "";
                str2 = str;
                str3 = str2;
            }
            cVar.a(z, "", str, str2, str3);
        }
    }

    public void UnInitSdk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
