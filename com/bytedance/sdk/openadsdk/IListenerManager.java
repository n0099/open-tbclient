package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
/* loaded from: classes9.dex */
public interface IListenerManager extends IInterface {

    /* loaded from: classes9.dex */
    public static class Default implements IListenerManager {
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

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void broadcastDialogListener(String str, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void broadcastPermissionListener(String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void executeAppDownloadCallback(String str, String str2, long j2, long j3, String str3, String str4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), str3, str4}) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void executeFullVideoCallback(String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void executeRewardVideoCallback(String str, String str2, boolean z, int i2, String str3, int i3, String str4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), str3, Integer.valueOf(i3), str4}) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, iCommonDialogListener) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, iFullScreenVideoAdInteractionListener) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, iCommonPermissionListener) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, str, iRewardAdInteractionListener) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, str, iTTAppDownloadListener) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, iTTAppDownloadListener) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IListenerManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static class a implements IListenerManager {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static IListenerManager f65182a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f65183b;

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
                this.f65183b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65183b : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void broadcastDialogListener(String str, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeInt(i2);
                        if (!this.f65183b.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().broadcastDialogListener(str, i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void broadcastPermissionListener(String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.f65183b.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().broadcastPermissionListener(str, str2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeAppDownloadCallback(String str, String str2, long j2, long j3, String str3, String str4) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), str3, str4}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    try {
                        if (!this.f65183b.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().executeAppDownloadCallback(str, str2, j2, j3, str3, str4);
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

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeFullVideoCallback(String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.f65183b.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().executeFullVideoCallback(str, str2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeRewardVideoCallback(String str, String str2, boolean z, int i2, String str3, int i3, String str4) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), str3, Integer.valueOf(i3), str4}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeString(str3);
                    obtain.writeInt(i3);
                    obtain.writeString(str4);
                    try {
                        if (!this.f65183b.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().executeRewardVideoCallback(str, str2, z, i2, str3, i3, str4);
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

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048582, this, str, iCommonDialogListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeStrongBinder(iCommonDialogListener != null ? iCommonDialogListener.asBinder() : null);
                        if (!this.f65183b.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().registerDialogListener(str, iCommonDialogListener);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048583, this, str, iFullScreenVideoAdInteractionListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeStrongBinder(iFullScreenVideoAdInteractionListener != null ? iFullScreenVideoAdInteractionListener.asBinder() : null);
                        if (!this.f65183b.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().registerFullVideoListener(str, iFullScreenVideoAdInteractionListener);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, iCommonPermissionListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeStrongBinder(iCommonPermissionListener != null ? iCommonPermissionListener.asBinder() : null);
                        if (!this.f65183b.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().registerPermissionListener(str, iCommonPermissionListener);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048585, this, str, iRewardAdInteractionListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeStrongBinder(iRewardAdInteractionListener != null ? iRewardAdInteractionListener.asBinder() : null);
                        if (!this.f65183b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().registerRewardVideoListener(str, iRewardAdInteractionListener);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048586, this, str, iTTAppDownloadListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeStrongBinder(iTTAppDownloadListener != null ? iTTAppDownloadListener.asBinder() : null);
                        if (!this.f65183b.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().registerTTAppDownloadListener(str, iTTAppDownloadListener);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048587, this, str, iTTAppDownloadListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                        obtain.writeString(str);
                        obtain.writeStrongBinder(iTTAppDownloadListener != null ? iTTAppDownloadListener.asBinder() : null);
                        if (!this.f65183b.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().unregisterTTAppDownloadListener(str, iTTAppDownloadListener);
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
            attachInterface(this, "com.bytedance.sdk.openadsdk.IListenerManager");
        }

        public static IListenerManager asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IListenerManager)) {
                    return (IListenerManager) queryLocalInterface;
                }
                return new a(iBinder);
            }
            return (IListenerManager) invokeL.objValue;
        }

        public static IListenerManager getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f65182a : (IListenerManager) invokeV.objValue;
        }

        public static boolean setDefaultImpl(IListenerManager iListenerManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iListenerManager)) == null) {
                if (a.f65182a != null || iListenerManager == null) {
                    return false;
                }
                a.f65182a = iListenerManager;
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
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            registerRewardVideoListener(parcel.readString(), IRewardAdInteractionListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            executeRewardVideoCallback(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 3:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            registerFullVideoListener(parcel.readString(), IFullScreenVideoAdInteractionListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            executeFullVideoCallback(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            registerTTAppDownloadListener(parcel.readString(), ITTAppDownloadListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 6:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            unregisterTTAppDownloadListener(parcel.readString(), ITTAppDownloadListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            executeAppDownloadCallback(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            registerDialogListener(parcel.readString(), ICommonDialogListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            broadcastDialogListener(parcel.readString(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            registerPermissionListener(parcel.readString(), ICommonPermissionListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                            broadcastPermissionListener(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.IListenerManager");
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    void broadcastDialogListener(String str, int i2) throws RemoteException;

    void broadcastPermissionListener(String str, String str2) throws RemoteException;

    void executeAppDownloadCallback(String str, String str2, long j2, long j3, String str3, String str4) throws RemoteException;

    void executeFullVideoCallback(String str, String str2) throws RemoteException;

    void executeRewardVideoCallback(String str, String str2, boolean z, int i2, String str3, int i3, String str4) throws RemoteException;

    void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException;

    void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException;

    void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException;

    void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException;

    void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException;

    void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException;
}
