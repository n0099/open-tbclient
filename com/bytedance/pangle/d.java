package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
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
import com.bytedance.pangle.f;
/* loaded from: classes4.dex */
public interface d extends IInterface {
    ComponentName a(Intent intent, String str);

    void a(f fVar);

    boolean a(Intent intent, f fVar, int i, String str);

    boolean b(Intent intent, String str);

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static d a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
                if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                    return (d) queryLocalInterface;
                }
                return new C0255a(iBinder);
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
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i == 1) {
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    ComponentName a = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                } else if (i == 2) {
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    boolean b = b(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                } else if (i == 3) {
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    boolean a2 = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, f.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                } else if (i != 4) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.bytedance.pangle.IServiceManager");
                    return true;
                } else {
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    a(f.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        public static d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0255a.a : (d) invokeV.objValue;
        }

        /* renamed from: com.bytedance.pangle.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0255a implements d {
            public static /* synthetic */ Interceptable $ic;
            public static d a;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder b;

            public C0255a(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.d
            public final ComponentName a(Intent intent, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, intent, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                        if (intent != null) {
                            obtain.writeInt(1);
                            intent.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().a(intent, str);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (ComponentName) invokeLL.objValue;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.pangle.d
            public final boolean b(Intent intent, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, intent, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                        if (intent != null) {
                            obtain.writeInt(1);
                            intent.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().b(intent, str);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeLL.booleanValue;
            }

            @Override // com.bytedance.pangle.d
            public final boolean a(Intent intent, f fVar, int i, String str) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, intent, fVar, i, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                        if (intent != null) {
                            obtain.writeInt(1);
                            intent.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        if (!this.b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().a(intent, fVar, i, str);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeLLIL.booleanValue;
            }

            @Override // com.bytedance.pangle.d
            public final void a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                        obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                        if (!this.b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                            a.a().a(fVar);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
        }
    }
}
