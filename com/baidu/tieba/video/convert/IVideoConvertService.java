package com.baidu.tieba.video.convert;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface IVideoConvertService extends IInterface {

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IVideoConvertService {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.baidu.tieba.video.convert.IVideoConvertService";
        public static final int TRANSACTION_abortConvert = 4;
        public static final int TRANSACTION_doConvert = 1;
        public static final int TRANSACTION_isConvertRunning = 5;
        public static final int TRANSACTION_setConvertType = 2;
        public static final int TRANSACTION_setIVideoConvertListener = 3;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static class Proxy implements IVideoConvertService {
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

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public void abortConvert() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public int doConvert(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        this.mRemote.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeLL.intValue;
            }

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public boolean isConvertRunning() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public void setConvertType(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        this.mRemote.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, iVideoConvertListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iVideoConvertListener != null ? iVideoConvertListener.asBinder() : null);
                        this.mRemote.transact(3, obtain, obtain2, 0);
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

        public static IVideoConvertService asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IVideoConvertService)) {
                    return (IVideoConvertService) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IVideoConvertService) invokeL.objValue;
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
                    int doConvert = doConvert(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(doConvert);
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface(DESCRIPTOR);
                    setConvertType(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                } else if (i2 == 3) {
                    parcel.enforceInterface(DESCRIPTOR);
                    setIVideoConvertListener(IVideoConvertListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                } else if (i2 == 4) {
                    parcel.enforceInterface(DESCRIPTOR);
                    abortConvert();
                    parcel2.writeNoException();
                    return true;
                } else if (i2 != 5) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                } else {
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isConvertRunning = isConvertRunning();
                    parcel2.writeNoException();
                    parcel2.writeInt(isConvertRunning ? 1 : 0);
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void abortConvert() throws RemoteException;

    int doConvert(String str, String str2) throws RemoteException;

    boolean isConvertRunning() throws RemoteException;

    void setConvertType(int i2) throws RemoteException;

    void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException;
}
