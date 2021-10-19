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
public interface d extends IInterface {
    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();

    /* loaded from: classes9.dex */
    public static abstract class a extends Binder implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static d a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                    return (d) queryLocalInterface;
                }
                return new C1882a(iBinder);
            }
            return (d) invokeL.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1) {
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                } else if (i2 == 3) {
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    boolean c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                } else if (i2 == 4) {
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a3);
                    return true;
                } else if (i2 != 5) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                    return true;
                } else {
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b3 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        /* renamed from: com.bytedance.embedapplog.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C1882a implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f64409a;

            public C1882a(IBinder iBinder) {
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
                this.f64409a = iBinder;
            }

            @Override // com.bytedance.embedapplog.d
            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f64409a.transact(1, obtain, obtain2, 0);
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64409a : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.embedapplog.d
            public String b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f64409a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.bytedance.embedapplog.d
            public boolean c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f64409a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.bytedance.embedapplog.d
            public String a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        obtain.writeString(str);
                        this.f64409a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.bytedance.embedapplog.d
            public String b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        obtain.writeString(str);
                        this.f64409a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }
        }
    }
}
