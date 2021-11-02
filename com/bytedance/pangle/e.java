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
import com.bytedance.pangle.g;
/* loaded from: classes11.dex */
public interface e extends IInterface {
    ComponentName a(Intent intent, String str);

    void a(g gVar);

    boolean a(Intent intent, g gVar, int i2, String str);

    boolean b(Intent intent, String str);

    /* loaded from: classes11.dex */
    public static abstract class a extends Binder implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static e a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
                if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                    return (e) queryLocalInterface;
                }
                return new C1842a(iBinder);
            }
            return (e) invokeL.objValue;
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
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    ComponentName a2 = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (a2 != null) {
                        parcel2.writeInt(1);
                        a2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    boolean b2 = b(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b2 ? 1 : 0);
                    return true;
                } else if (i2 == 3) {
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    boolean a3 = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, g.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                } else if (i2 != 4) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.bytedance.pangle.IServiceManager");
                    return true;
                } else {
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    a(g.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        public static e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C1842a.f61372a : (e) invokeV.objValue;
        }

        /* renamed from: com.bytedance.pangle.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C1842a implements e {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static e f61372a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f61373b;

            public C1842a(IBinder iBinder) {
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
                this.f61373b = iBinder;
            }

            @Override // com.bytedance.pangle.e
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
                        if (!this.f61373b.transact(1, obtain, obtain2, 0) && a.a() != null) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61373b : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.pangle.e
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
                        if (!this.f61373b.transact(2, obtain, obtain2, 0) && a.a() != null) {
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

            @Override // com.bytedance.pangle.e
            public final boolean a(Intent intent, g gVar, int i2, String str) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, intent, gVar, i2, str)) == null) {
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
                        obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                        obtain.writeInt(i2);
                        obtain.writeString(str);
                        if (!this.f61373b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().a(intent, gVar, i2, str);
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

            @Override // com.bytedance.pangle.e
            public final void a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                        obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                        if (!this.f61373b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                            a.a().a(gVar);
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
