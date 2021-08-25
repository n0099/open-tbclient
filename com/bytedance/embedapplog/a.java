package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface a extends IInterface {

    /* renamed from: com.bytedance.embedapplog.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static abstract class AbstractBinderC1871a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.bytedance.embedapplog.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C1872a implements a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f63879a;

            public C1872a(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63879a = iBinder;
            }

            @Override // com.bytedance.embedapplog.a
            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f63879a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63879a : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.embedapplog.a
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f63879a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.bytedance.embedapplog.a
            public String c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f63879a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.bytedance.embedapplog.a
            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f63879a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.bytedance.embedapplog.a
            public boolean e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f63879a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.bytedance.embedapplog.a
            public void f() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f63879a.transact(6, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
        }

        public static a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                    return (a) queryLocalInterface;
                }
                return new C1872a(iBinder);
            }
            return (a) invokeL.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 != 1598968902) {
                    switch (i2) {
                        case 1:
                            parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                            String a2 = a();
                            parcel2.writeNoException();
                            parcel2.writeString(a2);
                            return true;
                        case 2:
                            parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                            boolean b2 = b();
                            parcel2.writeNoException();
                            parcel2.writeInt(b2 ? 1 : 0);
                            return true;
                        case 3:
                            parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                            String c2 = c();
                            parcel2.writeNoException();
                            parcel2.writeString(c2);
                            return true;
                        case 4:
                            parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                            String d2 = d();
                            parcel2.writeNoException();
                            parcel2.writeString(d2);
                            return true;
                        case 5:
                            parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                            boolean e2 = e();
                            parcel2.writeNoException();
                            parcel2.writeInt(e2 ? 1 : 0);
                            return true;
                        case 6:
                            parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                            f();
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    String a();

    boolean b();

    String c();

    String d();

    boolean e();

    void f();
}
