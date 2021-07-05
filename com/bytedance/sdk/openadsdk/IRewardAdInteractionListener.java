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
/* loaded from: classes6.dex */
public interface IRewardAdInteractionListener extends IInterface {

    /* loaded from: classes6.dex */
    public static class Default implements IRewardAdInteractionListener {
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

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onAdClose() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onAdShow() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onAdVideoBarClick() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onDestroy() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onSkippedVideo() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onVideoComplete() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onVideoError() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements IRewardAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public static class a implements IRewardAdInteractionListener {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static IRewardAdInteractionListener f28904a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f28905b;

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
                this.f28905b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28905b : (IBinder) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onAdClose() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        if (!this.f28905b.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onAdClose();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onAdShow() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        if (!this.f28905b.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onAdShow();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onAdVideoBarClick() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        if (!this.f28905b.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onAdVideoBarClick();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onDestroy() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        if (!this.f28905b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onDestroy();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        obtain.writeInt(z ? 1 : 0);
                        obtain.writeInt(i2);
                        obtain.writeString(str);
                        obtain.writeInt(i3);
                        obtain.writeString(str2);
                        if (!this.f28905b.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onRewardVerify(z, i2, str, i3, str2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onSkippedVideo() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        if (!this.f28905b.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onSkippedVideo();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onVideoComplete() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        if (!this.f28905b.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onVideoComplete();
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onVideoError() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        if (!this.f28905b.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onVideoError();
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
            attachInterface(this, "com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        }

        public static IRewardAdInteractionListener asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IRewardAdInteractionListener)) {
                    return (IRewardAdInteractionListener) queryLocalInterface;
                }
                return new a(iBinder);
            }
            return (IRewardAdInteractionListener) invokeL.objValue;
        }

        public static IRewardAdInteractionListener getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f28904a : (IRewardAdInteractionListener) invokeV.objValue;
        }

        public static boolean setDefaultImpl(IRewardAdInteractionListener iRewardAdInteractionListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iRewardAdInteractionListener)) == null) {
                if (a.f28904a != null || iRewardAdInteractionListener == null) {
                    return false;
                }
                a.f28904a = iRewardAdInteractionListener;
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
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onDestroy();
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onAdShow();
                            parcel2.writeNoException();
                            return true;
                        case 3:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onAdVideoBarClick();
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onAdClose();
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onVideoComplete();
                            parcel2.writeNoException();
                            return true;
                        case 6:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onVideoError();
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onRewardVerify(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                            onSkippedVideo();
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    void onAdClose() throws RemoteException;

    void onAdShow() throws RemoteException;

    void onAdVideoBarClick() throws RemoteException;

    void onDestroy() throws RemoteException;

    void onRewardVerify(boolean z, int i2, String str, int i3, String str2) throws RemoteException;

    void onSkippedVideo() throws RemoteException;

    void onVideoComplete() throws RemoteException;

    void onVideoError() throws RemoteException;
}
