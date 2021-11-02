package com.bytedance.pangle;

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
/* loaded from: classes11.dex */
public interface d extends IInterface {
    boolean a(String str);

    int b(String str);

    boolean c(String str);

    /* loaded from: classes11.dex */
    public static abstract class a extends Binder implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.bytedance.pangle.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C1840a implements d {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static d f61278a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f61279b;

            public C1840a(IBinder iBinder) {
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
                this.f61279b = iBinder;
            }

            @Override // com.bytedance.pangle.d
            public final boolean a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                        obtain.writeString(str);
                        if (!this.f61279b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().a(str);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeL.booleanValue;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61279b : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.pangle.d
            public final int b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                        obtain.writeString(str);
                        if (!this.f61279b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().b(str);
                        }
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeL.intValue;
            }

            @Override // com.bytedance.pangle.d
            public final boolean c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                        obtain.writeString(str);
                        if (!this.f61279b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().c(str);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeL.booleanValue;
            }
        }

        public a() {
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
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static d a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
                if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                    return (d) queryLocalInterface;
                }
                return new C1840a(iBinder);
            }
            return (d) invokeL.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1) {
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    boolean a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    int b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                } else if (i2 != 3) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                } else {
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    boolean c2 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        public static d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C1840a.f61278a : (d) invokeV.objValue;
        }
    }
}
