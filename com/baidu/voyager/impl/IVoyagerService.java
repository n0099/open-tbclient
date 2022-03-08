package com.baidu.voyager.impl;

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
import com.baidu.voyager.impl.IVoyagerCallback;
import java.util.List;
/* loaded from: classes6.dex */
public interface IVoyagerService extends IInterface {

    /* loaded from: classes6.dex */
    public static class Default implements IVoyagerService {
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

        @Override // com.baidu.voyager.impl.IVoyagerService
        public void uploadFileList(List<String> list, String str, long j2, int i2, int i3, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) {
            }
        }

        @Override // com.baidu.voyager.impl.IVoyagerService
        public void uploadFileListWithCallback(List<String> list, String str, long j2, int i2, IVoyagerCallback iVoyagerCallback) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), iVoyagerCallback}) == null) {
            }
        }

        @Override // com.baidu.voyager.impl.IVoyagerService
        public void uploadZipFile(String str, String str2, int i2, int i3, String str3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3}) == null) {
            }
        }

        @Override // com.baidu.voyager.impl.IVoyagerService
        public void uploadZipFileWithCallback(String str, String str2, int i2, IVoyagerCallback iVoyagerCallback) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048580, this, str, str2, i2, iVoyagerCallback) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements IVoyagerService {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.baidu.voyager.impl.IVoyagerService";
        public static final int TRANSACTION_uploadFileList = 2;
        public static final int TRANSACTION_uploadFileListWithCallback = 1;
        public static final int TRANSACTION_uploadZipFile = 4;
        public static final int TRANSACTION_uploadZipFileWithCallback = 3;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public static class Proxy implements IVoyagerService {
            public static /* synthetic */ Interceptable $ic;
            public static IVoyagerService sDefaultImpl;
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

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // com.baidu.voyager.impl.IVoyagerService
            public void uploadFileList(List<String> list, String str, long j2, int i2, int i3, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    try {
                        if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().uploadFileList(list, str, j2, i2, i3, str2);
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

            @Override // com.baidu.voyager.impl.IVoyagerService
            public void uploadFileListWithCallback(List<String> list, String str, long j2, int i2, IVoyagerCallback iVoyagerCallback) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), iVoyagerCallback}) != null) {
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iVoyagerCallback != null ? iVoyagerCallback.asBinder() : null);
                    try {
                        if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().uploadFileListWithCallback(list, str, j2, i2, iVoyagerCallback);
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

            @Override // com.baidu.voyager.impl.IVoyagerService
            public void uploadZipFile(String str, String str2, int i2, int i3, String str3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeString(str3);
                        if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().uploadZipFile(str, str2, i2, i3, str3);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.voyager.impl.IVoyagerService
            public void uploadZipFileWithCallback(String str, String str2, int i2, IVoyagerCallback iVoyagerCallback) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLIL(1048581, this, str, str2, i2, iVoyagerCallback) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeInt(i2);
                        obtain.writeStrongBinder(iVoyagerCallback != null ? iVoyagerCallback.asBinder() : null);
                        if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().uploadZipFileWithCallback(str, str2, i2, iVoyagerCallback);
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IVoyagerService asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IVoyagerService)) {
                    return (IVoyagerService) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IVoyagerService) invokeL.objValue;
        }

        public static IVoyagerService getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Proxy.sDefaultImpl : (IVoyagerService) invokeV.objValue;
        }

        public static boolean setDefaultImpl(IVoyagerService iVoyagerService) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iVoyagerService)) == null) {
                if (Proxy.sDefaultImpl != null || iVoyagerService == null) {
                    return false;
                }
                Proxy.sDefaultImpl = iVoyagerService;
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
                if (i2 == 1) {
                    parcel.enforceInterface(DESCRIPTOR);
                    uploadFileListWithCallback(parcel.createStringArrayList(), parcel.readString(), parcel.readLong(), parcel.readInt(), IVoyagerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface(DESCRIPTOR);
                    uploadFileList(parcel.createStringArrayList(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                } else if (i2 == 3) {
                    parcel.enforceInterface(DESCRIPTOR);
                    uploadZipFileWithCallback(parcel.readString(), parcel.readString(), parcel.readInt(), IVoyagerCallback.Stub.asInterface(parcel.readStrongBinder()));
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
                    uploadZipFile(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void uploadFileList(List<String> list, String str, long j2, int i2, int i3, String str2) throws RemoteException;

    void uploadFileListWithCallback(List<String> list, String str, long j2, int i2, IVoyagerCallback iVoyagerCallback) throws RemoteException;

    void uploadZipFile(String str, String str2, int i2, int i3, String str3) throws RemoteException;

    void uploadZipFileWithCallback(String str, String str2, int i2, IVoyagerCallback iVoyagerCallback) throws RemoteException;
}
