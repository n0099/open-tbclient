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
/* loaded from: classes6.dex */
public interface IVideoCompositeService extends IInterface {
    void abortConvert() throws RemoteException;

    int addSticker(String str, String str2, String str3, boolean z, int i, int i2, int i3, int i4) throws RemoteException;

    boolean isConvertRunning() throws RemoteException;

    void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements IVideoCompositeService {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.baidu.tieba.video.convert.IVideoCompositeService";
        public static final int TRANSACTION_abortConvert = 2;
        public static final int TRANSACTION_addSticker = 4;
        public static final int TRANSACTION_isConvertRunning = 3;
        public static final int TRANSACTION_setIVideoConvertListener = 1;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        /* loaded from: classes6.dex */
        public static class Proxy implements IVideoCompositeService {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            public Proxy(IBinder iBinder) {
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
                this.mRemote = iBinder;
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public void abortConvert() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public boolean isConvertRunning() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        boolean z = false;
                        this.mRemote.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        return z;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public int addSticker(String str, String str2, String str3, boolean z, int i, int i2, int i3, int i4) throws RemoteException {
                InterceptResult invokeCommon;
                int i5;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        if (z) {
                            i5 = 1;
                        } else {
                            i5 = 0;
                        }
                        obtain.writeInt(i5);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        this.mRemote.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeCommon.intValue;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.mRemote;
                }
                return (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException {
                IBinder iBinder;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, iVideoConvertListener) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (iVideoConvertListener != null) {
                            iBinder = iVideoConvertListener.asBinder();
                        } else {
                            iBinder = null;
                        }
                        obtain.writeStrongBinder(iBinder);
                        this.mRemote.transact(1, obtain, obtain2, 0);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, DESCRIPTOR);
        }

        public static IVideoCompositeService asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IVideoCompositeService)) {
                    return (IVideoCompositeService) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IVideoCompositeService) invokeL.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 1598968902) {
                                    return super.onTransact(i, parcel, parcel2, i2);
                                }
                                parcel2.writeString(DESCRIPTOR);
                                return true;
                            }
                            parcel.enforceInterface(DESCRIPTOR);
                            String readString = parcel.readString();
                            String readString2 = parcel.readString();
                            String readString3 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            int addSticker = addSticker(readString, readString2, readString3, z, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(addSticker);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isConvertRunning = isConvertRunning();
                        parcel2.writeNoException();
                        parcel2.writeInt(isConvertRunning ? 1 : 0);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    abortConvert();
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                setIVideoConvertListener(IVideoConvertListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }
}
