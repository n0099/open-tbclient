package com.baidu.wallet.remotepay;

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
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import java.util.Map;
/* loaded from: classes12.dex */
public interface IBDWalletAppPay extends IInterface {

    /* loaded from: classes12.dex */
    public static abstract class Stub extends Binder implements IBDWalletAppPay {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.baidu.wallet.remotepay.IBDWalletAppPay";
        public static final int TRANSACTION_doPay = 1;
        public static final int TRANSACTION_getWalletSdkVersion = 2;
        public static final int TRANSACTION_registerCallback = 3;
        public static final int TRANSACTION_unregisterCallback = 4;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes12.dex */
        public static class Proxy implements IBDWalletAppPay {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
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
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public String doPay(String str, Map map) throws RemoteException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeMap(map);
                        this.mRemote.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeLL.objValue;
            }

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public String getWalletSdkVersion() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, iRemoteServiceCallback) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                        this.mRemote.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public void unregisterCallback() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IBDWalletAppPay asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IBDWalletAppPay)) {
                    return (IBDWalletAppPay) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IBDWalletAppPay) invokeL.objValue;
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
                if (i2 == 1) {
                    parcel.enforceInterface(DESCRIPTOR);
                    String doPay = doPay(parcel.readString(), parcel.readHashMap(Stub.class.getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(doPay);
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface(DESCRIPTOR);
                    String walletSdkVersion = getWalletSdkVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(walletSdkVersion);
                    return true;
                } else if (i2 == 3) {
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                } else if (i2 != 4) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                } else {
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback();
                    parcel2.writeNoException();
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    String doPay(String str, Map map) throws RemoteException;

    String getWalletSdkVersion() throws RemoteException;

    void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;

    void unregisterCallback() throws RemoteException;
}
