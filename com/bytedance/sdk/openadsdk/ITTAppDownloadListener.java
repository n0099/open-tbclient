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
public interface ITTAppDownloadListener extends IInterface {

    /* loaded from: classes9.dex */
    public static class Default implements ITTAppDownloadListener {
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

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onIdle() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onInstalled(String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements ITTAppDownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static class a implements ITTAppDownloadListener {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static ITTAppDownloadListener f64986a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f64987b;

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
                this.f64987b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64987b : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (!this.f64987b.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onDownloadActive(j2, j3, str, str2);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (!this.f64987b.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onDownloadFailed(j2, j3, str, str2);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        obtain.writeLong(j2);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.f64987b.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onDownloadFinished(j2, str, str2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (!this.f64987b.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onDownloadPaused(j2, j3, str, str2);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onIdle() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        if (!this.f64987b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onIdle();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onInstalled(String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.f64987b.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onInstalled(str, str2);
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
            attachInterface(this, "com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        }

        public static ITTAppDownloadListener asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                if (queryLocalInterface != null && (queryLocalInterface instanceof ITTAppDownloadListener)) {
                    return (ITTAppDownloadListener) queryLocalInterface;
                }
                return new a(iBinder);
            }
            return (ITTAppDownloadListener) invokeL.objValue;
        }

        public static ITTAppDownloadListener getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f64986a : (ITTAppDownloadListener) invokeV.objValue;
        }

        public static boolean setDefaultImpl(ITTAppDownloadListener iTTAppDownloadListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iTTAppDownloadListener)) == null) {
                if (a.f64986a != null || iTTAppDownloadListener == null) {
                    return false;
                }
                a.f64986a = iTTAppDownloadListener;
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
                if (i2 != 1598968902) {
                    switch (i2) {
                        case 1:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                            onIdle();
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                            onDownloadActive(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 3:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                            onDownloadPaused(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                            onDownloadFailed(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                            onDownloadFinished(parcel.readLong(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 6:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                            onInstalled(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    void onDownloadActive(long j2, long j3, String str, String str2) throws RemoteException;

    void onDownloadFailed(long j2, long j3, String str, String str2) throws RemoteException;

    void onDownloadFinished(long j2, String str, String str2) throws RemoteException;

    void onDownloadPaused(long j2, long j3, String str, String str2) throws RemoteException;

    void onIdle() throws RemoteException;

    void onInstalled(String str, String str2) throws RemoteException;
}
