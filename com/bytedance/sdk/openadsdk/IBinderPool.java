package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface IBinderPool extends IInterface {

    /* loaded from: classes9.dex */
    public static class Default implements IBinderPool {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Default() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i2) throws RemoteException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                return null;
            }
            return (IBinder) invokeI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IBinderPool {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static class a implements IBinderPool {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static IBinderPool f65700a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f65701b;

            public a(IBinder iBinder) {
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
                this.f65701b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65701b : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.openadsdk.IBinderPool
            public IBinder queryBinder(int i2) throws RemoteException {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IBinderPool");
                        obtain.writeInt(i2);
                        if (!this.f65701b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().queryBinder(i2);
                        }
                        obtain2.readException();
                        return obtain2.readStrongBinder();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (IBinder) invokeI.objValue;
            }
        }

        public Stub() {
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
            attachInterface(this, "com.bytedance.sdk.openadsdk.IBinderPool");
        }

        public static IBinderPool asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IBinderPool");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IBinderPool)) {
                    return (IBinderPool) queryLocalInterface;
                }
                return new a(iBinder);
            }
            return (IBinderPool) invokeL.objValue;
        }

        public static IBinderPool getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f65700a : (IBinderPool) invokeV.objValue;
        }

        public static boolean setDefaultImpl(IBinderPool iBinderPool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iBinderPool)) == null) {
                if (a.f65700a != null || iBinderPool == null) {
                    return false;
                }
                a.f65700a = iBinderPool;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 != 1) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.bytedance.sdk.openadsdk.IBinderPool");
                    return true;
                }
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IBinderPool");
                IBinder queryBinder = queryBinder(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(queryBinder);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    IBinder queryBinder(int i2) throws RemoteException;
}
